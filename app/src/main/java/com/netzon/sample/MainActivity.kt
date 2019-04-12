package com.netzon.sample

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import androidx.appcompat.app.AppCompatActivity
import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.EmptyComponent
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge
import com.facebook.yoga.YogaJustify
import com.netzon.sample.inviteUser.InviteUserActivity


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
object CustomTextSpec {

    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext,
                       @Prop title: String): Component =
        Column.create(c)
            .alignSelf(YogaAlign.CENTER)
            .justifyContent(YogaJustify.CENTER)
            .child(
                Text.create(c)
                    .text(title)
                    .textSizeDip(25F)
                    .textAlignment(Layout.Alignment.ALIGN_CENTER)
                    .touchExpansionDip(YogaEdge.ALL, 10f)
                    .clickHandler(CustomText.onClick(c))
                    .build()
            ).build()


    @OnEvent(ClickEvent::class)
    fun onClick(c: ComponentContext) {
        val intent = Intent(c.androidContext, InviteUserActivity::class.java)
        c.androidContext.startActivity(intent)
    }
}
