package com.devforbest.movieapp.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by daniel on 09/11/2017.
 */

public class ResponseMovieDetail {


    @SerializedName("adult")
    private boolean isAdult;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    private Object belongToCollection;
    @SerializedName("budget")
    private int budget;
    @SerializedName("genres")
    private ArrayList<ItemWithNameID> genres;

    @SerializedName("homepage")
    private String homePage;

    @SerializedName("id")
    private int id;
    @SerializedName("imdb_id")
    private String imdbID;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_titile")
    private String originalTitle;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private float popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("production_companies")
    private ArrayList<ItemWithNameID> productionCompanies;
    @SerializedName("production_countries")
    private ArrayList<Country> productionCountries;


    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("revenue")
    private int revenue;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("spoken_languages")
    private ArrayList<Country> spokenLenguages;

    @SerializedName("status")
    private String status;
    @SerializedName("tagline")
    private String tagline;


    @SerializedName("title")
    private String title;
    @SerializedName("video")
    private boolean hasVideo;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("vote_cout")
    private int voteCount;


    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Object getBelongToCollection() {
        return belongToCollection;
    }

    public void setBelongToCollection(Object belongToCollection) {
        this.belongToCollection = belongToCollection;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public ArrayList<ItemWithNameID> getGenres() {
        return genres;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public ArrayList<ItemWithNameID> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(ArrayList<ItemWithNameID> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public ArrayList<Country> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(ArrayList<Country> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public ArrayList<Country> getSpokenLenguages() {
        return spokenLenguages;
    }

    public void setSpokenLenguages(ArrayList<Country> spokenLenguages) {
        this.spokenLenguages = spokenLenguages;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }


    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    private class Country {
        @SerializedName("iso_3166_1")
        private String iso;
        @SerializedName("name")
        private String name;

        public String getIso() {
            return iso;
        }

        public void setIso(String iso) {
            this.iso = iso;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private class ItemWithNameID {


        @SerializedName("name")
        private String name;
        @SerializedName("id")
        private int id;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
/*
*  "adult": false,
    "backdrop_path": "/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg",
    "belongs_to_collection": null,
    "budget": 35000000,
    "genres": [
        {
            "id": 18,
            "name": "Drama"
        },
        {
            "id": 27,
            "name": "Horror"
        },
        {
            "id": 53,
            "name": "Thriller"
        }
    ],
    "homepage": "http://itthemovie.com/",
    "id": 346364,
    "imdb_id": "tt1396484",
    "original_language": "en",
    "original_title": "It",
    "overview": "In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.",
    "popularity": 703.9096060000001,
    "poster_path": "/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg",
    "production_companies": [
        {
            "name": "New Line Cinema",
            "id": 12
        },
        {
            "name": "Vertigo Entertainment",
            "id": 829
        },
        {
            "name": "Lin Pictures",
            "id": 2723
        },
        {
            "name": "RatPac-Dune Entertainment",
            "id": 41624
        },
        {
            "name": "KatzSmith Productions",
            "id": 87671
        }
    ],
    "production_countries": [
        {
            "iso_3166_1": "US",
            "name": "United States of America"
        }
    ],
    "release_date": "2017-09-05",
    "revenue": 555575232,
    "runtime": 135,
    "spoken_languages": [
        {
            "iso_639_1": "en",
            "name": "English"
        },
        {
            "iso_639_1": "de",
            "name": "Deutsch"
        }
    ],
    "status": "Released",
    "tagline": "Your fears are unleashed",
    "title": "It",
    "video": false,
    "vote_average": 7.3,
    "vote_count": 3515
}*/
}
