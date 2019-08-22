package buu.informatics.s59160927.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import buu.informatics.s59160927.aboutme.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var myName:MyName = MyName("Kittiphop Ngamsantichai")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply{
            done_button.setOnClickListener {
                addNickname(it)
            }
            nickname_text.setOnClickListener {
                updateNickname(it)
            }
            this.myName = this@MainActivity.myName
        }
    }

    private fun addNickname(view: View) {

        binding.apply{
            myName?.nickname = nickname_edit.text.toString()
            nickname_edit.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE
            done_button.visibility = View.GONE
            invalidateAll()
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
        }
    }

    private  fun updateNickname(view: View){
        binding.apply{
            nickname_edit.visibility = View.VISIBLE
            done_button.visibility = View.VISIBLE
            nickname_edit.requestFocus()
            view.visibility = View.GONE

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nickname_edit, 0)
        }
    }
}
