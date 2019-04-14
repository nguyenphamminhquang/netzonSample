package com.netzon.sample.inviteUser.components

import android.text.Layout
import com.facebook.litho.ClickEvent
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R

@LayoutSpec
object AccessDateItemSpec {
    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @Prop title: String
    ): Component {
        return Column.create(c)
            .flex(1f)
            .child(
                CheckBoxLitho.create(c).initChecked(false)
            )
            .child(
                Text.create(c)
                    .marginRes(YogaEdge.TOP, R.dimen.space_small)
                    .textAlignment(Layout.Alignment.ALIGN_CENTER)
                    .clickHandler(AccessDateItem.onClickedText(c))
                    .text(title)
                    .textSizeRes(R.dimen.text_small)
                    .textColor(c.getColor(android.R.color.black))
            )
            .build()
    }

    @OnEvent(ClickEvent::class)
    fun onClickedText(c: ComponentContext) {
        //TODO update state in checkBox.
    }

}