package com.example.appwithkoin

class MainPresenter(private val apiProvider: ApiProvider) {
    fun fetch() = apiProvider.fetchData()
}