import kotlin.random.Random
import kotlin.system.exitProcess

fun jugar(){
    //    Crear un numero aleatorio de 4 cifras según ChatGPT
    val numero_random= Random.nextInt(1000,9999)
    val numero_random_split=numero_random.toString().toList()
    val array_numero_random=numero_random_split.toTypedArray()

}
fun trazas() {

}
fun salir() {
    exitProcess(0)
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
            3 -> salir()
            else -> println("ha introducido un numero erroneo no se hace nada")
        }
        eleccion= readln().toInt()
    }

}