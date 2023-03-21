package co.rishiz.jsm.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import co.rishiz.jsm.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    companion object{
        private val TAG= Companion::class.java.name
    }
    private var welcome: ConstraintLayout? = null
    private var txtLogIn: TextView? = null
    private var txtSignUp: TextView? = null
    private var btnSubmit: Button? = null
    private var confirmPassword: TextInputLayout? = null
    private var forgotPass: TextView? = null
    private var isLogin:Boolean?=null
    private var email:TextView?=null
    private var password:TextView?=null

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_JaiSevalalMarketing)
        setContentView(R.layout.activity_login)
        //Init views
        initViews()
        txtLogIn?.setOnClickListener(View.OnClickListener {
            isLogin=false
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
            isLogin=true
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
        btnSubmit?.setOnClickListener{
            if(email?.text.toString().isEmpty()&&password?.text.toString().isEmpty()){
                Toast.makeText(this,"Invalid input ",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(isLogin==true){
                login()
            }else{
                signUp()
            }
        }
    }

    private fun initViews() {
        welcome = findViewById(R.id.welcome)
        welcome?.setOnClickListener(View.OnClickListener { welcome?.visibility = View.GONE })
        txtLogIn = findViewById(R.id.txtLogin)
        txtSignUp = findViewById(R.id.txtSignup)
        btnSubmit = findViewById(R.id.btnSubmit)
        forgotPass = findViewById(R.id.forgotPass)
        confirmPassword = findViewById(R.id.confirmPasswordLayout)
        email=findViewById(R.id.edtEmail)
        password=findViewById(R.id.edtPassword)
    }

    private fun login(){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email?.text.toString(),password?.text.toString()).addOnCompleteListener{
            if(it.isSuccessful){
                Toast.makeText(this,"Logged in successfully",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
            }else{
                Toast.makeText(this,it.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun signUp(){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email?.text.toString(),password?.text.toString()).addOnCompleteListener{
           if(it.isSuccessful){
               Toast.makeText(this,"Sign up successfully",Toast.LENGTH_SHORT).show()
        }else{
               Toast.makeText(this,it.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
        }
        }
    }
}