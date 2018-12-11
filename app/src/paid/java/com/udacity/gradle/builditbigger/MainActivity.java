package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.displayjokelib.DisplayActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create the InterstitialAd and set the adUnitId.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        displayJoke();
    }
    public void displayJoke(){
        new EndpointAsyncTask(){
            @Override
            protected void onPostExecute(String s) {
                System.out.println("ganesh in the string::"+s);
                if (s != null ) {
                    Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                    intent.putExtra("joke", s);
                    getApplicationContext().startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Couldnt fetch the Joke", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }

}
