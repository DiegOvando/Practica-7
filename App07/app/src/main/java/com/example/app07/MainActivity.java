package com.example.app07;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario, txtContraseña;
    private Button btnIngresa, btnCerrar;
    private Usuarios user = new Usuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
        btnIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsuario.getText().toString().matches("") ||
                txtContraseña.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Falto capturar información",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txtUsuario.getText().toString().matches(user.getUser()) && txtContraseña.getText().toString().matches(user.getContraseña())){
                        Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                        //Cargando la new Activity "LstActivity"
                        Intent intent = new Intent(MainActivity.this,LstActivity.class);
                        //intent.putExtra("usuario", txtUsuario.getText().toString());
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("usuario", user);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
            }
        });
        btnCerrar = (Button) findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("¿Cerrar App?");
                confirmar.setMessage("Se descartara toda la informacion. ");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Nada
                    }
                }); confirmar.show();
            }
        });

    }

    private void iniciar(){
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);
        btnIngresa = (Button) findViewById(R.id.btnIngresa);
        user.setUser(getResources().getString(R.string.userName));
        user.setContraseña(getResources().getString(R.string.contraseña));
        user.setNombreCompleto(getResources().getString(R.string.nombre));
        user.setEmail(getResources().getString(R.string.email));
    }
}
