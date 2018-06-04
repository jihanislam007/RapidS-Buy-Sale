package com.devsbox.jihanislam007.rapidseba.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devsbox.jihanislam007.rapidseba.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class SellerFragment extends Fragment {
    public SellerFragment() {
        // Required empty public constructor
    }

    EditText AddressEditText,
            RateEditText,
            kathaEditText,
            SquarefootEditText;
    Button DoneButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_seller, container, false);

        AddressEditText = rootView.findViewById(R.id.AddressEditText);
        RateEditText = rootView.findViewById(R.id.RateEditText);
        kathaEditText = rootView.findViewById(R.id.kathaEditText);
        SquarefootEditText = rootView.findViewById(R.id.SquarefootEditText);

        DoneButton = rootView.findViewById(R.id.DoneButton);

        DoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strtext = getArguments().getString("Username","There is no Data");
                Toast.makeText(getActivity(), "Hi "+ strtext, Toast.LENGTH_SHORT).show();

                String LandAddress = AddressEditText.getText().toString();
                String LandRate = RateEditText.getText().toString()+" Tk";
                String LandKatha = kathaEditText.getText().toString();
                String LandSqf = SquarefootEditText.getText().toString();


                //////////////////get data from previous fragment.////////////////
                String Username = getArguments().getString("Username","There is no Data");
                String Userphone = getArguments().getString("Userphone","There is no Data");
                String Useraddress = getArguments().getString("Useraddress","There is no Data");


                if(LandAddress.isEmpty() || LandRate.isEmpty() || (LandKatha.isEmpty() && LandSqf.isEmpty())){
                    Toast.makeText(getActivity(), "দয়া করে সকল তথ্য সম্পন্ন করুন ।", Toast.LENGTH_SHORT).show();
                }else {

                    if(LandKatha.isEmpty()){
                        LandKatha = "";
                        String LSqf = LandSqf+"SqFeet";

                        String Phone = "+8801711425005";
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                        smsIntent.setData(Uri.parse("smsto:" + Uri.encode(Phone)));

                        smsIntent.putExtra("sms_body", "Nmae :"+Username+"\nPhone :"+Userphone+
                                "\nMy Address :"+Useraddress+"\nLand Address :"+LandAddress+"\nExpected Rate :"+
                                LandRate+"\nLand Size :"+LandKatha+LSqf);
                        startActivity(smsIntent);

                        Toast.makeText(getActivity(), "Your Message is ready to send", Toast.LENGTH_LONG).show();
                        //   finish();

                    }else if(LandSqf.isEmpty()){
                        LandSqf = "";
                        String Katha = LandKatha+" Katha";

                        String Phone = "+8801711425005";
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                        smsIntent.setData(Uri.parse("smsto:" + Uri.encode(Phone)));

                        smsIntent.putExtra("sms_body", "Nmae :"+Username+"\nPhone :"+Userphone+
                                "\nMy Address :"+Useraddress+"\nLand Address :"+LandAddress+"\nExpected Rate :"+
                                LandRate+"\nLand Size :"+Katha+LandSqf);
                        startActivity(smsIntent);

                        Toast.makeText(getActivity(), "Your Message is ready to send", Toast.LENGTH_LONG).show();
                        //   finish();
                    }else {


                        String Phone = "+8801711425005";
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                        smsIntent.setData(Uri.parse("smsto:" + Uri.encode(Phone)));

                        smsIntent.putExtra("sms_body", "Nmae :"+Username+"\nPhone :"+Userphone+
                                "\nMy Address :"+Useraddress+"\nLand Address :"+LandAddress+"\nExpected Rate :"+
                                LandRate+"\nLand Size :"+LandKatha+"\n"+LandSqf);
                        startActivity(smsIntent);

                        Toast.makeText(getActivity(), "Your Message is ready to send", Toast.LENGTH_LONG).show();
                        //   finish();
                    }



                }
            }
        });

        /////////////////working for add///////////////////////////////////////////

        MobileAds.initialize(getActivity(), "ca-app-pub-2793185816066957~4430595646");

        AdView mAdView = rootView.findViewById(R.id.adView);
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

        return rootView;
    }
}
