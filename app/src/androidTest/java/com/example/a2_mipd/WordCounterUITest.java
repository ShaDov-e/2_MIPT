package com.example.a2_mipd;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4ClassRunner.class)
public class WordCounterUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWordCountButton() {
        // Type a sentence in the input field
        Espresso.onView(ViewMatchers.withId(R.id.editText))
                .perform(ViewActions.typeText("This is a test sentence"), ViewActions.closeSoftKeyboard());


        Espresso.onView(ViewMatchers.withId(R.id.spinner)).perform(ViewActions.click());
        Espresso.onData(allOf(is(instanceOf(String.class)), is("Words")))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.CountText))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.resultText))
                .check(ViewAssertions.matches(ViewMatchers.withText(containsString("Word count"))));
    }
}
