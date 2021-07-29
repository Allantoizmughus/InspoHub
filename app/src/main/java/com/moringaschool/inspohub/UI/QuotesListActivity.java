package com.moringaschool.inspohub.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.moringaschool.inspohub.Adapter.QuotesListAdapter;
import com.moringaschool.inspohub.Model.Quote;
import com.moringaschool.inspohub.Network.QuoteClient;
import com.moringaschool.inspohub.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuotesListActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    LinearLayoutManager linearLayoutManager;
    QuotesListAdapter mAdapter;
    List<Quote> quoteList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list);
        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new QuotesListAdapter(quoteList);
        mRecyclerView.setAdapter(mAdapter);


        Log.e("TAG","inside onCreate");
        fetchPost();
    }

    private void fetchPost(){
        mProgressBar.setVisibility(View.VISIBLE);
        Log.e("TAG","inside fetchPost");
        QuoteClient.getRetrofitClient().getQuotes().enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                if(response.isSuccessful() && response.body() != null){
                    Log.e("TAG","Response");
                    quoteList.addAll(response.body());
                    mAdapter.notifyDataSetChanged();
                    mProgressBar.setVisibility(View.GONE);

                    showQuotes();
                }
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e("TAG","inside onFailure");
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(QuotesListActivity.this, "Error"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showQuotes(){mRecyclerView.setVisibility(View.VISIBLE);}
}