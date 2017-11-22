package haythem.hd.retrofit.data.repository;

import java.util.ArrayList;

import haythem.hd.retrofit.api.ApiClient;
import haythem.hd.retrofit.api.ApiInterface;
import haythem.hd.retrofit.data.model.Comment;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Haythem on 16/11/2017.
 */

public class CommentRepository {

    private IResponse mResponseListener;
    private Call<ArrayList<Comment>> mCall;

    public CommentRepository(IResponse responseListener) {
        mResponseListener = responseListener;
    }

    public void getResponse(int mIdPost) {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        mCall = apiService.getCommentById(mIdPost);
        mCall.enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, retrofit2.Response<ArrayList<Comment>> response) {
                mResponseListener.reponseSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {
                mResponseListener.responseFail(t);
            }

        });
    }

    public void cancel() {
        mResponseListener = null;
        if (mCall.isCanceled() && mCall != null)
            mCall.cancel();
    }
}
