package com.example.task3.presentation.decorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecycleViewDecorator(
    var spaceLeft: Int,
    var spaceUp: Int,
    var spaceRight: Int,
    var spaceDown: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(spaceLeft, spaceUp, spaceRight, spaceDown)
    }
}