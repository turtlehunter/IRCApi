package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class OnRegistered implements Event {
    @Override
    public String getName() {
        return "onRegistered";
    }
}
