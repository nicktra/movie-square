package com.nicktra.moviesquare.utils

import com.nicktra.moviesquare.data.MovieEntity
import com.nicktra.moviesquare.data.ShowEntity

object DataDummy {

    private const val imageUrl = "https://image.tmdb.org/t/p/w500/"

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
                MovieEntity(
                        "590995",
                        "The Craft: Legacy",
                        "An eclectic foursome of aspiring teenage witches get more than they bargained for as they lean into their newfound powers.",
                        "${imageUrl}lhMIra0pqWNuD6CIXoTmGwZ0EBS.jpg",
                        "Horror, Drama, Fantasy",
                        "Oct 28, 2020",
                        "6.3"
                )
        )

        movies.add(
                MovieEntity(
                        "531219",
                        "Roald Dahl's The Witches",
                        "In late 1967, a young orphaned boy goes to live with his loving grandma in the rural Alabama town of Demopolis. As the boy and his grandmother encounter some deceptively glamorous but thoroughly diabolical witches, she wisely whisks him away to a seaside resort. Regrettably, they arrive at precisely the same time that the world's Grand High Witch has gathered.",
                        "${imageUrl}betExZlgK0l7CZ9CsCBVcwO1OjL.jpg",
                        "Fantasy, Family, Adventure, Comedy, Horror",
                        "Oct 26, 2020",
                        "6.9"
                )
        )

        movies.add(
                MovieEntity(
                        "646593",
                        "Wander",
                        "After getting hired to probe a suspicious death in the small town of Wander, a mentally unstable private investigator becomes convinced the case is linked to the same 'conspiracy cover up' that caused the death of his daughter.",
                        "${imageUrl}2AwPvNHphpZBJDqjZKVuMAbvS0v.jpg",
                        "Thriller, Crime, Mystery",
                        "Dec 04, 2020",
                        "5.6"
                )
        )

        movies.add(
                MovieEntity(
                        "590706",
                        "Jiu Jitsu",
                        "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance.",
                        "${imageUrl}eLT8Cu357VOwBVTitkmlDEg32Fs.jpg",
                        "Action, Fantasy, Science Fiction",
                        "Nov 20, 2020",
                        "5.7"
                )
        )

        movies.add(
                MovieEntity(
                        "765123",
                        "Christmas Crossfire",
                        "A man foils an attempted murder, then flees the crew of would-be killers along with their intended target as a woman he's just met tries to find him.",
                        "${imageUrl}ajKpYK7XdzIYjy9Uy8nkgRboKyv.jpg",
                        "Comedy, Crime, Thriller",
                        "Dec 04, 2020",
                        "5.2"
                )
        )

        movies.add(
                MovieEntity(
                        "294963",
                        "Bone Tomahawk",
                        "During a shootout in a saloon, Sheriff Hunt injures a suspicious stranger. One of the villagers takes care of him in prison. One day they both disappear – only the spear of a cannibal tribe is found. Hunt and a few of his men go in search of the prisoner and his nurse.",
                        "${imageUrl}ifdPXLsGmdspNOonv3DwU5pbyVC.jpg",
                        "Horror, Western, History",
                        "Oct 23, 2015",
                        "6.8"
                )
        )

        movies.add(
                MovieEntity(
                        "602211",
                        "Fatman",
                        "A rowdy, unorthodox Santa Claus is fighting to save his declining business. Meanwhile, Billy, a neglected and precocious 12 year old, hires a hit man to kill Santa after receiving a lump of coal in his stocking.",
                        "${imageUrl}4n8QNNdk4BOX9Dslfbz5Dy6j1HK.jpg",
                        "Action, Comedy, Fantasy",
                        "Nov 13, 2020",
                        "5.9"
                )
        )

        movies.add(
                MovieEntity(
                        "553604",
                        "Honest Thief",
                        "A bank robber tries to turn himself in because he's falling in love and wants to live an honest life...but when he realizes the Feds are more corrupt than him, he must fight back to clear his name.",
                        "${imageUrl}zeD4PabP6099gpE0STWJrJrCBCs.jpg",
                        "Action, Thriller, Crime, Drama",
                        "Sep 03, 2020",
                        "7.2"
                )
        )

        movies.add(
                MovieEntity(
                        "577922",
                        "Tenet",
                        "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                        "${imageUrl}k68nPLbIST6NP96JmTxmZijEvCA.jpg",
                        "Action, Thriller, Science Fiction",
                        "Aug 22, 2020",
                        "7.4"
                )
        )

        movies.add(
                MovieEntity(
                        "662546",
                        "Godmothered",
                        "A young and unskilled fairy godmother that ventures out on her own to prove her worth by tracking down a young girl whose request for help was ignored. What she discovers is that the girl has now become a grown woman in need of something very different than a \"prince charming.\"",
                        "${imageUrl}ir8Qqi90mENhH7CDxEpdeCcm6UL.jpg",
                        "Family, Fantasy, Comedy",
                        "Dec 04, 2020",
                        "7.2"
                )
        )

        return movies
    }

    fun generateDummyShows(): List<ShowEntity> {

        val shows = ArrayList<ShowEntity>()

        shows.add(
                ShowEntity(
                        "82856",
                        "The Mandalorian",
                        "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                        "${imageUrl}sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                        "Sci-Fi & Fantasy, Action & Adventure",
                        "Nov 12, 2019",
                        "8.5"
                )
        )

        shows.add(
                ShowEntity(
                        "71712",
                        "The Good Doctor",
                        "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                        "${imageUrl}6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                        "Drama",
                        "Sep 25, 2017",
                        "8.6"
                )
        )

        shows.add(
                ShowEntity(
                        "1416",
                        "Grey's Anatomy",
                        "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                        "${imageUrl}clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                        "Drama",
                        "Mar 27, 2005",
                        "8.1"
                )
        )

        shows.add(
                ShowEntity(
                        "63174",
                        "Lucifer",
                        "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                        "${imageUrl}4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                        "Crime, Sci-Fi & Fantasy",
                        "Jan 25, 2016",
                        "8.5"
                )
        )

        shows.add(
                ShowEntity(
                        "71789",
                        "Seal Team",
                        "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can ask.",
                        "${imageUrl}sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                        "Action & Adventure, Drama, War & Politics\n",
                        "Sep 27, 2017",
                        "7.8"
                )
        )

        shows.add(
                ShowEntity(
                        "62286",
                        "Fear the Walking Dead",
                        "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                        "${imageUrl}wGFUewXPeMErCe2xnCmmLEiHOGh.jpg",
                        "Action & Adventure, Drama",
                        "Aug 23, 2015",
                        "7.5"
                )
        )

        shows.add(
                ShowEntity(
                        "69050",
                        "Riverdale",
                        "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                        "${imageUrl}4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg",
                        "Drama, Mystery",
                        "Jan 26, 2017",
                        "8.6"
                )
        )

        shows.add(
                ShowEntity(
                        "68507",
                        "His Dark Materials",
                        "Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.",
                        "${imageUrl}g6tIKGc3f1H5QMz1dcgCwADKpZ7.jpg",
                        "Drama, Sci-Fi & Fantasy",
                        "Nov 03, 2019",
                        "8.1"
                )
        )

        shows.add(
                ShowEntity(
                        "87739",
                        "The Queen's Gambit",
                        "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
                        "${imageUrl}zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
                        "Drama",
                        "Oct 23, 2020",
                        "8.7"
                )
        )

        shows.add(
                ShowEntity(
                        "1399",
                        "Game of Thrones",
                        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                        "${imageUrl}u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                        "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
                        "Apr 17, 2011",
                        "8.3"
                )
        )

        return shows
    }
}