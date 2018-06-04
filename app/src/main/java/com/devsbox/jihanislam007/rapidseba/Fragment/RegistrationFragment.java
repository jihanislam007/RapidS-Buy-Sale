package com.devsbox.jihanislam007.rapidseba.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.devsbox.jihanislam007.rapidseba.Activity.DemoAdd;
import com.devsbox.jihanislam007.rapidseba.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {

    EditText NameEditText,
            PhoneEditText,
            AddressEditText;
    Button DoneButton;


    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_registration, container, false);

        MobileAds.initialize(getActivity(), "ca-app-pub-2793185816066957~4430595646");


        NameEditText = rootview.findViewById(R.id.NameEditText);
        PhoneEditText = rootview.findViewById(R.id.PhoneEditText);
        AddressEditText = rootview.findViewById(R.id.AddressEditText);


        TextView text = rootview.findViewById(R.id.text);

        DoneButton = rootview.findViewById(R.id.DoneButton);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =   new Intent(getActivity(), DemoAdd.class);
                startActivity(in);
            }
        });

        DoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String name = NameEditText.getText().toString();
                String phone = PhoneEditText.getText().toString();
                String address = AddressEditText.getText().toString();

                if(name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                    Toast.makeText(getActivity(), "দয়া করে সকল তথ্য সম্পন্ন করুন।", Toast.LENGTH_SHORT).show();
                }else {
                
                SellChoiceFragment sellChoiceFragment = new SellChoiceFragment();
                FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
                
                /////////////data pass////////////////////
                    Bundle args = new Bundle();
                    args.putString("Username", name);
                    args.putString("Userphone", phone);
                    args.putString("Useraddress", address);
                    sellChoiceFragment.setArguments(args);
                
                
                fragTransaction.replace(R.id.FragmentContainer,sellChoiceFragment );
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();
                
                }
            }
        });

        /////////////////working for add///////////////////////////////////////////
        AdView mAdView = rootview.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Request for Ads
        AdRequest adRequest1 = new AdRequest.Builder()

                // Add a test device to show Test Ads
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("947B975E60AF133A105A2C362E253C35") //Random Text
                .build();
		 /*	// Load ads into Banner Ads
			mAdView.loadAd(adRequest1);*/
        mAdView.loadAd(adRequest1);
        /////////////////finish add///////////////////////////////////////////////

        return rootview;
    }

}
