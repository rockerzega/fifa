package com.example.test.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import com.example.test.databinding.ActivityMainBinding
import com.example.test.model.entities.api.Usuarios
import com.example.test.userCase.usuarios.UsuariosUC
import com.example.test.utils.Variables
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var us: Unit? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClass()

    }


    override fun onPause() {
        super.onPause()
        println("PAUSANDO APP")

    }

    override fun onResume() {
        super.onResume()
        println("REANUDANDO APP")
    }

    private fun initClass() {
        val txt = binding.txtUser
        binding.buttonLogin.setOnClickListener {
            val txtUser = binding.txtUser.text.toString()
            val txtPass = binding.txtPass.text.toString()
            lifecycleScope.launch(Dispatchers.Main) {
                    val userAux = UsuariosUC().getUsuario(txtUser)
                if( userAux != null) {
                    if (txtUser == (userAux?.user) && txtPass == userAux?.pass) {
                        var intent = Intent(this@MainActivity, PrincipalActivity::class.java)
                        intent.putExtra(Variables.nombreUsuario, "Bienvenidos")
                        startActivity(intent)
                    }
                }
                Snackbar.make(
                    txt, "Nombre de usuario o contraseña incorrectos",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}