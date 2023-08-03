package com.app.loginexample;

public class BMICalculator {

    public static String calculateBMI(double weightKg, double heightMeters) {
        double bmi = weightKg / (heightMeters * heightMeters);

        if (bmi < 18.5) {
            return "Tienes bajo peso.";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Tu peso es normal.";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Tienes sobrepeso.";
        } else {
            return "Tienes obesidad.";
        }
    }
}
