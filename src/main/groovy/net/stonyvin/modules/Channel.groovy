package net.stonyvin.modules

import net.stonyvin.messages.channel.Join
import net.stonyvin.util.IRCSocket

class Channel extends Module {
    Channel(IRCSocket socket) {
        super(socket)
    }

    void joinCommand(String channel, String key) {
        joinCommand([channel : key])
    }

    void joinCommand(Map<String, String> channels) {
        socket.write(new Join(channels))
    }
}
