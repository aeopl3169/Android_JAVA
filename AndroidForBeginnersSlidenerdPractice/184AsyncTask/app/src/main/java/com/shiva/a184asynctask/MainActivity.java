package com.shiva.a184asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private String[] texts = {"abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz",
            "12", "34", "56", "78", "99", "123", "456", "789", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "abc", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz",
            "12", "34", "56", "78", "99", "123", "456", "789", "1", "2", "3", "4", "5", "6", "7", "8", "9",};
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // To display a progress bar in the title. Should be call before setContentView.
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        // adapter is initialized with empty array list (third parameter).
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
        new MyTask().execute();
    }

    class MyTask extends AsyncTask<Void, String, Void> {
        private ArrayAdapter<String> stringArrayAdapter;
        private int count = 0;

        @Override
        protected void onPreExecute() {
            stringArrayAdapter = (ArrayAdapter<String>) listView.getAdapter();
            setProgressBarIndeterminate(false);
            setProgressBarVisibility(true);
            Log.d("ASYNC", "onPreExecute: ");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (String item : texts) {
                // publishProgress will automatically call onProgressUpdate
                publishProgress(item);
                Log.w("ASYNC", "doInBackground: " + item);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            stringArrayAdapter.add(values[0]);
            Log.d("ASYNC", "onProgressUpdate: " + values[0]);
            count++;
            int info = (int) (((double) count / texts.length) * 10000);
            Log.i("ASYNC","Progress bar: "+info+" count: "+count+" texts: "+texts.length);
            setProgress((int) (((double) count / texts.length) * 10000));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setProgressBarVisibility(false);
            Log.i("ASYNC", "onPostExecute called.");
            Toast.makeText(MainActivity.this, "All items added successfully.", Toast.LENGTH_SHORT).show();
        }
    }
}