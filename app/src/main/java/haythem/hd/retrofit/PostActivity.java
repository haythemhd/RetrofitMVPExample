package haythem.hd.retrofit;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import haythem.hd.retrofit.adapter.OnItemClickListener;
import haythem.hd.retrofit.adapter.PostAdapter;
import haythem.hd.retrofit.contract.PostContract;
import haythem.hd.retrofit.data.model.Comment;
import haythem.hd.retrofit.data.model.Post;
import haythem.hd.retrofit.global.Constantes;
import haythem.hd.retrofit.global.Utils;
import haythem.hd.retrofit.presenter.PostPresenter;

public class PostActivity extends AppCompatActivity implements PostContract.View, OnItemClickListener {
    private AlertDialog mDialog;
    private RecyclerView mRecycleView;
    private View mProgressView;
    private PostPresenter mPostPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_comment);

        findViewsByIds();
        initialize();
        mPostPresenter = new PostPresenter(this);
        if (Utils.isNetworkAvailable(this)) {
            mPostPresenter.fetchFromServer();
        } else {
            mPostPresenter.noNetworkAvailable();
        }

    }

    @NonNull
    private void findViewsByIds() {
        mRecycleView = findViewById(R.id.recycleview_post);
        mProgressView = getLayoutInflater().inflate(R.layout.progress, null);
    }

    private void initialize() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        getSupportActionBar().setTitle(R.string.post);
        mDialog = new AlertDialog.Builder(this).setView(mProgressView).create();
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialog.setCancelable(false);
    }

    @Override
    public void showProgress() {
        mDialog.show();
    }

    @Override
    public void hideProgress() {
        mDialog.dismiss();
    }

    public void showAlert() {
        Utils.showAlert(this,getString(R.string.no_internet));
    }

    @Override
    public void onItemClicked(ArrayList<Comment> comments) {
        Intent in = new Intent(this, CommentActivity.class);
        in.putExtra(Constantes.KEY_ID_POST, comments);
        startActivity(in);
    }


    @Override
    public void getFromServer(ArrayList<Post> posts) {
        mRecycleView.setAdapter(new PostAdapter(posts, PostActivity.this));
    }

    @Override
    public void onItemClick(int position) {
        mPostPresenter.fetchCommentFromServer(position + 1);
    }
}
