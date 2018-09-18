package co.asynclabs.ahuskano.noteapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
public class SignUpTest {

    @Rule
    public IntentsTestRule<SignUpActivity> mActivityRule
            = new IntentsTestRule<>(SignUpActivity.class);


    @Test
    public void registration() {

        onView(withId(R.id.etName)).perform(typeText("Alen"));
        onView(withId(R.id.etEmail)).perform(typeText("alen@email.com"));
        onView(withId(R.id.etPassword)).perform(typeText("password"));

        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etPasswordRepeat)).perform(typeText("password"));

        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnRegistration)).perform(click());

        onView(withId(R.id.etEmail)).perform(typeText("alen@email.com"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etPassword)).perform(typeText("password"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnLogin)).perform(click());

        onView(withId(R.id.rvNotes)).check(matches(isDisplayed()));

    }

}