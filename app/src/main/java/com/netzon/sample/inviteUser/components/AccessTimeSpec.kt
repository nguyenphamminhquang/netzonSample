package com.netzon.sample.inviteUser.components

import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R

@LayoutSpec
object AccessTimeSpec {
    
    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext
    ): Component {
        val row = Row.create(c)
            .marginRes(YogaEdge.TOP, R.dimen.space_small)
            .child(AccessTimetem.create(c)
                .marginRes(YogaEdge.RIGHT, R.dimen.space_normal)
                .title(c.getString(R.string.start_time)))
            .child(AccessTimetem.create(c).title(c.getString(R.string.end_time)))
        return row.build()
    }

}