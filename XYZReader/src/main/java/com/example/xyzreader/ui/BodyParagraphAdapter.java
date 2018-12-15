package com.example.xyzreader.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

import java.util.ArrayList;
import java.util.List;

public class BodyParagraphAdapter extends RecyclerView.Adapter<BodyParagraphAdapter.BodyParagraphAdapterViewHolder> {
    private Context mContext;
    private List<String> mParagraphData;

    public BodyParagraphAdapter(Context context) {
        mContext = context;
    }

    public class BodyParagraphAdapterViewHolder extends RecyclerView.ViewHolder{

        public final TextView mBodyParagraphTextView;
        public BodyParagraphAdapterViewHolder(View itemView) {
            super(itemView);
            mBodyParagraphTextView = (TextView) itemView.findViewById(R.id.tv_article_body_paragraph_item);
        }

    }

    @Override
    public BodyParagraphAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutForItem = R.layout.list_item_body_paragraph;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutForItem, parent, false);

        return new BodyParagraphAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BodyParagraphAdapterViewHolder holder, int position) {
        String bodyParagraphText = mParagraphData.get(position);
        holder.mBodyParagraphTextView.setText(bodyParagraphText);
        holder.mBodyParagraphTextView.setTypeface(
                Typeface.createFromAsset(
                        mContext.getResources().getAssets(), "Rosario-Regular.ttf"));

    }

    @Override
    public int getItemCount() {
        if(mParagraphData == null) { return 0; }
        return mParagraphData.size();
    }


    public void setParagraphData(List<String> paragraphList) {
        if(mParagraphData == null) { mParagraphData = new ArrayList<>();}
        mParagraphData.clear();
        //check argument
        if (paragraphList != null && paragraphList.size() != 0) {
            mParagraphData.addAll(paragraphList);
        }
        notifyDataSetChanged();
    }
}
