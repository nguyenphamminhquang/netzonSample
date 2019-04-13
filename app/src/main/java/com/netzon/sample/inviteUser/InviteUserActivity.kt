package com.netzon.sample.inviteUser

import android.app.Activity
import android.os.Bundle
import com.facebook.litho.Column
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R
import com.netzon.sample.inviteUser.components.EmailAddress
import com.netzon.sample.inviteUser.components.Header
import com.netzon.sample.inviteUser.components.UserType

class InviteUserActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val c = ComponentContext(this)
        val component = Column.create(c)
            .paddingDip(YogaEdge.HORIZONTAL, 20f)
            .paddingDip(YogaEdge.TOP, 20f)
            .child(Header.create(c)
                .title(getString(R.string.invite_user)))
            .child(EmailAddress.create(c))
            .child(UserType.create(c))
            .build()
        setContentView(LithoView.create(c, component))
    }
}

