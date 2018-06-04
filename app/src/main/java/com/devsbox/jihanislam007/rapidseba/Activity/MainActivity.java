package com.devsbox.jihanislam007.rapidseba.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.devsbox.jihanislam007.rapidseba.Fragment.RegistrationFragment;
import com.devsbox.jihanislam007.rapidseba.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        RegistrationFragment registrationFragment = new RegistrationFragment();
        fragmentManager.beginTransaction().add(R.id.FragmentContainer,registrationFragment).commit();


        MobileAds.initialize(this, "ca-app-pub-2793185816066957~4430595646");

        /*mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2793185816066957/8710296598");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());*/

    }


}
