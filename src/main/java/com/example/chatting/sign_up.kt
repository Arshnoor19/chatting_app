package com.example.chatting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class sign_up : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signup: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()
        supportActionBar?.hide()

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signup = findViewById(R.id.signup)

        signup.setOnClickListener {

            val email = email.text.toString()
            val password = password.text.toString()
            //val name=name.text.toString()

            signup(email, password)
        }
    }

    private fun signup(email: String, password: String) {

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent=Intent(this@sign_up, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@sign_up, "email invalid", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
