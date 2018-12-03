package module

// 기본 데이터 클래스 (getter/setter 위주)
data class Person(val name: String, val address: String)

fun example01(){
    val john = Person("John Doe", "Somewhere")
    val john2 = Person("John Doe", "Somewhere")
    val jane = Person("Jane Doe", "Anywhere")

    println("John == John2? = ${john == john2}")
    println("John == Jane? = ${john == jane}")
    println("John.hashCode() = ${john.hashCode()}")

    println("John = $john")
    println("Jane = $jane")
}

// 한정 클래스(sealed class)
sealed class MobileApp(val os: String){
    class Android(os: String, val packageNaame: String): MobileApp(os)
    class IOS(os: String, val bundleID: String): MobileApp(os)
    class WindowMobile(os: String, packageName: String): MobileApp(os)
}

fun whoami(app: MobileApp) = when(app) {
    is MobileApp.Android -> println("${app.os} / ${app.packageNaame}")
    is MobileApp.IOS -> println("${app.os} / ${app.bundleID}")
    is MobileApp.WindowMobile -> println(app.os)
}

class Person2(val age: Int, val name: String){
    val adult: Boolean
        get() = age > 19


    var address: String = ""
        set(value){
            field = value.substring(0..9)
        }
}

fun kotlinModule01(){
    example01()
}