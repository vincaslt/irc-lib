package net.stonyvin.modules

import net.stonyvin.Messages.Connection.Nick
import net.stonyvin.util.IRCSocket

class Connection extends Module {
    private String username

    Connection(IRCSocket socket, String username) {
        super(socket)
        this.username = username
    }

    void userCommand(String hostname, String realName) {
        socket.write(new net.stonyvin.Messages.Connection.User(username, hostname, socket.host, realName))
    }

    void nickCommand() {
        socket.write(new Nick(username))
    }
}
