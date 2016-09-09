package com.wakuei.fakedcard.Listview;

/**
 * Created by user on 2016/7/27/027.
 */
public class DcardItem {
    private String title,excerpt,id,forumAlias,likeCount,commentCount,gender,forumName;

    public DcardItem(){

    }
    public DcardItem(String title,String excerpt,String id,String forumAlias,String likeCount,String commentCount,String gender,String forumName){
        this.title = title;
        this.excerpt = excerpt;
        this.id = id;
        this.forumAlias = forumAlias;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.gender = gender;
        this.forumName = forumName;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getExcerpt() {return excerpt;}
    public void setExcerpt(String excerpt) {this.excerpt = excerpt;}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getForumAlias() {return forumAlias;}
    public void setForumAlias(String forumAlias) {this.forumAlias = forumAlias;}

    public String getLikeCount() {return likeCount;}
    public void setLikeCount(String likeCount) {this.likeCount = likeCount;}

    public String getCommentCount() {return commentCount;}
    public void setCommentCount(String commentCount) {this.commentCount = commentCount;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public String getForumName() {return forumName;}
    public void setForumName(String forumName) {this.forumName = forumName;}
}
