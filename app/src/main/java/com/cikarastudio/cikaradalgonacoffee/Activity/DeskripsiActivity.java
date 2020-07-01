package com.cikarastudio.cikaradalgonacoffee.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cikarastudio.cikaradalgonacoffee.Model.Dalgona;
import com.cikarastudio.cikaradalgonacoffee.R;

public class DeskripsiActivity extends AppCompatActivity {
    public static final String EXTRA_MASSAGE = "extra_dalgona";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);
        TextView tv_judul = findViewById(R.id.tv_judul);
        TextView tv_deskripsi = findViewById(R.id.tv_deskripsi);
        ImageView img_deskripsi = findViewById(R.id.img_deskripsi);

        Dalgona dalgona = getIntent().getParcelableExtra(EXTRA_MASSAGE);
        String title = dalgona.getJudul();
        String deskripsi = dalgona.getDeskripsi();
        int photo = dalgona.getImage2();

        tv_judul.setText(title);
        tv_deskripsi.setText(deskripsi);
        img_deskripsi.setImageResource(photo);

        ImageView img_kembali = findViewById(R.id.imageView13);
        img_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}
