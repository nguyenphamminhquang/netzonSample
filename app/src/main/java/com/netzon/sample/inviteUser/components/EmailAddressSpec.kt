package com.netzon.sample.inviteUser.components

import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.annotations.*
import com.facebook.litho.widget.EditText
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.TextChangedEvent
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
            .marginRes(YogaEdge.TOP, R.dimen.space_large)
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
                            .textChangedEventHandler(EmailAddress.textChanged(c))
                            .flex(1f)
                    ))
            .child(
                Row.create(c)
                    .heightDip(1f)
            )
            .build()

    @OnEvent(TextChangedEvent::class)
    fun textChanged(c : ComponentContext, @FromEvent text: String, @Prop textChangedEvent: (String) -> Unit){
        textChangedEvent.invoke(text)
    }
}