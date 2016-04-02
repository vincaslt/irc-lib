package net.stonyvin.modules

import net.stonyvin.messages.channel.Join
import net.stonyvin.messages.channel.List
import net.stonyvin.util.IRCSocket

class Channel extends Module {
    Channel(IRCSocket socket) {
        super(socket)
    }

    void joinCommand(String channel, String key) {
        socket.write(new Join([(channel) : key]))
    }

    void joinCommand(Map<String, String> channels) {
        socket.write(new Join(channels))
    }

    void listCommand(java.util.List<String> channels = []) {
        socket.write(new List(channels))
    }
}
