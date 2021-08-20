package model;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Tweet extends Model {
    private String text;
    private ID imageID;
    private LocalDateTime createTime;
    private LocalDateTime retweetTime;
    private ID writerID;
    private ID retweeterID;


    private LinkedList<ID> likes;
    private LinkedList<ID> comments;
    private LinkedList<ID> reports;

    private ID upperTweetID;
    private ID parentTweetID;


//    private MemoType memoType;

//    private TweetType tweetType;


    public Tweet(ID id, String text, ID imageID,
                 LocalDateTime createTime, LocalDateTime retweetTime,
                 ID writerID, ID retweeterID,
                 LinkedList<ID> likes, LinkedList<ID> comments, LinkedList<ID> reports,
                 ID upperTweetID, ID parentTweetID) {
        super(id);
        this.text = text;
        this.imageID = imageID;
        this.createTime = createTime;
        this.retweetTime = retweetTime;
        this.writerID = writerID;
        this.retweeterID = retweeterID;
        this.likes = likes;
        this.comments = comments;
        this.reports = reports;
        this.upperTweetID = upperTweetID;
        this.parentTweetID = parentTweetID;
    }

    public ID getWriterID() {
        return writerID;
    }

    public void addLike(ID id) {
        likes.add(id);
    }

    public void removeLike(ID id) {
        likes.remove(id);
    }

    public void addReport(ID id) {
        reports.add(id);
    }
}
