package com.menga.myaadharservices;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewbinding.BuildConfig;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.menga.myaadharservices.databinding.FragmentBlankBinding;



public class BlankFragment extends BottomSheetDialogFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentBlankBinding binding=FragmentBlankBinding.inflate(inflater,container,false);




        binding.rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getContext().getPackageName()));
                startActivity(rateIntent);
                BlankFragment.this.dismiss();

            }
        });

        return binding.getRoot();
    }
}