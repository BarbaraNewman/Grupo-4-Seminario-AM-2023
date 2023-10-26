package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.prueba.HomeActivity
import com.example.prueba.R
import com.example.prueba.RegistroActivity

class MainActivity : AppCompatActivity() {

    lateinit var etUsuario: EditText
    lateinit var etPass: EditText
    lateinit var cbRecordar: CheckBox
    lateinit var btnRegistrar: Button
    lateinit var btnIniciar: Button
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsuario = findViewById(R.id.etUsuario)
        etPass = findViewById(R.id.etPass)
        cbRecordar = findViewById(R.id.cbRecordar)
        btnIniciar = findViewById(R.id.botonIniciar)
        btnRegistrar = findViewById(R.id.botonRegistrar)

        var preferencias = getSharedPreferences(resources.getString((R.string.sp_credenciales)), MODE_PRIVATE)
        var usuarioGuardado = preferencias.getString(resources.getString(R.string.nombreUser), "")
        var passwordGuardado = preferencias.getString(resources.getString(R.string.passwordUser), "")

        if (usuarioGuardado != null && passwordGuardado != null) {
            etUsuario.setText(usuarioGuardado)
            etPass.setText(passwordGuardado)
            cbRecordar.isChecked = true
        }


        //toolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(toolbar)
        //supportActionBar!!.title = resources.getString(R.string.tit

        btnRegistrar.setOnClickListener {
            var intentTerminos = Intent(this, RegistroActivity::class.java)
            startActivity(intentTerminos)
        }

        btnIniciar.setOnClickListener {
            var mensaje = "Iniciar Sesion"
            // Obtenemos el dato que se ingreso en la vista
            var nombreUsuario = etUsuario.text.toString()
            var passwordUsuario = etPass.text.toString()

            if(nombreUsuario.isEmpty() || passwordUsuario.isEmpty()){
                mensaje+= " - Faltan Datos"
            }else {
                mensaje+= " - Datos OK"
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
        intentMain.putExtra(resources.getString(R.string.nombreUser), usuarioGuardado)
        startActivity(intentMain)
        finish()
    }
}