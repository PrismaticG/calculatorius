package com.example.calculatorius;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;

public class CalculatorUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAdditionUI() {
        // Simulate button clicks for "3 + 7 ="
        Espresso.onView(ViewMatchers.withId(R.id.btn3)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.btnAdd)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.btn7)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.btnEquals)).perform(ViewActions.click());

        // Verify result "10.0"
        Espresso.onView(ViewMatchers.withId(R.id.txtDisplay))
                .check(ViewAssertions.matches(ViewMatchers.withText("10.0")));
    }

    @Test
    public void testClearUI() {
        // Simulate input and clear action
        Espresso.onView(ViewMatchers.withId(R.id.btn5)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.btnClear)).perform(ViewActions.click());

        // Verify cleared result "0"
        Espresso.onView(ViewMatchers.withId(R.id.txtDisplay))
                .check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }
}
