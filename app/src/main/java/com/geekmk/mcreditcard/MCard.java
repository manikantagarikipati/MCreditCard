package com.geekmk.mcreditcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Mani on 23/02/17.
 * Custom card that contains its design of a conventional credit/debit card
 */

public class MCard extends RelativeLayout{

    public MCard(Context context) {
        super(context);
        initViews(context);
    }

    public MCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public MCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    private void initViews(Context context) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_mcard, this);

    }
}
