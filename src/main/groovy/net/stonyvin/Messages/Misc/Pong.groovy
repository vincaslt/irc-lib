package net.stonyvin.Messages.Misc

import net.stonyvin.Messages.Message

class Pong extends Message{
    String daemon

    Pong(String daemon) {
        this.daemon = daemon
    }

    @Override
    String translateResponse(int responseCode) {
        return null
    }

    @Override
    String toString() {
        return "PONG ${daemon}"
    }
}
