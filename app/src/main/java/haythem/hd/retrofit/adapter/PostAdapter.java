package haythem.hd.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import haythem.hd.retrofit.R;
import haythem.hd.retrofit.data.model.Post;


public class PostAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Post> mDataPost;
    private OnItemClickListener mOnItemClickListener = null;

    public PostAdapter(ArrayList<Post> myDataset, OnItemClickListener listener) {
        mDataPost = myDataset;
        mOnItemClickListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_post_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Post post = mDataPost.get(position);
        holder.getId().setText(String.valueOf(post.getId()));
        holder.getTitle().setText(post.getTitle());
        holder.getBody().setText(post.getBody());
        holder.bind(position, mOnItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mDataPost.size();
    }


}