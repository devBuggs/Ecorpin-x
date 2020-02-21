package com.ecorpin.ecorpin_x;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InternFetch extends AsyncTask<Void, Void, Void> {
    String data;

    String dataParsed ="";
    String singleParsed = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL internURL = new URL("https://ecorpin.firebaseapp.com/assets/resource/ecorpinIntern.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) internURL.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line="";
            while(line!=null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            String crappyPrefix = "null";

            if(data.startsWith(crappyPrefix)){
                data = data.substring(crappyPrefix.length(), data.length());
            }

            JSONArray ecorpinInternJSON = new JSONArray(data);
            for(int i=0; i<ecorpinInternJSON.length(); i++){
                System.out.println("making JSON Object");
                JSONObject JO = (JSONObject) ecorpinInternJSON.get(i);
                singleParsed = "Certificate No.: " + JO.get("certificate") + "\n" +
                               "Name: " + JO.get("name") + "\n" +
                               "Designation: " + JO.get("designation") +"\n" +
                               "Date: " + JO.get("fromDate") + " - " + JO.get("toDate") +"\n" +
                               "Email: " + JO.get("email") + "\n";

                dataParsed = dataParsed + singleParsed + "\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Ecorpin_Intern.internButton.setText("Ecorpin Internship");
        Ecorpin_Intern.internData.setText(this.dataParsed);
    }
}
