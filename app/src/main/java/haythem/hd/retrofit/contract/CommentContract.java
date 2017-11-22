package haythem.hd.retrofit.contract;

import java.util.ArrayList;

import haythem.hd.retrofit.data.model.Comment;

/**
 * Created by Haythem on 16/11/2017.
 */

public class CommentContract {

    public interface View {

        void showProgress();

        void hideProgress();

        void showFromServer(ArrayList<Comment> comments);

        void showAlert();

    }

    public interface Presenter {

        void fetchFromServer();

        void onDestroy();

        void onCreate(int idPost);

    }

}
