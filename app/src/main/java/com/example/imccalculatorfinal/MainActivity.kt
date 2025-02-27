package com.example.imccalculatorfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

              // Retrieve the EditText components
             // Create a variable and associate the UI component <EditText
            // Retrieve the button from the screen

           // Add action to the button setOnClickListener
          // Retrieve the text entered in the weight EditText


        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)


        btnCalcular.setOnClickListener {

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                // Mostrar mensagem para o usuário.

                Snackbar.make(
                    edtPeso,
                    "Fill in all fields",
                    Snackbar.LENGTH_LONG
                )
                    .show()


            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2
                // Navegar para próxima tela
                // Criar o Layout da próxima tela
                // Passar dados para a próxima tela

                // Intent - Classe do próprio android

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)

                // Cores
                // EditText background + ícone
                // Gradiente + ícone + título + descrição

            }
        }
    }
}