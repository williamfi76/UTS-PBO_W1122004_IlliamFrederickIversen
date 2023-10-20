package Model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Story extends Post {
    private int duration, views;

    public Story(String postId, ContentState status, Timestamp timeUpload, ContentType posType,
            ArrayList<Comment> comments, int duration, int views) {
        super(postId, status, timeUpload, posType, comments);
        this.duration = duration;
        this.views = views;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
