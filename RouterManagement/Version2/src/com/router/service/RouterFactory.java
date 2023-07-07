package com.router.service;

public class RouterFactory {

    public static Router getRouter(int poolSize, int initialCapacity){
        Router router = Router.getInstance(poolSize,initialCapacity);
        router.startRouter();
        return router;
    }
}
