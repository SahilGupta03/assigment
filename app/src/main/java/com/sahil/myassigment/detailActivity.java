package com.sahil.myassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sahil.myassigment.databinding.ActivityDetailBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class detailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=this.getIntent();

        if (intent!=null){
            String name=intent.getStringExtra("name");
            String prize=intent.getStringExtra("prize");
            int imageid=intent.getIntExtra("imageid",R.drawable.burger);

            binding.viewName.setText(name);
            binding.viewPrize.setText(prize);
            binding.viewImage.setImageResource(imageid);


        }
binding.btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});


    }
}