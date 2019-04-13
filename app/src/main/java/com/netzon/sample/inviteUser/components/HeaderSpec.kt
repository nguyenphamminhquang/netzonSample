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
import com.facebook.yoga.YogaPositionType
import com.netzon.sample.R

@LayoutSpec
object HeaderSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @Prop title: String
    ): Component =
        Row.create(c)
            .child(
                Image.create(c)
                    .alignSelf(YogaAlign.CENTER)
                    .widthRes(R.dimen.btn_back)
                    .heightRes(R.dimen.btn_back)
                    .clickHandler(Header.onClick(c))
                    .drawableRes(R.mipmap.ic_back))
            .child(
                Text.create(c)
                    .paddingRes(YogaEdge.LEFT, R.dimen.padding_normal)
                    .text(title)
                    .textSizeRes(R.dimen.text_title)
                    .textColor(c.getColor(android.R.color.black))
                    .paddingDip(YogaEdge.ALL, 10f)
            )
            .build()


    @OnEvent(ClickEvent::class)
    fun onClick(c: ComponentContext) {
        (c.androidContext as Activity).onBackPressed()
    }
}