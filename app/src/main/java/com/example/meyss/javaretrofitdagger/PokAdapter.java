package com.example.meyss.javaretrofitdagger;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meyss.javaretrofitdagger.Repository.PokemonRepo;
import com.example.meyss.javaretrofitdagger.data.Attack;
import com.example.meyss.javaretrofitdagger.data.Pokemon;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PokAdapter extends RecyclerView.Adapter<PokAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView img;
        public TextView nametext;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nametext = (TextView) itemView.findViewById(R.id.PokName);
            img = (ImageView) itemView.findViewById(R.id.pokImg);
        }
    }

    // Store a member variable for the contacts
    private List<Pokemon> poksList;
    private  Context context;
    public PokAdapter(List<Pokemon> poksList, Context context) {
        this.poksList = poksList;
        this.context = context;
    }

    @Override
    public PokAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        System.out.println("iciiii adapter");
        // Inflate the custom layout
        View pokView = inflater.inflate(R.layout.pokemon_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(pokView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(PokAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position

        Pokemon pok = poksList.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nametext;
        textView.setText(pok.getName());
        ImageView imageView = viewHolder.img;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            URL url = new URL(pok.getImageUrl());
            imageView.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (IOException e) {
            Log.e("imageLoder", e.getMessage());
        }


    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return poksList.size();
    }
}
