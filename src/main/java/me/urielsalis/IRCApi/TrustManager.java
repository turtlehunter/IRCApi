package me.urielsalis.IRCApi;

import org.schwering.irc.lib.ssl.SSLTrustManager;

import java.security.cert.X509Certificate;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 25/3/2016
 */
public class TrustManager implements SSLTrustManager {

    private X509Certificate[] chain;
    public X509Certificate[] getAcceptedIssuers() {
        return chain != null ? chain : new X509Certificate[0];
    }
    public boolean isTrusted(X509Certificate[] chain) {
        return true; //TODO
    }
}
