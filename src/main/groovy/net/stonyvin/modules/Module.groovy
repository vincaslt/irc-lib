package net.stonyvin.modules

import net.stonyvin.util.IRCSocket

abstract class Module {
    IRCSocket socket;

    Module(IRCSocket socket) {
        this.socket = socket
    }
}
