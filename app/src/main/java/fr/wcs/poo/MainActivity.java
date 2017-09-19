package fr.wcs.poo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText brand = (EditText) findViewById(R.id.brand);
        final EditText model = (EditText) findViewById(R.id.model);
        final EditText kilometers = (EditText) findViewById(R.id.kilometers);
        final EditText hours = (EditText) findViewById(R.id.hours);
        final EditText power = (EditText) findViewById(R.id.power);
        final Button send = (Button) findViewById(R.id.send);

        final Spinner spinner = (Spinner) findViewById(R.id.vehicle_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicule_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                send.setEnabled(i > 0);
                if(i == 0){
                    kilometers.setVisibility(View.GONE);
                    hours.setVisibility(View.GONE);
                    power.setVisibility(View.GONE);
                } else if (i == 1) {
                    // car
                    kilometers.setVisibility(View.VISIBLE);
                    hours.setVisibility(View.GONE);
                    power.setVisibility(View.GONE);
                } else if (i == 2) {
                    // boat
                    kilometers.setVisibility(View.GONE);
                    hours.setVisibility(View.VISIBLE);
                    power.setVisibility(View.GONE);
                } else if (i == 3) {
                    // moto
                    kilometers.setVisibility(View.GONE);
                    hours.setVisibility(View.GONE);
                    power.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VehicleActivity.class);
                intent.putExtra("type", spinner.getSelectedItemPosition());
                intent.putExtra("brand", brand.getText().toString());
                intent.putExtra("model", model.getText().toString());
                intent.putExtra("kilometers", kilometers.getText().toString());
                intent.putExtra("hours", hours.getText().toString());
                intent.putExtra("power", power.getText().toString());
                startActivity(intent);
            }
        });
    }
}
