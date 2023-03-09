import org.proxy.internet.Internet;
import org.proxy.internet.ProxyInternet;
import org.proxy.video.ProxyVideoDownloader;
import org.proxy.video.VideoDownloader;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-structural-proxy/src/main/java/com/youtube/geekific/MainApp.java
//https://www.youtube.com/watch?v=TS5i-uPXLs8&t=124s
public class ProxyMain {
    public static void main(String[] args) {

        System.out.println("Internet Proxy -------");
        Internet internet = new ProxyInternet();
        internet.connectTo("google.com");
        internet.connectTo("banned.com");

        System.out.println("Video Download Proxy -----------");
        VideoDownloader videoDownloader =  new ProxyVideoDownloader();
        videoDownloader.getVideo("A");
        videoDownloader.getVideo("A");
        videoDownloader.getVideo("B");
        videoDownloader.getVideo("A");
        videoDownloader.getVideo("B");

    }
}