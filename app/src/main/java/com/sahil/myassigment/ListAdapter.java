package com.sahil.myassigment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter(Context context, ArrayList<User> userArrayList){

        super(context,R.layout.listitem,userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user=getItem(position);
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.listitem,parent,false);
        }

        ImageView imageView=convertView.findViewById(R.id.itemimage);
        TextView nameitem=convertView.findViewById(R.id.itemname);
        TextView prizeitem=convertView.findViewById(R.id.itemprize);

        imageView.setImageResource(user.imageId);
        nameitem.setText(user.name);
        prizeitem.setText(user.prize);

        return convertView;

        
    }
}
