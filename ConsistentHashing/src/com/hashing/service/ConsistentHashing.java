package com.hashing.service;

import com.hashing.model.HashFunction;

import java.util.SortedMap;
import java.util.TreeMap;

//https://ishan-aggarwal.medium.com/consistent-hashing-an-overview-and-implementation-in-java-6b47c718558a
public class ConsistentHashing {

    private final TreeMap<Long, String> ring;
    private final int numberOfReplicas;
    private final HashFunction hashFunction;

    public ConsistentHashing(int numberOfReplicas){
        ring = new TreeMap<>();
        this.numberOfReplicas = numberOfReplicas;
        hashFunction = new HashFunction();
    }

    public void addServer(String server){
        for(int i=0;i<numberOfReplicas;i++){
            long hash = hashFunction.generateHash(server +i);
            ring.put(hash,server);
        }
    }

    public void removeServer(String server){
        for(int i=0;i<numberOfReplicas;i++){
            long hash = hashFunction.generateHash(server +i);
            ring.remove(hash);
        }
    }

    public String getServer(String key){
        if(ring.isEmpty()){
            return null;
        }
        long hash = hashFunction.generateHash(key);
        if(!ring.containsKey(hash)){
            SortedMap<Long,String> tailMap = ring.tailMap(hash);
            hash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
        }
        return ring.get(hash);
    }

}
