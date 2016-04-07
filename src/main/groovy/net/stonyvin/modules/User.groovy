package net.stonyvin.modules

import net.stonyvin.messages.user.Who
import net.stonyvin.util.IRCSocket

class User extends Module {
    User(IRCSocket socket) {
        super(socket)
    }

    void whoCommand(String name) {
        socket.write(new Who(name))
    }
}
