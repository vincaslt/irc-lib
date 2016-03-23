package net.stonyvin.messages.sending

import net.stonyvin.messages.Message

class PrivMsg extends Message {
    ArrayList<String> receivers // Users or Channels
    String message

    PrivMsg(ArrayList<String> receivers, String message) {
        this.receivers = receivers
        this.message = message
    }

    @Override
    String toString() {
        return "PRIVMSG ${receivers.join(",")} :${message}"
    }
}
