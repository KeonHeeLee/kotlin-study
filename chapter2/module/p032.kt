package module

import com.sun.istack.internal.Nullable
import java.awt.Button
import javax.swing.text.AttributeSet

class Context
class Bundle

// Example View and OnClickListener Interface..
abstract class View(context: Context ?= null) {
    interface OnClickListener{
        fun onClick(view: View)
    }
}

// Example Abstract class: AppCompatActivity
abstract class AppCompatActivity{
    init{}

    // 상속받게 할려면 반드시 open이란 키워드를 붙여야한다.
    // 그게 아니라면 재정의를 할 수 없다.
    protected open fun onCreate(savedInstanceState: Bundle?){

    }
}


// 7. 상속 및 인터페이스 구현 차이 (안드로이드 기준)
// 인터페이스와 상속을 구준하지 않고, 그냥 :뒤에 쉼표(,)로 구분한다.
class MainActivity: AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
// AppCompatActivity는 그냥 생성자를 바로 호출

class MyView: View {
    // 뷰 초기화
    constructor(context: Context): this(context, null)
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs)
}

// 그리고 코틀린에선 오버라이드는 무조건 키워드를 붙여줘야한다.
class MyActivity: AppCompatActivity(), View.OnClickListener {
    // AppCompateAcitivity의 onCreate() 메서드 상속
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onClick(view: View) {
        TODO("not implemented")
        //To change body of created functions use File | Settings | File Templates.
    }
}

// 반대로 final을 붙이면 상속을 하지 못한다. (open은 상속가능)
open class OpenClass {
    open val openProperty = "foo"
    val finalProperty = "bar"
    open fun openFunc() {}
    fun finalFunc() {}
}

class FinalClass: OpenClass() {
    override val openProperty = "Foo"
    override fun openFunc() {
        println("Hello World!")
    }
}

class MyActivity2: AppCompatActivity() {
    lateinit var btnHello: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // java :: btnHello = (Button)findViewById(R.id.btn_hello)
        btnHello = findViewById(R.id.btn_hello) as Button

        // 인터페이스 선언은 object:로 한다.
        btnHello.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                TODO("not implemented")
                //To change body of created functions use File | Settings | File Templates.
                // this = View.OnClickListener
                // 액티비티의 인스턴스를 참고하기 위해 this@MyActivity를 사용
                // java:: Toast.makeText(MyActivity.this, "Hello", Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MyActivity2, "Hello", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

fun kotlinBase032(){

}