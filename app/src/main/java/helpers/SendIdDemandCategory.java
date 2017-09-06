package helpers;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import config.Configuration;

/**
 * Created by youness on 2017-08-13.
 */

public class SendIdDemandCategory extends AsyncTask<Long,Void,String> {
    @Override
    protected String doInBackground(Long... params) {
        JSONObject jsonTaskDep = new JSONObject();

        try {
            jsonTaskDep.put("id", params[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        String msg = jsonTaskDep.toString();


        HttpClient client= new DefaultHttpClient();
        HttpPost post=new HttpPost("http://"+ Configuration.local+":8080/kt_FST_2/webresources/DemandCategory/find");
        post.setHeader("content-type","application/json");

        try {
            StringEntity entity=new StringEntity(msg, "UTF8");
            post.setEntity(entity);

            HttpResponse response=client.execute(post);
            BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            String result="";
            while ((line = rd.readLine()) != null) {
                result+=line;
            }
            return result;
//            if(response.getStatusLine().getStatusCode()==204){
//                return  "request sent successefully";
//            }
//            else {
//                return  response.getAllHeaders().toString();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
