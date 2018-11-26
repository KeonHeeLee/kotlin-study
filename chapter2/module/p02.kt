package module

fun kotlinBase02(){
    // 자료를 수정할 수 없는 리스트 생성
    val immutableList: List<String> = listOf("Lorem", "ipsum", "dolor", "sit")

    // immutableList(List)의 경우 수정이 불가능하므로 add같은 수정하는 메서드 사용불가
    // immutableList.add("amet")

    val mutableList: MutableList<String> = arrayListOf("Lorem", "ipsum", "dolor", "sit")
    mutableList.add("amet")

    val immutableList2: List<String> = mutableList
    // immutableList2의 경우 수정이 불가능하다.
    // immutableList2.add("amet")

    // 배열 인덱스 방식으로 리스트 접근 가능
    println("example 1 - ${immutableList[0]}")
    mutableList[0] = "Lollypop"
    println("example 2 - ${mutableList[0]}")

    val immutableMap: Map<String, Int> = mapOf(Pair("A", 65), Pair("B", 66))
    println("example 3 - ${immutableMap["A"]}")
    // 에러 -> immutableMap["C"] = 67

    // 에러 -> val mutableMap: MutableMap<String, Int> = immutableMap;
    val mutableMap: HashMap<String, Int> = hashMapOf(Pair("A", 65), Pair("B", 66))
    mutableMap["C"] = 67 // 변경가능
}