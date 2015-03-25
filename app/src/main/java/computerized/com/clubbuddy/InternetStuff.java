package computerized.com.clubbuddy;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Primary function is to make calls to the server and get a result
 */
public class InternetStuff extends AsyncTask {
    public String query(String url)
    {
        URL preset = null;
        try {
            preset = new URL("http://hackathon.fernandomendez.io/"+url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            preset.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine;
        String result = "";

        try {
            while ((inputLine = in.readLine()) != null)
            //    System.out.println(inputLine);
                result += inputLine;
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // TODO: Make this work

    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }
}
