package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText


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

        var preferencias = getSharedPreferences(resources.getString((R.string.credenciales)), MODE_PRIVATE)
        var usuarioGuardado = preferencias.getString(resources.getString(R.string.nombre_usuario), "")
        var passwordGuardado = preferencias.getString(resources.getString(R.string.password_usuario), "")

        if(usuarioGuardado!= null && passwordGuardado!= null){
            startMainActivity(usuarioGuardado)
        }

        btRegistrar.setOnClickListener{
            val intentRegistro = Intent(this, RegistroActivity::class.java)
            startActivity(intentRegistro)
            finish()
        }

        btIniciar.setOnClickListener {
            var mensaje = "Iniciar Sesion"
            var nombreUsuario = etUsuario.text.toString()
            var passwordUsuario = etPass.text.toString()

            if(nombreUsuario.isEmpty() || passwordUsuario.isEmpty()){
                mensaje+= " - Faltan Datos"
            }else {
                mensaje+= " - Datos OK"

                if (cbRecordar.isChecked) {
                    var preferencias = getSharedPreferences(resources.getString((R.string.credenciales)), MODE_PRIVATE)
                    preferencias.edit().putString(resources.getString(R.string.nombre_usuario), nombreUsuario).apply()
                    preferencias.edit().putString(resources.getString(R.string.password_usuario), passwordUsuario).apply()
                }
                startMainActivity(nombreUsuario)
            }
        }
    }

    private fun startMainActivity(usuarioGuardado: String) {
        val intentMain = Intent(this, HomeActivity::class.java)
        intentMain.putExtra(resources.getString(R.string.nombre_usuario), usuarioGuardado)
        startActivity(intentMain)
        finish()
    }
    }


