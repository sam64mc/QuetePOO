package fr.wcs.poo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        String brand = intent.getStringExtra("brand");
        String model = intent.getStringExtra("model");
        String kilometers = intent.getStringExtra("kilometers");
        String hours = intent.getStringExtra("hours");
        String power = intent.getStringExtra("power");

        Vehicle vehicle = null;
        if (type == 1) {
            vehicle = new Car(brand, model, kilometers);
        } else if (type == 2) {
            vehicle = new Boat(brand, model, hours);
        } else if (type == 3) {
            vehicle = new Moto(brand, model, power);
        }

        if (vehicle != null) {
            ImageView icon = (ImageView) findViewById(R.id.vehicle_icon);
            icon.setImageDrawable(vehicle.getVehicleIcon(VehicleActivity.this));

            TextView description = (TextView) findViewById(R.id.vehicle_description);
            description.setText(vehicle.getDescription(VehicleActivity.this));
        }
    }
}