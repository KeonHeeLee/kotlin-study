package module

import com.sun.istack.internal.Nullable

/* 자바 클래스와는 다른점
 * 1. 코틀린은 아무 접근 제한자를 지정하지 않을 경우 public이다.
 * (단, 자바는 default로 표기가 된다는 것이 차이점이다.)
 */

class Foo {
    val URL:String = "https://github.com/KeonHeeLee"

    private fun Hello(){
        println("Hello World!")
    }

    fun publicHello(){
        this.Hello()
        println("${this.URL} Hi!")
    } // 이게 public 접근 지정자다.
}

abstract class Hoo {
    abstract fun bar()
}

interface Bar {
    fun baz()
}

/*
 * 2. 본체없이 선언이 가능하다. (인터페이스 포함)
 */
class NonBodyClass
interface NonBodyInterface


/* 3. 자바의 getter/setter를 대체하기 위해 property를 사용한다.
 *   이로인해 소스코드의 분량이 배로 커지는 것을 막을 수 있다. (매우 간결해졌다.)
 *   또한 읽을 수만 있게 할려면 val, 쓰고읽기가 가능하게 할려면 var을 쓰면된다.
 */
class Person {
    @Nullable var name: String? = null
    @Nullable var address: String? = null // 이렇게 안쓰면 컴파일 에러가 난다.
    // var address: String <- 이게 컴파일 에러
    @Nullable lateinit var example: String
    // 책에서 조금 이상한게 lateinit var example: String? 라고했는데, 이거 lateinit에서 빨간줄 뜬다.
}

/*
 * 하지만 var 멤버변수에도 나중에 할당할 변수가 있을 수가 있다.
 * 이런 경우에는 lateinit를 써주면 컴파일 에러가 발생하지 않는다.
 */

/*
 * 4. 접근 제한자에서의 차이
 *  첫째, public 은 생략
 *  둘째, 패키지 단위 제한자(java에선 default)는 internal
 *   하지만 internal 접근 제한자도 동일한 모듈내의 클래스(패키지x)로만 접근을 제한시킨다.
 *  그 외에는 자바와 거의 동일하다.
 *
 * 5. 생성자에서의 차이
 *  키워드는 init
 */

class Woo {
    val a = 1
    protected val b = 2
    private val c = 3
    internal val d = 4

    init {
        TODO("Contructor Todo")
    }
}

// 이런 경우는 생성자에 인자가 필요하다고 해서 primary constructor라고 부른다.
// 또한 internal constructor 키워드를 넣으면 생성자의 가시성이 향상된다.
class Hello internal constructor(val a: Int, val b: Char) {
    init {
        TODO("Primary Constructor")
    }

    // 주생성자는 반드시 있어야 한다.
    // 또한 프로퍼티가 필요한 경우, 반드시 이를 주 생성자에서 처리해야한다.
    constructor(a: Int): this(1, 'A')
    constructor(): this(0, 'F')
}

// 6. 메서드 키워드 차이
class FunExample {

    // 아무 값도 반환하지 않는 메서드
    // Unit이란 키워드를 제거해도 상관없다.
    fun foo(): Unit {

    }

    // Int형 값을 반환하는 메서드
    fun baa(): Int {
        return 0
    }
}

fun kotlinBase031(){
    // Foo 인스턴스 생성
    val foo: Foo = Foo()
    foo.publicHello()

    // 추상 클래스 인스턴스 생성
    val hoo: Hoo = object: Hoo() {
        override fun bar() {
            TODO("not implemented")
            //To change body of created functions use File | Settings | File Templates.
        }
    }

    // 인터페이스 인스턴스 생성
    val bar:Bar = object: Bar {
        override fun baz() {
            TODO("not implemented")
            //To change body of created functions use File | Settings | File Templates.
        }
    }

    val hello: Hello = Hello(0, 'B')
}