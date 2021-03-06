package net.stonyvin.modules

import net.stonyvin.messages.connection.Nick
import net.stonyvin.util.IRCSocket

class Connection extends Module {
    private String username

    Connection(IRCSocket socket, String username) {
        super(socket)
        this.username = username
    }

    void userCommand(String hostname = getLocalHost(), String realName) {
        socket.write(new net.stonyvin.messages.connection.User(username, hostname, socket.host, realName))
    }

    private String getLocalHost() {
        return InetAddress.getLocalHost().getHostAddress()
    }

    void nickCommand() {
        socket.write(new Nick(username))
    }
}
