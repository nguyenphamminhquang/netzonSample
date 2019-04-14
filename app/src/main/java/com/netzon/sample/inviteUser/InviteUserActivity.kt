package com.netzon.sample.inviteUser

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.facebook.litho.Column
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R
import com.netzon.sample.inviteUser.components.*

class InviteUserActivity : Activity() {
    var emailAddress = ""
    var listSelectedDay = listOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val c = ComponentContext(this)
        val component = Column.create(c)
            .child(
                Column.create(c)
                    .backgroundColor(Color.WHITE)
                    .paddingRes(YogaEdge.HORIZONTAL, R.dimen.space_normal)
                    .paddingRes(YogaEdge.TOP, R.dimen.space_normal)
                    .child(
                        Header.create(c)
                            .title(getString(R.string.invite_user))
                    )
                    .child(EmailAddress.create(c)
                        .textChangedEvent {
                            emailAddress = it
                        })
                    .child(UserType.create(c))
                    .child(
                        Title.create(c)
                            .title(getString(R.string.access_time))
                    )
                    .child(
                        AccessTime.create(c)
                    )
                    .child(
                        Title.create(c)
                            .title(getString(R.string.access_days))
                    )
                    .child(AccessDate.create(c)
                        .selectedDayListener { it ->
                            listSelectedDay = it
                        })
            )
            .child(BtnInvite.create(c)
                .btnClickListener(btnInviteClick))
            .build()
        setContentView(LithoView.create(c, component))
    }

    val btnInviteClick = {
        Toast.makeText(this, "Invite Email Address : " + emailAddress + " \n in " + listSelectedDay.toString(), Toast.LENGTH_SHORT).show()
    }

}

