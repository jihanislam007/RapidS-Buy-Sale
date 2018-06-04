package com.devsbox.jihanislam007.rapidseba.Fragment;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.devsbox.jihanislam007.rapidseba.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuyFragment extends Fragment {

    Spinner Spinner;
    EditText BudgetEditText,
            ChooseAreaEditText;

    String land="", flat="";
    int selection;
    Button DoneButton;

    public BuyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_buy, container, false);

        BudgetEditText = rootView.findViewById(R.id.BudgetEditText);
        ChooseAreaEditText = rootView.findViewById(R.id.ChooseAreaEditText);

        DoneButton = rootView.findViewById(R.id.DoneButton);

        Spinner = rootView.findViewById(R.id.Spinner);


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("নির্বাচন করুন");
        categories.add("জমি কিনবো");
        categories.add("ফ্ল্যাট কিনবো");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        Spinner.setAdapter(dataAdapter);

////////////////////////////////////////////////////////
        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {

                switch(position){
                    /*case 0:
                        selection = 0;
                        break;*/
                    case 1:
                      land = "জমি কিনবো";
                      flat = "";
                        break;
                    case 2:
                        flat = "ফ্ল্যাট কিনবো";
                        land = "";
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });


        DoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "you clicked"+land+flat, Toast.LENGTH_SHORT).show();

                String LandArea = ChooseAreaEditText.getText().toString();
                String Budget = BudgetEditText.getText().toString()+" Tk";

                String spinnerChoose = land+ flat;

                //////////////////get data from previous fragment.////////////////
                String Username = getArguments().getString("Username","There is no Data");
                String Userphone = getArguments().getString("Userphone","There is no Data");
                String Useraddress = getArguments().getString("Useraddress","There is no Data");

                if(LandArea.isEmpty() || Budget.isEmpty() || spinnerChoose.isEmpty()){
                    Toast.makeText(getActivity(), "দয়া করে সকল তথ্য সম্পন্ন করুন ।", Toast.LENGTH_SHORT).show();
                }else {

                    if(spinnerChoose.isEmpty()){
                        Toast.makeText(getActivity(), "দয়া করে সকল তথ্য সম্পন্ন করুন ।", Toast.LENGTH_SHORT).show();
                    }else {
                        String Phone = "+8801711425005";
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                        smsIntent.setData(Uri.parse("smsto:" + Uri.encode(Phone)));

                        smsIntent.putExtra("sms_body", "Nmae :"+Username+"\nPhone :"+Userphone+
                                "\nMy Address :"+Useraddress+"\nBuy :"+ spinnerChoose+ "\nBudget :"+ Budget+ "\nTarget Area :"+LandArea);
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
