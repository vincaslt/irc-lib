package net.stonyvin.util

class IdentServer extends Thread {
    private String username
    private boolean registered = false
    private boolean exit = false

    private BufferedReader identIn

    IdentServer(String username) {
        this.username = username
    }

    @Override
    void run() {
        try {
            Logging.instance.log("Starting ident server on port 113...");
            ServerSocket identServ = new ServerSocket(113)
            Socket identCl = identServ.accept()
            identIn = new BufferedReader(
                    new InputStreamReader(identCl.getInputStream()))
            BufferedWriter identOut = new BufferedWriter(
                    new OutputStreamWriter(identCl.getOutputStream()))
            String line = null;
            while ((line = identIn.readLine()) != null && exit != true) {
                Logging.instance.log("IDENT: " + line)
                line = line + " : USERID : UNIX : ${this.username}\r\n"
                identOut.write(line)
                identOut.flush()
                registered = true
            }
            identServ.close()
            identOut.close()
        } catch (IOException e) {
            e.printStackTrace()
        }
    }

    void exit() {
        exit = true
    }

    boolean isRegistered() {
        return registered && !identIn.ready()
    }
}
