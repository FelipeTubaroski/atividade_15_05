package com.br.cad.atividadedehoje;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //DECLARAR AS VARIÁVEIS
    EditText nome, mat, curso, sem;
    Button send;

    //DECLARAR O ARQUIVO DE PREFERÊNCIA
    public static final String MyPREFERENCES = "arquivo";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome=(EditText)  findViewById(R.id.username);
        mat=(EditText)  findViewById(R.id.matricula);
        curso=(EditText)  findViewById(R.id.curso);
        sem=(EditText)  findViewById(R.id.semestre);
        send=(Button) findViewById(R.id.button);

        //CLASSE SHAREDPREFERENCES
        SharedPreferences sharedPreferences = getSharedPreferences("arquivo", 0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DECLARAÇÃO DE VARIÁVEIS LOCAIS
                String nomeLocal = nome.getText().toString();
                String matLocal = mat.getText().toString();
                String curLocal = curso.getText().toString();
                String semLocal = sem.getText().toString();

                //DECLARAÇÃO DO EDITOR - SHAREDPREFERENCES NO MODO DE EDIÇÃO
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //FAZER A PERSISTÊNCIA DOS DADOS
                editor.putString("Nome", nomeLocal);
                editor.putString("Matricula", matLocal);
                editor.putString("Curso", curLocal);
                editor.putString("Semestre", semLocal);

                //CONFIRMAR A PERSISTÊNCIA
                editor.commit();

                //NOTIFICAÇÃO NO APP
                Toast.makeText(MainActivity.this, "Dados Cadastrados no arquivo .xml com sucesso!", Toast.LENGTH_LONG).show();

                //LIMPAR O FORMULÁRIO (GLOBAL) PARA O PRÓXIMO CADASTRO
                nome.getText().clear();
                mat.getText().clear();
                curso.getText().clear();
                sem.getText().clear();
                nome.requestFocus();
            }
        });

    }
}