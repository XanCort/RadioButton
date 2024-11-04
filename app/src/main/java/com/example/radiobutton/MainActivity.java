package com.example.radiobutton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public class eventoCambio implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            RadioButton radio = findViewById(i);
            String texto=radio.getText().toString();

            Toast mensaje = Toast.makeText(MainActivity.this,texto , Toast.LENGTH_SHORT);
            mensaje.show();

            View view = mensaje.getView();
            TextView text =(TextView) view.findViewById(android.R.id.message);

            if(texto.equals("Verde")){
                text.setTextColor(Color.GREEN);
            }else if(texto.equals("Rojo")){
                text.setTextColor(Color.RED);
            }else if(texto.equals("Azul")){
                text.setTextColor(Color.BLUE);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RadioGroup grupo = findViewById(R.id.radioGroup);
        grupo.setOnCheckedChangeListener(new eventoCambio());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}