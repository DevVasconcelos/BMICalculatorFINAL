package com.example.imccalculatorfinal

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val corThinness = ContextCompat.getColor(this, R.color.cor_thinness)
        val corNormal = ContextCompat.getColor(this, R.color.cor_normal)
        val corOverweight = ContextCompat.getColor(this, R.color.cor_overweight)
        val corObesity = ContextCompat.getColor(this, R.color.cor_obesity)
        val corSevereObesity = ContextCompat.getColor(this, R.color.cor_severe_obesity)

        val classificacao: String = if (result <= 18.5f) {
            tvClassificacao.setTextColor(corThinness)
            "THINNESS"
        } else if (result >= 18.5f && result < 24.9f) {
            tvClassificacao.setTextColor(corNormal)
            "NORMAL"
        } else if (result >= 25f && result < 29.9f) {
            tvClassificacao.setTextColor(corOverweight)
            "OVERWEIGHT"
        } else if (result >= 38f && result < 39.9f) {
            tvClassificacao.setTextColor(corObesity)
            "OBESITY"
        } else {
            tvClassificacao.setTextColor(corSevereObesity)
            "SEVERE OBESITY"
        }

        tvClassificacao.text = classificacao
    }
}