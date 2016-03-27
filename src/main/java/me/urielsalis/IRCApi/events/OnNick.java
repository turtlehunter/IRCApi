package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;
import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnNick implements Event {
    public IRCUser u;
    public String newNick;

    public OnNick(IRCUser ircUser, String s) {
        u = ircUser;
        newNick = s;
    }

    @Override
    public String getName() {
        return "onNick";
    }
}
