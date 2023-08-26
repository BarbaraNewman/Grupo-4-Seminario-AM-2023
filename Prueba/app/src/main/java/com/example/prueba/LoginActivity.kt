package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    // Variables para vincular con la vista
    lateinit var etUsuario: EditText
    lateinit var etCorreo: EditText
    lateinit var etPass: EditText
    lateinit var btnRegistrar: Button

    // Funcion que se ejecuta al iniciar un Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Vinculamos las variables con los IDs correspondientes a la vista
        etUsuario = findViewById(R.id.etUsuario)
        etPass = findViewById(R.id.etPass)
        btnRegistrar = findViewById(R.id.botonRegistrar)

        //Agregamos funcionalidad al Boton
        btnRegistrar.setOnClickListener {
            var mensaje = "Registrar"
            // Obtenemos el dato que se ingreso en la vista
            var nombreUsuario = etUsuario.text.toString()
            if(nombreUsuario.isEmpty() || etPass.text.toString().isEmpty()){
                mensaje+= " - Faltan Datos"
            }else {
                mensaje+= " - Datos OK"

                // Indicamos a que pantalla queremos ir
                val intentMain = Intent(this, RegistroActivity2::class.java)
                // Agregamos datos que queremos pasar a la proxima pantalla
                intentMain.putExtra("nombre", nombreUsuario)
                // Cambiamos de pantalla
                startActivity(intentMain)
                // Eliminamos la Activity actual para sacarla de la Pila
                finish()
            }
        }
    }
}