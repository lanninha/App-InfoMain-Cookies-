package com.example.cookies

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {

    private lateinit var textoSenha: EditText
    private lateinit var imagemMostrarSenha: ImageView

    private var senhaVisivel:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textoSenha = findViewById(R.id.editTextTextPassword)
        imagemMostrarSenha = findViewById(R.id.imagemMostrarSenha)

        imagemMostrarSenha.setOnClickListener {
            senhaVisivel = !senhaVisivel
            alternarVisibilidadeSenha()
        }

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#EFD6C1")
    }

    private fun alternarVisibilidadeSenha() {
        if (senhaVisivel) {
            // Mostrar senha
            textoSenha.transformationMethod = HideReturnsTransformationMethod.getInstance()
            imagemMostrarSenha.setImageResource(R.drawable.eye)
        } else {
            // Esconder senha
            textoSenha.transformationMethod = PasswordTransformationMethod.getInstance()
            imagemMostrarSenha.setImageResource(R.drawable.invisibleeye)
        }

        // Move o cursor para o final do texto
        textoSenha.setSelection(textoSenha.text.length)
    }
} 