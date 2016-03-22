package net.stonyvin.modules

import net.stonyvin.Messages.Misc.Pong
import net.stonyvin.util.IRCSocket

class Misc extends Module {
    Misc(IRCSocket socket) {
        super(socket)
    }

    void pongCommand(String daemon) {
        socket.write(new Pong(daemon))
    }
}
