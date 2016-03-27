package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;
import org.schwering.irc.lib.IRCModeParser;
import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnMode implements Event {
    public boolean channel;

    public IRCUser u;
    public String nickPass;
    public String mode;

    public String chan;
    public IRCModeParser mp;

    public OnMode(String s, IRCUser ircUser, IRCModeParser ircModeParser) {
        channel = true;
        chan = s;
        u = ircUser;
        mp = ircModeParser;

    }

    public OnMode(IRCUser ircUser, String s, String s1) {
        channel = false;
        u = ircUser;
        nickPass = s;
        mode = s1;
    }

    @Override
    public String getName() {
        return "onMode";
    }
}
