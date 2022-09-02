package com.example.whatstnews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class scienceFragment extends Fragment {
    String api="040ae3020697403a922203402cdb1e46";
    ArrayList<modelclass> modelclassArrayList;
    AdapterClass adapter;
    String country="in";
    RecyclerView recyclerViewofscience;
    String category="science";

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view= inflater.inflate(R.layout.sciencefragment,null);

            recyclerViewofscience=view.findViewById(R.id.recyclerviewofscience);
            recyclerViewofscience.setLayoutManager(new LinearLayoutManager(getContext()));
            modelclassArrayList=new ArrayList<>();
            adapter=new AdapterClass(getContext(),modelclassArrayList);
            recyclerViewofscience.setAdapter(adapter);
            findNews();
            return  view;

        }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                modelclassArrayList.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable throwable) {

            }
        });
    }
}
