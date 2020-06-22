package com.cikarastudio.cikaradalgonacoffee.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cikarastudio.cikaradalgonacoffee.Model.Dalgona;
import com.cikarastudio.cikaradalgonacoffee.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder> {

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Dalgona data);
    }


    private ArrayList<Dalgona> listDalgona;

    public Adapter(ArrayList<Dalgona> listDalgona) {
        this.listDalgona = listDalgona;
    }
    @NonNull
    @Override
    public Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Dalgona dalgona = listDalgona.get(position);
        holder.img_list.setImageResource(dalgona.getImage());
        holder.tv_judul.setText(dalgona.getJudul());
        holder.tv_deskripsi.setText(dalgona.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listDalgona.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDalgona.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView img_list;
        TextView tv_judul;
        TextView tv_deskripsi;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            img_list = itemView.findViewById(R.id.img_list);
            tv_judul = itemView.findViewById(R.id.tv_judul);
            tv_deskripsi = itemView.findViewById(R.id.tv_deskripsi);

        }
    }
}
