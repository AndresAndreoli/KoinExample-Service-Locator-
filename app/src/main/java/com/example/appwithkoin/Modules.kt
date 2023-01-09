package com.example.appwithkoin

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/*

    Aca crearemos los modulos que se utilizaran en el proyecto. Estos modulos sirven para definir
    que dependencias tiene cada clase que queremos instanciar.

 */

val presenterModule = module {
    /*

    En la primera línea creamos el módulo que vamos a utilizar para definir las  dependencias de
    los presenters de nuestra aplicación. Podemos crear tantos módulos como queramos, es más,
    sería conveniente ir creando módulos conforme vaya creciendo nuestra aplicación para tener el
    código lo más ordenado posible.

    En primera definición de dependencia utilizamos la palabra SINGLE, con ella, estamos diciendo
    que nos cree un singleton de la clase MainPresenter. Si queremos que sea una instancia distinta
    en cada instanciación, valga la redundancia, entonces utilizaremos FACTORY.

    La clase MainPresenter requiere un parámetro por el constructor, una instancia de la clase
    ApiProvider, que se lo estamos inyectando al llamar al método GET().

    Al llamar a este método GET(), el propio inyector buscará internamente que clase le hace falta
    instanciar según la definición que hemos hecho en los módulos, y él creará la instancia de ella
    y se la pasará cuando sea necesario.

 */
    single { MainPresenter(get()) }
    single { (activity: MainActivity, number: Int) ->
        OtherMainPresenter(get(), activity, number)
    }
}

val providersModule = module {
    single { ApiProvider(androidApplication()) }
}