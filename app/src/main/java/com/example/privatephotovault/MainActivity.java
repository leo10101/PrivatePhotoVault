package com.example.privatephotovault;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), CreateAlbumActivity.class);
                startActivity(intent);
                finish();
            }
        });

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.Albumgallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<AlbumList> albumLists = prepareData();
        AlbumAdapter adapter = new AlbumAdapter(getApplicationContext(), albumLists);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<AlbumList> prepareData(){

        ArrayList<String> album_titles = new ArrayList<String>();
        ArrayList<ArrayList<Integer> >  albumImages = new ArrayList<ArrayList<Integer> >();

        SQLiteDatabase myDB = openOrCreateDatabase("my.db", MODE_PRIVATE, null);

        myDB.execSQL(
                "CREATE TABLE IF NOT EXISTS Albums (name VARCHAR(200))"
        );
        Cursor albumCursor = myDB.rawQuery("select name from Albums", null);
        int albumCount=0;
        while(albumCursor.moveToNext()) {
            String name = albumCursor.getString(0);
            album_titles.add(name);
            String sqlCommand= "CREATE TABLE IF NOT EXISTS"+ name +"(id INT)";
            myDB.execSQL(
                    sqlCommand
            );
            String sqlCommand2= "select id from"+" "+name;
            Cursor imageCursor = myDB.rawQuery(sqlCommand2, null);
            int imageCount=0;
            while(imageCursor.moveToNext()){

                albumImages.get(albumCount).set(imageCount,imageCursor.getInt(imageCount));
            }


        }


        ArrayList<Integer> privateVault = new ArrayList<Integer>();
        privateVault.add(R.drawable.img1);
        albumImages.add(privateVault);

        ArrayList<AlbumList> theimage = new ArrayList<>();
        for(int i = 0; i< album_titles.size(); i++){
            AlbumList albumList = new AlbumList();
            albumList.setImage_title(album_titles.get(i));
            albumList.setImageIDs(albumImages.get(i));
            theimage.add(albumList);
        }
        return theimage;
    }
}