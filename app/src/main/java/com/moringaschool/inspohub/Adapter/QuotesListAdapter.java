package com.moringaschool.inspohub.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.inspohub.Model.Quote;
import com.moringaschool.inspohub.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuotesListAdapter extends RecyclerView.Adapter<QuotesListAdapter.QuotesViewHolder> {
    private List<Quote> quoteList;


    public QuotesListAdapter(List<Quote> quoteList){
        this.quoteList = quoteList;
    }

    @Override
    public QuotesViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_quote_list_item,parent,false);
        return new QuotesViewHolder(view);
    }


    @Override
    public void onBindViewHolder(QuotesListAdapter.QuotesViewHolder holder, int position) {
        holder.mIdTextView.setText(quoteList.get(position).getId());
        holder.mQuoteTextView.setText(quoteList.get(position).getQuoteText());
        holder.mAuthorTextView.setText(quoteList.get(position).getQuoteAuthor());
    }


    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.IdTextView)
        TextView mIdTextView;
        @BindView(R.id.QuoteTextView) TextView mQuoteTextView;
        @BindView(R.id.AuthorTextView) TextView mAuthorTextView;

        private Context mContext;

        public QuotesViewHolder( View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

        }
    }
}
