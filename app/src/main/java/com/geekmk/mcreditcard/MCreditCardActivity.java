package com.geekmk.mcreditcard;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;

public class MCreditCardActivity extends AppCompatActivity implements MCardInfoSetInf{

    private MCard mCard;

    private AnimatorSet inSet;
    private AnimatorSet outSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcredit_card);
        initViews();
        loadAnimations();


    }

    //initialize all views needed.
    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mCard = (MCard) findViewById(R.id.mcard);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_credit_card_info);
        MCardInfoAdapter mCardInfoAdapter = new MCardInfoAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mCardInfoAdapter);
        viewPager.setOffscreenPageLimit(MCardConstants.NUMBER_OF_FIELDS);
        int pagerPadding = (int) getResources().getDimension(R.dimen.pager_padding);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        viewPager.setClipToPadding(false);
        viewPager.setPadding(width / 4, 0, width / 4, 0);
        viewPager.setPageMargin(width / 14);

//        viewPager.setPadding(pagerPadding, 0, pagerPadding, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mcredit_card, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        //making action menu icon color to primary color
        MenuItem item = menu.findItem(R.id.action_refresh);
        Drawable icon = ContextCompat.getDrawable(this,R.drawable.ic_refresh_black_24dp);
        icon.setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        item.setIcon(icon);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case R.id.action_refresh:
                performClearAnimation();
                return false;
            case android.R.id.home:
                finish();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void performClearAnimation() {
        outSet.setTarget(mCard);
        outSet.start();
        inSet.setTarget(mCard);
        inSet.start();
        mCard.reset();
    }

    private void loadAnimations() {
        inSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_flip_in);
        outSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.card_flip_out);
    }

    @Override
    public void onCvvProvided(String cvv) {
        mCard.setCvv(cvv);
    }

    @Override
    public void onDateProvided(String date) {
        mCard.setDate(date);
    }

    @Override
    public void onNameProvided(String name) {
        mCard.setName(name);
    }

    @Override
    public void onCardNumberProvided(String cardNo) {
        mCard.setCardNumber(cardNo);
    }
}
