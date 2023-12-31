package com.app.loginexample;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        welcomeTextView.setText(String.format("Bienvenido, %s!", username));

        // Inicializa los elementos de la interfaz.
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        bmiResultTextView = findViewById(R.id.bmiResultTextView);

        // Configura el botón para calcular el IMC.
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(v -> calculateBMI());
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

        // Calcular el IMC utilizando la clase BMICalculator.
        String result = BMICalculator.calculateBMI(weightKg, heightMeters);

        // Mostrar el resultado del IMC en el TextView del XML.
        bmiResultTextView.setText(result);

        // Agregar la animación de desvanecimiento al mostrar el resultado.
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        bmiResultTextView.startAnimation(fadeInAnimation);
    }
}
