package br.com.playonadev.eletriccarapp.ui

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.playonadev.eletriccarapp.R
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class CalcularAutonomiaActivity : AppCompatActivity() {

    lateinit var preco: EditText
    lateinit var kmPercorrido: EditText
    lateinit var resultado: TextView
    lateinit var btnCalcular: Button
    lateinit var btnBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_autonomia)
        setupView()
        setupListeners()
        setupCachedResult()
    }

    private fun setupCachedResult() {
        val valorCalculado = getSharePref()
        resultado.text = valorCalculado.toString()
    }

    fun setupView() {
        preco = findViewById(R.id.et_preco_kwh)
        kmPercorrido = findViewById(R.id.et_km_percorrido)
        resultado = findViewById(R.id.tv_resultado)
        btnCalcular = findViewById(R.id.btn_calcular)
        btnBack = findViewById(R.id.iv_icon_back)
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    fun calcular() {
        val preco = preco.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()

        val result = preco / km

        resultado.text = result.toString()
        savaSharedPref(result)
    }

    fun savaSharedPref(result: Float){
        val sharePref = getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharePref.edit()){
            putFloat(getString(R.string.saved_calc), result)
            apply()
        }
    }

    fun getSharePref(): Float {
        val sharePref = getPreferences(Context.MODE_PRIVATE)
        return sharePref.getFloat(getString(R.string.saved_calc), 0.0f)
    }
}