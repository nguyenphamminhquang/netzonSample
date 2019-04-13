package com.netzon.sample.inviteUser.components

import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.TextInput
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R

@LayoutSpec
object EmailAddressSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext
    ): Component =
        Column.create(c)
            .child(
                Row.create(c)
                    .child(
                        Image.create(c)
                            .marginRes(YogaEdge.LEFT, R.dimen.space_normal)
                            .alignSelf(YogaAlign.CENTER)
                            .clickHandler(Header.onClick(c))
                            .drawableRes(R.mipmap.ic_email))
                    .child(
                        TextInput.create(c)
                            .hint(c.getString(R.string.email_address))
                            .paddingRes(YogaEdge.LEFT, R.dimen.space_normal)
                            .textSizeRes(R.dimen.text_title)
                            .flex(1f)
                    ))
            .child(
                Row.create(c)
                    .heightDip(1f)
            )
            .build()

}