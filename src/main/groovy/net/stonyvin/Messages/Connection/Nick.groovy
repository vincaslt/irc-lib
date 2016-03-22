package net.stonyvin.messages.connection

import net.stonyvin.messages.Message

class Nick extends Message {
    String username

    Nick(String username) {
        this.username = username
    }

    @Override
    String translateResponse(int responseCode) {
        return null
    }

    @Override
    String toString() {
        return "NICK ${username}"
    }
}
