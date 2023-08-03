package com.app.loginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();

                if (!username.isEmpty()) {
                    // Aquí puedes agregar lógica para verificar el inicio de sesión.
                    // Por ahora, simplemente lo redirigiremos a la pantalla de bienvenida.
                    Toast.makeText(MainActivity.this, "Bienvenido " + username, Toast.LENGTH_SHORT).show();
                    openDashboard(username);
                } else {
                    Toast.makeText(MainActivity.this, "Ingrese un nombre de usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openDashboard(String username) {
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.putExtra("USERNAME_EXTRA", username);
        startActivity(intent);
        finish(); // Finaliza la actividad de inicio de sesión para que no pueda volver a ella usando el botón "Atrás".
    }
}
