package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;
import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnPrivmsg implements Event {
    public String chan;
    public IRCUser u;
    public String msg;

    public OnPrivmsg(String s, IRCUser ircUser, String s1) {
        chan = s;
        u = ircUser;
        msg = s1;
    }

    @Override
    public String getName() {
        return "onPrivmsg";
    }
}
