package com.unifreelancer.masso.medicinereminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminProfile extends AppCompatActivity implements View.OnClickListener{

    public static final String USER_NAME = "USER_NAME";

    private String username;
    private Button buttonAddMed;
    private Button buttonMyInfo;
    private Button buttonAskPharma;
    private Button buttonHelp;
    private Button buttonAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        buttonAddMed = (Button) findViewById(R.id.buttonAddMed);

        buttonAddMed.setOnClickListener(this);


        buttonMyInfo = (Button) findViewById(R.id.buttonMyInfo);

        buttonMyInfo.setOnClickListener(this);

        buttonAskPharma = (Button) findViewById(R.id.buttonAskPharma);

        buttonAskPharma.setOnClickListener(this);

        buttonHelp = (Button) findViewById(R.id.buttonHelp);

        buttonHelp.setOnClickListener(this);




        Intent intent = getIntent();
        username = intent.getStringExtra(LoginActivity.USER_NAME);

        TextView textView = (TextView) findViewById(R.id.textView3);

        textView.setText("Welcome "+username);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAddMed){


            Intent intent = new Intent(getApplicationContext(), AddMedicineActivity.class);
            intent.putExtra(USER_NAME,username);
            startActivity(intent);
        }

        if(v == buttonMyInfo){

            Intent intent = new Intent(getApplicationContext(), MyInfoActivity.class);
            intent.putExtra(ConfigCRUD.USERNAME,username);
            startActivity(intent);
        }

        if(v == buttonAskPharma){

            Intent intent = new Intent(getApplicationContext(), EmailActivity.class);

            startActivity(intent);
        }

        if(v == buttonHelp){

            Intent intent = new Intent(getApplicationContext(), HelpServices.class);

            startActivity(intent);
        }

    }

}
