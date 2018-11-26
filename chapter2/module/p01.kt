package module

fun f01(arr: Array<Int>){
    println("Hello f01!")
}

fun f02(vararg args: String){
    println("Hello f02!")
}

fun kotlinBase01(){
    // 10진수 표기
    val decValue: Int = 100

    // 16진수 표기
    val hexValue: Int = 0x100

    // 2진수 표기
    val binaryValue: Int = 0b100

    // Long에 한해 대문자만 사용합니다.
    // (대문자 I 등 다른 문자와의 혼동 방지)
    val longValue: Long = 100L

    val doubleValue: Double = 100.1
    // (혹은 1.001e2)

    val floatValue = 100.0f
    // (혹은 100f)
    // (100.f 형태는 지원되지 않음)

    val c: Int = 65
    val ch: Char = c.toChar()

    val foo: String = "Lorem ipsum"
    val ch1: Char = foo.get(4)  // 4번째 인덱스인 'm'
    val ch2: Char = foo[6]      // 6번째 인덱스인 'i'

    var length: Int = 3000
    var lengthText: String = String.format("Length: %d meters", length)

    // "Length: 3000 meters" 값 할당
    lengthText = "Length: $length meters"

    // 문자열 내 값 할당
    var text: String = "Lorem ipsum"
    lengthText = "TextLength: ${text.length}"

    // 문자열 내의 달러문자
    val price: Int = 1000
    val priceText: String = "Price: ${'$'}$price"

    val words: Array<String> = arrayOf(
        "Lorem", "ipsum", "dolor", "sit")

    val intArr1: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val intArr2: Array<Int> = arrayOf(1, 2, 3, 4, 5)

    f01(intArr2)    // 정수형 배열은 인자로 바로 대입
    f02(*words)     // 문자열의 배열은 스프레드 연산자 사용해야 함
}