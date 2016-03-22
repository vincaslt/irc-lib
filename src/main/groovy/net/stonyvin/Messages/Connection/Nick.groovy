package net.stonyvin.Messages.Connection

import net.stonyvin.Messages.Message

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
