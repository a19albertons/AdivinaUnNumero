//Libreria recomendada por chat gpt para ficheros y numeros aleatorios
import java.io.File
import kotlin.random.Random

//Variables globales realacionadas con los logs
val fichero="trazas.log"

fun jugar(){
    //    Crear un numero aleatorio de 4 cifras según ChatGPT
    val numero_random= Random.nextInt(1000,9999)
    val numero_random_split=numero_random.toString().toList()
    val array_numero_random=numero_random_split.toTypedArray()
//    println(array_numero_random[0])
    println("los numero van del 1000 al 9999")
    println("Si te sale asterisco es que el numero no es coincidente")
    println("Si repites algun numero va dar falsos duplicados en las posiciones no coincidentes")
    println("Solo se guardan las trazas de la ultima partida")
    println("teclea un numero de 4 cifras")
    var numero= readln()
    val intentos=10
    var num_intentos=0

//    Reincia el fichero y añade la linea del numero secreto
    File(fichero).writeText("El numero secreto era: "+numero_random+"\n")

    while (num_intentos<intentos) {
        num_intentos++
        val numero_lista=numero.toList()
        val numeros_no_coincidete_random= mutableListOf<Int>()
        val numeros_no_coincidete_dado= mutableListOf<Int>()

//        Empieza concatenar la linea de intentos
        File(fichero).appendText("Intento $num_intentos: " + numero)
        var contador_acierto=0
//        Gestiona la comprobación del numero 100% coincidente
        for (i in 0 until array_numero_random.size) {
//        println(array_numero_random[i])
//        println(numero_lista[i])
            if (array_numero_random[i].toString().toInt()==numero_lista[i].toString().toInt()) {
                print(array_numero_random[i])
                contador_acierto++
            }
            else {
                print("*")
//                Crea la lista que posteriormente serán las que comprobara si algun numero dado
//                estan en una posición distinta
                numeros_no_coincidete_random.add(array_numero_random[i].toString().toInt())
                numeros_no_coincidete_dado.add(numero_lista[i].toString().toInt())
            }
        }
//        Le añade los aciertos a la linea de intentos
        File(fichero).appendText(" Aciertos: $contador_acierto,")
        var contador_coindicendia=0
        if (numeros_no_coincidete_dado.size>0) {
            print(" Numeros coincidentes en otra posicion si hay:")
            for (i in numeros_no_coincidete_dado) {
                if (i in numeros_no_coincidete_random) {
                    print(" "+i)
                    contador_coindicendia++
                }
            }
        }
//        Añade a la linea de intentos las coincidencias
        File(fichero).appendText(" Coincidencias: $contador_coindicendia\n")
        println()
//        println(numero)
//        println(numero_random)
        if (numero.toInt()==numero_random.toString().toInt()) {

            break
        }
        numero= readln()

    }
    println("Gracias por jugar")
}
fun ver_trazas() {
//    Impresion de un fichero según chatGPT
    if (File(fichero).exists()) {
        val contenido = File(fichero).readText()
        println(contenido)
    }
    else {
        println("El fichero de log no se ha encontrado estad seguro de que ya ha jugado?")
    }
}

fun creditos() {
    println("Adivina un numero")
    println("Programador: A19AlbertoNS")
    println("Diseñador: A19AlbertoNS")
    println("Beta Tester: A19AlbertoNS")
    println("Realizado con kotlin, java, chatGPT e Intellij")
}


fun main() {

    println("1. Jugar")
    println("2. Ver traza del ultimo intento")
    println("3. Ver creditos")
    println("4. Salir")
    var eleccion= readln().toInt()
    while (eleccion!=4) {
        when (eleccion) {
            1 -> jugar()
            2 -> ver_trazas()
            else -> println("ha introducido un numero erroneo no se hace nada")
        }

        println()
        println("1. Jugar")
        println("2. Ver traza del ultimo intento")
        println("3. Ver creditos")
        println("4. Salir")
        eleccion= readln().toInt()
    }

}