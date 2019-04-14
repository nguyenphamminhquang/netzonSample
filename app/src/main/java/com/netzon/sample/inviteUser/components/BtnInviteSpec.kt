package com.netzon.sample.inviteUser.components

import android.text.Layout
import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
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
            .child(Row.create(c).flex(1f))
            .child(Text.create(c)
                .paddingRes(YogaEdge.TOP, R.dimen.space_normal)
                .backgroundColor(c.getColor(R.color.bg_invite_btn))
                .heightDip(80f)
                .textColor(c.getColor(android.R.color.white))
                .textSizeRes(R.dimen.text_normal)
                .text(c.getString(R.string.invite))
                .textAlignment(Layout.Alignment.ALIGN_CENTER)
                .clickHandler(BtnInvite.onClick(c)))
            .build()

    @OnEvent(ClickEvent::class)
    fun onClick(c : ComponentContext, @Prop btnClickListener: () -> Unit) {
        btnClickListener.invoke()
    }

}