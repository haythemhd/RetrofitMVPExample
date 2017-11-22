package haythem.hd.retrofit.contract;

import java.util.ArrayList;

import haythem.hd.retrofit.data.model.Comment;
import haythem.hd.retrofit.data.model.Post;

/**
 * Created by Haythem on 16/11/2017.
 */

public class PostContract {

    public interface View {
        void showProgress();

        void hideProgress();

        void getFromServer(ArrayList<Post> posts);

        void showAlert();

        void onItemClicked(ArrayList<Comment> comments);

    }

    public interface Presenter {
        void fetchFromServer();

        void fetchCommentFromServer(int id);

        void onDestroy();

    }
}
