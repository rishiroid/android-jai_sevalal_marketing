package co.rishiz.jsm.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import co.rishiz.jsm.R
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private var welcome: ConstraintLayout? = null
    private var txtLogIn: TextView? = null
    private var txtSignUp: TextView? = null
    private var btnSubmit: Button? = null
    private var confirmPassword: TextInputLayout? = null
    private var forgotPass: TextView? = null
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_JaiSevalalMarketing)
        setContentView(R.layout.activity_main)
        welcome = findViewById(R.id.welcome)
        welcome?.setOnClickListener(View.OnClickListener { welcome?.visibility = View.GONE })
        txtLogIn = findViewById(R.id.txtLogin)
        txtSignUp = findViewById(R.id.txtSignup)
        btnSubmit = findViewById(R.id.btnSubmit)
        forgotPass = findViewById(R.id.forgotPass)
        confirmPassword = findViewById(R.id.confirmPassword)
        txtLogIn?.setOnClickListener(View.OnClickListener {
            txtLogIn?.background = resources.getDrawable(R.drawable.text_selected)
            txtLogIn?.setTextColor(resources.getColor(R.color.whie_card))
            txtLogIn?.elevation = 4f
            txtSignUp?.elevation = 0f
            txtSignUp?.background = resources.getDrawable(R.drawable.text_unselected)
            txtSignUp?.setTextColor(resources.getColor(R.color.red))
            btnSubmit?.text = "Log in"
            forgotPass?.visibility = View.VISIBLE
            confirmPassword?.visibility = View.GONE
        })
        txtSignUp?.setOnClickListener(View.OnClickListener {
            txtLogIn?.background = resources.getDrawable(R.drawable.text_unselected)
            txtLogIn?.setTextColor(resources.getColor(R.color.red))
            txtLogIn?.elevation = 0f
            txtSignUp?.elevation = 4f
            txtSignUp?.background = resources.getDrawable(R.drawable.text_selected)
            txtSignUp?.setTextColor(resources.getColor(R.color.whie_card))
            btnSubmit?.text = "Sign up"
            forgotPass?.visibility = View.GONE
            confirmPassword?.visibility = View.VISIBLE
        })
    }
}