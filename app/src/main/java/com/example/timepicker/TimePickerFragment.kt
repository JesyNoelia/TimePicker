package com.example.timepicker

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

//recibe un parametro de entrada cuando la instanciemos, que sera, un string, que devolvera la hora seleccionada y extiende de dialogfragment, luego hay que hacer el listner que nos avise cunado el usuario selecciona una hora.

class TimePickerFragment(val listener: (String)->Unit):DialogFragment(), TimePickerDialog.OnTimeSetListener {


    //FUNCION QUE DEVUELVE EL DIALOGO DEL TIMEPICKER (hay que soobreescribir el metodo oncreatedialog, -> code, override methods)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //hay que sacar la hora actual y los minutos.
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val dialog = TimePickerDialog(activity as Context,R.style.timePicker, this, hour, minute, true)
        return dialog

    }

    //FUNCION QUE SOLO AVISA QUE LA HORA HA SIDO SELECCIONADA
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        //esta funcion solo nos avisa que la hora ha sido seleccionada.
        listener("$hourOfDay:$minute")
    }
}