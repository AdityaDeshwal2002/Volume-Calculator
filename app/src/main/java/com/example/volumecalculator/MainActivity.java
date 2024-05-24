package com.example.volumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Shape> shapeArrayList = new ArrayList<Shape>();
    GridView gridView;
    ShpGrdCstmAdptr shpGrdCstmAdptr;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.shpGridView);

        shapeArrayList.add(new Shape(R.drawable.cube,"Cube"));
        shapeArrayList.add(new Shape(R.drawable.cylinder,"Cylinder"));
        shapeArrayList.add(new Shape(R.drawable.prism,"Prism"));
        shapeArrayList.add(new Shape(R.drawable.sphere,"Sphere"));

        shpGrdCstmAdptr = new ShpGrdCstmAdptr(MainActivity.this,shapeArrayList);
        gridView.setAdapter(shpGrdCstmAdptr);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = view.findViewById(R.id.name);
                String tv = textView.getText().toString();
                if ( ((TextView)view.findViewById(R.id.name)).getText().toString() == "Sphere"){
                    Intent intent = new Intent(MainActivity.this, Sphere.class);
                    startActivity(intent);
                }
            }
        });

    }


}