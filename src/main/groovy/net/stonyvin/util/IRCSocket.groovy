package net.stonyvin.util

import net.stonyvin.messages.Message
import net.stonyvin.modules.Misc

class IRCSocket {
    String host
    int port
    private BufferedWriter writer
    private BufferedReader reader

    private InputThread inputThread
    private OutputThread outputThread
    private IdentServer identServer
    private java.net.Socket socket

    IRCSocket(String host, int port, String username) {
        this.host = host
        this.port = port
        socket = new java.net.Socket(host, port)

        writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        identServer = new IdentServer(username)
        identServer.start()
    }

    void start(Misc misc) {
        inputThread = new InputThread(reader, misc)
        outputThread = new OutputThread(writer, inputThread, this)
        inputThread.start()
        outputThread.start()
    }

    synchronized void write(Message message) {
        outputThread.write(message)
    }

    boolean isRegistered() {
        return identServer.isRegistered()
    }

    boolean isProcessing() {
        return outputThread.hasMessages() || inputThread.isProcessing()
    }

    void close() {
        identServer.exit()
        inputThread.exit()
        outputThread.exit()
        socket.close()
    }
}
