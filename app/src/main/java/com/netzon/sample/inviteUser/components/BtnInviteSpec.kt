package com.netzon.sample.inviteUser.components

import android.app.Activity
import android.text.Layout
import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.EmptyComponent
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R

@LayoutSpec
object BtnInviteSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext
    ): Component =
        Column.create(c)
            .flex(1f)
            .backgroundColor(c.getColor(R.color.invite_bg))
            .child(Row.create(c).flex(1f))
            .child(Text.create(c)
                .heightDip(80f)
                .textColor(c.getColor(android.R.color.white))
                .textSizeRes(R.dimen.text_title)
                .text(c.getString(R.string.invite))
                .textAlignment(Layout.Alignment.ALIGN_CENTER))
            .build()

}