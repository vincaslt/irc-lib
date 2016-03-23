package net.stonyvin.messages.channel

import net.stonyvin.messages.Message

class Join extends Message {
    Map<String, String> channels

    Join(Map<String, String> channels) {
        this.channels = channels
    }

    @Override
    String toString() {
        return "JOIN ${channels.collect {k, v -> k}.join(",")} ${channels.collect {k, v -> v}.join(",")}"
    }
}
