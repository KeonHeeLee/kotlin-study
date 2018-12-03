package module

import java.lang.IllegalArgumentException

fun drawCircle(x: Int, y: Int, radius: Int = 25){
    // ... //
}

fun example021(){
    drawCircle(10, 5, 25)
    // or
    drawCircle(x=10, y=5, radius=25)
}

// 단일 표현식 표기
fun theAnswerToLifeTheUniverseAndEverything1(): Int { return 21*2 }
fun theAnswerToLifeTheUniverseAndEverything2(): Int = 21*2
fun theAnswerToLifeTheUniverseAndEverything3() = 21*2

// 확장 함수
// 확장 함수를 추가할 대상 클래스는 리시버 타입(Reciever Type)이라 부른다.

    // String 클래스에 withPostfix() 함수를 추가한다.
    // this를 통해 인스턴스에 접근 가능하다.
    private fun String.withPostfix(postfix: String) = "$this$postfix"

    // this를 사용하여 인스턴스에 접근할 수 있으므로, 앞에서 정의한 확장 함수를 사용할 수 있다.
    fun String.withBar() = this.withPostfix("Bar")
// 하지만 확장함수는 엄밀히 따져서 외부에서 선언한 함수이기에,
// 내부에서만 사용 가능하다

// 연산자 오버로딩
// 자바는 못하지만 코틀린은 된다.
class Volume(var left: Int, var right: Int){
    // 단항 연산자 '-'를 재정의
    operator fun unaryMinus(): Volume {
        this.left = -this.left
        this.right = -this.right
        return this
    }

    // 단항 연산자 '++'를 재정의
    operator fun inc(): Volume {
        this.left += 1
        this.right += 1
        return this
    }

    // 단항 연산자 '--'fmf wowjddml
    operator fun dec(): Volume {
        this.left -= 1
        this.right -= 1
        return this
    }

    override fun equals(other: Any?): Boolean {
        if(other == this)
            return true
        if(other !is Volume)
            return false

        return other.left == this.left && other.right == this.right
    }

    // 중위 표기법 지원
    infix fun increaseBy(amount: Int){
        this.left += amount
        this.right += amount
    }
}

infix fun Volume.decreaseBy(amount: Int){
    this.left -= amount
    this.right -= amount
}

fun example022(){
    var v = Volume(50, 50)
    val v1 = -v
    v++
    v--
}

// 재정의 가능
operator fun Volume.unaryMinus(): Volume {
    this.left = -this.left
    this.right = -this.right
    return this
}

operator fun Volume.plus(other: Volume)
        = Volume(this.left + other.left, this.right + other.right)

operator fun Volume.minus(other: Volume)
        = Volume(this.left - other.left, this.right - other.right)

operator fun Volume.plusAssign(other: Int){
    this.left += other
    this.right += other
}

operator fun Volume.minusAssign(other: Int){
    this.left -= other
    this.right -= other
}

class Rectangle(val width: Int, val height: Int)

operator fun Rectangle.compareTo(other: Rectangle): Int {
    val myDimension = this.width * this.height
    val otherDimension = other.width * other.height
    return myDimension - otherDimension
}

// 인덱스 접근 연산자
class Triple(var first: Int, var second: Int, var third: Int)

operator fun Triple.get(index: Int) = when(index){
    0-> this.first
    1-> this.second
    2-> this.third
    else -> IllegalArgumentException()
}

operator fun Triple.set(index: Int, value: Int){
    when(index){
        0-> this.first = value
        1-> this.second = value
        2-> this.third = value
        else -> IllegalArgumentException()
    }
}

// in 연산자 재정의
class Line(val start: Int, val end: Int)

operator fun Line.contains(point: Int): Boolean {
    return point in start..end
}

fun kotlinModule02(){
    example021()
    val foobar = "Hello".withBar()
    example022()

    val v1 = Volume(10,10) + Volume(20,20)
    val v2 = Volume(50,30) - Volume(20,10)

    val a = Rectangle(10, 10)
    val b = Rectangle(2,10)
    println("${a > b} ${a >= b} ${a <= b} ${a < b}")

    val triple = Triple(10, 20, 30)

    // get(i) 호출
    println("${triple[0]} ${triple[1]} ${triple[2]}")

    // set(i) 호출
    triple[1] = 30
    triple[0] = 20

    println("${triple[0]} ${triple[1]} ${triple[2]}")

    val line = Line(0, 10)
    println("${5 in line}")

    val currentVolume = Volume(50, 50)
    currentVolume increaseBy 30
    currentVolume decreaseBy 20
}