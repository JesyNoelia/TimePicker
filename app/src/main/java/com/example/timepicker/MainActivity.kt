package com.example.timepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.timepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.maEtTime.setOnClickListener {showTimePickerDialog()}
    }

    private fun showTimePickerDialog() {
       //va a cargar el fragment que muestra el time picker, hay que crear una nueva clase (TimePickerFragment)

        //ahora se crea la instancia de la clase TimePickerFragment, esta recibe un parametro que es una funcion, que devuelve un string, entonces, como es una funcion va entre{}, hay que crear esa funcion.
        val timePicker = TimePickerFragment{onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")

    }

    //FUNCION PARAMETRO DE LA ANTERIOR
    private fun onTimeSelected(time: String){
        binding.maEtTime.setText("Has seleccionado las $time")
    }

}