package com.example.calcularimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calcularimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener {
            val nome = binding.edtNome.text.toString()
            val peso = binding.edtPeso.text.toString().toDoubleOrNull()
            val altura = binding.edtAltura.text.toString().toDoubleOrNull()

            if (nome.isNotEmpty() && peso != null && altura != null && altura > 0) {
                val imc = peso / (altura * altura)

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("nome", nome)
                intent.putExtra("imc", imc)
                startActivity(intent)
            } else {
                binding.tvResultado.text = "Por favor, insira valores válidos."
            }
        }
    }
}
