package com.nicktra.moviesquare.utils

import com.nicktra.moviesquare.data.source.local.entity.MovieEntity
import com.nicktra.moviesquare.data.source.local.entity.ShowEntity
import com.nicktra.moviesquare.data.source.remote.response.movie.DetailMovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.MovieResponse
import com.nicktra.moviesquare.data.source.remote.response.movie.ResultsMovieItem
import com.nicktra.moviesquare.data.source.remote.response.tvshow.DetailShowResponse
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ResultsShowItem
import com.nicktra.moviesquare.data.source.remote.response.tvshow.ShowResponse

object DataDummy {

    private const val imageUrl = "https://image.tmdb.org/t/p/w500/"

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
                MovieEntity(
                        464052,
                        "Wonder Woman 1984",
                        "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                        "${imageUrl}8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                        "2020-12-16",
                        7.0,
                        2923.424,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        38700,
                        "Bad Boys for Life",
                        "Marcus and Mike are forced to confront new threats, career changes, and midlife crises as they join the newly created elite team AMMO of the Miami police department to take down the ruthless Armando Armas, the vicious leader of a Miami drug cartel.",
                        "${imageUrl}y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg",
                        "2020-01-15",
                        7.2,
                        706.168,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        775996,
                        "Outside the Wire",
                        "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
                        "${imageUrl}e6SK2CAbO3ENy52UTzP3lv32peC.jpg",
                        "2021-01-15",
                        6.5,
                        2510.524,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        590706,
                        "Jiu Jitsu",
                        "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance.",
                        "${imageUrl}eLT8Cu357VOwBVTitkmlDEg32Fs.jpg",
                        "2020-11-20",
                        5.7,
                        706.148,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        765123,
                        "Christmas Crossfire",
                        "A man foils an attempted murder, then flees the crew of would-be killers along with their intended target as a woman he's just met tries to find him.",
                        "${imageUrl}ajKpYK7XdzIYjy9Uy8nkgRboKyv.jpg",
                        "2020-12-04",
                        5.2,
                        706.149,
                        false
                )
        )

        return movies
    }

    fun generateDummyShows(): List<ShowEntity> {

        val shows = ArrayList<ShowEntity>()

        shows.add(
                ShowEntity(
                        85271,
                        "WandaVision",
                        "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                        "${imageUrl}glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                        "2021-01-15",
                        8.4,
                        2799.374,
                        false
                )
        )
        shows.add(
                ShowEntity(
                        1399,
                        "Game of Thrones",
                        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                        "${imageUrl}u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                        "2011-04-17",
                        8.4,
                        938.808,
                        false
                )
        )
        shows.add(
                ShowEntity(
                        71712,
                        "The Good Doctor",
                        "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                        "${imageUrl}6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                        "2017-09-25",
                        8.6,
                        938.708,
                        false
                )
        )
        shows.add(
                ShowEntity(
                        1416,
                        "Grey's Anatomy",
                        "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                        "${imageUrl}clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                        "2005-03-27",
                        8.1,
                        667.871,
                        false
                )
        )
        shows.add(
                ShowEntity(
                        63174,
                        "Lucifer",
                        "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                        "${imageUrl}4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                        "2016-01-25",
                        8.5,
                        636.037,
                        false
                )
        )

        return shows
    }

    fun generateRemoteDummyMovies(): List<ResultsMovieItem> {

        val movies = ArrayList<ResultsMovieItem>()

        movies.add(
                ResultsMovieItem(
                        464052,
                        "Wonder Woman 1984",
                        "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                        "${imageUrl}8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                        "2020-12-16",
                        7.0,
                        2923.424
                )
        )
        movies.add(
                ResultsMovieItem(
                        38700,
                        "Bad Boys for Life",
                        "Marcus and Mike are forced to confront new threats, career changes, and midlife crises as they join the newly created elite team AMMO of the Miami police department to take down the ruthless Armando Armas, the vicious leader of a Miami drug cartel.",
                        "${imageUrl}y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg",
                        "2020-01-15",
                        7.2,
                        706.168
                )
        )
        movies.add(
                ResultsMovieItem(
                        775996,
                        "Outside the Wire",
                        "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
                        "${imageUrl}e6SK2CAbO3ENy52UTzP3lv32peC.jpg",
                        "2021-01-15",
                        6.5,
                        2510.524
                )
        )
        movies.add(
                ResultsMovieItem(
                        590706,
                        "Jiu Jitsu",
                        "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance.",
                        "${imageUrl}eLT8Cu357VOwBVTitkmlDEg32Fs.jpg",
                        "2020-11-20",
                        5.7,
                        706.148
                )
        )
        movies.add(
                ResultsMovieItem(
                        765123,
                        "Christmas Crossfire",
                        "A man foils an attempted murder, then flees the crew of would-be killers along with their intended target as a woman he's just met tries to find him.",
                        "${imageUrl}ajKpYK7XdzIYjy9Uy8nkgRboKyv.jpg",
                        "2020-12-04",
                        5.2,
                        706.149
                )
        )

        return movies
    }

    fun generateRemoteDummyShows(): List<ResultsShowItem> {

        val shows = ArrayList<ResultsShowItem>()

        shows.add(
                ResultsShowItem(
                        85271,
                        "WandaVision",
                        "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                        "${imageUrl}glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                        "2021-01-15",
                        8.4,
                        2799.374
                )
        )
        shows.add(
                ResultsShowItem(
                        1399,
                        "Game of Thrones",
                        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                        "${imageUrl}u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                        "2011-04-17",
                        8.4,
                        938.808
                )
        )
        shows.add(
                ResultsShowItem(
                        71712,
                        "The Good Doctor",
                        "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                        "${imageUrl}6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                        "2017-09-25",
                        8.6,
                        938.708
                )
        )
        shows.add(
                ResultsShowItem(
                        1416,
                        "Grey's Anatomy",
                        "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                        "${imageUrl}clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                        "2005-03-27",
                        8.1,
                        667.871
                )
        )
        shows.add(
                ResultsShowItem(
                        63174,
                        "Lucifer",
                        "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                        "${imageUrl}4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                        "2016-01-25",
                        8.5,
                        636.037
                )
        )

        return shows
    }

}