package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnReply implements Event {
    public int num;
    public String value;
    public String msg;

    public OnReply(int i, String s, String s1) {
        num = i;
        value = s;
        msg = s1;
    }

    @Override
    public String getName() {
        return "onReply";
    }
}
