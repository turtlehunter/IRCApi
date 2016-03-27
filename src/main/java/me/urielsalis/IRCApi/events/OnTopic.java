package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;
import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnTopic implements Event {
    public String chan;
    public IRCUser u;
    public String topic;

    public OnTopic(String s, IRCUser ircUser, String s1) {
        chan = s;
        u = ircUser;
        topic = s1;
    }

    @Override
    public String getName() {
        return "onTopic";
    }
}
