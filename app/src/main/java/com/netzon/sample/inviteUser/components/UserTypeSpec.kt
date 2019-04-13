package com.netzon.sample.inviteUser.components

import android.widget.Toast
import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text
import com.facebook.litho.widget.TextInput
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge
import com.facebook.yoga.YogaJustify
import com.netzon.sample.R

@LayoutSpec
object UserTypeSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext
    ): Component =
        Row.create(c)
            .marginRes(YogaEdge.TOP, R.dimen.space_normal)
            .marginRes(YogaEdge.BOTTOM, R.dimen.space_normal)
            .child(
                Column.create(c)
                    .flex(1f)
                    .child(
                        Text.create(c)
                            .clickHandler(UserType.onClick(c))
                            .text(c.getString(R.string.user_type))
                            .textSizeRes(R.dimen.text_title))
                    .child(
                        Text.create(c)
                            .clickHandler(UserType.onClick(c))
                            .text(c.getString(R.string.select_user_type))
                            .textSizeRes(R.dimen.text_normal)
                            .textColor(c.getColor(android.R.color.darker_gray))
                    ))
            .child(
                Image.create(c)
                    .clickHandler(UserType.onClick(c))
                    .alignSelf(YogaAlign.CENTER)
                    .drawableRes(R.mipmap.ic_arrow_right)
            )
            .build()

    @OnEvent(ClickEvent::class)
    fun onClick(c: ComponentContext){
        Toast.makeText(c.androidContext,
            c.getString(R.string.select_user_type),
            Toast.LENGTH_SHORT).show()
    }
}