package com.cikarastudio.cikaradalgonacoffee.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cikarastudio.cikaradalgonacoffee.Adapter.Adapter;
import com.cikarastudio.cikaradalgonacoffee.Model.Dalgona;
import com.cikarastudio.cikaradalgonacoffee.R;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;

public class KumpulanResepActivity extends AppCompatActivity {
    private ImageView img_kembali;
    private RecyclerView rvDalgona;
    private ArrayList<Dalgona> list = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumpulan_resep);

        rvDalgona = findViewById(R.id.rv_listDalgona);
        rvDalgona.setHasFixedSize(true);
        list.addAll(getListDalgona());
        showRecyclerList();

        img_kembali = findViewById(R.id.img_kembali);

        img_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kembali = new Intent(KumpulanResepActivity.this, MainActivity.class);
                startActivity(kembali);
                finish();
            }
        });
    }

    private void showRecyclerList() {
        layoutManager = new LinearLayoutManager(this);
        rvDalgona.setLayoutManager(layoutManager);
        Adapter listDalgonaAdapter = new Adapter(list);
        rvDalgona.setAdapter(listDalgonaAdapter);

        listDalgonaAdapter.setOnItemClickCallback(new Adapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Dalgona data) {
                Intent detaildalgona = new Intent(KumpulanResepActivity.this, DeskripsiActivity.class);
                detaildalgona.putExtra(DeskripsiActivity.EXTRA_MASSAGE, data);
                startActivity(detaildalgona);
                finish();
            }
        });
    }

    private ArrayList<Dalgona> getListDalgona() {
        String[] dataTitle = getResources().getStringArray(R.array.data_judul);
        String[] dataDescription = getResources().getStringArray(R.array.data_deskripsi);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo_dalgona);
        TypedArray dataPhoto2 = getResources().obtainTypedArray(R.array.data_photo_dalgona_deskripsi);
        ArrayList<Dalgona> listDalgona = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Dalgona dalgona = new Dalgona();
            dalgona.setJudul(dataTitle[i]);
            dalgona.setDeskripsi(dataDescription[i]);
            dalgona.setImage(dataPhoto.getResourceId(i, -1));
            dalgona.setImage2(dataPhoto2.getResourceId(i, -1));
            listDalgona.add(dalgona);
        }
        return listDalgona;
    }
}
