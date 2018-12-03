package module

// 타입 별칭
typealias PeopleList = List<Person>
typealias ItemInTags<T> = Map<String, T>

data class Person4(val age: Int, val name: String)

fun kotlinModule04(){
    // Person4 클래스의 분해선언
    val person: Person4 = Person4(27, "Lee")
    val (ageOfPerson4, nameOfPerson4) = person
}