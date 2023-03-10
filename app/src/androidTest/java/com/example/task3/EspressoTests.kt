package com.example.task3

import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class EspressoTests {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun checkCollectionWith1000Size() {
        onView(withId(R.id.collectionSize)).check(matches(isDisplayed()))
        onView(withId(R.id.collectionSize)).perform(typeText("10000"),closeSoftKeyboard())
        onView(withId(R.id.calculate)).check(matches(isDisplayed()))
        onView(withId(R.id.calculate)).perform(click())
        onView(withId(R.id.elementAmount)).check(matches(isDisplayed()))
        onView(withId(R.id.elementAmount)).perform(typeText("1000"),closeSoftKeyboard())
        onView(withId(R.id.startBtnColl)).check(matches(isDisplayed()))
        onView(withId(R.id.startBtnColl)).perform(click())
        onView(withId(R.id.recycleCollections)).check(matches(isDisplayed()))
        onView(withId(R.id.recycleCollections)).check(matches(hasChildCount(15)))
    }

    @Test
    fun checkMapWith1000Size() {
        onView(withId(R.id.ViewPager2)).check(matches(isDisplayed()))
        onView(withId(R.id.ViewPager2)).perform(swipeLeft())
        SystemClock.sleep(1000)
        onView(withId(R.id.collectionSizeMap)).check(matches(isDisplayed()))
        onView(withId(R.id.collectionSizeMap)).perform(typeText("111"), closeSoftKeyboard())
        onView(withId(R.id.calculateMap)).check(matches(isDisplayed()))
        onView(withId(R.id.calculateMap)).perform(click())
        onView(withId(R.id.elementAmountMaps)).check(matches(isDisplayed()))
        onView(withId(R.id.elementAmountMaps)).perform(typeText("111"), closeSoftKeyboard())
        onView(withId(R.id.startBtnMap)).check(matches(isDisplayed()))
        onView(withId(R.id.startBtnMap)).perform(click())
        onView(withId(R.id.recycleMaps)).check(matches(isDisplayed()))
        onView(withId(R.id.recycleMaps)).check(matches(hasChildCount(6)))
    }
    @Test
    fun checkBothFragmentsWith1000Size() {
        onView(withId(R.id.collectionSize)).check(matches(isDisplayed()))
        onView(withId(R.id.collectionSize)).perform(typeText("10000"),closeSoftKeyboard())
        onView(withId(R.id.calculate)).check(matches(isDisplayed()))
        onView(withId(R.id.calculate)).perform(click())
        onView(withId(R.id.elementAmount)).check(matches(isDisplayed()))
        onView(withId(R.id.elementAmount)).perform(typeText("1000"),closeSoftKeyboard())
        onView(withId(R.id.startBtnColl)).check(matches(isDisplayed()))
        onView(withId(R.id.startBtnColl)).perform(click())
        onView(withId(R.id.recycleCollections)).check(matches(isDisplayed()))
        onView(withId(R.id.recycleCollections)).check(matches(hasChildCount(15)))
        onView(withId(R.id.ViewPager2)).check(matches(isDisplayed()))
        onView(withId(R.id.ViewPager2)).perform(swipeLeft())
        SystemClock.sleep(1000)
        onView(withId(R.id.collectionSizeMap)).check(matches(isDisplayed()))
        onView(withId(R.id.collectionSizeMap)).perform(typeText("111"), closeSoftKeyboard())
        onView(withId(R.id.calculateMap)).check(matches(isDisplayed()))
        onView(withId(R.id.calculateMap)).perform(click())
        onView(withId(R.id.elementAmountMaps)).check(matches(isDisplayed()))
        onView(withId(R.id.elementAmountMaps)).perform(typeText("111"), closeSoftKeyboard())
        onView(withId(R.id.startBtnMap)).check(matches(isDisplayed()))
        onView(withId(R.id.startBtnMap)).perform(click())
        onView(withId(R.id.recycleMaps)).check(matches(isDisplayed()))
        onView(withId(R.id.recycleMaps)).check(matches(hasChildCount(6)))
    }
}