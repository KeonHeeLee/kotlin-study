package module

class Car{ }

interface Container<T: Car> {
    fun put(item: T)
    fun take(): T
}

class Garage: Container<Car> {
    override fun take(): Car {
        TODO("not implemented")
        //To change body of created functions use File | Settings | File Templates.
    }
    override fun put(item: Car) {
        TODO("not implemented")
        //To change body of created functions use File | Settings | File Templates.
    }
}

// 제너릭 타입을 받는 함수
// 미리 정의된 타입을 받을 경우
fun processItems1(items: List<String>){ }

// 호출 시점에 타입을 받는 경우
fun <T> processItems2(items: List<T>){ }

open class Car01{ }
class Sedan: Car01() {}
class Truck: Car01() {}

fun <T> append(dest: MutableList<in T>, src: List<out T>){
    dest.addAll(src)
}

fun kotlinBase06(){
    // 무조건 template를 넣어줘야한다.
    val names: List<String> // List 선언
    val entries: Map<String, String> // Map 선언


}