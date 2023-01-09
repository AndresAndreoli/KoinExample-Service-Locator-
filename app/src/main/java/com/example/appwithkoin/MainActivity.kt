package com.example.appwithkoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/*

    Con todos los módulos creados con las definiciones de las inyecciones, solo nos queda
    inyectarlas donde nos haga falta. Todas las creaciones de clases que sean necesarias por
    constructor las resolverá el inyector y únicamente tendremos que hacer es inyectar en
    donde se inicializa todo el grado de inyecciones, osea, en este caso, en el MainActivity.

 */

class MainActivity : AppCompatActivity() {

    private val presenter: MainPresenter by inject()

    private val otherPresenter: OtherMainPresenter by inject { parametersOf(this@MainActivity, 3) }

    /*

    Con esto, estamos diciéndole  a Koin que nos cree una instancia de la clase MainPresenter cuando
    la clase MainActivity se cree. Además le pasamos los parámetros que configuramos en el módulo y
    que son necesarios, una referencia a la Activity y un campo de tipo entero.

    Unicamente con esta configuración y esta llamada a la inyección en la activity, se genera
    automáticamente todas las dependencias de todas las clases que entran en juego.

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchData()
    }

    private fun fetchData() {
        val result = presenter.fetch()
        showAlertWithData(result)
    }

    private fun showAlertWithData(message: String) {

        val alertBuilder = AlertDialog.Builder(this).apply {
            title = "Hello Koin"
            setMessage(message)
        }
        alertBuilder.create().show()
    }
}