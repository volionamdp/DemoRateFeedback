package com.volio.rate_feedback

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager.NameNotFoundException
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.volio.rate_feedback.adapter.FeedbackAdapter
import com.volio.rate_feedback.databinding.DialogFeedbackBinding
import com.volio.rate_feedback.model.DataFeedback
import com.volio.rate_feedback.utils.BaseDialogRateFeedback
import com.volio.rate_feedback.utils.Constant.EMAIL_FEEDBACK
import com.volio.rate_feedback.utils.Utils


class DialogFeedback(context: Context, private val rateFeedbackListener: RateFeedbackListener) :
    BaseDialogRateFeedback(context) {
    private val binding = DialogFeedbackBinding.inflate(LayoutInflater.from(context))

    private var isSendMail: Boolean = false

    private var content: String = ""

    private var feedbackPosition: Int = -1

    private val adapter by lazy {
        FeedbackAdapter(context) { position, isLast, data ->
            selectItem(position, isLast, data)
        }
    }

    override val contentView: View = binding.root
    override fun onViewReady() {
        initRVFeedback()
        initListener()
    }

    private fun initListener() {
        binding.edFeedback.doAfterTextChanged {
            if (isSendMail) {
                content = it.toString()
            }
        }
        binding.tvFeedback.setOnClickListener {
            if (feedbackPosition >=0) {
                sendMail()
                dismiss()
                rateFeedbackListener.onFeedback(feedbackPosition, content)
            }
        }
        binding.imgCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun initRVFeedback() {
        binding.rvFeedback.adapter = adapter
    }

    private fun selectItem(position: Int, isLast: Boolean, data: DataFeedback) {
        feedbackPosition = position
        isSendMail = isLast
        content = data.content
        binding.tvFeedback.isClickable = true
        binding.tvFeedback.alpha = 1f
        binding.tvFeedback.backgroundTintList = null
        if (isLast) {
            binding.edFeedback.visibility = View.VISIBLE
            content = binding.edFeedback.text.toString()
        } else {
            binding.edFeedback.visibility = View.GONE
        }
    }
    private fun getAppName():String{
        val packageManager = context.packageManager
        var applicationInfo: ApplicationInfo? = null
        runCatching {
            applicationInfo = packageManager.getApplicationInfo(context.packageName, 0)

        }.onFailure {
            it.printStackTrace()
        }
        return (if (applicationInfo != null) packageManager.getApplicationLabel(applicationInfo!!) else "") as String
    }

    private fun sendMail() {

        var version = ""
        runCatching {
            val info: PackageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            version = info.versionName
        }.onFailure {
            it.printStackTrace()
        }
        val title = "${getAppName()} $version Feedback"
        Utils.sendEmail(context, arrayOf(EMAIL_FEEDBACK), title, content)
    }
}