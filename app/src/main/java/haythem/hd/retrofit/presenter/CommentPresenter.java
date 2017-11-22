package haythem.hd.retrofit.presenter;


import android.util.Log;

import java.util.ArrayList;

import haythem.hd.retrofit.contract.CommentContract;
import haythem.hd.retrofit.data.model.Comment;
import haythem.hd.retrofit.data.repository.CommentRepository;
import haythem.hd.retrofit.data.repository.IResponse;

/**
 * Created by Haythem on 16/11/2017.
 */

public class CommentPresenter implements CommentContract.Presenter, IResponse {

    private CommentContract.View mViewListener;
    private CommentRepository mCommentRepository;
    private int mIdPost;

    public CommentPresenter(CommentContract.View view) {
        mViewListener = view;
        mCommentRepository = new CommentRepository(this);
    }

    @Override
    public void onCreate(int idPost) {
        mIdPost = idPost;
    }

    @Override
    public void reponseSuccess(ArrayList comments) {
        mViewListener.showFromServer((ArrayList<Comment>) comments);
        mViewListener.hideProgress();
    }

    @Override
    public void responseFail(Throwable t) {
        Log.i("TAG", "ResponseFAil");
        mViewListener.hideProgress();
    }

    @Override
    public void fetchFromServer() {
        mViewListener.showProgress();
        mCommentRepository.getResponse(mIdPost);
    }

    public void noNetworkAvailable() {
        mViewListener.showAlert();
    }

    @Override
    public void onDestroy() {
        if (mCommentRepository != null) {
            mCommentRepository.cancel();
            mCommentRepository = null;
        }
        mViewListener = null;
    }


}