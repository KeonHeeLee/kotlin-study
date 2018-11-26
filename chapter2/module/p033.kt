package module

// 정적 필드 및 메서드

// 패키지에 변수를 선언한다.
// 자바의 경우는 static으로 활용
const val FOO = 123

// 패키지에 함수를 선언한다.
// 자바의 경우는 static으로 활용
fun foo() {}

class F00 {
    // 이 메서드는 인스턴스가 생성되어야만 사용가능
    fun bar() {}
}

// 하지만 코틀린은 static 의 정적 컴포넌트는 사용할 수가 없다.
// 그럴 경우에 사용하는 것이 동반 객체(companion object)다.

// private이므로 외부에선 접근이 불가능하다.
class User private constructor(val name:String, val registerTime: Long){
    companion object {
        // companion object는 클래스 내부에 존재
        // 이를 통해서 생성자에 접근이 가능하다.
        fun create(name: String): User {
            return User(name, System.currentTimeMillis())
        }
    }
}

// @Singleton
// 싱글톤은 아래와 같이 선언
object Singleton

// 싱글톤 예제
object Goo{
    val GOO = "goo"
    fun goo(){}
}

// enum 클래스
enum class Direction1 {
    NORTH, SOUTH, WEST, EAST
}

// 어노테이션 클래스
annotation class  Keon (val name: String)

@Keon("KeonHeeLee")
class khlee

annotation class Lee (
    val numbers: IntArray,
    val names: Array<String>
)

@Lee(numbers = intArrayOf(1, 2, 3),
    names = arrayOf("a", "b", "c"))
class lee

// mete annotation
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
@MustBeDocumented
annotation class AnnotationExample

annotation class Example1
class Example2{
    @Example1 constructor(){

    }
    @Example1 constructor(@Example1 b: String){

    }
}

// 주 생성자를 사용하는 경우, 주 생성자에 어노테이션을 추가해주면 된다.
class Example3 @Example1 constructor(val param: String){

}

// 프로퍼티 어노테이션
class Example4 {
    @setparam:Example1 // setter 메서드의 매개변수
    @set:Example1 // 프로퍼티 내 Setter 메서드
    var bar: String = "bar"

    @field:Example1
    val baz: String = "baz"
}
// 오브젝트 Goo의 값 GOO 참조
val gooValue = Goo.GOO

// 중첩 클래스
// 자바의 경우는 클래스 내부에 static을 사용함으로써 중첩 클래스를 선언해준다.
// 코틀린의 경우는 그럴 필요가 없다.
class Outer {
    // 키워드가 없으면 중첩 클래스로 간주
    class StaticNested {

    }

    // inner 키워드가 아니면 비중첩 클래스 선언
    // 자바는 키워드가 없으면 비중첩 클래스 선언으로 간주
    inner class NonStaticNested{

    }

    // 정적 중첩 클래스: Outer 클래스의 인스턴스 생성 없이 인스턴스 생성 가능
    val staticInstance = Outer.StaticNested()
    // java:: StaticNested staticInstance = new Outer.StaticNested()

    // 비정적 중첩 클래스: Outer 클래스의 인스턴스를 생성해야 인스턴스 생성 가능
    val nonStaticInstance = Outer().NonStaticNested()
    // java:: NonStaticNested nonStaticInstance = new Outer().NonStaticNested()
}

fun kotlinBase033(){
    val ex4: Example4 = Example4()
    println(ex4.baz)
}