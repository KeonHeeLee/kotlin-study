package keonheelee.github.io.ankoapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toast.makeText(Context, "Hello, Kotlin!". Toast.LENGTH_SHORT).show()
        toast("Hello, Kotlin")

        // Toast.makeText(Context, R.string.hello, Toast.LENGTH_SHORT).show()
        toast(R.string.hello)

        // Toast.makeText(Context, R.string.hello, Toast.LENGTH_LONG).show()
        longToast("Hello, Kotlin")
    }
}
