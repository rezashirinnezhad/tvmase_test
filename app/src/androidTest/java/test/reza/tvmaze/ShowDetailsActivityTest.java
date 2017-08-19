package test.reza.tvmaze;

import android.app.ListActivity;
import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.reza.tvmaze.activity.ShowDetailsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
/**
 * Created by Reza on 8/19/2017.
 */

@RunWith(AndroidJUnit4.class)
public class ShowDetailsActivityTest {


    @Rule
    public ActivityTestRule<ShowDetailsActivity> showDetails =
            new ActivityTestRule<>(ShowDetailsActivity.class);
    @Test
    public void isBackButtonOnClickPerfom(){
        Espresso.onView(withId(R.id.thumbnail_poster)).check(matches(isDisplayed()));
    }
}
