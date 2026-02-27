package com.example.androiduitesting;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;


import org.junit.Test;


public class ShowActivityTest {

    @Test
    public void testIntent(){

        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());
        //Clicking on listview to call the new intent
        onView(withId(R.id.city_list)).perform(click());
        //Checking if the Back button has loaded
        onView(withId(R.id.button_back)).check(matches(isDisplayed()));
    }

    @Test
    public void testConsistency(){

        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withId(R.id.city_list)).perform(click());
        //Checking if the view has Changed
        onView(withId(R.id.button_back)).check(matches(isDisplayed()));
        //Checking if displayed text is consistent with user input
        onView(withText("Edmonton")).check(matches(isDisplayed()));
    }

    @Test
    public void testReturn(){
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withId(R.id.city_list)).perform(click());
        //Checking if the view has Changed
        onView(withId(R.id.button_back)).check(matches(isDisplayed()));
        //Clicking on Back button
        onView(withId(R.id.button_back)).perform(click());
        //Checking if the view has returned to main activity
        onView(withId(R.id.button_add)).check(matches(isDisplayed()));
    }

}
