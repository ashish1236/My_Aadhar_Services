package com.menga.myaadharservices;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.menga.myaadharservices.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView = findViewById(R.id.adView);
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {

                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        });



//
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interstitialad();

//                Adload(Request, "ca-app-pub-9986980606552169/3972869877");
                Adactivity("https://myaadhaar.uidai.gov.in/genricDownloadAadhaar",1);


            }
        });

        binding.t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RewardedAdload(Request2,"ca-app-pub-9986980606552169/5138180686");
                Interstitialad();

                Adactivity("https://myaadhaar.uidai.gov.in/CheckAadhaarStatus",2);


            }
        });
        binding.t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interstitialad();

//                Adload(Request3, "ca-app-pub-9986980606552169/3123618791");
                Adactivity("https://myaadhaar.uidai.gov.in/genricPVC",3);

            }
        });
        binding.t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RewardedAdload(Request4,"ca-app-pub-9986980606552169/2783480085");
                Interstitialad();

//                Rewardedadactivity(2);
//                Adload(Request4, "ca-app-pub-9986980606552169/3226764417");
                Adactivity("https://myaadhaar.uidai.gov.in/verify-email-mobile",4);


            }
        });
        binding.t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Adload(Request5, "ca-app-pub-9986980606552169/6072419607");
                Adactivity("https://myaadhaar.uidai.gov.in/verifyAadhaar",5);
                Interstitialad();

            }
        });
        binding.t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RewardedAdload(Request6,"ca-app-pub-9986980606552169/8774173360");
                Interstitialad();

//                Rewardedadactivity(6);
                Adactivity("https://appointments.uidai.gov.in/(X(1)S(vjfqdp55cthjpgm5x3vjv355))/easearch.aspx?AspxAutoDetectCookieSupport=1",6);

            }
        });


        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragment  fragment=new BlankFragment();
                fragment.show(getSupportFragmentManager(),fragment.getTag());
            }
        });

//        ca-app-pub-9986980606552169/8193064336
        InterstitialAd.load(this, "ca-app-pub-9986980606552169/8281960568", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                super.onAdClicked();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.

                                mInterstitialAd = null;
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.

                                mInterstitialAd = null;
                            }

                            @Override
                            public void onAdImpression() {
                                // Called when an impression is recorded for an ad.
                                super.onAdImpression();
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.

                            }
                        });

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });

    }

    private void Adactivity(String s,int code) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("key",s);
        intent.putExtra("code",code);
        startActivity(intent);
    }



    private void Interstitialad() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(MainActivity.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }


}