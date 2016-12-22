package com.events.hub.swahilipot.swahilipothub;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class MemberDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_details);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        //Init transfered data
        Bundle extras = getIntent().getExtras();

        //Display only if not null
        if(extras != null)

        collapsingToolbar.setTitle(extras.getString("EXTRA_NAME"));
        loadBackdrop();

        //Bio section
        TextView bio = (TextView) findViewById(R.id.bio);
        bio.setText(extras.getString("EXTRA_BIO"));

        //Category section
        TextView category = (TextView) findViewById(R.id.category);
        category.setText(extras.getString("EXTRA_CAT"));

        //Registration Section
        TextView reg = (TextView) findViewById(R.id.reg);
        reg.setText(extras.getString("EXTRA_REG"));

    }

    private void loadBackdrop() {
        Bundle extras = getIntent().getExtras();
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(extras.getString("EXTRA_AVATAR")).centerCrop().into(imageView);
    }

}
