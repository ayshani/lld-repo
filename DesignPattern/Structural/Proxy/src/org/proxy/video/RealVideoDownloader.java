package org.proxy.video;

public class RealVideoDownloader implements VideoDownloader{
    @Override
    public Video getVideo(String videoName) {
        System.out.println("Connection to https://www.youtube.com/");
        System.out.println("Downloading video");
        System.out.println("Retrieving Video Metadata for : "+ videoName);
        return new Video(videoName);
    }
}
