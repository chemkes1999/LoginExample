package com.app.loginexample;

import java.text.DecimalFormat;

public class BMICalculator {

    public static String calculateBMI(double weightKg, double heightMeters) {
        double bmi = weightKg / (heightMeters * heightMeters);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double bmiValue = weightKg / (heightMeters * heightMeters);
        String formattedBMI = decimalFormat.format(bmiValue);
        if (bmi < 18.5) {
            return "Tu índice es de " + formattedBMI + ". Tienes bajo peso.";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Tu índice es de " + formattedBMI + ". Tu peso es normal.";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Tu índice es de " + formattedBMI + ". Tienes sobrepeso.";
        } else {
            return "Tu índice es de " + formattedBMI + " .Tienes obesidad.";
        }
    }
}
