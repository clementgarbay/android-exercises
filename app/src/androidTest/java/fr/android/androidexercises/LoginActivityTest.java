package fr.android.androidexercises;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

// https://developer.android.com/training/testing/espresso/cheat-sheet.html

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void shouldTryLoginAndSuccess() throws Exception {
        onView(withId(R.id.usernameEdit)).perform(typeText("test@email.com"));
        onView(withId(R.id.passwordEdit)).perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.loggedText)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldTryLoginAndFailed() throws Exception {
        onView(withId(R.id.usernameEdit)).perform(typeText("test@email.com"));
        onView(withId(R.id.passwordEdit)).perform(typeText("p"), closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());
        onView(withId(R.id.loggedText)).check(matches(not(isDisplayed())));
    }
}