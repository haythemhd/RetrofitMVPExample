package haythem.hd.retrofit.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Haythem on 09/11/2017.
 */

public class Post {
    @SerializedName("id")
    private int mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("body")
    private String mBody;

    @SerializedName("userId")
    private int mUserID;

    public Post() {
    }

    public Post(int id, String title, String body, int userID) {
        mId = mId;
        mTitle = mTitle;
        mBody = mBody;
        mUserID = mUserID;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public int getUserID() {
        return mUserID;
    }

    public void setUserID(int userID) {
        mUserID = userID;
    }
}
