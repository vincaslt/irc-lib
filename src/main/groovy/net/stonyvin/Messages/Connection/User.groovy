package net.stonyvin.messages.connection

import net.stonyvin.messages.Message

class User extends Message {
    String userName
    String hostName
    String serverName
    String realName

    User(String username, String hostname, String serverName, String realName) {
        this.userName = username
        this.hostName = hostname
        this.serverName = serverName
        this.realName = realName
    }

    @Override
    String toString() {
        return "USER ${userName} ${hostName} ${serverName} ${realName}"
    }
}
