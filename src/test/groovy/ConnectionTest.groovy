import junit.framework.TestCase
import net.stonyvin.IRCLib
import net.stonyvin.util.IRCSocket

class ConnectionTest extends TestCase {
    IRCSocket socket;

    ConnectionTest() {
    }

    void testUserCommand() {
        IRCLib irc = new IRCLib("irc.data.lt")
        irc.connection.userCommand("vincas", "localhost", "Vincas Stonys")
    }
}
