package com.unifreelancer.masso.medicinereminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class UserProfile extends ActionBarActivity implements View.OnClickListener{




    private String username;
    private Button buttonAddMed;
    private Button buttonMyInfo;
    private Button buttonAskPharma;
    private Button buttonHelp;
    private Button buttonAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        buttonAddMed = (Button) findViewById(R.id.buttonAddMed);

        buttonAddMed.setOnClickListener(this);


        buttonMyInfo = (Button) findViewById(R.id.buttonMyInfo);

        buttonMyInfo.setOnClickListener(this);

        buttonAskPharma = (Button) findViewById(R.id.buttonAskPharma);

        buttonAskPharma.setOnClickListener(this);

        buttonHelp = (Button) findViewById(R.id.buttonHelp);

        buttonHelp.setOnClickListener(this);

        buttonAlarm = (Button) findViewById(R.id.buttonPillReminder);

        buttonAlarm.setOnClickListener(this);


        Intent intent = getIntent();
        username = intent.getStringExtra(LoginActivity.USER_NAME);

        TextView textView = (TextView) findViewById(R.id.textView3);

        textView.setText("Welcome "+username);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAddMed){

            Intent intent = new Intent(getApplicationContext(), ViewAllMedicineActivity.class);
            startActivity(intent);
        }

        if(v == buttonMyInfo){

            Intent intent = new Intent(getApplicationContext(), MyInfoActivity.class);
            intent.putExtra(ConfigCRUD.USERNAME,username);
            startActivity(intent);
        }

        if(v == buttonAskPharma){

            Intent intent = new Intent(getApplicationContext(), ChatClientServer.class);

            startActivity(intent);
        }

        if(v == buttonHelp){

            Intent intent = new Intent(getApplicationContext(), HelpServices.class);

            startActivity(intent);
        }

        if(v == buttonAlarm){

            Intent intent = new Intent(getApplicationContext(), AlarmActivity.class);

            startActivity(intent);
        }




    }

}
