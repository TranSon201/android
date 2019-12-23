package com.example.nhac.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhac.Adapter.BaihathotAdapter;
import com.example.nhac.Model.BaiHat;
import com.example.nhac.R;
import com.example.nhac.Service.APIService;
import com.example.nhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Baihat_Hot extends Fragment {

    View view;
    BaihathotAdapter baihathotAdapter;
    RecyclerView recyclerViewbaihathot;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihat_hot, container, false);
        GetData();
        recyclerViewbaihathot = view.findViewById(R.id.recyclerviewbathathot);
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHat>> callback = dataservice.Getbaihat();
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> baiHatArrayList = (ArrayList<BaiHat>) response.body();
                baihathotAdapter = new BaihathotAdapter(getActivity(), baiHatArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewbaihathot.setLayoutManager(linearLayoutManager);
                recyclerViewbaihathot.setAdapter(baihathotAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }
}
