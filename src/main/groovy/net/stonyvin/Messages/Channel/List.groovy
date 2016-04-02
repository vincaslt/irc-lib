package net.stonyvin.messages.channel

import net.stonyvin.messages.Message

class List extends Message {
    java.util.List<String> channels

    List(java.util.List<String> channels = []) {
        this.channels = channels
    }

    @Override
    String toString() {
        return "LIST ${channels.collect().join(',')}"
    }
}
