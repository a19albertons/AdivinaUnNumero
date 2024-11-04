import kotlin.random.Random
import kotlin.system.exitProcess

fun jugar(){
    //    Crear un numero aleatorio de 4 cifras según ChatGPT
    val numero_random= Random.nextInt(1000,9999)
    val numero_random_split=numero_random.toString().toList()
    val array_numero_random=numero_random_split.toTypedArray()
    println(array_numero_random[0])
    println("los numero van del 1000 al 9999")
    println("Si te sale asterisco es que el numero no es coincidente")
    println("Si repites algun numero puede dar falsos duplicados en las posiciones no coincidentes")
    println("teclea un numero de 4 cifras")
    var numero= readln()
    while (numero_random!=numero.toInt()) {
        val numero_lista=numero.toList()
        val numeros_no_coincidete_random= mutableListOf<Int>()
        val numeros_no_coincidete_dado= mutableListOf<Int>()

//        Gestiona la comprobación del numero 100% coincidente
        for (i in 0 until array_numero_random.size) {
//        println(array_numero_random[i])
//        println(numero_lista[i])
            if (array_numero_random[i].toString().toInt()==numero_lista[i].toString().toInt()) {
                print(array_numero_random[i])
            }
            else {
                print("*")
//                Crea la lista que posteriormente serán las que comprobara si algun numero dado
//                estan en una posición distinta
                numeros_no_coincidete_random.add(array_numero_random[i].toString().toInt())
                numeros_no_coincidete_dado.add(numero_lista[i].toString().toInt())
            }
        }
        if (numeros_no_coincidete_dado.size>0) {
            print(" Estos son los numeros coincidentes en otra posicion1 si hay:")
            for (i in numeros_no_coincidete_dado) {
                if (i in numeros_no_coincidete_random) {
                    print(" "+i)
                }
            }
        }
        println()
        numero= readln()

    }
}
fun trazas() {

}


fun main() {
    println("1. Jugar")
    println("2. Ver traza del ultimo intento")
    println("3. Salir")
    var eleccion= readln().toInt()
    while (eleccion!=3) {
        when (eleccion) {
            1 -> jugar()
            2 -> trazas()
            else -> println("ha introducido un numero erroneo no se hace nada")
        }
        eleccion= readln().toInt()
    }

}