package com.sahil.myassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.sahil.myassigment.databinding.ActivityMainBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SliderView sliderView;
    int[] image={R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i5};
    ListView listView;
    ActivityMainBinding binding;
    ImageView ig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sliderView=findViewById(R.id.image_slider);
        sliderAdapter sliderAdapter=new sliderAdapter(image);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
        
binding.cart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(MainActivity.this,CartActivity.class);
        startActivity(intent);
    }
});


        int[] imagsid={R.drawable.burger,R.drawable.pizza,R.drawable.cholabhatura,R.drawable.chowmein,R.drawable.momos};
        String[] name={"burger","pizza","cholabhatura","chowmein","momos"};
        String[] prize={"$20","$70","$50","$40","$25"};


        ArrayList<User> userArrayList=new ArrayList<>();
        for (int i =0;i<imagsid.length;i++){
            User user =new User(name[i],prize[i],imagsid[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter=new ListAdapter(MainActivity.this,userArrayList);

        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(MainActivity.this, CartActivity.class);
                intent.putExtra("name",name[position]);
                intent.putExtra("prize",prize[position]);
                intent.putExtra("imageid",imagsid[position]);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent a =new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}