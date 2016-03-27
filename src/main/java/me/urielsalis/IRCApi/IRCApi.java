package me.urielsalis.IRCApi;

import me.urielsalis.IRCApi.events.ConfigurationEvent;
import me.urielsalis.IRCApi.events.EventHandler;
import org.schwering.irc.lib.IRCConnection;
import org.schwering.irc.lib.ssl.SSLIRCConnection;
import java.io.IOException;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 22/3/2016
 */
public class IRCApi extends Thread {

    private IRCConnection conn;
    private String defaultTarget;

    public void init(String host, int port, String pass, String nick, String user, String name, boolean ssl) {
        try {
            if (!ssl) {
                conn = new IRCConnection(host, new int[] { port }, pass, nick, user,
                        name);
            } else {
                conn = new SSLIRCConnection(host, new int[] { port }, pass, nick, user,
                        name);
                ((SSLIRCConnection)conn).addTrustManager(new TrustManager());
            }
            conn.addIRCEventListener(new Listener());
            conn.setEncoding("UTF-8");
            conn.setPong(true);
            conn.setDaemon(false);
            conn.setColors(false);
            conn.connect();
            conn.run();
        } catch (IOException exc) {
            exc.printStackTrace();
            EventManager.raise(new ConfigurationEvent(exc));
        }
    }

    public void init(String host, int port, String pass, String nick, String user, String name) {
        init(host, port, pass, nick, user, name, false);
    }

    public void init(String host, String nick, String user, String name) {
        init(host, 6667, "", nick, user, name, false);
    }

    public void init(String host, String user) {
        init(host, 6667, "", user, user, user, false);
    }

    @EventHandler("sendRaw")
    public void sendRaw(String s) {
        conn.send(s);
    }

    public void send(String target, String line) {
        conn.doPrivmsg(target, line);
    }

    public void notice(String target, String line) {
        conn.doNotice(target, line);
    }

    public void partChannel(String target, String line) {
        conn.doPart(target, line);
    }

    public void away(String message) {
        conn.doAway(message);
    }

    public void invite(String nick, String target) {conn.doInvite(nick, target);}

    public void join(String channel) {conn.doJoin(channel);}

    public void join(String channel, String password) {conn.doJoin(channel, password);}

    public void kick(String channel, String user) {conn.doKick(channel, user);}

    public void mode(String user, String mode) {conn.doMode(user, mode);}

    public void quit(String message) {conn.doQuit(message);}

    public void topic(String channel, String message) {conn.doTopic(channel, message);}

    public boolean isConnected() {return conn.isConnected();}

    @Override
    public void run() {
        super.run();
        conn.run();
    }
}
