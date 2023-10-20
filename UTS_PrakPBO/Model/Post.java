package Model;

import java.sql.Timestamp;
import java.util.ArrayList;

public abstract class Post {
    private String postId;
    private ContentState status;
    private Timestamp timeUpload;
    private ContentType posType;
    private ArrayList<Comment> comments;

    public Post(String postId, ContentState status, Timestamp timeUpload, ContentType posType,
            ArrayList<Comment> comments) {
        this.postId = postId;
        this.status = status;
        this.timeUpload = timeUpload;
        this.posType = posType;
        this.comments = comments;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ContentState getStatus() {
        return status;
    }

    public void setStatus(ContentState status) {
        this.status = status;
    }

    public Timestamp getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(Timestamp timeUpload) {
        this.timeUpload = timeUpload;
    }

    public ContentType getPosType() {
        return posType;
    }

    public void setPosType(ContentType posType) {
        this.posType = posType;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

}
