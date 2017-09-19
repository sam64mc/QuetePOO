package fr.wcs.poo;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by bkrettly on 21/08/17.
 */

public class Moto extends Vehicle {

    private String power;

    public Moto(String brand, String model, String power) {
        super(brand, model);
        this.power = power;
    }

    public String getDescription(Context context) {
        return super.getDescription(context)
                + context.getResources().getString(R.string.power) + " : " + power;
    }

    public Drawable getVehicleIcon(Context context) {
        return context.getResources().getDrawable(R.drawable.ic_motorcycle_black_24dp);
    }
}
