package haythem.hd.retrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import haythem.hd.retrofit.adapter.CommentAdapter;
import haythem.hd.retrofit.data.model.Comment;
import haythem.hd.retrofit.global.Constantes;

public class CommentActivity extends AppCompatActivity {

    //private AlertDialog mDialog;
    private RecyclerView mRecycleView;
    //private CommentPresenter commentPresenter;
    //private View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_comment);
        findViewsByIds();
        initialize();

        ArrayList<Comment> comments = (ArrayList<Comment>) getIntent().getSerializableExtra(Constantes.KEY_ID_POST);
        mRecycleView.setAdapter(new CommentAdapter(comments));

       /* commentPresenter = new CommentPresenter(this);
        if (savedInstanceState != null)
            commentPresenter.onCreate(savedInstanceState.getInt(Constantes.KEY_ID_POST));
        else
            commentPresenter.onCreate(getIntent().getIntExtra(Constantes.KEY_ID_POST, 0));

        if (Utils.isNetworkAvailable(this))
            commentPresenter.fetchFromServer();
        else
            commentPresenter.noNetworkAvailable();*/
    }

    @NonNull
    private void findViewsByIds() {
        mRecycleView = findViewById(R.id.recycleview_post);
        // mProgressView = getLayoutInflater().inflate(R.layout.progress, null);

    }

    private void initialize() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        getSupportActionBar().setTitle(R.string.comment);
       /* mDialog = new AlertDialog.Builder(this).setView(mProgressView).create();
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialog.setCancelable(false);*/
    }

   /* @Override
    public void showProgress() {
        mDialog.show();
    }

    @Override
    public void hideProgress() {
        mDialog.dismiss();
    }

    @Override
    public void showFromServer(ArrayList<Comment> comments) {
        mRecycleView.setAdapter(new CommentAdapter(comments));
    }

    @Override
    public void showAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle(R.string.no_internet);
        alertDialogBuilder
                .setMessage(R.string.check_network)
                .setCancelable(false)
                .setPositiveButton(R.string.exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onDestroy() {
        commentPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(Constantes.KEY_ID_POST, getIntent().getIntExtra(Constantes.KEY_ID_POST, 0));
        super.onSaveInstanceState(outState);
    }*/
}
