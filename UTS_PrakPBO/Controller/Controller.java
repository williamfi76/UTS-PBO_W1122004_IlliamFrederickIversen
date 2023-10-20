package Controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import Model.Comment;
import Model.ContentState;
import Model.ContentType;
import Model.Feed;
import Model.Post;
import Model.Reel;
import Model.Story;
import Model.User;

public class Controller {

    public static ArrayList<User> users = usersDummy();

    static ArrayList<User> usersDummy() {
        ArrayList<Comment> dummyComments = new ArrayList<>(Arrays.asList(
                new Comment("50001", "First", ContentState.PINNED),
                new Comment("50002", "Second", ContentState.SHOWED),
                new Comment("50003", "THird", ContentState.SHOWED),
                new Comment("50004", "Fourth", ContentState.ARCHIVED),
                new Comment("50005", "Dahlah", ContentState.DELETED)));

        ArrayList<Post> postsSelebgram = new ArrayList<>(Arrays.asList(
                new Feed("20001", ContentState.SHOWED, Timestamp.valueOf("2023-04-02 09:03:45"), ContentType.PICTURE,
                        dummyComments, "Review Barang", 200),
                new Feed("20002", ContentState.PINNED, Timestamp.valueOf("2023-05-02 09:03:45"), ContentType.VIDEO,
                        dummyComments, "Review Makeup", 130),
                new Feed("20003", ContentState.ARCHIVED, Timestamp.valueOf("2023-06-02 09:03:45"), ContentType.VIDEO,
                        dummyComments, "Review Tripod", 1330),
                new Feed("20004", ContentState.DELETED, Timestamp.valueOf("2023-07-02 09:03:45"), ContentType.PICTURE,
                        dummyComments, "Testing", 20)));
        User selebgram = new User("10001", "chibiNa", "111111", "Review Barang Olshop", postsSelebgram);

        ArrayList<Post> postsResearcher = new ArrayList<>(Arrays.asList(
                new Feed("20005", ContentState.SHOWED, Timestamp.valueOf("2022-04-02 09:03:45"), ContentType.PICTURE,
                        dummyComments, "Burung 101", 250),
                new Feed("20006", ContentState.PINNED, Timestamp.valueOf("2022-05-02 09:03:45"), ContentType.VIDEO,
                        dummyComments, "Badak 101", 1300),
                new Feed("20007", ContentState.ARCHIVED, Timestamp.valueOf("2021-06-02 09:03:45"), ContentType.VIDEO,
                        dummyComments, "Jerapah 101", 1330),
                new Feed("20008", ContentState.DELETED, Timestamp.valueOf("2022-07-02 09:03:45"), ContentType.PICTURE,
                        dummyComments, "Singa 101", 20)));
        User researcher = new User("10002", "SteveIrwin", "222222", "I Love Animals", postsResearcher);

        ArrayList<User> newUsers = new ArrayList<>(Arrays.asList(
                selebgram,
                researcher));

        return newUsers;
    }

    public static void showUserPost(User user) {
        ArrayList<Post> posts = user.getPosts();
        // Collections.sort(posts);
        ArrayList<Post> postsArchived = new ArrayList<>();
        ArrayList<Post> postsShowed = new ArrayList<>();
        ArrayList<Post> postsDeleted = new ArrayList<>();
        ArrayList<Post> postsPinned = new ArrayList<>();

        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            ContentState status = post.getStatus();
            if (status == ContentState.PINNED) {
                postsPinned.add(post);
            } else if (status == ContentState.SHOWED) {
                postsShowed.add(post);
            } else if (status == ContentState.DELETED) {
                postsDeleted.add(post);
            } else if (status == ContentState.ARCHIVED) {
                postsArchived.add(post);
            }
        }

        int postNum = 1;

        // PRINT PINNED
        for (int i = 0; i < postsPinned.size(); i++) {
            Post post = postsPinned.get(i);
            if (post instanceof Feed) {
                System.out.println(
                        postNum + ". " + postsPinned.get(i).getPostId() + " - PINNED: --> " + ((Feed) post).getLikes());
            } else if (post instanceof Story) {
                System.out.println(postNum + ". " + postsPinned.get(i).getPostId() + " - PINNED: --> "
                        + ((Story) post).getViews());
            } else if (post instanceof Reel) {
                System.out.println(postNum + ". " + postsPinned.get(i).getPostId() + " - PINNED: --> "
                        + ((Reel) post).getPlayedCount());
            }
            postNum++;
        }

        // PRINT SHOWED
        for (int i = 0; i < postsShowed.size(); i++) {
            Post post = postsShowed.get(i);
            if (post instanceof Feed) {
                System.out.println(
                        postNum + ". " + postsShowed.get(i).getPostId() + " - SHOWED: --> " + ((Feed) post).getLikes());
            } else if (post instanceof Story) {
                System.out.println(postNum + ". " + postsShowed.get(i).getPostId() + " - SHOWED: --> "
                        + ((Story) post).getViews());
            } else if (post instanceof Reel) {
                System.out.println(postNum + ". " + postsShowed.get(i).getPostId() + " - SHOWED: --> "
                        + ((Reel) post).getPlayedCount());
            }
            postNum++;
        }

        // PRINT ARCHIVED
        for (int i = 0; i < postsArchived.size(); i++) {
            Post post = postsArchived.get(i);
            if (post instanceof Feed) {
                System.out.println(postNum + ". " + postsArchived.get(i).getPostId() + " - ARCHIVED: --> "
                        + ((Feed) post).getLikes());
            } else if (post instanceof Story) {
                System.out.println(postNum + ". " + postsArchived.get(i).getPostId() + " - ARCHIVED: --> "
                        + ((Story) post).getViews());
            } else if (post instanceof Reel) {
                System.out.println(postNum + ". " + postsArchived.get(i).getPostId() + " - ARCHIVED: --> "
                        + ((Reel) post).getPlayedCount());
            }
            postNum++;
        }
        System.out.println("Jumlah Post ter delete: " + postsDeleted.size() + " posts");
    }

    public static void showPost(String postId) {
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).getPosts().size(); j++) {
                if (users.get(i).getPosts().get(j).getPostId().equalsIgnoreCase(postId)) {
                    Post post = users.get(i).getPosts().get(j);
                    System.out.println("Post ID:     " + post.getPostId());
                    System.out.println("Post Status: " + post.getStatus().getSTATUS());
                    System.out.println("Time Upload: " + post.getTimeUpload());
                    if (post instanceof Reel) {
                        System.out.println("Durasi: " + ((Reel) post).getDuration());
                        System.out.println("Played Count: " + ((Reel) post).getPlayedCount());
                    } else if (post instanceof Story) {
                        System.out.println("Durasi: " + ((Story) post).getDuration());
                        System.out.println("Views: " + ((Story) post).getViews());
                    } else if (post instanceof Feed) {
                        System.out.println("Caption: " + ((Feed) post).getCaption());
                        System.out.println("Likes: " + ((Feed) post).getLikes());
                    }
                    break;
                }

            }
        }
    }

    public static void changePostStatus(Post post, ContentState cs) {
        if (cs == ContentState.DELETED) {
            if (post.getStatus() == ContentState.ARCHIVED) {
                post.setStatus(ContentState.DELETED);
            } else {
                System.out.println("Post harus di archive terlebih dahulu");
            }
        } else {
            if (cs == ContentState.PINNED) {
                if (post instanceof Feed) {
                    post.setStatus(cs);
                } else {
                    System.out.println("Tidak bisa Pin post yang bukan Feed");
                }
            } else {
                post.setStatus(cs);
            }
        }
    }

}
