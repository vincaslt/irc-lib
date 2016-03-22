# irc-lib
A basic IRC library for computer networks CS course in university.

### Usage example:

    IRCLib irc = new IRCLib("irc.data.lt", "username")
    irc.connection.nickCommand()
    irc.connection.userCommand("localhost", "Name Surname")
    irc.channel.joinCommand(["#krantas": ""])

### Currently implemented

* Connecting to IRC servers via sockets
* Ident authentication server
* Non-blocking read/write
* Commands:
 * Join
 * Nick
 * User
 * Pong
