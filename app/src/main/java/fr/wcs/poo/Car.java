package fr.wcs.poo;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by bkrettly on 21/08/17.
 */

public class Car extends Vehicle {

    private String kilometers;

    public Car(String brand, String model, String kilometers) {
        super(brand, model);
        this.kilometers = kilometers;
    }

    public String getDescription(Context context) {
        return super.getDescription(context)
                + context.getResources().getString(R.string.kilometers) + " : " + kilometers;
    }

    public Drawable getVehicleIcon(Context context) {
        return context.getResources().getDrawable(R.drawable.ic_directions_car_black_24dp);
    }
}
