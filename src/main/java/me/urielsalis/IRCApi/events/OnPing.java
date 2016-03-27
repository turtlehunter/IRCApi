package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnPing implements Event {
    public String p;

    public OnPing(String s) {
        p = s;
    }

    @Override
    public String getName() {
        return "onPing";
    }
}
