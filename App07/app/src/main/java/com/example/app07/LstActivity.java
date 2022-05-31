package com.example.app07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class LstActivity extends AppCompatActivity {

    private TextView lblUser;
    private ListView lstAlumnos;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst);
        lblUser = (TextView) findViewById(R.id.lblUsuario);
        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.alumnos));
        lstAlumnos.setAdapter(adapter);
        
        //Bundle datos = getIntent().getExtras();
        //lblUser.setText(datos.getString("usuario"));

        Bundle datos = getIntent().getExtras();
        Usuarios user = (Usuarios) datos.getSerializable("usuario");
        lblUser.setText(user.getNombreCompleto());

    }
}
