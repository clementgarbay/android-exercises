package fr.android.androidexercises;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.assertj.android.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class JUnitLoginActivityTest {

    private LoginActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void should_set_logged_state() throws Exception {
        activity.logged();
        assertThat(activity.loginLayout).isGone();
        assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void should_not_set_logged_state() throws Exception {
        activity.notLogged();
        assertThat(activity.loginLayout).isNotGone();
        assertThat(activity.loggedText).isNotVisible();
    }
}