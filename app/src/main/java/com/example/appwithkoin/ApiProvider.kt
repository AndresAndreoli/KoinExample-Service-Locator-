package com.example.appwithkoin

import android.content.Context

class ApiProvider(private val context: Context) {

    fun fetchData() = "Remote data from webservice"

    fun fetchDataWithActivity( number: Int) = "Remote other data from webservice"

    fun otherFetchWithContext() : String{
        //si aquí necesitásemos el contexto
        //solo hay que utilizarlo ya que lo tenemos disponible gracias a la
        //inyección por el contructor
        return context.getString(R.string.app_name)
    }
}