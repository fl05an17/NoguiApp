package com.android.noguiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.content_register.*
import com.android.noguiapp.BaseDatos.AdminBD

class ActivityRegister : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            if(etNombreReg.text.toString().isEmpty() || etEmailReg.text.toString().isEmpty() || etPassReg.text.toString().isEmpty()){
                Toast.makeText(this, "Error falta informacion", Toast.LENGTH_LONG).show()
                etNombreReg.requestFocus()
            }
            else{
                val nom = etNombreReg.text.toString(); val corr = etEmailReg.text.toString(); val pass = etPassReg.text.toString()
                val sentencia = "INSERT INTO Usuarios (nom, email, pass)VALUES('$nom','$corr','$pass')"

                var admin = AdminBD(this)
                if(admin.Ejecuta(sentencia)){
                    Toast.makeText(this, "El registro fue exitoso", Toast.LENGTH_LONG).show()

                    val actividad = Intent(this,MainActivity::class.java)
                    actividad.putExtra("correo",corr)
                    actividad.putExtra("pass",pass)
                    startActivity(actividad)
                }
                else{
                    Toast.makeText(this, "Error, el usuario no se registro", Toast.LENGTH_LONG).show()
                    etNombreReg.requestFocus()
                }
            }
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
