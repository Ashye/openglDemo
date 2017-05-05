package com.chinatsp.glesdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.chinatsp.glesdemo.demos.AntiSmoothActivity;
import com.chinatsp.glesdemo.demos.BitmapMatrixActivity;
import com.chinatsp.glesdemo.demos.CubeActivity;
import com.chinatsp.glesdemo.demos.DrawArrowActivity;
import com.chinatsp.glesdemo.demos.DrawFirstSightActivity;
import com.chinatsp.glesdemo.demos.DrawIcosahedronActivity;
import com.chinatsp.glesdemo.demos.DrawLineActivity;
import com.chinatsp.glesdemo.demos.DrawPointActivity;
import com.chinatsp.glesdemo.demos.DrawRoud2DActivity;
import com.chinatsp.glesdemo.demos.DrawRoudActivity;
import com.chinatsp.glesdemo.demos.DrawSolarSystemActivity;
import com.chinatsp.glesdemo.demos.DrawSphereActivity;
import com.chinatsp.glesdemo.demos.DrawTriangleActivity;
import com.chinatsp.glesdemo.demos.HelloActivity;
import com.chinatsp.glesdemo.demos.LandMarkActivity;
import com.chinatsp.glesdemo.demos.LightingActivity;
import com.chinatsp.glesdemo.demos.DrawRoutineActivity;

public class MainActivity extends AppCompatActivity {

    private ListView lvDemos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListView();
    }

    private String[] labels = {
            "Hello world",
            "Point",
            "Lines",
            "Triangle",
            "DrawIcosahedron",
            "DrawSolarSystem",
            "DrawSphere",
            "Lighting",


            "Cube",
            "Arrow",

            "Bitmap Matrix",
            "LandMark",
            "Anti smooth",
            "routine",
            "First sight",
            "draw route before",
            "2d draw route before",
    };
    private void initListView() {
        lvDemos = (ListView)findViewById(R.id.lv_demos);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, labels);
        lvDemos.setAdapter(adapter);

        lvDemos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, HelloActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, DrawPointActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, DrawLineActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, DrawTriangleActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, DrawIcosahedronActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, DrawSolarSystemActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, DrawSphereActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, LightingActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, CubeActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, DrawArrowActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, BitmapMatrixActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, LandMarkActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(MainActivity.this, AntiSmoothActivity.class));
                        break;
                    case 13:
                        startActivity(new Intent(MainActivity.this, DrawRoutineActivity.class));
                        break;
                    case 14:
                        startActivity(new Intent(MainActivity.this, DrawFirstSightActivity.class));
                        break;
                    case 15:
                        startActivity(new Intent(MainActivity.this, DrawRoudActivity.class));
                        break;
                    case 16:
                        startActivity(new Intent(MainActivity.this, DrawRoud2DActivity.class));
                        break;
                }

            }
        });
    }

}
