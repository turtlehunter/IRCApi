package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;
import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnNotice implements Event {
    public String target;
    public IRCUser u;
    public String msg;

    public OnNotice(String s, IRCUser ircUser, String s1) {
        target = s;
        u = ircUser;
        msg = s1;
    }

    @Override
    public String getName() {
        return "onNotice";
    }
}
