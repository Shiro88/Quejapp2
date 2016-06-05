package com.pqrs.sena.quejapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by FAMILIA on 05/06/2016.
 */

public class LoadingTask extends AsyncTask<String,Integer,Integer>{

    public interface  LoadingTaskFinishedListener{
        void onTaskFinished();
    }

    private final ProgressBar progressBar;

    private final LoadingTaskFinishedListener finishedListener;

    public LoadingTask(ProgressBar progressBar,LoadingTaskFinishedListener finishedListener){
        this.progressBar = progressBar;
        this.finishedListener = finishedListener;
    }


    @Override
    protected Integer doInBackground(String... params) {

        Log.i("Tutorial", "Starting task with url: "+params[0]);
        downloadResources();
        // Perhaps you want to return something to your post execute
        return 1234;
    }

    private void downloadResources() {
        // We are just imitating some process thats takes a bit of time (loading of resources / downloading)
        int count = 2;
        for (int i = 0; i < count; i++) {

            // Update the progress bar after every step
            int progress = (int) ((i / (float) count) * 100);
            publishProgress(progress);

            // Do some long loading things
            try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
        }
    }

    private boolean resourcesDontAlreadyExist() {
        // Here you would query your app's internal state to see if this download had been performed before
        // Perhaps once checked save this in a shared preference for speed of access next time
        return true; // returning true so we show the splash every time
    }

    protected void onProgreeUpdate(Integer...values){
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }
    protected void onPostExecute(Integer result){
        super.onPostExecute(result);
        finishedListener.onTaskFinished();
    }
}
