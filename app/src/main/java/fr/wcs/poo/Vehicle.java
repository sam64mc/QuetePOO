package fr.wcs.poo;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by bkrettly on 21/08/17.
 */

class Vehicle {

    private String brand;
    private String model;

    Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getDescription(Context context) {
        return context.getResources().getString(R.string.brand) + " : " + brand + "\n"
                + context.getResources().getString(R.string.model) + " : " + model + "\n";
    }

    public Drawable getVehicleIcon(Context context) {
        return null;
    }
}
