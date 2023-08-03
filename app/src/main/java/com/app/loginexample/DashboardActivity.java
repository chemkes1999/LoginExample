package com.app.loginexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView bmiResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Recupera el nombre de usuario pasado desde la actividad de inicio de sesión.
        String username = getIntent().getStringExtra("USERNAME_EXTRA");

        // Muestra el nombre de usuario en la pantalla de bienvenida.
        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        welcomeTextView.setText("Bienvenido, " + username + "!");

        // Inicializa los elementos de la interfaz.
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        bmiResultTextView = findViewById(R.id.bmiResultTextView);

        // Configura el botón para calcular el IMC.
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Obtener el peso y la altura ingresados por el usuario.
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            // Si los campos están vacíos, mostrar un mensaje de error.
            bmiResultTextView.setText("Por favor, ingresa el peso y la altura.");
            return;
        }

        // Convertir los valores a números (peso en kg y altura en metros).
        double weightKg = Double.parseDouble(weightStr);
        double heightMeters = Double.parseDouble(heightStr);

        // Calcular el IMC.
        double bmi = weightKg / (heightMeters * heightMeters);

        // Mostrar el resultado del IMC en el TextView del XML.
        bmiResultTextView.setText(String.format("Tu IMC es: %.2f", bmi));
    }
}
