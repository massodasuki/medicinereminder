package com.unifreelancer.masso.medicinereminder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String USER_NAME = "USER_NAME";

    public static final String PASSWORD = "PASSWORD";

    /*Masso punya
    private static final String LOGIN_URL = "http://khamra.biz/login.php";
    */
    private static final String LOGIN_URL = "http://pocketmedicinee.com/login.php";

    private EditText editTextUserName;
    private EditText editTextPassword;

    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonLogin = (Button) findViewById(R.id.login);

        buttonLogin.setOnClickListener(this);
    }


    private void login(){
        String username = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        userLogin(username,password);
    }

    private void userLogin(final String username, final String password){
        class UserLoginClass extends AsyncTask<String,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {

                super.onPreExecute();
                loading = ProgressDialog.show(LoginActivity.this,"Please Wait",null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equalsIgnoreCase("success")){
                        if (Objects.equals(username, "admin")){
                            Intent intent = new Intent(LoginActivity.this, AdminProfile.class);
                            intent.putExtra(USER_NAME, username);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(LoginActivity.this, UserProfile.class);
                            intent.putExtra(USER_NAME, username);
                            startActivity(intent);
                        }
                }else{
                    Toast.makeText(LoginActivity.this,s,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String,String> data = new HashMap<>();
                data.put("username",params[0]);
                data.put("password",params[1]);

                RegisterUserClass ruc = new RegisterUserClass();

                String result = ruc.sendPostRequest(LOGIN_URL,data);

                return result;
            }
        }
        UserLoginClass ulc = new UserLoginClass();
        ulc.execute(username,password);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonLogin){
            login();
        }
    }
}