package com.app.loginexample;

import java.text.DecimalFormat;

public class BMICalculator {

    public static String calculateBMI(double weightKg, double heightMeters) {
        double bmi = weightKg / (heightMeters * heightMeters);
        String formattedBMI = formatBMI(bmi);

        return generateResultMessage(formattedBMI);
    }

    private static String formatBMI(double bmiValue) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(bmiValue);
    }

    private static String generateResultMessage(String formattedBMI) {
        double bmi = Double.parseDouble(formattedBMI);

        if (bmi < 18.5) {
            return "Tu índice es de " + formattedBMI + ". Tienes bajo peso.";
        } else if (bmi < 24.9) {
            return "Tu índice es de " + formattedBMI + ". Tu peso es normal.";
        } else if (bmi < 29.9) {
            return "Tu índice es de " + formattedBMI + ". Tienes sobrepeso.";
        } else {
            return "Tu índice es de " + formattedBMI + ". Tienes obesidad.";
        }
    }
}
