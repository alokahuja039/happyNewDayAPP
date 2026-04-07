package com.happyday.app

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dayName = getDayName()

        val greetingText = findViewById<TextView>(R.id.greetingText)
        val dayText = findViewById<TextView>(R.id.dayText)
        val subtitleText = findViewById<TextView>(R.id.subtitleText)

        greetingText.text = "Have a Happy"
        dayText.text = dayName
        subtitleText.text = getDayMessage(dayName)

        val fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        fadeIn.duration = 1000
        greetingText.startAnimation(fadeIn)

        val slideUp = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        slideUp.duration = 800
        dayText.startAnimation(slideUp)
    }

    private fun getDayName(): String {
        val calendar = Calendar.getInstance()
        return when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY    -> "Monday"
            Calendar.TUESDAY   -> "Tuesday"
            Calendar.WEDNESDAY -> "Wednesday"
            Calendar.THURSDAY  -> "Thursday"
            Calendar.FRIDAY    -> "Friday"
            Calendar.SATURDAY  -> "Saturday"
            Calendar.SUNDAY    -> "Sunday"
            else               -> "Day"
        }
    }

    private fun getDayMessage(day: String): String {
        return when (day) {
            "Monday"    -> "Start the week strong! 💪"
            "Tuesday"   -> "Keep the momentum going! 🚀"
            "Wednesday" -> "Halfway there, you've got this! ⚡"
            "Thursday"  -> "Almost at the finish line! 🌟"
            "Friday"    -> "The weekend is almost here! 🎉"
            "Saturday"  -> "Enjoy your day off! 🌈"
            "Sunday"    -> "Rest, recharge, repeat! ☀️"
            else        -> "Make it a great one!"
        }
    }
}
