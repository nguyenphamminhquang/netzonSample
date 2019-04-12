package com.netzon.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.litho.ClickEvent
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = ComponentContext(this)
        val component = CustomText.create(context)
            .title("Invite User")
            .build()
        setContentView(LithoView.create(context, component))
    }
}

@LayoutSpec
object CustomText {

    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext,
                       @Prop title: String): Component =
        Text.create(c)
            .alignSelf(YogaAlign.CENTER)
            .text(title)
            .textSizeDip(25F)
            .clickHandler(onClick(c))
            .touchExpansionDip(YogaEdge.ALL, 10f)
            .build()

    @OnEvent(ClickEvent::class)
    fun onClick(c: ComponentContext) {

    }
}
