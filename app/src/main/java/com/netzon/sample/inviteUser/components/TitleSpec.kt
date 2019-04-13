package com.netzon.sample.inviteUser.components

import android.app.Activity
import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R

@LayoutSpec
object TitleSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @Prop title: String
    ): Component =
        Text.create(c)
            .text(title)
            .textSizeRes(R.dimen.text_title)
            .textColor(c.getColor(android.R.color.black))
            .build()

}