package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;
import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnQuit implements Event {
    public IRCUser u;
    public String msg;

    public OnQuit(IRCUser ircUser, String s) {
        u = ircUser;
        msg = s;
    }

    @Override
    public String getName() {
        return "onQuit";
    }
}
