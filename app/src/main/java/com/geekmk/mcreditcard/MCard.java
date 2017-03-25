package com.geekmk.mcreditcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.attr.name;

/**
 * Created by Mani on 23/02/17.
 * Custom card that contains its design of a conventional credit/debit card
 */

public class MCard extends RelativeLayout{

    private TextView tvCardNo;

    private TextView tvDate;

    private TextView tvName;

    private TextView tvCvv;


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

        tvCardNo = (TextView) view.findViewById(R.id.tv_card_number);

        tvDate = (TextView) view.findViewById(R.id.tv_month_year);

        tvName = (TextView) view.findViewById(R.id.tv_card_holder_name);

        tvCvv = (TextView) view.findViewById(R.id.tv_card_cvv);

    }


    public void setCardNumber(String cardNumber) {
        tvCardNo.setText(cardNumber);
    }

    public void setDate(String date) {
        tvDate.setText(date);
    }

    public void setName(String name) {
        tvName.setText(name);
    }

    public void setCvv(String cvv) {
        tvCvv.setText(cvv);
    }

    public void reset(){
        tvCardNo.setText(getResources().getString(R.string.default_card_number));
        tvDate.setText(getResources().getString(R.string.default_card_month_year));
        tvName.setText(getResources().getString(R.string.default_card_holder));
        tvCvv.setText(getResources().getString(R.string.default_card_cvv));
    }

}
