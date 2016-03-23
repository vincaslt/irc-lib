package net.stonyvin.modules

import net.stonyvin.messages.sending.PrivMsg
import net.stonyvin.util.IRCSocket

class Sending extends Module {
    Sending(IRCSocket socket) {
        super(socket)
    }

    void privMsgCommand(String receiver, String message) {
        privMsgCommand([receiver], message)
    }

    void privMsgCommand(ArrayList<String> receivers, String message) {
        socket.write(new PrivMsg(receivers, message))
    }
}
