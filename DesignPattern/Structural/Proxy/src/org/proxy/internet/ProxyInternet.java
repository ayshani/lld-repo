package org.proxy.internet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProxyInternet implements Internet{

    private static final Set<String> bannedState;
    private final Internet internet = new RealInternet();

    static{
        bannedState = new HashSet<>();
        bannedState.add("banned.com");
    }


    @Override
    public void connectTo(String host) {
        if(bannedState.contains(host)){
            System.out.println("Access Denied to   "+ host);
            return;
        }
        internet.connectTo(host);
    }
}
