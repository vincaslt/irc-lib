package net.stonyvin.messages.channel

import net.stonyvin.messages.Message

class Join extends Message {
    Map<String, String> channels

    Join(Map<String, String> channels) {
        this.channels = channels
    }

    @Override
    String translateResponse(int responseCode) {
        switch (responseCode) {
            case 0:
                return "Invalid parameter count!"
            case 1:
                return "User with this name is already registered!"
        }
    }

    @Override
    String toString() {
        return "JOIN ${channels.collect {k, v -> k}.join(",")} ${channels.collect {k, v -> v}.join(",")}"
    }
}
