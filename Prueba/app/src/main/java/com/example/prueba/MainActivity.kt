package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.newFixedThreadPoolContext
import androidx.appcompat.widget.Toolbar
// import com.example.prueba.databinding.ActivityMainBinding

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


        var preferencias = getSharedPreferences(resources.getString((R.string.sp_credenciales)), MODE_PRIVATE)
        var usuarioGuardado = preferencias.getString(resources.getString(R.string.nombreUser), null)
        var passwordGuardado = preferencias.getString(resources.getString(R.string.passwordUser), null)

        if(usuarioGuardado != null && passwordGuardado != null){
                startMainActivity(usuarioGuardado)
        }

        btRegistrar.setOnClickListener {
            val intentRegistro = Intent(this, RegistroActivity::class.java)
            startActivity(intentRegistro)
            finish()
        }

        btIniciar.setOnClickListener {
            var mensaje = "Iniciar Sesion"
            // Obtenemos el dato que se ingreso en la vista
            var nombreUsuario = etUsuario.text.toString()
            var passwordUsuario = etPass.text.toString()

            if(nombreUsuario.isEmpty() || passwordUsuario.isEmpty()){
                mensaje+= " - Faltan Datos"
            }else {
                mensaje+= " - Datos OK"
                // Verificamos si esta tildado el CechBox
                if(cbRecordar.isChecked) {
                    var preferencias = getSharedPreferences(resources.getString((R.string.sp_credenciales)), MODE_PRIVATE)
                    preferencias.edit().putString(resources.getString(R.string.nombreUser), nombreUsuario).apply()
                    preferencias.edit().putString(resources.getString(R.string.passwordUser), passwordUsuario).apply()
                }

                startMainActivity(nombreUsuario)
            }
        }
    }

    private fun startMainActivity(usuarioGuardado: String) {
        val intentMain = Intent(this, HomeActivity::class.java)
        intentMain.putExtra(resources.getString(R.string.nombreUser ), usuarioGuardado)
        startActivity(intentMain)
        finish()
    }


//  FUNCIONALIDAD DEL TOOLBAR
//    class MainActivity : AppCompatActivity() {
//        private lateinit var binding: ActivityMainBinding
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.toolbar)
//
//            // Encuentra la Toolbar por su ID
//            val myToolbar: Toolbar = findViewById(R.id.toolbar_interactivo)
//
//            // Configura la Toolbar como la barra de acción de la actividad
//            setSupportActionBar(myToolbar)
//        }
//    }

}
