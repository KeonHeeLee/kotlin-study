package module

import java.io.IOException
import java.lang.Exception
import java.lang.IllegalArgumentException

fun checkAge(age: Int){
    if(age < 0){
        throw IllegalArgumentException(
            "Invalid age: $age")
    }
}

fun example01(): Boolean{
    return try{
        true
    } catch (e: Exception){
        false
    } finally {

    }
}

fun readFromJson(fileName: String): String{
    return if(fileName != "Hello") {
        throw IOException("Hello")
    } else "Yes"
}

fun kotlinBase07(){
    checkAge(-1)
    println(example01())
    println(readFromJson("Hello"))
}