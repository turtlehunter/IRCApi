package me.urielsalis.IRCApi.events;

import java.io.IOException;

/**
 * me.urielsalis.IRCApi.events - uriel IRCApi 26/3/2016
 */
public class ConfigurationEvent implements Event {
    public Exception exception;

    public ConfigurationEvent(IOException exc) {
        this.exception = exc;
    }

    @Override
    public String getName() {
        return "configurationEvent";
    }
}
