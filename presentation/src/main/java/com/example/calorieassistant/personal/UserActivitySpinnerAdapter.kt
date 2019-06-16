package com.example.calorieassistant.personal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.calorieassistant.models.UserActivityLevel
import android.view.MotionEvent
import android.widget.TextView
import com.example.calorieassistant.R


class UserActivitySpinnerAdapter(context: Context,
                                 val res: Int,
                                 val array: List<UserActivityLevel>,
                                 val listener: (UserActivityLevel) -> Unit)
    : ArrayAdapter<UserActivityLevel>(context, res, array){

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var newView = convertView;
        if(newView == null){
            val inflater = LayoutInflater.from(context)
            newView = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false)
        }
        val item = array[position]
        val text1 = newView?.findViewById(android.R.id.text1) as TextView
        text1.text = getText(item)
        setOnTouchListener(newView, item)
        return newView
    }

    private fun setOnTouchListener(view: View, item: UserActivityLevel) {
        view.setOnTouchListener { v: View, e: MotionEvent ->
            listener(item)
            false
        }
    }

    private fun getText(activityLevel: UserActivityLevel): String{
        return when(activityLevel) {
            UserActivityLevel.No -> context.resources.getString(R.string.user_activity_no)
            UserActivityLevel.Low -> context.resources.getString(R.string.user_activity_low)
            UserActivityLevel.Medium -> context.getString(R.string.user_activity_medium)
            UserActivityLevel.High -> context.getString(R.string.user_activity_high)
            UserActivityLevel.Extreme -> context.getString(R.string.user_activity_very_high)
        }
    }
}