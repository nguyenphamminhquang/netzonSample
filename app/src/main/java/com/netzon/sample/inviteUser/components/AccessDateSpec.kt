package com.netzon.sample.inviteUser.components

import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R

@LayoutSpec
object AccessDateSpec {
    val listDay = listOf<String>("MON","TUE","WED","THU","FRI","SAT","SUN")
    val selectedDays = ArrayList<String>()
    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @Prop selectedDayListener: (List<String>) -> Unit
    ): Component {
        val row = Row.create(c).
            marginRes(YogaEdge.TOP, R.dimen.space_small)
        listDay.forEachIndexed { index, s ->
            row.child(AccessDateItem.create(c)
                .currentPosition(index)
                .selectedDayListener { currentPosition, isChecked ->
                    val selectedDayName = listDay[currentPosition]
                    if (isChecked){
                        selectedDays.add(selectedDayName)
                    } else {
                        if (selectedDays.contains(selectedDayName))
                            selectedDays.remove(selectedDayName)
                    }
                    selectedDayListener.invoke(selectedDays)
                }
                .title(s))
        }

        return row.build()
    }

}