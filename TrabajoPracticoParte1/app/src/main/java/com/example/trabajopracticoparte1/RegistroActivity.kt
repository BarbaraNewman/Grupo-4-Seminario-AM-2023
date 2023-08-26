package com.example.trabajopracticoparte1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {
    lateinit var etUsuario: EditText
    lateinit var etPass: EditText
    lateinit var PassC: EditText
    lateinit var btRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        etUsuario = findViewById(R.id.etUsuario)
        etPass = findViewById(R.id.etPass)
        PassC = findViewById(R.id.PassC)
        btRegistrar = findViewById(R.id.btRegistrar)


        btRegistrar.setOnClickListener {
            Toast.makeText(this,"Usuario Creado", Toast.LENGTH_SHORT).show()
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
            finish()
        }
        }
}
