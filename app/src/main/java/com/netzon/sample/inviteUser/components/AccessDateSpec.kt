package com.netzon.sample.inviteUser.components

import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R

@LayoutSpec
object AccessDateSpec {
    val listDay = listOf<String>("MON","TUE","WED","THU","FRI","SAT","SUN")
    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext
    ): Component {
        val row = Row.create(c).
            marginRes(YogaEdge.TOP, R.dimen.space_small)
        for (item in listDay)
            row.child(AccessDateItem.create(c)
                .title(item))
        return row.build()
    }

}