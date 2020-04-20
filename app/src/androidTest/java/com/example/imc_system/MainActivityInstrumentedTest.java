package com.example.imc_system;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void that_clicking_calculation_button_IMC_is_calculated() throws Exception {
        onView(withId(R.id.inputHeight)).perform(typeText("1.76")).perform(closeSoftKeyboard());
        onView(withId(R.id.inputWeight)).perform(typeText("65")).perform(closeSoftKeyboard());
        onView(withId(R.id.btnCalc)).perform(click());
        onView(withText("21.0")).check(matches(isDisplayed()));
    }

    public void that_low_IMC_results_are_correctly_displayed() throws Exception {
        onView(withId(R.id.inputHeight)).perform(typeText("1.76")).perform(closeSoftKeyboard());
        onView(withId(R.id.inputWeight)).perform(typeText("40")).perform(closeSoftKeyboard());
        onView(withId(R.id.btnCalc)).perform(click());
        onView(withText("Você está MAGRELO!")).check(matches(isDisplayed()));
    }

    public void that_average_IMC_results_are_correctly_displayed() throws Exception {
        onView(withId(R.id.inputHeight)).perform(typeText("1.76")).perform(closeSoftKeyboard());
        onView(withId(R.id.inputWeight)).perform(typeText("65")).perform(closeSoftKeyboard());
        onView(withId(R.id.btnCalc)).perform(click());
        onView(withText("Você está OK!")).check(matches(isDisplayed()));
    }

    public void that_high_IMC_results_are_correctly_displayed() throws Exception {
        onView(withId(R.id.inputHeight)).perform(typeText("1.76")).perform(closeSoftKeyboard());
        onView(withId(R.id.inputWeight)).perform(typeText("90")).perform(closeSoftKeyboard());
        onView(withId(R.id.btnCalc)).perform(click());
        onView(withText("Você está GORDO!")).check(matches(isDisplayed()));
    }
}
