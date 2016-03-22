package net.stonyvin.util

import net.stonyvin.Messages.Message
import net.stonyvin.Messages.Misc.Pong

class OutputThread extends Thread {
    private InputThread inputThread
    private LinkedList<Message> queue = new LinkedList<Message>()
    private BufferedWriter writer
    IRCSocket socket
    private quit = false

    OutputThread(BufferedWriter writer, InputThread inputThread, IRCSocket socket) {
        this.writer = writer
        this.inputThread = inputThread
        this.socket = socket
    }

    @Override
    void run() {
        while (!quit) {
            if (!inputThread.isProcessing() && socket.isRegistered()) {
                Message message = getNextMessage()
                if (message != null) {
                    Logging.instance.log ("OUT: ${message}")
                    writer.write(message.toString() + "\r\n")
                    writer.flush()
                }
            }
        }
    }

    synchronized private Message getNextMessage() {
        if (queue.size() > 0)
            return queue.poll()
        else
            return null
    }

    synchronized void write(Message message) {
        if (message instanceof Pong) {
            queue.addFirst(message)
        } else {
            queue.add(message)
        }
    }

    void exit() {
        quit = true
    }
}
