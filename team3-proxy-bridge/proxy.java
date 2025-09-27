import java.util.List;

public interface ThirdPartyYouTubeLib {
    List<String> listVideos();
    String getVideoInfo(int id);
    void downloadVideo(int id);
}import java.util.Arrays;
import java.util.List;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {
    public List<String> listVideos() {
        return Arrays.asList("Video1", "Video2", "Video3");
    }

    public String getVideoInfo(int id) {
        return "Info about video " + id;
    } import java.util.List;

public class CachedYouTubeClass implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib service;
    private List<String> listCache;
    private String videoCache; 
    private boolean needReset;

    public CachedYouTubeClass(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

    public List<String> listVideos() {
        if (listCache == null || needReset) {
            listCache = service.listVideos();
        }
        return listCache;
    }

    public String getVideoInfo(int id) {
        if (videoCache == null || needReset) {
            videoCache = service.getVideoInfo(id);
        }
        return videoCache;
    }

    public void downloadVideo(int id) {
        service.downloadVideo(id);
    }
}



    public void downloadVideo(int id) {
        System.out.println("Downloading video " + id);
    }
}
import java.util.List;

public class YouTubeManager {
    protected ThirdPartyYouTubeLib service;

    public YouTubeManager(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

    public void renderVideoPage(int id) {
        String info = service.getVideoInfo(id);
        System.out.println("Rendering video page: " + info);
    }

    public void renderListPanel() {
        List<String> list = service.listVideos();
        System.out.println("Rendering list panel: " + list);
    }

    public void reactOnUserInput() {
        renderListPanel();
        renderVideoPage(1);
    }
}
public class Application {
    public static void main(String[] args) {
        ThirdPartyYouTubeClass youTubeService = new ThirdPartyYouTubeClass();
        CachedYouTubeClass youTubeProxy = new CachedYouTubeClass(youTubeService);
        YouTubeManager manager = new YouTubeManager(youTubeProxy);
        manager.reactOnUserInput();
    }
}
