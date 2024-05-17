package com.example.volumecalculator;

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

public class ShpGrdCstmAdptr extends ArrayAdapter<Shape> {
    private Context context;
    private ArrayList<Shape> shapeArrayList = new ArrayList<Shape>();
    public ShpGrdCstmAdptr(@NonNull Context context, ArrayList<Shape> shapeArrayList) {
        super(context,R.layout.cstm_grd_layout);
        this.context = context;
        this.shapeArrayList = shapeArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shape = getItem(position); // getItem is use in custom Adapters it is a function in the base adapter
        ViewHolder viewHolder ;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.cstm_grd_layout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.shapeHeading = (TextView) convertView.findViewById(R.id.name);
            viewHolder.shapeImage = (ImageView) convertView.findViewById(R.id.iconImage);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        String name = shapeArrayList
        viewHolder.shapeHeading.setText(shape.getShapeHeading());
        viewHolder.shapeImage.setImageResource(shape.getShapeImg());

        return convertView;
    }

    private static class ViewHolder {
        TextView shapeHeading;
        ImageView shapeImage;
    }
}

