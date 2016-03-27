package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;
import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnKick implements Event {
    public String chan;
    public IRCUser u;
    public String nickPass;
    public String msg;

    public OnKick(String s, IRCUser ircUser, String s1, String s2) {
        chan = s;
        u = ircUser;
        nickPass = s1;
        msg = s2;
    }

    @Override
    public String getName() {
        return "onKick";
    }
}
