package com.example.volumecalculator;

import android.os.Bundle;
import android.widget.GridView;

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

    }
}