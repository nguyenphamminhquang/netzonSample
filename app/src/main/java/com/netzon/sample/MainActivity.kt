package com.netzon.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = ComponentContext(this)
        val component = Text.create(context)
            .text("Hello World")
            .textSizeDip(25F)
            .build()
        setContentView(LithoView.create(context, component))
    }
}
