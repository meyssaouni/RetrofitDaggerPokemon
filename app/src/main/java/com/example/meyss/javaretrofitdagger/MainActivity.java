package com.example.meyss.javaretrofitdagger;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.meyss.javaretrofitdagger.Repository.PokemonRepo;
import com.example.meyss.javaretrofitdagger.data.Attack;
import com.example.meyss.javaretrofitdagger.data.Pokemon;
import com.example.meyss.javaretrofitdagger.data.PokemonList;
import com.example.meyss.javaretrofitdagger.di.ApiInterface;
import com.example.meyss.javaretrofitdagger.di.App;

import javax.inject.Inject;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    ApiInterface apiInterface;
    @Inject
    PokemonRepo repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView pokRC = (RecyclerView) findViewById(R.id.PokRecycler);
        //App.getAppComponent().inject(this);


        apiInterface.listPokemeon().enqueue(new Callback<PokemonList>() {
            @Override
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {

                PokemonList result = response.body();

                if (result != null) {
                    //retrofit
                    System.out.println("pokemons:"+result.getPoks().toString());
                        PokAdapter pokAdapter = new PokAdapter(result.getPoks(),getApplicationContext());
                        pokRC.setAdapter(pokAdapter);
                        pokRC.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                    //room

                   // PokemonRepo repo = new PokemonRepo(context);
                    int i=0;
                    for (Pokemon pok : result.getPoks()) {
                        System.out.println(pok.getId());
                        if (pok.getId().equals( "hgss2-90")) {
                            i++;

                        } else {
                            for (Attack a : pok.getAttacks()) {
                                a.setPokId(pok.getId());
                                a.setAttackId(i);
                                i++;
                            }
                            repo.insertAttack(pok.getAttacks());
                            System.out.println(" attatcks inserted");
                        }

                    }
                    repo.insertPok(result.getPoks());
                    System.out.println( "room relations");
                    System.out.println(repo.getAttacks());

                }
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable t) {
                t.printStackTrace();
            }
        });
        //System.out.println( apiInterface.listPokemeon().enqueue(new););
       // Log.e("my retrofit", apiInterface.listPokemeon().toString());

    }
}
