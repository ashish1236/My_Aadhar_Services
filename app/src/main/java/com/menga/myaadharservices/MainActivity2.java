package com.menga.myaadharservices;

import android.content.Intent;
import android.net.Uri;
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
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.menga.myaadharservices.databinding.ActivityMain2Binding;


public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    Intent intent;
    private AdView mAdView;

    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        intent=getIntent();
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
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

        String url=intent.getStringExtra("key");
int code=intent.getIntExtra("code",0);
if (code==1){
binding.textView.setText("e-Aadhaar is a password protected electronic copy of Aadhaar, which is digitally signed by the competent Authority of UIDAI. Resident can download e-Aadhaar by following two ways. - By Using Enrollment Number: Resident can download e-Aadhaar using 28 digit enrolment no. along with Full Name and Pin code. In this download process OTP is received on registered mobile no. Resident can also use TOTP to download e-Aadhaar instead of OTP. TOTP can generated using mAadhaar mobile Application. - By Using Aadhaar No: Resident can download e-Aadhaar by using 12 digits Aadhaar No. along with Full Name and Pin code. In this download process OTP is received on registered mobile no. Resident can also use TOTP to download e-Aadhaar instead of OTP. TOTP can generated using mAadhaar mobile Application.");
}else if (code==2){
    binding.textView.setText("Check if your Aadhaar is generated or updated (In case you have updated at an Enrolment/Update center). - You will require EID (Enrolment ID) or SRN to check your Aadhaar Status. The EID is displayed on the top of your enrolment/update acknowledgement slip and contains 14 digit enrolment number (1234/12345/12345) and the 14 digit date and time (yyyy/mm/dd hh:mm:ss) of enrolment. These 28 digits together form your Enrolment ID (EID). - In case if you lost EID you can retrieve lost or forgotten EID by your registered mobile number. Check Enrolment & Update Status");
}else if (code==3){
    binding.textView.setText("\"Order Aadhaar Card\" is a new service launched by UIDAI which facilitates the Aadhaar holder to get their Aadhaar details printed on PVC card by paying nominal charges. Residents who do not have registered mobile number can also order using Non-Registered /Alternate Mobile Number. 1) Click on \"Order Aadhaar Card\" Service. 2) Enter your 12-digit Aadhaar Number (UID) or 16-digit Virtual Identification Number (VID) or 28 digits Enrollment ID. 3) Enter the security code. 4) If you have TOTP, choose option \"I have TOTP\" by clicking in check box else Click on \"Request OTP\" button.");
}else if (code==4){
    binding.textView.setText("You can verify your email address and mobile number that has been declared at the time of enrolment or during latest Aadhaar detail update. Aadhaar Online services. In case your mobile number is not registered with your Aadhaar, visit the nearest Permanent Aadhaar Centre (PAC).");
}else if (code==5){
    binding.textView.setText("Here you can check if your Aadhaar or Aadhaar submitted to you is a genuine one or not. Residents are using this service to verify the identity of their workers. Step 1. Now click on \"Verify an Aadhaar Number\" Step 2. You will be redirected to a new page for Aadhaar Verification Step 3. Enter your 12-digit Unique Identification Number, i.e., Aadhaar Number Step 4: Enter \"Captcha Verification from the given box Step 5: Click on \"Proceed to Verify\" Step 6: Your Aadhaar verification will be done.");
}else if (code==6){
    binding.textView.setText("Steps to locate Aadhar Enrolment Centres are mentioned below: Step 1: Click on \"Locate Enrolment & Update Centres in Other Cities\" Step 2: Select State/Pin Code/Search Box option Step 3: Enter your details such as District/Sub District/Village/Town Step 4: If you want to Search only permanent centres, select check box option. Step 5: Enter Verification code and press Search button Step 6: Relevant Aadhar Card Enrolment Centres are displayed on the screen.");
}


binding.button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
});


binding.more.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       BlankFragment fragment=new BlankFragment();
        fragment.show(getSupportFragmentManager(),fragment.getTag());
    }
});
//        ca-app-pub-9986980606552169/8193064336
        InterstitialAd.load(this, "ca-app-pub-9986980606552169/1113863081", adRequest,
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
    private void Interstitialad() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(MainActivity2.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }

    @Override
    public void onBackPressed() {
        Interstitialad();
        super.onBackPressed();
    }
}