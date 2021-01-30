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
                        7.3,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        636565,
                        "Rose Island",
                        "In 1968, engineer Giorgio Rosa established the independent state called \"The Isle of Roses\" off the coast of Rimini, built on a platform outside the territorial waters, with Esperanto as the official language. The Italian authorities did not take it well because the micronation was seen as an expedient to not pay taxes on the revenues obtained thanks to the arrival of numerous tourists and curious people.",
                        "${imageUrl}yePO1PrRfrVMGqwJ3EzKhVvQXBX.jpg",
                        "2020-12-09",
                        7.2,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        646593,
                        "Wander",
                        "After getting hired to probe a suspicious death in the small town of Wander, a mentally unstable private investigator becomes convinced the case is linked to the same 'conspiracy cover up' that caused the death of his daughter.",
                        "${imageUrl}2AwPvNHphpZBJDqjZKVuMAbvS0v.jpg",
                        "2020-12-09",
                        5.6,
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
                        false
                )
        )
        movies.add(
                MovieEntity(
                        294963,
                        "Bone Tomahawk",
                        "During a shootout in a saloon, Sheriff Hunt injures a suspicious stranger. One of the villagers takes care of him in prison. One day they both disappear – only the spear of a cannibal tribe is found. Hunt and a few of his men go in search of the prisoner and his nurse.",
                        "${imageUrl}ifdPXLsGmdspNOonv3DwU5pbyVC.jpg",
                        "2015-10-23",
                        6.8,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        602211,
                        "Fatman",
                        "A rowdy, unorthodox Santa Claus is fighting to save his declining business. Meanwhile, Billy, a neglected and precocious 12 year old, hires a hit man to kill Santa after receiving a lump of coal in his stocking.",
                        "${imageUrl}4n8QNNdk4BOX9Dslfbz5Dy6j1HK.jpg",
                        "2020-11-13",
                        5.9,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        553604,
                        "Honest Thief",
                        "A bank robber tries to turn himself in because he's falling in love and wants to live an honest life...but when he realizes the Feds are more corrupt than him, he must fight back to clear his name.",
                        "${imageUrl}zeD4PabP6099gpE0STWJrJrCBCs.jpg",
                        "2020-09-03",
                        7.2,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        577922,
                        "Tenet",
                        "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                        "${imageUrl}k68nPLbIST6NP96JmTxmZijEvCA.jpg",
                        "2020-08-22",
                        7.4,
                        false
                )
        )
        movies.add(
                MovieEntity(
                        662546,
                        "Godmothered",
                        "A young and unskilled fairy godmother that ventures out on her own to prove her worth by tracking down a young girl whose request for help was ignored. What she discovers is that the girl has now become a grown woman in need of something very different than a \"prince charming.\"",
                        "${imageUrl}ir8Qqi90mENhH7CDxEpdeCcm6UL.jpg",
                        "2020-12-04",
                        7.2,
                        false
                )
        )

        return movies
    }

    fun generateDummyShows(): List<ShowEntity> {

        val shows = ArrayList<ShowEntity>()

        shows.add(
                ShowEntity(
                    77169,
                        "Cobra Kai",
                        "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                        "${imageUrl}obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                        "2018-05-02",
                        8.1,
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
                        false
                )
        )
        shows.add(
                ShowEntity(
                        71789,
                        "Seal Team",
                        "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can ask.",
                        "${imageUrl}sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                        "2017-09-27",
                        7.8,
                        false
                )
        )
        shows.add(
                ShowEntity(
                        62286,
                        "Fear the Walking Dead",
                        "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                        "${imageUrl}wGFUewXPeMErCe2xnCmmLEiHOGh.jpg",
                        "2015-08-23",
                        7.5,
                        false
                )
        )
        shows.add(
                ShowEntity(
                        69050,
                        "Riverdale",
                        "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                        "${imageUrl}4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                        "2017-01-26",
                        8.6,
                        false
                )
        )
        shows.add(
                ShowEntity(
                        68507,
                        "His Dark Materials",
                        "Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.",
                        "${imageUrl}g6tIKGc3f1H5QMz1dcgCwADKpZ7.jpg",
                        "2019-11-03",
                        8.1,
                        false
                )
        )
        shows.add(
                ShowEntity(
                        87739,
                        "The Queen's Gambit",
                        "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
                        "${imageUrl}zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
                        "2020-10-23",
                        8.7,
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
                        8.3,
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
                        7.3
                )
        )
        movies.add(
                ResultsMovieItem(
                        636565,
                        "Rose Island",
                        "In 1968, engineer Giorgio Rosa established the independent state called \"The Isle of Roses\" off the coast of Rimini, built on a platform outside the territorial waters, with Esperanto as the official language. The Italian authorities did not take it well because the micronation was seen as an expedient to not pay taxes on the revenues obtained thanks to the arrival of numerous tourists and curious people.",
                        "${imageUrl}yePO1PrRfrVMGqwJ3EzKhVvQXBX.jpg",
                        "2020-12-09",
                        7.2
                )
        )
        movies.add(
                ResultsMovieItem(
                        646593,
                        "Wander",
                        "After getting hired to probe a suspicious death in the small town of Wander, a mentally unstable private investigator becomes convinced the case is linked to the same 'conspiracy cover up' that caused the death of his daughter.",
                        "${imageUrl}2AwPvNHphpZBJDqjZKVuMAbvS0v.jpg",
                        "2020-12-09",
                        5.6
                )
        )
        movies.add(
                ResultsMovieItem(
                        590706,
                        "Jiu Jitsu",
                        "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance.",
                        "${imageUrl}eLT8Cu357VOwBVTitkmlDEg32Fs.jpg",
                        "2020-11-20",
                        5.7
                )
        )
        movies.add(
                ResultsMovieItem(
                        765123,
                        "Christmas Crossfire",
                        "A man foils an attempted murder, then flees the crew of would-be killers along with their intended target as a woman he's just met tries to find him.",
                        "${imageUrl}ajKpYK7XdzIYjy9Uy8nkgRboKyv.jpg",
                        "2020-12-04",
                        5.2
                )
        )
        movies.add(
                ResultsMovieItem(
                        294963,
                        "Bone Tomahawk",
                        "During a shootout in a saloon, Sheriff Hunt injures a suspicious stranger. One of the villagers takes care of him in prison. One day they both disappear – only the spear of a cannibal tribe is found. Hunt and a few of his men go in search of the prisoner and his nurse.",
                        "${imageUrl}ifdPXLsGmdspNOonv3DwU5pbyVC.jpg",
                        "2015-10-23",
                        6.8
                )
        )
        movies.add(
                ResultsMovieItem(
                        602211,
                        "Fatman",
                        "A rowdy, unorthodox Santa Claus is fighting to save his declining business. Meanwhile, Billy, a neglected and precocious 12 year old, hires a hit man to kill Santa after receiving a lump of coal in his stocking.",
                        "${imageUrl}4n8QNNdk4BOX9Dslfbz5Dy6j1HK.jpg",
                        "2020-11-13",
                        5.9
                )
        )
        movies.add(
                ResultsMovieItem(
                        553604,
                        "Honest Thief",
                        "A bank robber tries to turn himself in because he's falling in love and wants to live an honest life...but when he realizes the Feds are more corrupt than him, he must fight back to clear his name.",
                        "${imageUrl}zeD4PabP6099gpE0STWJrJrCBCs.jpg",
                        "2020-09-03",
                        7.2
                )
        )
        movies.add(
                ResultsMovieItem(
                        577922,
                        "Tenet",
                        "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                        "${imageUrl}k68nPLbIST6NP96JmTxmZijEvCA.jpg",
                        "2020-08-22",
                        7.4
                )
        )
        movies.add(
                ResultsMovieItem(
                        662546,
                        "Godmothered",
                        "A young and unskilled fairy godmother that ventures out on her own to prove her worth by tracking down a young girl whose request for help was ignored. What she discovers is that the girl has now become a grown woman in need of something very different than a \"prince charming.\"",
                        "${imageUrl}ir8Qqi90mENhH7CDxEpdeCcm6UL.jpg",
                        "2020-12-04",
                        7.2
                )
        )

        return movies
    }

    fun generateRemoteDummyShows(): List<ResultsShowItem> {

        val shows = ArrayList<ResultsShowItem>()

        shows.add(
                ResultsShowItem(
                    77169,
                        "Cobra Kai",
                        "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                        "${imageUrl}obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                        "2018-05-02",
                        8.1
                )
        )
        shows.add(
                ResultsShowItem(
                        71712,
                        "The Good Doctor",
                        "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                        "${imageUrl}6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                        "2017-09-25",
                        8.6
                )
        )
        shows.add(
                ResultsShowItem(
                        1416,
                        "Grey's Anatomy",
                        "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                        "${imageUrl}clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                        "2005-03-27",
                        8.1
                )
        )
        shows.add(
                ResultsShowItem(
                        63174,
                        "Lucifer",
                        "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                        "${imageUrl}4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                        "2016-01-25",
                        8.5
                )
        )
        shows.add(
                ResultsShowItem(
                        71789,
                        "Seal Team",
                        "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can ask.",
                        "${imageUrl}sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                        "2017-09-27",
                        7.8
                )
        )
        shows.add(
                ResultsShowItem(
                        62286,
                        "Fear the Walking Dead",
                        "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                        "${imageUrl}wGFUewXPeMErCe2xnCmmLEiHOGh.jpg",
                        "2015-08-23",
                        7.5
                )
        )
        shows.add(
                ResultsShowItem(
                        69050,
                        "Riverdale",
                        "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                        "${imageUrl}4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                        "2017-01-26",
                        8.6
                )
        )
        shows.add(
                ResultsShowItem(
                        68507,
                        "His Dark Materials",
                        "Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.",
                        "${imageUrl}g6tIKGc3f1H5QMz1dcgCwADKpZ7.jpg",
                        "2019-11-03",
                        8.1
                )
        )
        shows.add(
                ResultsShowItem(
                        87739,
                        "The Queen's Gambit",
                        "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
                        "${imageUrl}zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
                        "2020-10-23",
                        8.7
                )
        )
        shows.add(
                ResultsShowItem(
                        1399,
                        "Game of Thrones",
                        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                        "${imageUrl}u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                        "2011-04-17",
                        8.3
                )
        )

        return shows
    }

    fun generateRemoteDummyMoviesDetail(kMovieId: Int): DetailMovieResponse {
        val movieId = arrayOf(464052, 636565, 646593, 590706, 765123, 294963, 602211, 553604, 577922, 662546)

        val movieTitle = arrayOf(
                "Wonder Woman 1984",
                "Rose Island",
                "Wander",
                "Jiu Jitsu",
                "Christmas Crossfire",
                "Bone Tomahawk",
                "Fatman",
                "Honest Thief",
                "Tenet",
                "Godmothered"
        )

        val movieOverview = arrayOf(
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                "In 1968, engineer Giorgio Rosa established the independent state called \"The Isle of Roses\" off the coast of Rimini, built on a platform outside the territorial waters, with Esperanto as the official language. The Italian authorities did not take it well because the micronation was seen as an expedient to not pay taxes on the revenues obtained thanks to the arrival of numerous tourists and curious people.",
                "After getting hired to probe a suspicious death in the small town of Wander, a mentally unstable private investigator becomes convinced the case is linked to the same 'conspiracy cover up' that caused the death of his daughter.",
                "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance.",
                "A man foils an attempted murder, then flees the crew of would-be killers along with their intended target as a woman he's just met tries to find him.",
                "During a shootout in a saloon, Sheriff Hunt injures a suspicious stranger. One of the villagers takes care of him in prison. One day they both disappear – only the spear of a cannibal tribe is found. Hunt and a few of his men go in search of the prisoner and his nurse.",
                "A rowdy, unorthodox Santa Claus is fighting to save his declining business. Meanwhile, Billy, a neglected and precocious 12 year old, hires a hit man to kill Santa after receiving a lump of coal in his stocking.",
                "A bank robber tries to turn himself in because he's falling in love and wants to live an honest life...but when he realizes the Feds are more corrupt than him, he must fight back to clear his name.",
                "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                "A young and unskilled fairy godmother that ventures out on her own to prove her worth by tracking down a young girl whose request for help was ignored. What she discovers is that the girl has now become a grown woman in need of something very different than a \"prince charming.\""
        )

        val moviePosterPath = arrayOf(
                "${imageUrl}8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "${imageUrl}yePO1PrRfrVMGqwJ3EzKhVvQXBX.jpg",
                "${imageUrl}2AwPvNHphpZBJDqjZKVuMAbvS0v.jpg",
                "${imageUrl}eLT8Cu357VOwBVTitkmlDEg32Fs.jpg",
                "${imageUrl}ajKpYK7XdzIYjy9Uy8nkgRboKyv.jpg",
                "${imageUrl}ifdPXLsGmdspNOonv3DwU5pbyVC.jpg",
                "${imageUrl}4n8QNNdk4BOX9Dslfbz5Dy6j1HK.jpg",
                "${imageUrl}zeD4PabP6099gpE0STWJrJrCBCs.jpg",
                "${imageUrl}k68nPLbIST6NP96JmTxmZijEvCA.jpg",
                "${imageUrl}ir8Qqi90mENhH7CDxEpdeCcm6UL.jpg"

        )

        val movieReleaseDate = arrayOf(
                "2020-12-16",
                "2020-12-09",
                "2020-12-09",
                "2020-11-20",
                "2020-12-04",
                "2015-10-23",
                "2020-11-13",
                "2020-09-03",
                "2020-08-22",
                "2020-12-04"
        )

        val movieVoteAverage = doubleArrayOf(7.3, 7.2, 5.6, 5.7, 5.2, 6.8, 5.9, 7.2, 7.4, 7.2)


        lateinit var movie: DetailMovieResponse

        for (i in movieId.indices) {
            if (kMovieId == movieId[i]) {
                movie = DetailMovieResponse(
                        movieId[i],
                        movieTitle[i],
                        movieOverview[i],
                        moviePosterPath[i],
                        movieReleaseDate[i],
                        movieVoteAverage[i])
                break
            }
        }
        return movie
    }

    fun generateRemoteDummyShowsDetail(kShowId: Int): DetailShowResponse {
        val showId = arrayOf(77169, 71712, 1416, 63174, 71789, 62286, 69050, 68507, 87739, 1399)

        val showName = arrayOf(
                "Cobra Kai",
                "The Good Doctor",
                "Grey's Anatomy",
                "Lucifer",
                "Seal Team",
                "Fear the Walking Dead",
                "Riverdale",
                "His Dark Materials",
                "The Queen's Gambit",
                "Game of Thrones"
        )

        val showOverview = arrayOf(
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can ask.",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.",
                "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond."
        )

        val showPosterPath = arrayOf(
                "${imageUrl}obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                "${imageUrl}6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "${imageUrl}clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "${imageUrl}4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "${imageUrl}sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                "${imageUrl}wGFUewXPeMErCe2xnCmmLEiHOGh.jpg",
                "${imageUrl}4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                "${imageUrl}g6tIKGc3f1H5QMz1dcgCwADKpZ7.jpg",
                "${imageUrl}zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
                "${imageUrl}u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"

        )

        val showFirstAirDate = arrayOf(
                "2018-05-02",
                "2017-09-25",
                "2005-03-27",
                "2016-01-25",
                "2017-09-27",
                "2015-08-23",
                "2017-01-26",
                "2019-11-03",
                "2020-10-23",
                "2011-04-17"
        )

        val showVoteAverage = doubleArrayOf(8.1, 8.6, 8.1, 8.5, 7.8, 7.5, 8.6, 8.1, 8.7, 8.3)


        lateinit var show: DetailShowResponse

        for (i in showId.indices) {
            if (kShowId == showId[i]) {
                show = DetailShowResponse(
                        showId[i],
                        showName[i],
                        showOverview[i],
                        showPosterPath[i],
                        showFirstAirDate[i],
                        showVoteAverage[i])
                break
            }
        }
        return show

    }
}