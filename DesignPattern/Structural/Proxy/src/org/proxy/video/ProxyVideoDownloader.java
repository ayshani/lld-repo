package org.proxy.video;

import java.util.HashMap;
import java.util.Map;

public class ProxyVideoDownloader implements VideoDownloader{

    private final Map<String,Video> videoCache = new HashMap<>();
    private final VideoDownloader videoDownloader =  new RealVideoDownloader();
    @Override
    public Video getVideo(String videoName) {
        if(!videoCache.containsKey(videoName)){
            videoCache.put(videoName,videoDownloader.getVideo(videoName));
        } else {
            System.out.println("Retrieving video : " + videoName + " from cache...");
        }
        System.out.println("-----------------");
        return videoCache.get(videoName);
    }
}
