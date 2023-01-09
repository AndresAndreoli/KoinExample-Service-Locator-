package com.example.appwithkoin

class OtherMainPresenter(
    private val apiProvider: ApiProvider,
    private val activity: MainActivity,
    private val number: Int
) {

    fun fetch() = apiProvider.fetchDataWithActivity(number)
}