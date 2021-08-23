package com.example.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.i("TESTING", "on start loading wala log");
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Earthquake> loadInBackground() {



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Log.i("TESTING", "load in background wala log");
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        Log.i("TESTING", "fetch earthquake ke niche wala log");
        return earthquakes;
    }
}
