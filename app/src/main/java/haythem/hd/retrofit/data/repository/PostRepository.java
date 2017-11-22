package haythem.hd.retrofit.data.repository;

import java.util.ArrayList;

import haythem.hd.retrofit.api.ApiClient;
import haythem.hd.retrofit.api.ApiInterface;
import haythem.hd.retrofit.data.model.Post;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Haythem on 16/11/2017.
 */

public class PostRepository {

    private IResponse mResponseListener;
    private Call<ArrayList<Post>> mCall;

    public PostRepository(IResponse responseListener) {
        mResponseListener = responseListener;
    }

    public void getResponse() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        mCall = apiService.getPosts();
        mCall.enqueue(new Callback<ArrayList<Post>>() {

            @Override
            public void onResponse(Call<ArrayList<Post>> call, retrofit2.Response<ArrayList<Post>> response) {
                mResponseListener.reponseSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
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
