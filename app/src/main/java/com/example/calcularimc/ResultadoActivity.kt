package com.example.calcularimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calcularimc.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra("nome")
        val imc = intent.getDoubleExtra("imc", 0.0)

        binding.tvNomeResultado.text = "Nome: $nome"
        binding.tvImcResultado.text = String.format("Seu IMC é: %.2f", imc)

        binding.btCompartilhar.setOnClickListener {
            val compartilharIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "O IMC de $nome é: %.2f".format(imc))
                type = "text/plain"
            }
            startActivity(Intent.createChooser(compartilharIntent, "Compartilhar via"))
        }

        binding.btVoltar.setOnClickListener {
            finish()
        }
    }
}
