package module

import java.io.IOException
import java.lang.Exception
import java.lang.IllegalStateException

// 코틀린의 if문은 자바의 if문이랑 크게 다를게 없다
fun example01(age:Int): String{
    val ageRange: String

    if(age >= 10 && age < 20)
        ageRange = "10대"
    else if(age >= 20 && age < 30)
        ageRange = "20대"
    else
        ageRange = "기타"

    return ageRange
}

// 하지만 값을 받아낼 수 있다는 점이 다르다.
fun example02(age: Int): String{
    val ageRange: String =
            if(age >= 10 && age < 20) "10대"
            else if(age >= 20 && age < 30) "20대"
            else "기타"

    return ageRange
}

// when문 (자바의 switch문)
fun example03(bags: Int): String{
    return when (bags){
        0 -> "We have no bags"
        1, 2 -> "1,2 bags"
        else -> "..?"
    }
}

// when문을 통한 예외처리 및 문자열 처리 예제
fun example04(e: Exception, str: String){
    when(e){
        is IOException -> println("Hello")
        is IllegalStateException -> println("World")
    }

    // 첫번째 문자에 따른 println()
    if(str.startsWith('a'))
        println("start with a")
    else if(str.startsWith('k'))
        println("start with b")
    else
        println("I don\'n know..")
}

// while문
fun example05(){
    var a: Int = 0
    var b: Int = 10

    while(a < b){
        println("a=$a b=$b")
        a+=2
        b++
    }

    a = 0
    b = 0
    do{
        println("a=$a b=$b")
        a+=2
        b++
    } while(a < b)
}

// for문
fun example06(){
    val names: List<String> = arrayListOf("one", "two", "three")
    var i:Int = 0

    // 파이썬이랑 비슷함
    for(name in names)
        println("name[${i++}]=$name")
}

// range
fun example07(){
    val myRange: IntRange = 0..10

    // example 1
    for(i in myRange){ }

    // example 2
    for(i in 0..10){ }
}

fun example08(){
    val myRange: List<String> = arrayListOf("hello", "world", "!!")

    // 0번 인덱스부터 3번 인덱스까지 총 4개의 항목을 포함하는 범위
    val intMyRange: IntRange = 0..3

    // myRange와 동일한 항목을 포함하는 범위
    val myRange2: IntRange = 0 until 4

    val foo: Boolean = "hello" in myRange
    val bar: Boolean = 3 !in intMyRange

    // 5부터 1까지 1씩 감소 = 54321
    for(i in 5 downTo 1)
        System.out.println(i)

    // 5부터 1까지 2씩 감소 = 531
    for(i in 5 downTo 1 step 2)
        System.out.println(i)

    for(i in intMyRange) println(i)
}


fun kotlinBase05(){
    println(example01(25))
    println(example02(15))

    // 삼항 연산자를 대체가능하다.
    var str: String = if (25%2 == 0) "Even" else "Odd"

    println(example03(2))
    example04(
        Exception() as IOException,
        "android"
    )
    example05()
    example06()

    example07()
    example08()
}