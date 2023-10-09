package com.example.chatting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


private lateinit var email: EditText
private lateinit var password: EditText
private lateinit var lgnbtn: Button
private lateinit var signup: Button
private lateinit var mAuth: FirebaseAuth
class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        email = findViewById(R. id. email)
        password = findViewById(R. id. password)
        lgnbtn = findViewById(R. id. lgnbtn)
        signup = findViewById(R. id. signup)

        signup.setOnClickListener{
            val intent= Intent( this ,sign_up::class.java)
            startActivity(intent)
        }

        lgnbtn.setOnClickListener{
            val email = email.text.toString()
            val password = password.text.toString()

            login(email,password)
        }


    }

    private fun login(email: String,password :String){

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this,"user not there",Toast.LENGTH_SHORT).show()

                }
            }
    }
}