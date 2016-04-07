package net.stonyvin.messages.channel

import net.stonyvin.messages.Message
import java.util.List

class Names extends Message {
    List<String> channels

    Names(List<String> channels) {
        this.channels = channels
    }

    @Override
    String toString() {
        return "NAMES ${channels.collect().join(",")}"
    }
}
