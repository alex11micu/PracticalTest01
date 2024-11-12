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
        setContentView(R.layout.activity_colocviu1_1_main)

        // References to TextViews and Buttons
        val textView1: TextView = findViewById(R.id.textView1)
        val textView2: TextView = findViewById(R.id.textView2)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)

        // Restore state if available
        if (savedInstanceState != null) {
            countButton1 = savedInstanceState.getInt("countButton1", 0)
            countButton2 = savedInstanceState.getInt("countButton2", 0)
            textView1.text = countButton1.toString()
            textView2.text = countButton2.toString()
        }

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

    // Save the current state (counters) before rotation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("countButton1", countButton1)
        outState.putInt("countButton2", countButton2)
    }

    // Restore the saved state after rotation
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        countButton1 = savedInstanceState.getInt("countButton1", 0)
        countButton2 = savedInstanceState.getInt("countButton2", 0)

        // Update the TextViews with the restored values
        findViewById<TextView>(R.id.textView1).text = countButton1.toString()
        findViewById<TextView>(R.id.textView2).text = countButton2.toString()
    }
}