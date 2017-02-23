package com.geekmk.mcreditcard;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by Mani on 23/02/17.
 * Custom card that contains its design of a conventional credit/debit card
 */

public class MCard extends CardView{

    public MCard(Context context) {
        super(context);
        initViews();
    }

    public MCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public MCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {

    }
}
