package com.example.gam3r.partyrocker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView currentSong,upcomingSongs;
    String[] currSong = {"Tum hi ho bandu"};
    String[] upcomingSong ={"Bhula dena","teri yaad","Titanic","askjdklasjlkd","adkjsadkaslk"} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        currentSong= (ListView) findViewById(R.id.listview1);
        upcomingSongs= (ListView) findViewById(R.id.example_lv_list);
//        ArrayAdapter<String> currSongs = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,currSong);
        ArrayAdapter<String> upcoming = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,upcomingSong);
//        currentSong.setAdapter(currSongs);
        upcomingSongs.setAdapter(upcoming);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
