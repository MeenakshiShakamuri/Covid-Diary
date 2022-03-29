package uk.ac.tees.MAD.W9560777.coviddiary;

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

public class FragmentHealth extends Fragment {

    String key_API = "183af7cffe5a40d1a5c499398a760edb";
    ArrayList<Class_Model> class_modelArrayList;
    Class_Adapter adapter;
    String country_name = "us";
    private RecyclerView health_recyclerview;
    private String category = "health";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health, null);

        health_recyclerview = view.findViewById(R.id.health_recyclerview);
        class_modelArrayList = new ArrayList<>();
        health_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Class_Adapter(class_modelArrayList, getContext());
        health_recyclerview.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {

        Utilities_Api.getApiInterface().getCategorical_News(country_name, category, 90, key_API).enqueue(new Callback<Class_Main_News>() {
            @Override
            public void onResponse(Call<Class_Main_News> call, Response<Class_Main_News> response) {
                if (response.isSuccessful()){
                    class_modelArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<Class_Main_News> call, Throwable t) {

            }
        });
    }

}