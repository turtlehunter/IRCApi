package me.urielsalis.IRCApi;

import me.urielsalis.IRCApi.events.*;
import org.schwering.irc.lib.IRCEventListener;
import org.schwering.irc.lib.IRCModeParser;
import org.schwering.irc.lib.IRCUser;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 25/3/2016
 */
public class Listener implements IRCEventListener {
    @Override
    public void onRegistered() {
        EventManager.raise(new OnRegistered());
    }

    @Override
    public void onDisconnected() {
        EventManager.raise(new OnDisconnected());
    }

    @Override
    public void onError(String s) {
        EventManager.raise(new OnError(s));
    }

    @Override
    public void onError(int i, String s) {
        EventManager.raise(new OnError(i, s));
    }

    @Override
    public void onInvite(String s, IRCUser ircUser, String s1) {
        EventManager.raise(new OnInvite(s, ircUser, s1));
    }

    @Override
    public void onJoin(String s, IRCUser ircUser) {
        EventManager.raise(new OnJoin(s, ircUser));
    }

    @Override
    public void onKick(String s, IRCUser ircUser, String s1, String s2) {
        EventManager.raise(new OnKick(s, ircUser, s1, s2));
    }

    @Override
    public void onMode(String s, IRCUser ircUser, IRCModeParser ircModeParser) {
        EventManager.raise(new OnMode(s, ircUser, ircModeParser));
    }

    @Override
    public void onMode(IRCUser ircUser, String s, String s1) {
        EventManager.raise(new OnMode(ircUser, s, s1));
    }

    @Override
    public void onNick(IRCUser ircUser, String s) {
        EventManager.raise(new OnNick(ircUser, s));
    }

    @Override
    public void onNotice(String s, IRCUser ircUser, String s1) {
        EventManager.onMessage(new OnNotice(s, ircUser, s1));
        EventManager.raise(new OnNotice(s, ircUser, s1));
    }

    @Override
    public void onPart(String s, IRCUser ircUser, String s1) {
        EventManager.raise(new OnPart(s, ircUser, s1));
    }

    @Override
    public void onPing(String s) {
        EventManager.raise(new OnPing(s));
    }

    @Override
    public void onPrivmsg(String s, IRCUser ircUser, String s1) {
        EventManager.onMessage(new OnPrivmsg(s, ircUser, s1));
        EventManager.raise(new OnPrivmsg(s, ircUser, s1));
    }

    @Override
    public void onQuit(IRCUser ircUser, String s) {
        EventManager.raise(new OnQuit(ircUser, s));
    }

    @Override
    public void onReply(int i, String s, String s1) {
        EventManager.raise(new OnReply(i, s, s1));
    }

    @Override
    public void onTopic(String s, IRCUser ircUser, String s1) {
        EventManager.raise(new OnTopic(s, ircUser, s1));
    }

    @Override
    public void unknown(String s, String s1, String s2, String s3) {
        EventManager.raise(new Unknown(s, s1, s2, s3));
    }
}
