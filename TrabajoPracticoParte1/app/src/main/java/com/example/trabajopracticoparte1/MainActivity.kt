package com.example.trabajopracticoparte1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.newFixedThreadPoolContext

class MainActivity : AppCompatActivity() {
    lateinit var etUsuario: EditText
    lateinit var etPass: EditText
    lateinit var cbRecordar: CheckBox
    lateinit var btRegistrar: Button
    lateinit var btIniciar: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsuario = findViewById(R.id.etUsuario)
        etPass = findViewById(R.id.etPass)
        cbRecordar = findViewById(R.id.cbRecordar)
        btIniciar = findViewById(R.id.btIniciar)
        btRegistrar = findViewById(R.id.btRegistrar)

        btRegistrar.setOnClickListener{
            val intentRegistro = Intent(this, RegistroActivity::class.java)
                startActivity(intentRegistro)
                finish()
        }


        btIniciar.setOnClickListener {
            var mensaje = "Iniciar Sesion"
            // Obtenemos el dato que se ingreso en la vista
            var nombreUsuario = etUsuario.text.toString()
            
            if (nombreUsuario.isEmpty() || etPass.text.toString().isEmpty()) {
                mensaje += " - Faltan Datos"
            } else {
                mensaje += " - Datos OK"
                // Verificamos si esta tildado el CechBox
                if (cbRecordar.isChecked)
                    mensaje += "- Recordar Usuario"                
                val intentMain = Intent(this, MainActivity::class.java)                
                intentMain.putExtra("nombre", nombreUsuario)               
                startActivity(intentMain)
                finish()
            }
        }
    }
}
