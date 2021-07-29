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
import com.moringaschool.inspohub.Model.QuotesResponse;
import com.moringaschool.inspohub.Network.QuoteApi;
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
    public List<Quote> quoteList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes_list);
        ButterKnife.bind(this);


        Log.e("TAG","inside onCreate");
        fetchPost();
    }

    private void fetchPost(){
        mProgressBar.setVisibility(View.VISIBLE);
        Log.e("TAG","inside fetchPost");
        QuoteApi client = QuoteClient.getRetrofitClient();
        Call<QuotesResponse> call =client.getQuotes();
        call.enqueue(new Callback<QuotesResponse>() {
            @Override
            public void onResponse(Call<QuotesResponse> call, Response<QuotesResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    Log.e("TAG","Response");
                    quoteList=response.body().getData();
                    mAdapter= new QuotesListAdapter(quoteList);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(QuotesListActivity.this);
                    mRecyclerView.setLayoutManager(linearLayoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    mAdapter.notifyDataSetChanged();
                    mProgressBar.setVisibility(View.GONE);

                    showQuotes();
                }
            }

            @Override
            public void onFailure(Call<QuotesResponse> call, Throwable t) {
                Log.e("TAG","inside onFailure");
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(QuotesListActivity.this, "Error"+ t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showQuotes(){mRecyclerView.setVisibility(View.VISIBLE);}
}