package com.volio.rate_feedback.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volio.rate_feedback.DataRateFeedback
import com.volio.rate_feedback.databinding.ItemFeedbackBinding
import com.volio.rate_feedback.model.DataFeedback

class FeedbackAdapter(
    context: Context,
    val onSelectItem: (position: Int, isLast: Boolean, data: DataFeedback) -> Unit
) : RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder>() {
    private val listData = DataRateFeedback.getFeedback(context)
    private var selectPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackViewHolder {
        return FeedbackViewHolder(ItemFeedbackBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: FeedbackViewHolder, position: Int) {
        holder.bindView(position)
    }

    inner class FeedbackViewHolder(val binding: ItemFeedbackBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(position: Int) {
            binding.isSelect = selectPosition == position
            binding.title = listData[position].content
            binding.root.setOnClickListener {
                val oldPosition = selectPosition
                selectPosition = position
                onSelectItem.invoke(position, position == listData.size - 1, listData[position])
                notifyItemChanged(position)
                if (oldPosition >= 0) {
                    notifyItemChanged(oldPosition)
                }
            }
        }
    }
}




