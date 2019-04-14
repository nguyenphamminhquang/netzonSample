package com.netzon.sample.inviteUser.components

import android.text.Layout
import com.facebook.litho.*
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge
import com.netzon.sample.R
import com.facebook.litho.sections.common.SingleComponentSection
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.Column
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.yoga.YogaAlign


@LayoutSpec
object AccessTimetemSpec {

    val MIN_MINUTE = 0
    val MAX_MINUTE = 2
    val MIN_SECOND = 0
    val MAX_SECOND = 60

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @Prop title: String
    ): Component {
        return Column.create(c)
            .backgroundColor(c.getColor(R.color.bg_time))
            .flex(1f)
            .child(
                Title.create(c)
                    .alignSelf(YogaAlign.CENTER)
                    .title(title)
                    .marginRes(YogaEdge.TOP, R.dimen.space_normal)
            )
            .child(
                Row.create(c)
                    .marginRes(YogaEdge.TOP, R.dimen.space_normal)
                    .child(
                        Text.create(c)
                            .flex(1f)
                            .textAlignment(Layout.Alignment.ALIGN_CENTER)
                            .text(c.getString(R.string.hour_second))
                            .textSizeRes(R.dimen.text_small)
                    )
                    .child(
                        Text.create(c)
                            .flex(1f)
                            .textAlignment(Layout.Alignment.ALIGN_CENTER)
                            .text(c.getString(R.string.minute_second))
                            .textSizeRes(R.dimen.text_small)
                    )
            )
            .child(
                Row.create(c)
                    .marginRes(YogaEdge.TOP,R.dimen.space_normal)
                    .heightDip(100f)
                    .child(
                        RecyclerCollectionComponent.create(c)
                            .disablePTR(true)
                            .flex(1f)
                            .section(
                                TimeSection.create(SectionContext(c))
                                    .min(MIN_MINUTE)
                                    .max(MAX_MINUTE)
                            ).build()
                    )
                    .child(
                        Text.create(c)
                            .paddingRes(YogaEdge.ALL, R.dimen.space_small)
                            .alignSelf(YogaAlign.CENTER)
                            .text(":")
                            .textSizeRes(R.dimen.text_title)
                    )
                    .child(
                        RecyclerCollectionComponent.create(c)
                            .disablePTR(true)
                            .flex(1f)
                            .section(
                                TimeSection.create(SectionContext(c))
                                    .min(MIN_SECOND)
                                    .max(MAX_SECOND)
                            ).build()
                    )

            ).build()
    }

    @OnEvent(ClickEvent::class)
    fun onClickedText(c: ComponentContext) {
    }

}

@GroupSectionSpec
object TimeSectionSpec {

    @OnCreateChildren
    fun onCreateChildren(
        c: SectionContext,
        @Prop min: Int,
        @Prop max: Int
    ): Children {
        val builder = Children.create()
        for (i in min..max) {
            builder.child(
                SingleComponentSection.create(c)
                    .component(TimeItem.create(c)
                        .time(i.toString()))
            )
        }
        return builder.build()
    }
}

@LayoutSpec
object TimeItemSpec {

    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @Prop time: String
    ): Component {
        return Column.create(c)
            .child(
                Text.create(c)
                    .textAlignment(Layout.Alignment.ALIGN_CENTER)
                    .text(time)
                    .textSizeRes(R.dimen.text_normal)
            ).build()
    }
}