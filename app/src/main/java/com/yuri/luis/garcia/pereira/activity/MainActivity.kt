package com.yuri.luis.garcia.pereira.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import com.yuri.luis.garcia.pereira.R
import com.yuri.luis.garcia.pereira.model.CalculaGorjeta

class MainActivity : AppCompatActivity() {

    private lateinit var editTextAmount : EditText
    private lateinit var editTextTip15: EditText
    private lateinit var editTextTotal15 : EditText
    private lateinit var editTextTip: EditText
    private lateinit var editTextTotal: EditText
    private lateinit var textViewPorcentagem: TextView
    private lateinit var seekBarGorjeta: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instanciaLayoutComXml()
        eventoSeekBarGorjeta()
        eventoEditTextAmount()
    }

    private fun instanciaLayoutComXml(){

        editTextAmount = findViewById(R.id.editTextAmount)
        editTextTip15 = findViewById(R.id.editTextTip15)
        editTextTotal15 = findViewById(R.id.editTextTotal15)
        editTextTip = findViewById(R.id.editTextTip)
        editTextTotal = findViewById(R.id.editTextTotal)
        textViewPorcentagem = findViewById(R.id.textViewPorcentagem)
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta)
    }

    private fun eventoSeekBarGorjeta(){

        seekBarGorjeta.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewPorcentagem.text = "$progress%"
                calculaTotais()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    private fun eventoEditTextAmount(){

        editTextAmount.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
               calculaTotais()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }

    private fun calculaTotais(){

        var valorTotal = 0.0
        if (!editTextAmount.text.isNullOrEmpty()){
            valorTotal = editTextAmount.text.toString().toDouble()
        }
        var gorjeta = CalculaGorjeta(valorTotal, seekBarGorjeta.progress.toDouble())
        editTextTip15.setText(String.format("R$: %.2f", gorjeta.calculaGorjeta15Porcento()))
        editTextTotal15.setText(String.format("R$: %.2f", gorjeta.calculaTotalComGorjeta15Porcento()))

        editTextTip.setText(String.format("R$: %.2f", gorjeta.calculaGorjeta()))
        editTextTotal.setText(String.format("R$: %.2f", gorjeta.calculaTotalComGorjeta()))
    }
}
