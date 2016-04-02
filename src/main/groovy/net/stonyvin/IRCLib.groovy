package net.stonyvin

import net.stonyvin.modules.Channel
import net.stonyvin.modules.Connection
import net.stonyvin.modules.Misc
import net.stonyvin.modules.Sending
import net.stonyvin.modules.User
import net.stonyvin.util.IRCSocket

class IRCLib {
    private IRCSocket socket
    private String username

    // Modules
    Connection connection
    Channel channel
    Misc misc
    Sending sending

    IRCLib(String host, String username) {
        this(host, 6667, username)
    }

    IRCLib(String host, int port, String username) {
        this.username = username
        socket = new IRCSocket(host, port, username)
        connection = new Connection(socket, username)
        channel = new Channel(socket)
        misc = new Misc(socket)
        sending = new Sending(socket)
        socket.start(misc)
    }

    /**
        Waits for any pending executions to finish, and closes the connection.
     */
    void exit() {
        Thread.start {
            while (socket.isProcessing()) { }
            socket.close()
        }
    }

    /**
     * Immediately closes the connection. Any remaining messages at the
     * time of abortion will not be sent.
     */
    void abort() {
        socket.close()
    }
}
