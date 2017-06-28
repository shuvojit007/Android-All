package com.example.shobojit.siunotice;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shobojit.siunotice.model.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class Asyntask_test_2 extends AppCompatActivity {
    private Button btn;
    String result="";
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyntask_test_2);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button Clicked ",Toast.LENGTH_SHORT).show();
               // new Demoasyntask().execute("https://jsonparsing.parseapp.com/jsonData/moviesDemoItem.txt");
                    new Demoasyntask().execute("https://jsonparsing.parseapp.com/jsonData/moviesDemoList.txt");
            }
        });
        txt = (TextView) findViewById(R.id.txt);

    }
    class Demoasyntask extends AsyncTask<String, String, List<model>> {

        @Override
        protected List<model> doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line="";
                StringBuffer buffer = new StringBuffer();
                while((line=br.readLine())!=null){
                    buffer.append(line);
                }

              result = buffer.toString();
                model moviemodel = new model();

                JSONObject parentObject = new JSONObject(result);
                JSONArray array = parentObject.getJSONArray("movies");
                List<model> flist = new ArrayList<>();
                for (int i = 0; i<array.length();i++){
                    JSONObject finalObject = array.getJSONObject(i);
                  moviemodel.setMovie(finalObject.getString("movie"));
                    moviemodel.setYear(finalObject.getInt("year"));
                    moviemodel.setRating((float) finalObject.getDouble("rating"));
                    moviemodel.setDirector(finalObject.getString("director"));
                    moviemodel.setStory(finalObject.getString("story"));
                    moviemodel.setDuration(finalObject.getString("duration"));
                    moviemodel.setTagline(finalObject.getString("tagline"));
                    moviemodel.setImage(finalObject.getString("image"));

                  //  stringBuffer.append(movie_name+ " : "+year+"\n" );
                    List<model.Cast> clist = new ArrayList<>();
                    for(int j = 0;j>finalObject.getJSONArray("cast").length();j++){
                        model.Cast cast = new model.Cast();
                        cast.setName(finalObject.getJSONArray("cast").getJSONObject(j).getString("name"));
                        clist.add(cast);
                    }
                    moviemodel.setCastList(clist);
                    flist.add(moviemodel);
                }
                //new add value in list


                return flist;

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
        protected void onPostExecute(List<model> models) {
            super.onPostExecute(models);
        }
    }
}
class Mylistadapter extends ArrayAdapter{

    public Mylistadapter(Context context, int resource) {
        super(context, resource);
    }
}
