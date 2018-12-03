package module

import com.sun.glass.ui.View
import java.awt.Button

/* Before Java lamda expression
 * Button button = ... // 버튼 인스턴스
 * button.setOnClickListener(new View.OnClickListener() {
 *     @Override
 *     public void onClick(View v){
 *         doSomething();
 *     }
 * });
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  To lamda expression (Java)
 *  Button button = ... // 버튼 인스턴스
 *  button.setOnClickListener((View v) -> doSomething());
 *  button.setOnClickListener(v -> doSomething());
 */

fun example031(){
    var button: Button?
    button.setOnClickListener({v: View -> doSomething()})
    button.setOnClickListener({v -> doSomething()})
}

class Person3(val name: String, val age: Int){
    val adult = age > 19
}

fun printAdults(people: List<Person3>){
    people.filter({person -> person.adult})
        .forEach{ println("Name= ${it.name}")}

    people.filter(Person3::adult)
        .forEach{ println("Name= ${it.name}")}
}

fun example032(){
    val people: List<Person3> = arrayListOf(Person3("tom", 20), Person3("amy", 25))
    printAdults(people)
}

fun kotlinModule03(){

}