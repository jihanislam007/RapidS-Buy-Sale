package com.devsbox.jihanislam007.rapidseba.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.devsbox.jihanislam007.rapidseba.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SellChoiceFragment extends Fragment {

    LinearLayout BuyLayout,
            SellLayout;
    public SellChoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_sell_choice, container, false);

        BuyLayout = rootView.findViewById(R.id.BuyLayout);
        SellLayout = rootView.findViewById(R.id.SellLayout);

        BuyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BuyFragment buyFragment = new BuyFragment();
                FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();

                String Username = getArguments().getString("Username","There is no Data");
                String Userphone = getArguments().getString("Userphone","There is no Data");
                String Useraddress = getArguments().getString("Useraddress","There is no Data");

                String buy = "buy";

                /////////////data pass////////////////////
                Bundle args = new Bundle();
                args.putString("Username", Username);
                args.putString("Userphone", Userphone);
                args.putString("Useraddress", Useraddress);
                args.putString("Userbuy", buy);
                buyFragment.setArguments(args);

                Toast.makeText(getActivity(), "Hi "+ Username, Toast.LENGTH_SHORT).show();

                fragTransaction.replace(R.id.FragmentContainer,buyFragment );
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();
            }
        });

        SellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SellerFragment sellerFragment = new SellerFragment();
                FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();

                String Username = getArguments().getString("Username","There is no Data");
                String Userphone = getArguments().getString("Userphone","There is no Data");
                String Useraddress = getArguments().getString("Useraddress","There is no Data");

                String sell = "sell";

                /////////////data pass////////////////////
                Bundle args = new Bundle();
                args.putString("Username", Username);
                args.putString("Userphone", Userphone);
                args.putString("Useraddress", Useraddress);
                args.putString("Usersell", sell);
                sellerFragment.setArguments(args);

                Toast.makeText(getActivity(), "Hi "+ Username, Toast.LENGTH_SHORT).show();

                fragTransaction.replace(R.id.FragmentContainer,sellerFragment );
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();




            }
        });

/////////////////working for add///////////////////////////////////////////

        MobileAds.initialize(getActivity(), "ca-app-pub-2793185816066957~4430595646");

        /*AdView mAdView = rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Request for Ads
        AdRequest adRequest1 = new AdRequest.Builder()

                // Add a test device to show Test Ads
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("947B975E60AF133A105A2C362E253C35") //Random Text
                .build();
		 *//*	// Load ads into Banner Ads
			mAdView.loadAd(adRequest1);*//*
        mAdView.loadAd(adRequest1);*/

        AdView mAdView = rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        AdView sAdView = rootView.findViewById(R.id.adViewss);
        AdRequest sadRequest = new AdRequest.Builder().build();
        sAdView.loadAd(sadRequest);

        /////////////////finish add///////////////////////////////////////////////

        return rootView;
    }

}
