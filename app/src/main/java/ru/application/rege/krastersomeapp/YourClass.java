package ru.application.rege.krastersomeapp;

import java.net.URL;
import java.io.InputStreamReader;
import java.net.URLConnection;

import android.os.AsyncTask;
import android.util.Log;


/**
 * Created by rege on 11.04.17.
 */

class YourClass implements MainSet {

    private static final String TAG = "EXAMPLE";

    @Override
    public String onButtonEvent(ButtonType button, ButtonEvent event) {
        Log.i(TAG, "I have an event: button "+button.name()+", event "+event.name()+".");
        String url="http://192.168.4.1/"+button.name()+"_"+event.name();



        new RequestAsyncTask(url).execute();
        return null;
    }



    @Override
    public String onConfigurationApplied(Configuration conf) {
        Log.i(TAG, "configured");
        return null;
    }

    @Override
    public void onStart() {
        Log.i(TAG, "start");
    }

    @Override
    public void onStop() {
        Log.i(TAG, "stop");
    }

    private class RequestAsyncTask extends AsyncTask<String, Integer, Void> {

        private static final String TAG = "REQUEST";
        String url="";

        RequestAsyncTask(String str){
            url=str;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(String... params) {
            try
            {
                // загрузка страницы
                URL url = new URL(this.url);
                URLConnection conn = url.openConnection();
                InputStreamReader rd = new InputStreamReader(conn.getInputStream());
                StringBuilder allpage = new StringBuilder();
                int n = 0;
                char[] buffer = new char[40000];
                while (n >= 0)
                {
                    n = rd.read(buffer, 0, buffer.length);
                    if (n > 0)
                    {
                        allpage.append(buffer, 0, n);
                    }
                }
                Log.i(TAG, "Server return: "+allpage+".");
            }
            catch (Exception e)
            {
                Log.i(TAG, "Oooops. Net ERROR. " + e.toString());
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {


        }

        @Override
        protected void onPostExecute(Void result) {
        }
    }

}

