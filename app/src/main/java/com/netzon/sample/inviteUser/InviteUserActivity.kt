package com.netzon.sample.inviteUser

import android.app.Activity
import android.os.Bundle
import android.text.Layout
import com.facebook.litho.Column
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R
import com.netzon.sample.inviteUser.components.*

class InviteUserActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val c = ComponentContext(this)
        val component = Column.create(c)
            .child(
                Column.create(c)
                    .paddingDip(YogaEdge.HORIZONTAL, 20f)
                    .paddingDip(YogaEdge.TOP, 20f)
                    .child(
                        Header.create(c)
                            .title(getString(R.string.invite_user))
                    )
                    .child(EmailAddress.create(c))
                    .child(UserType.create(c))
                    .child(
                        Title.create(c)
                            .title(getString(R.string.access_time))
                    )
                    .child(
                        Title.create(c)
                            .title(getString(R.string.access_days))
                    )
                    .child(AccessDate.create(c))
            )
            .child(BtnInvite.create(c))
            .build()
        setContentView(LithoView.create(c, component))
    }
}

