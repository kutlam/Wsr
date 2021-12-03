package com.example.wsr;

import android.os.AsyncTask;

import java.io.IOException;

public class postTask extends AsyncTask {

    @Override
    protected Void doInBackground(Object[] objects) {
        if (objects.length == 2)
        {
            try {
                DBhelper.SignInPost(objects[0].toString(), objects[1].toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (objects.length == 4)
        {
            try {
                DBhelper.RegPOST(objects[0].toString(), objects[1].toString(), objects[2].toString(), objects[3].toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public postTask () {
        super ( );
    }

    @Override
    protected void onPreExecute () {
        super.onPreExecute ( );
    }

    @Override
    protected void onPostExecute (Object o) {

    }

    @Override
    protected void onProgressUpdate (Object[] values) {
        super.onProgressUpdate (values);
    }

    @Override
    protected void onCancelled (Object o) {
        super.onCancelled (o);
    }

    @Override
    protected void onCancelled () {
        super.onCancelled ( );
    }
}
