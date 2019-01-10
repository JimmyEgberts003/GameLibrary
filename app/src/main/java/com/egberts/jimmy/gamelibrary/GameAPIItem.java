package com.egberts.jimmy.gamelibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;

public class GameAPIItem {

    @SerializedName("aliases")
    @Expose
    private String aliases;

    @SerializedName("api_detail_url")
    @Expose
    private String api_detail_url;

    @SerializedName("date_added")
    @Expose
    private String date_added;

    @SerializedName("date_last_updated")
    @Expose
    private String date_last_updated;

    @SerializedName("deck")
    @Expose
    private String deck;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("expected_release_month")
    @Expose
    private Double expected_release_month;

    @SerializedName("expected_release_quarter")
    @Expose
    private String expected_release_quarter;

    @SerializedName("expected_release_year")
    @Expose
    private String expected_release_year;

    @SerializedName("guid")
    @Expose
    private String guid;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("image")
    @Expose
    private JSONObject image;

    @SerializedName("image_tags")
    @Expose
    private ArrayList image_tags;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("number_of_user_reviews")
    @Expose
    private Integer number_of_user_reviews;

    @SerializedName("original_game_rating")
    @Expose
    private ArrayList original_game_rating;

    @SerializedName("original_release_date")
    @Expose
    private String original_release_date;

    @SerializedName("platforms")
    @Expose
    private ArrayList platforms;

    @SerializedName("site_detail_url")
    @Expose
    private String site_detail_url;

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getApi_detail_url() {
        return api_detail_url;
    }

    public void setApi_detail_url(String api_detail_url) {
        this.api_detail_url = api_detail_url;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getDate_last_updated() {
        return date_last_updated;
    }

    public void setDate_last_updated(String date_last_updated) {
        this.date_last_updated = date_last_updated;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getExpected_release_month() {
        return expected_release_month;
    }

    public void setExpected_release_month(Double expected_release_month) {
        this.expected_release_month = expected_release_month;
    }

    public String getExpected_release_quarter() {
        return expected_release_quarter;
    }

    public void setExpected_release_quarter(String expected_release_quarter) {
        this.expected_release_quarter = expected_release_quarter;
    }

    public String getExpected_release_year() {
        return expected_release_year;
    }

    public void setExpected_release_year(String expected_release_year) {
        this.expected_release_year = expected_release_year;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JSONObject getImage() {
        return image;
    }

    public void setImage(JSONObject image) {
        this.image = image;
    }

    public ArrayList getImage_tags() {
        return image_tags;
    }

    public void setImage_tags(ArrayList image_tags) {
        this.image_tags = image_tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber_of_user_reviews() {
        return number_of_user_reviews;
    }

    public void setNumber_of_user_reviews(Integer number_of_user_reviews) {
        this.number_of_user_reviews = number_of_user_reviews;
    }

    public ArrayList getOriginal_game_rating() {
        return original_game_rating;
    }

    public void setOriginal_game_rating(ArrayList original_game_rating) {
        this.original_game_rating = original_game_rating;
    }

    String getOriginal_release_date() {
        return original_release_date;
    }

    public void setOriginal_release_date(String original_release_date) {
        this.original_release_date = original_release_date;
    }

    public ArrayList getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList platforms) {
        this.platforms = platforms;
    }

    public String getSite_detail_url() {
        return site_detail_url;
    }

    public void setSite_detail_url(String site_detail_url) {
        this.site_detail_url = site_detail_url;
    }
}

