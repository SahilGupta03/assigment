package com.sahil.myassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sahil.myassigment.databinding.ActivityCartBinding;
import com.sahil.myassigment.databinding.ActivityDetailBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imagsid;
        String[] name;
        String[] prize;


        Intent intent=this.getIntent();

        if (intent!=null){
            String name1=intent.getStringExtra("name");
            String prize1=intent.getStringExtra("prize");
            int imageid1=intent.getIntExtra("imageid",R.drawable.burger);

            binding.itemname.setText(name1);
            binding.itemprize.setText(prize1);
            binding.itemimage.setImageResource(imageid1);




        }



    }
}