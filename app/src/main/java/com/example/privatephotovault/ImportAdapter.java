package com.example.privatephotovault;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImportAdapter extends RecyclerView.Adapter<ImportAdapter.ViewHolder> {
    private String[] arrPath ;
    private Context context;


    public ImportAdapter(Context context, String[] arrPath ) {
        this.arrPath = arrPath;
        this.context = context;
    }

    @Override
    public ImportAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_layout, viewGroup, false);
        return new ImportAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImportAdapter.ViewHolder viewHolder, int i) {

        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.img.setImageURI(Uri.parse(arrPath[i]));
    }

    @Override
    public int getItemCount() {
        return arrPath.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        public ViewHolder(View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.img);
        }
    }
}