package com.easyway.review.module.recycleview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.widget.ImageView;
import android.widget.TextView;

import com.easyway.review.R;
import com.easyway.review.base.BaseActivity;
import com.hanks.frame.utils.Ulog;
import com.hanks.frame.utils.glide.UtilGlide;

public class MeiziDetialActivity extends BaseActivity {

    public static final String IMAGE_URL = "image_url";
    public static final String TITLE = "title";
    public static final String NAME = "name";
    public static final String FAVORITES = "favorites";
    public static final String COMMENTS = "comments";

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meizi_detial);

        actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        getMeiziIntent();
    }

    @Override
    protected void setOnTranslucent() {
    }

    private void getMeiziIntent() {
        String imageUrl = getIntent().getStringExtra(IMAGE_URL);
        String title = getIntent().getStringExtra(TITLE);
        String name = getIntent().getStringExtra(NAME);
        int favorites = getIntent().getIntExtra(FAVORITES, 0);
        int comments = getIntent().getIntExtra(COMMENTS, 0);
        Ulog.i("getIntent",imageUrl, title, name, favorites, comments);
        setMeizi(imageUrl, title, name, favorites, comments);
    }

    private void setMeizi(String imageUrl, String title, String name, int favorites, int comments) {
        ImageView iv_image = findViewById(R.id.meizi_detial_image);
        TextView tv_title = findViewById(R.id.meizi_detial_title);
        TextView tv_name = findViewById(R.id.meizi_detial_name);
        TextView tv_favorites = findViewById(R.id.meizi_detial_favorites);
        TextView tv_comments = findViewById(R.id.meizi_detial_comments);
        UtilGlide.loadImg(this, imageUrl, iv_image);

        tv_title.setText(title);
        tv_name.setText(name);
        tv_favorites.setText(String.valueOf(favorites));
        tv_comments.setText(String.valueOf(comments));
        actionBar.setTitle(title);
    }


}