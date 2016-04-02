package net.stonyvin.util

import net.stonyvin.modules.Misc

class InputThread extends Thread {
    private BufferedReader reader
    private quit = false
    private Misc miscModule

    InputThread(BufferedReader reader, Misc miscModule) {
        this.reader = reader
        this.miscModule = miscModule
    }

    @Override
    void run() {
        String line = null
        try {
            while (!quit) {
                if (reader.ready() && (line = reader.readLine()) != null) {
                    Logging.instance.log("IN: ${line}")
                    if (line.toUpperCase().startsWith("PING ")) {
                        miscModule.pongCommand(line.substring(5))
                    }
                }
            }
            reader.close()
        } catch (SocketException e) {
            Logging.instance.log("ERROR: " + e.getMessage())
        }
    }

    boolean isProcessing() {
        if (quit) {
            return false
        }
        return reader.ready()
    }

    void exit() {
        quit = true
    }
}
