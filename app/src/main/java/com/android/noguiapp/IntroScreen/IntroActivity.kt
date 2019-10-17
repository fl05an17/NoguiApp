package com.android.noguiapp.IntroScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.android.noguiapp.R
import com.google.android.material.tabs.TabLayout

class IntroActivity : AppCompatActivity() {

    private var screenPager: ViewPager? = null
    protected lateinit var introViewPagerAdapter: IntroViewPagerAdapter
    protected lateinit var tabIndicator: TabLayout
    private lateinit var title1: String
    private lateinit var title2: String
    private lateinit var title3: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //ini views

        tabIndicator = findViewById(R.id.tab_indicator)

        title1 = (resources.getString(R.string.title_intro_1))
        title2 = (resources.getString(R.string.title_intro_2))
        title3 = (resources.getString(R.string.title_intro_3))

        //fill list screen
        val mList = ArrayList<ScreenItem>()
        mList.add(
            ScreenItem(
                "$title1",
                R.drawable.img_intro_1
            )
        )
        mList.add(
            ScreenItem(
                "$title2",
                R.drawable.img_intro_2
            )
        )
        mList.add(
            ScreenItem(
                "$title3",
                R.drawable.img_intro_3
            )
        )
        //Setup viewPager
        screenPager = findViewById(R.id.screen_viewpager)
        introViewPagerAdapter = IntroViewPagerAdapter(this, mList)
        screenPager!!.adapter = introViewPagerAdapter

        //setup tablayout with viewpager

        tabIndicator.setupWithViewPager(screenPager)
    }
}
