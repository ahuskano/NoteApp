package co.asynclabs.ahuskano.noteapp;

import android.graphics.drawable.Drawable;
import android.support.test.annotation.UiThreadTest;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.MediumTest;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ProgressBar;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;


@MediumTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    LoginActivity activity;

    @Rule
    public IntentsTestRule<LoginActivity> mActivityRule
            = new IntentsTestRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        activity = mActivityRule.getActivity();
    }


    @Test
    public void setup() {
        onView(withId(R.id.etEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.etPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()));
    }


    @Test
    public void getLayout() {

    }

    @Test
    public void onLoginSuccess() {
    }

    @Test
    public void onLoginFail() {

        activity.runOnUiThread(new Runnable() {
            public void run() {
                activity.onLoginFail(activity.getString(R.string.login_failed_msg));
            }
        });
        onView(withText(activity.getString(R.string.login_failed_msg))).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }



    @Test
    public void onValidationSuccess() {
    }

    @Test
    public void showProgress() {

        activity.runOnUiThread(new Runnable() {
            public void run() {
                activity.showProgress();
            }
        });

        Drawable notAnimatedDrawable = ContextCompat.getDrawable(activity, R.drawable.ic_launcher_background);
        ((ProgressBar) activity.findViewById(R.id.progressBar)).setIndeterminateDrawable(notAnimatedDrawable);

        onView(withId(R.id.progressBar)).check(matches(isDisplayed()));

    }

    @Test
    public void hideProgress() {

        activity.runOnUiThread(new Runnable() {
            public void run() {
                activity.hideProgress();
            }
        });

        Drawable notAnimatedDrawable = ContextCompat.getDrawable(activity, R.drawable.ic_launcher_background);
        ((ProgressBar) activity.findViewById(R.id.progressBar)).setIndeterminateDrawable(notAnimatedDrawable);

        onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())));
    }

    @Test
    public void logIn() {
        activity.logIn();
        intended(toPackage(LoginActivity.class.getPackage().getName()));
    }


}