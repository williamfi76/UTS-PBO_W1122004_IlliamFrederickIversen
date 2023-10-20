package Model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Feed extends Post {
    private String caption;
    private int likes;

    public Feed(String postId, ContentState status, Timestamp timeUpload, ContentType posType,
            ArrayList<Comment> comments, String caption, int likes) {
        super(postId, status, timeUpload, posType, comments);
        this.caption = caption;
        this.likes = likes;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
