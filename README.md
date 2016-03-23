# irc-lib
A basic IRC library for computer networks CS course in university.

### Usage Example:

    IRCLib irc = new IRCLib("irc.data.lt", "username")
    irc.connection.nickCommand()
    irc.connection.userCommand("localhost", "Name Surname")
    irc.channel.joinCommand("#krantas", "")
    irc.sending.privMsgCommand("#krantas", "Hello World!")

### Currently Implemented

* Connecting to IRC servers via sockets
* Ident authentication server
* Non-blocking read/write
* Commands:
 * Join
 * Nick
 * User
 * Pong
 * Privmsg

### To Do

* Remaining commands
* Configurable output settings
* Client example