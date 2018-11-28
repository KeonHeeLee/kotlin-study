package module

import java.awt.Image
import java.lang.IllegalStateException

// line2가 null을 넣을 수 있다.
fun formatAddress(line1: String, line2: String?, city: String): String { return "Hello" }

// 입력한 주소에 해당하는 우편변호를 반환하지만, 검색 결과가 없을 경우 null을 반환
fun findPostalCode(address: String?): String? {
    if(address == null)
        return null
    else
        return address
}

// 엘비스(?:) 연산자
// 엘비스 연산자 뒤에는 null일 경우를 적어주면 된다.
// 연산자 뒤는 null일 때 대체할 것을 넣는다.
fun findPostalCode2(address: String?): String? {
    return address ?: "Foo"
}

// 엘비스 연산자 예제
fun generateMapImage(address: String): Image? {
    // 우편번호 검색 결과가 없을 경우 바로
    // 함수 실행을 종료하고 결과로 null 반환
    var postal = findPostalCode(address)
        ?: return null

    // example 2
    postal = findPostalCode(address)
            ?: throw IllegalStateException()

    // 지도 이미지 생성
    return null
}

fun example081(){
    val foo:String? = findPostalCode("Hello") ?: "No address"
}

// ?. 안전 호출
// as? 강제 형변환 관련 null 검사
// !! null이 아님을 명시
// lateinit : 나중에 초기화됨을 명시

fun kotlinBase08(){
    // null값을 사용할려면 ?를 반드시 입력해줘야한다.
    val nullableString: String?= null
    val nonNullString: String = "foo"

    example081()
}