package com.netzon.sample.inviteUser.components

import com.facebook.litho.ClickEvent
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.StateValue
import com.facebook.litho.annotations.*
import com.facebook.litho.widget.Image
import com.netzon.sample.R

@LayoutSpec
object CheckBoxLithoSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @State isChecked: Boolean
    ): Component = Image.create(c)
        .drawableRes(if (isChecked) R.mipmap.ic_checked else R.mipmap.ic_unchecked)
        .clickHandler(CheckBoxLitho.onClick(c))
        .build()

    @OnEvent(ClickEvent::class)
    fun onClick(c : ComponentContext) {
        CheckBoxLitho.onUpdateState(c)
    }

    @OnCreateInitialState
    fun onCreateInitialState(c: ComponentContext, isChecked:StateValue<Boolean>, @Prop initChecked: Boolean?){
        isChecked.set(initChecked)
    }

    @OnUpdateState
    fun onUpdateState(isChecked:StateValue<Boolean>){
        isChecked.set(isChecked.get()?.not())
    }
}