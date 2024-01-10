package com.volio.rate_feedback

import android.content.Context
import com.volio.rate_feedback.model.DataFeedback
import com.volio.rate_feedback.model.DataRate

object DataRateFeedback {
    fun getRate(context: Context): List<DataRate> {
        val listRate: MutableList<DataRate> = mutableListOf()
        listRate.add(
            DataRate(
                R.drawable.img_star_rate_default,
                context.getString(R.string.how_do_you_feel_about_the_app_your_feedback_is_important_to_us)
            )
        )
        listRate.add(
            DataRate(
                R.drawable.img_star_rate_1,
                context.getString(R.string.oh_no_please_leave_us_some_feedback)
            )
        )
        listRate.add(
            DataRate(
                R.drawable.img_star_rate_2,
                context.getString(R.string.oh_no_please_leave_us_some_feedback)
            )
        )
        listRate.add(
            DataRate(
                R.drawable.img_star_rate_3,
                context.getString(R.string.how_do_you_feel_about_the_app_your_feedback_is_important_to_us)
            )
        )
        listRate.add(
            DataRate(
                R.drawable.img_star_rate_4,
                context.getString(R.string.we_like_you_too_thanks_for_your_feedback)
            )
        )
        listRate.add(
            DataRate(
                R.drawable.img_star_rate_5,
                context.getString(R.string.we_like_you_too_thanks_for_your_feedback)
            )
        )
        return listRate
    }
    fun getFeedback(context: Context):List<DataFeedback>{
        val listFeedback:MutableList<DataFeedback> = mutableListOf()
        listFeedback.add(DataFeedback(context.getString(R.string.less_call_screen_than_i_expected)))
        listFeedback.add(DataFeedback(context.getString(R.string.i_want_different_style_of_call_screen)))
        listFeedback.add(DataFeedback(context.getString(R.string.i_could_not_change_my_call_screen)))
        listFeedback.add(DataFeedback(context.getString(R.string.too_many_ads)))
        listFeedback.add(DataFeedback(context.getString(R.string.the_app_is_hard_to_use)))
        listFeedback.add(DataFeedback(context.getString(R.string.i_could_not_turn_on_the_speaker)))
        listFeedback.add(DataFeedback(context.getString(R.string.other)))
        return listFeedback
    }
}