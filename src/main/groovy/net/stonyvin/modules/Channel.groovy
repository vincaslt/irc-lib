package net.stonyvin.modules

import net.stonyvin.messages.channel.Join
import net.stonyvin.messages.channel.List
import net.stonyvin.util.IRCSocket

class Channel extends Module {
    ArrayList<String> joinedChannels = []

    Channel(IRCSocket socket) {
        super(socket)
    }

    void joinCommand(String channel, String key) {
        socket.write(new Join([(channel) : key]))
        joinedChannels.push(channel)
    }

    void joinCommand(Map<String, String> channels) {
        socket.write(new Join(channels))
        channels.each { joinedChannels.push(it) }
    }

    void listCommand(java.util.List<String> channels = []) {
        socket.write(new List(channels))
    }
}
