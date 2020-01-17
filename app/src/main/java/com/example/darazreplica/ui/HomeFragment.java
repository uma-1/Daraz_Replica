package com.example.darazreplica.ui;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.darazreplica.R;
import com.example.darazreplica.Url.Url;
import com.example.darazreplica.adapter.ItemAdapter;
import com.example.darazreplica.adapter.SliderAdapter;
import com.example.darazreplica.api.ProductApi;
import com.example.darazreplica.model.Item;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    SliderView sliderView;
    RecyclerView recyclerView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = view.findViewById(R.id.imageSlider);
        recyclerView=view.findViewById(R.id.itemRecyclerView);

        final SliderAdapter adapter = new SliderAdapter(getContext());
        adapter.setCount(5);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();
        getProduct();

        return view;
    }

    public void getProduct(){
        ProductApi productApi = Url.getInstance().create(ProductApi.class);
        Call<List<Item>> listCall =productApi.getProduct();
        listCall.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Toast" + response.code(), Toast.LENGTH_SHORT).show();
                }
                ItemAdapter itemAdapter =new ItemAdapter(getActivity(),response.body());
                recyclerView.setAdapter(itemAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                itemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error" +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
