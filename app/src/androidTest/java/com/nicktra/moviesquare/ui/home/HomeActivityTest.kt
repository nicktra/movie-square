package com.nicktra.moviesquare.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.nicktra.moviesquare.R
import com.nicktra.moviesquare.ui.MainActivity
import com.nicktra.moviesquare.utils.DataDummy
import com.nicktra.moviesquare.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    /*
    * 1. loadMovies()
    * Memastikan rv_movie dalam keadaan tampil
    * Gulir rv_movie ke posisi data terakhir
    *
    * 2. loadDetailMovie()
    * Memberi tindakan klik pada data pertama di rv_movie
    * Memastikan TextView untuk title tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk release tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk rating tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk overview tampil sesuai dengan yang diharapkan
    *
    * 3. loadShows()
    * Klik TabLayout dengan teks TV SHOW
    * Memastikan rv_show dalam keadaan tampil
    * Gulir rv_show ke posisi data terakhir
    *
    * 4. loadDetailShow()
    * Klik TabLayout dengan teks TV SHOW
    * Memberi tindakan klik pada data pertama di rv_show
    * Memastikan TextView untuk title tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk release tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk rating tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk overview tampil sesuai dengan yang diharapkan
    *
    * 5. loadFavoriteMovie()
    * Memberi tindakan klik pada data pertama di rv_movie
    * Memberi tindakan klik pada tombol favorite di action_bookmark
    * Memberi tindakan klik tombol back
    * Klik Bottom Navigation dengan id tombol navigation_favorite
    * Memastikan rv_favorite_movie dalam keadaan tampil
    * Memberi tindakan klik pada data pertama di rv_favorite_movie
    * Memastikan TextView untuk title tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk release tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk rating tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk overview tampil sesuai dengan yang diharapkan
    * Memberi tindakan klik pada tombol favorite di action_bookmark
    * Memberi tindakan klik tombol back
    *
    * 5. loadFavoriteShow()
    * Klik TabLayout dengan teks TV SHOW
    * Memberi tindakan klik pada data pertama di rv_show
    * Memberi tindakan klik pada tombol favorite di action_bookmark
    * Memberi tindakan klik tombol back
    * Klik Bottom Navigation dengan id tombol navigation_favorite
    * Klik TabLayout dengan teks TV SHOW
    * Memastikan rv_favorite_show dalam keadaan tampil
    * Memberi tindakan klik pada data pertama di rv_favorite_show
    * Memastikan TextView untuk title tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk release tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk rating tampil sesuai dengan yang diharapkan
    * Memastikan TextView untuk overview tampil sesuai dengan yang diharapkan
    * Memberi tindakan klik pada tombol favorite di action_bookmark
    * Memberi tindakan klik tombol back
    *
    * 7. loadAbout()
    * Klik Bottom Navigation dengan id tombol navigation_about
    * Memastikan tampilan About dengan id rellay1 dalam keadaan tampil
    * */

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyShow = DataDummy.generateDummyShows()

    @Before
    fun setup(){
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_data_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_data_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_release)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.tv_data_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_rating)).check(matches(withText(dummyMovie[0].voteAverage.toString())))
        onView(withId(R.id.tv_data_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_overview)).check(matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadShows() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size))
    }

    @Test
    fun loadDetailShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_data_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_title)).check(matches(withText(dummyShow[0].name)))
        onView(withId(R.id.tv_data_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_release)).check(matches(withText(dummyShow[0].firstAirDate)))
        onView(withId(R.id.tv_data_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_rating)).check(matches(withText(dummyShow[0].voteAverage.toString())))
        onView(withId(R.id.tv_data_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_overview)).check(matches(withText(dummyShow[0].overview)))
    }

    @Test
    fun loadFavoriteMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_data_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavoriteShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_favorite_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_data_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_data_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadAbout() {
        onView(withId(R.id.navigation_about)).perform(click())
        onView(withId(R.id.rellay1)).check(matches(isDisplayed()))
    }
}