package com.android.noguiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.android.noguiapp.BaseDatos.AdminBD
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var sCorr: String
    private lateinit var sCont: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actividad = intent
        //Esta rama es cuando la app regresa del registro
        if (actividad != null && actividad.hasExtra("correo") && actividad.hasExtra("pass")) {
            sCorr = actividad.getStringExtra("correo")
            sCont = actividad.getStringExtra("pass")
        } else {//cuando va iniciando
            val admin = AdminBD(this)
            val result = admin.Consulta("SELECT email,pass FROM Usuarios")
            if (result!!.moveToFirst()) {//El usuario ya esta registrado
                sCorr = result.getString(0)
                sCont = result.getString(1)
                //tvHola.text = "Hola,$sCorr"
                result.close()
                admin.close()
            } else {//Mandamos a registrar al usuario
                val actividadReg = Intent(this, ActivityRegister::class.java)
                startActivity(actividadReg)
            }
        }

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/
    }
}
