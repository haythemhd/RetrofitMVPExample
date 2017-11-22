package haythem.hd.retrofit.presenter;

import android.util.Log;

import java.util.ArrayList;

import haythem.hd.retrofit.contract.PostContract;
import haythem.hd.retrofit.data.model.Comment;
import haythem.hd.retrofit.data.model.Post;
import haythem.hd.retrofit.data.repository.CommentRepository;
import haythem.hd.retrofit.data.repository.IResponse;
import haythem.hd.retrofit.data.repository.PostRepository;


public class PostPresenter implements PostContract.Presenter, IResponse {

    private PostContract.View mPostViewListener;
    private PostRepository mPostRepository;
    private CommentRepository mCommentRepository;


    public PostPresenter(PostContract.View view) {
        mPostViewListener = view;
        mPostRepository = new PostRepository(this);
        mCommentRepository = new CommentRepository(this);
    }

    @Override
    public void reponseSuccess(ArrayList objects) {
        if (objects.get(0) instanceof Post) {
            mPostViewListener.getFromServer((ArrayList<Post>) objects);
            mPostViewListener.hideProgress();
        } else {
            mPostViewListener.hideProgress();
            mPostViewListener.onItemClicked((ArrayList<Comment>) objects);
        }
    }

    @Override
    public void responseFail(Throwable t) {
        Log.i("TAG", "ResponseFAil");
        mPostViewListener.showAlert();
        mPostViewListener.hideProgress();
    }

    @Override
    public void fetchFromServer() {
        mPostViewListener.showProgress();
        mPostRepository.getResponse();
    }

    @Override
    public void fetchCommentFromServer(int id) {
        mPostViewListener.showProgress();
        mCommentRepository.getResponse(id);
    }

    public void noNetworkAvailable() {
        mPostViewListener.showAlert();
    }


    @Override
    public void onDestroy() {
        if (mPostRepository != null) {
            mPostRepository.cancel();
            mPostRepository = null;
        }
        mPostViewListener = null;
    }

}
