package org.logger.handler;

import org.logger.enums.HandlerType;

import java.util.HashMap;
import java.util.Map;

public class HandlerContext{

    //At a time there will be only one active Handler
    private Handler handler;
    private static Map<HandlerType,Handler> handlerMap =  new HashMap<>();

    public HandlerContext(){
    }

    static {

        handlerMap.put(HandlerType.FILE, new FileHandler());
        handlerMap.put(HandlerType.DB, new DBHandler());
        handlerMap.put(HandlerType.CONSOLE, new ConsoleHandler());
    }

    private static void registerHandler(HandlerType handlerType, Handler handler ){
        handlerMap.put(handlerType,handler);
    }

    public static Handler getRegisteredHandler(HandlerType handlerType){
        return handlerMap.getOrDefault(handlerType, null);
    }

}
