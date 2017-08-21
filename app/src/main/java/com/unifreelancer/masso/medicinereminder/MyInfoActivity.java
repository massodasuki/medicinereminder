package com.unifreelancer.masso.medicinereminder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyInfoActivity extends AppCompatActivity {


    private TextView pTextMyName;
    private TextView pTextUserName;
    private TextView pTextEmail;

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        Intent intent = getIntent();

        username = intent.getStringExtra(ConfigCRUD.USERNAME);
        Log.i("WHAT IS THE USERNAME : ", username);
        pTextMyName = (TextView) findViewById(R.id.TextMyName);
        pTextUserName = (TextView) findViewById(R.id.TextUserName);
        pTextEmail = (TextView) findViewById(R.id.TextEmail);

        getEmployee();
    }

    private void getEmployee(){
        class GetMedicine extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MyInfoActivity.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandlerCRUD rh = new RequestHandlerCRUD();
                String s = rh.sendGetRequestParam(ConfigCRUD.URL_GET_USER_INFO,username);
                return s;
            }
        }
        GetMedicine ge = new GetMedicine();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(ConfigCRUD.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String name = c.getString(ConfigCRUD.TAG_MYNAME);
            String username = c.getString(ConfigCRUD.TAG_MYUSERNAME);
            String password = c.getString(ConfigCRUD.TAG_MYPASSWORD);
            String email = c.getString(ConfigCRUD.TAG_MYEMAIL);

            Log.i("WHAT IS THE USERNAME : ", email);

            pTextMyName.setText(name);
            pTextUserName.setText(username);
            pTextEmail.setText(email);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
