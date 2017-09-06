package helpers;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ammach on 7/22/2016.
 */
public class ReadTask extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... params) {
        try {
            URL url=new URL(params[0]);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            InputStream is=con.getInputStream();
            InputStreamReader isreader=new InputStreamReader(is);
            BufferedReader reader=new BufferedReader(isreader);
            String s="";
            String result="";
            while ((s=reader.readLine())!=null) {
                   result+=s;
               }
                return result;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
           }
        return null;
    }
}
