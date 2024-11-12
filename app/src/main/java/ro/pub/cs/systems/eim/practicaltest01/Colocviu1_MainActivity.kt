package ro.pub.cs.systems.eim.practicaltest01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class Colocviu1_MainActivity : AppCompatActivity() {
    // Counters for each button
    private var countButton1 = 0
    private var countButton2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_main) // Ensure this matches your layout file name

        // References to TextViews and Buttons
        val textView1: TextView = findViewById(R.id.textView1)
        val textView2: TextView = findViewById(R.id.textView2)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)

        // Set up listeners for each button
        button1.setOnClickListener {
            countButton1++ // Increment count for Button 1
            textView1.text = countButton1.toString() // Update TextView1 with the new count
        }

        button2.setOnClickListener {
            countButton2++ // Increment count for Button 2
            textView2.text = countButton2.toString() // Update TextView2 with the new count
        }
    }
}