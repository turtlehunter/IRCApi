package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;
import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnJoin implements Event {
    public String chan;
    public IRCUser u;

    public OnJoin(String s, IRCUser ircUser) {
        chan = s;
        u = ircUser;
    }

    @Override
    public String getName() {
        return "onJoin";
    }
}
