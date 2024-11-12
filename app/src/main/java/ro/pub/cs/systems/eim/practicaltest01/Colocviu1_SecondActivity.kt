package ro.pub.cs.systems.eim.practicaltest01

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Colocviu1_SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_second)

        // Get references to the UI elements
        val instructionText: TextView = findViewById(R.id.instruction_text)
        val registerButton: Button = findViewById(R.id.register_button)
        val cancelButton: Button = findViewById(R.id.cancel_button)

        // Retrieve the intent extras sent from the main activity
        val receivedText = intent.getStringExtra("text") ?: "No text received"
        val count = intent.getIntExtra("count", 0)

        // Set the received text and count in the TextView
        instructionText.text = "$receivedText - Count: $count"

        // Set up the Register button click listener
        registerButton.setOnClickListener {
            Toast.makeText(this, "Register button pressed", Toast.LENGTH_SHORT).show()
            // Optionally set result for other actions if needed
            finish()
        }

        // Set up the Cancel button click listener
        cancelButton.setOnClickListener {
            Toast.makeText(this, "Cancel button pressed", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_CANCELED) // Set result to indicate cancel
            finish() // End activity and return to the main activity
        }
    }
}
