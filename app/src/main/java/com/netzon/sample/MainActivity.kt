package com.netzon.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import androidx.appcompat.app.AppCompatActivity
import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Card
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge
import com.facebook.yoga.YogaJustify
import com.netzon.sample.inviteUser.InviteUserActivity


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = ComponentContext(this)
        val component = CustomText.create(context)
            .title(getString(R.string.invite_user))
            .build()
        setContentView(LithoView.create(context, component))
    }
}

@LayoutSpec
object CustomTextSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @Prop title: String
    ): Component =
        Column.create(c)
            .backgroundColor(c.getColor(android.R.color.white))
            .justifyContent(YogaJustify.CENTER)
            .child(
                Card.create(c)
                    .alignSelf(YogaAlign.CENTER)
                    .cardBackgroundColor(c.getColor(android.R.color.black))
                    .cornerRadiusDip(10f)
                    .widthPercent(50f)
                    .content(
                        Text.create(c)
                            .paddingDip(YogaEdge.VERTICAL, 8f)
                            .alignSelf(YogaAlign.CENTER)
                            .textColor(c.getColor(android.R.color.white))
                            .shadowRadiusDip(20f)
                            .text(title)
                            .textSizeDip(25F)
                            .textAlignment(Layout.Alignment.ALIGN_CENTER)
                            .touchExpansionDip(YogaEdge.ALL, 10f)
                            .clickHandler(CustomText.onClick(c))
                            .build()
                    ).build()
            ).build()

    @OnEvent(ClickEvent::class)
    fun onClick(c: ComponentContext) {
        val intent = Intent(c.androidContext, InviteUserActivity::class.java)
        c.androidContext.startActivity(intent)
    }
}
