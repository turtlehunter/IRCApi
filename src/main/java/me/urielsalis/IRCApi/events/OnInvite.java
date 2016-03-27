package me.urielsalis.IRCApi.events;

import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi.events - uriel IRCApi 26/3/2016
 */
public class OnInvite implements Event {
    public String chan;
    public IRCUser u;
    public String nickPass;

    public OnInvite(String s, IRCUser ircUser, String s1) {
        chan = s;
        u = ircUser;
        nickPass = s1;
    }

    @Override
    public String getName() {
        return "onInvite";
    }
}
