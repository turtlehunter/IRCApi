package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnError implements Event {
    public String msg;
    public int num = -1;

    public OnError(String s) {
        msg = s;
    }

    public OnError(int i, String s) {
        num = i;
        msg = s;
    }

    @Override
    public String getName() {
        return "onError";
    }
}
