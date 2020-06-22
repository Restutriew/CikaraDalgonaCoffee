package com.cikarastudio.cikaradalgonacoffee.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cikarastudio.cikaradalgonacoffee.R;

public class MainActivity extends AppCompatActivity{
    ImageView img_listResep, img_keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_listResep = findViewById(R.id.img_listResep);
        img_keluar = findViewById(R.id.img_keluar);

        img_listResep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listresep = new Intent(MainActivity.this,KumpulanResepActivity.class);
                startActivity(listresep);
                finish();
            }
        });

        img_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


}
