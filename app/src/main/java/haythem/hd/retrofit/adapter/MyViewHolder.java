package haythem.hd.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import haythem.hd.retrofit.R;

/**
 * Created by Haythem on 17/11/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView mId, mTitle, mBody;

    protected MyViewHolder(View view) {
        super(view);
        mId = view.findViewById(R.id.id);
        mTitle = view.findViewById(R.id.title);
        mBody = view.findViewById(R.id.body);
    }


    protected void bind(final int position, final OnItemClickListener listener) {
        mBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
    }

    public TextView getId() {
        return mId;
    }

    public void setId(TextView id) {
        this.mId = id;
    }

    public TextView getTitle() {
        return mTitle;
    }

    public void setTitle(TextView title) {
        this.mTitle = title;
    }

    public TextView getBody() {
        return mBody;
    }

    public void setBody(TextView body) {
        this.mBody = body;
    }
}
