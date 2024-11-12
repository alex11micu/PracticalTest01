package ro.pub.cs.systems.eim.practicaltest01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Colocviu1_MainActivity : AppCompatActivity() {

    // Counters for each button
    private var countButton1 = 0
    private var countButton2 = 0

    companion object {
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviu1_1_main)

        // References to TextViews and Buttons
        val textView1: TextView = findViewById(R.id.textView1)
        val textView2: TextView = findViewById(R.id.textView2)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val navigateButton: Button = findViewById(R.id.navigate_button)

        // Restore state if available
        if (savedInstanceState != null) {
            countButton1 = savedInstanceState.getInt("countButton1", 0)
            countButton2 = savedInstanceState.getInt("countButton2", 0)
            textView1.text = countButton1.toString()
            textView2.text = countButton2.toString()
        }

        // Set up listeners for each button
        button1.setOnClickListener {
            countButton1++
            textView1.text = countButton1.toString()
        }

        button2.setOnClickListener {
            countButton2++
            textView2.text = countButton2.toString()
        }

        // Navigate to the secondary activity
        navigateButton.setOnClickListener {
            val intent = Intent(this, Colocviu1_SecondActivity::class.java)
            intent.putExtra("text", "Navigated from Main Activity")
            intent.putExtra("count", countButton1 + countButton2)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("countButton1", countButton1)
        outState.putInt("countButton2", countButton2)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        countButton1 = savedInstanceState.getInt("countButton1", 0)
        countButton2 = savedInstanceState.getInt("countButton2", 0)
        findViewById<TextView>(R.id.textView1).text = countButton1.toString()
        findViewById<TextView>(R.id.textView2).text = countButton2.toString()
    }

    // Override onActivityResult to reset counters if Cancel was pressed
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_CANCELED) {
            // Reset counters
            countButton1 = 0
            countButton2 = 0
            findViewById<TextView>(R.id.textView1).text = countButton1.toString()
            findViewById<TextView>(R.id.textView2).text = countButton2.toString()
        }
    }
}
