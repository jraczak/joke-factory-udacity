package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.justinraczak.android.jokedispenser.JokeActivity;
import com.justinraczak.android.jokes.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Justin on 3/5/17.
 */

class JokeBackendAsyncTask extends AsyncTask<Context, Void, String> {
    private MyApi myApi = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApi == null) {
            //MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
            //        new AndroidJsonFactory(), null)
            //        // Set options for running against local server
            //        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
            //        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            //            @Override
            //            public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
            //                request.setDisableGZipContent(true);
            //            }
            //        });

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://joke-factory-160303.appspot.com/_ah/api/");
            // End of options for local / dev server
            myApi = builder.build();
        }

        context = params[0];
        //String name = params[0].second;

        try {
            return myApi.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        //Toast.makeText(context, s, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra("joke", s);
        context.startActivity(intent);
    }
}
