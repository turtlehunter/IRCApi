package me.urielsalis.IRCApi.events;

import me.urielsalis.IRCApi.events.Event;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class Unknown implements Event {
    public String a;
    public String b;
    public String c;
    public String d;
    public Unknown(String s, String s1, String s2, String s3) {
        a = s;
        b = s1;
        c = s2;
        d = s3;
    }

    @Override
    public String getName() {
        return "unknown";
    }
}
