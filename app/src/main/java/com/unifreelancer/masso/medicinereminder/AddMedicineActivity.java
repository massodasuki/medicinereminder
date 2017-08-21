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

public class AddMedicineActivity extends AppCompatActivity implements View.OnClickListener{

    //Defining views
    private EditText editTextName;
    private EditText editTextDesg;
    private EditText editTextPrice;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);


        //Initializing views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDesg = (EditText) findViewById(R.id.editTextDesg);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Adding an employee
    private void addMedicine(){


        final String name = editTextName.getText().toString().trim();
        final String description = editTextDesg.getText().toString().trim();
        final String price = editTextPrice.getText().toString().trim();

        class AddMedicine extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(AddMedicineActivity.this,"Adding...","Wait...",false,false);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(AddMedicineActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {

                HashMap<String,String> params = new HashMap<>();

                params.put(ConfigCRUD.KEY_EMP_NAME,name);
                params.put(ConfigCRUD.KEY_EMP_DESC,description);
                params.put(ConfigCRUD.KEY_EMP_PRICE,price);

                RequestHandlerCRUD rh = new RequestHandlerCRUD();
                String res = rh.sendPostRequest(ConfigCRUD.URL_ADD, params);
                return res;
            }
        }

        AddMedicine ae = new AddMedicine();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addMedicine();
        } else if(v == buttonView){
            startActivity(new Intent(this,ViewAllMedicineActivity.class));
        }
    }
}
