package com.nicktra.moviesquare.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.utils.DataDummy
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    /*
    * 1. loadMovies()
    * Memastikan rv_movie dalam keadaan tampil
    * Gulir rv_movie ke posisi data terakhir
    *
    * 2. loadDetailMovies()
    * Memberi tindakan klik pada data pertama di rv_movie
    * Memastikan TextView untuk title tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk release tampil sesuai dengan yang diharapkan
    *
    * 3. loadShows()
    * Klik TabLayout dengan teks TV SHOW
    * Memastikan rv_show dalam keadaan tampil
    * Gulir rv_show ke posisi data terakhir
    *
    * 4. loadDetailShows()
    * Klik TabLayout dengan teks TV SHOW
    * Memberi tindakan klik pada data pertama di rv_show
    * Memastikan TextView untuk title tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk release tampil sesuai dengan yang diharapkan
    * */

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyShow = DataDummy.generateDummyShows()

    @Before
    fun setup(){
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies() {
        Thread.sleep(2000)
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        Thread.sleep(2000)
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Thread.sleep(2000)
        onView(withId(R.id.tv_data_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_data_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_release)).check(matches(withText(dummyMovie[0].releaseDate)))
    }

    @Test
    fun loadShows() {
        Thread.sleep(2000)
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size))
    }

    @Test
    fun loadDetailShow() {
        onView(withText("TV SHOW")).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Thread.sleep(2000)
        onView(withId(R.id.tv_data_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_title)).check(matches(withText(dummyShow[0].name)))
        onView(withId(R.id.tv_data_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_release)).check(matches(withText(dummyShow[0].firstAirDate)))
    }

    @Test
    fun loadAbout() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("About")).perform(click())
        onView(withId(R.id.rellay1)).check(matches(isDisplayed()))
    }
}