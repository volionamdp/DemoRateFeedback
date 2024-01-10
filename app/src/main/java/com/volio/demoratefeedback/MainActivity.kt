package com.volio.demoratefeedback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.volio.rate_feedback.DialogFeedback
import com.volio.rate_feedback.DialogRate
import com.volio.rate_feedback.RateFeedbackListener

class MainActivity : AppCompatActivity() {
    private var rateFeedbackListener = object : RateFeedbackListener {
        override fun onRate(start: Int) {

        }

        override fun onFeedback(position: Int, contentFeedback: String) {

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        DialogRate(this,rateFeedbackListener).show()

        DialogFeedback(this,rateFeedbackListener).show()
    }
}