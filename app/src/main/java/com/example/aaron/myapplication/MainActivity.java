package com.example.aaron.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final double[] eV = {350,200,10,12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView pushupOut = (TextView) findViewById(R.id.pushup_out_number);
        final TextView situpOut = (TextView) findViewById(R.id.situp_out_number);
        final TextView jumpingjackOut = (TextView) findViewById(R.id.jumpingjack_out_number);
        final TextView joggingOut = (TextView) findViewById(R.id.jogging_out_number);
        final TextView calories = (TextView) findViewById(R.id.calories_label);

        final TextView minuteReps = (TextView) findViewById(R.id.minute_reps);
        final EditText editText = (EditText) findViewById(R.id.number_input);

        final Spinner spinner = (Spinner) findViewById(R.id.input_fitness_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercises_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0 || position == 1) {
                    minuteReps.setText(getString(R.string.reps));
                } else {
                    minuteReps.setText(getString(R.string.minutes));
                }
                editText.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //minuteReps.setText(s.toString());
                double i = 0;
                if(!s.toString().isEmpty()) {
                    i = Double.parseDouble(s.toString());
                }

                int pn = 0;
                int sn = 0;
                int jn = 0;
                int gn = 0;
                int c = 0;
                int j = spinner.getSelectedItemPosition();

                c =  (int) (100*i/eV[j]);
                pn = (int) (eV[0]/eV[j] * i);
                sn = (int) (eV[1]/eV[j] * i);
                jn = (int) (eV[2]/eV[j] * i);
                gn = (int) (eV[3]/eV[j] * i);

                calories.setText(getString(R.string.calories) + Integer.toString(c));
                pushupOut.setText(Integer.toString(pn));
                situpOut.setText(Integer.toString(sn));
                jumpingjackOut.setText(Integer.toString(jn));
                joggingOut.setText(Integer.toString(gn));

                /*
                if(j == 0) {
                    pn = i;
                    sn = i/eV[0]*eV[1];
                } else if(j == 1) {

                } else if(j == 2) {

                } else if(j == 3) {

                }*/

            }
        });



    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
