package com.example.darazreplica.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.darazreplica.R;
import com.example.darazreplica.SignInUpActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    Button btnSignIn;
    BottomNavigationView my_order_navigation, my_service_navigation;


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_account, container, false);

        this.my_order_navigation=view.findViewById(R.id.my_order_bottom_navigation);
        this.my_service_navigation=view.findViewById(R.id.my_service_bottom_navigation);
        my_order_navigation.setItemIconTintList(null);
        my_service_navigation.setItemIconTintList(null);

        //binding id for signinup button
        this.btnSignIn=view.findViewById(R.id.btnSignInUp);

        this.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SignInUpActivity.class));
            }
        });
        return view;
    }
}

