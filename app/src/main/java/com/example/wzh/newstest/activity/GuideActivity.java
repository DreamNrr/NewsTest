package com.example.wzh.newstest.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.wzh.newstest.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class GuideActivity extends AppCompatActivity {
    @InjectView(R.id.vp)
    ViewPager vp;
    @InjectView(R.id.btn_start_main)
    Button btnStartMain;
    @InjectView(R.id.activity_guide)
    RelativeLayout activityGuide;

    private ArrayList<ImageView> imageViews;
    private int[] images = {R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.inject(this);
        initData();

    }

    private void initData() {
        imageViews = new ArrayList<>();
        for(int i = 0; i < images.length;i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(images[i]);
            imageViews.add(imageView);
        }
        vp.setAdapter(new MyPagerAdapter());
        vp.addOnPageChangeListener(new MyOnPageChangeListener());

    }
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        //选中某个页面是回调
        @Override
        public void onPageSelected(int position) {
            if (position == imageViews.size() - 1) {
                //最后一个页面就显示
                btnStartMain.setVisibility(View.VISIBLE);
            } else {
                //其他页面隐藏
                btnStartMain.setVisibility(View.GONE);
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }






    class MyPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return imageViews.size();
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            container.addView(imageView);
            return imageView;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @OnClick(R.id.btn_start_main)
    public void onViewClicked() {
    }
}
