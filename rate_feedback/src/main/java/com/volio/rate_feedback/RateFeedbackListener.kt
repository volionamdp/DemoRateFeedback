package com.volio.rate_feedback

interface RateFeedbackListener {
    fun onRate(start:Int)
    fun onFeedback(position:Int,contentFeedback:String)
}