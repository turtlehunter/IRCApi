package me.urielsalis.IRCApi.events;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * me.urielsalis.IRCApi.events - uriel IRCApi 26/3/2016
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
    String value();
}
