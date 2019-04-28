package com.sample.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by akram on 19/11/18.
 */

public class Results {

    @SerializedName("abstract")
    private String abstract_title;

    private String published_date;

    private String asset_id;

    private String type;

    private String url;

    private String section;

    private String[] des_facet;

    private String id;

    private String title;

    private String byline;

    private String source;

    private String views;

    //private String[] org_facet;

    private String column;

    private String adx_keywords;

    private List<Media> media;

    public String getAbstract() {
        return abstract_title;
    }

    public void setAbstract(String abstract_title) {
        this.abstract_title = abstract_title;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String[] getDes_facet() {
        return des_facet;
    }

    public void setDes_facet(String[] des_facet) {
        this.des_facet = des_facet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getAdx_keywords() {
        return adx_keywords;
    }

    public void setAdx_keywords(String adx_keywords) {
        this.adx_keywords = adx_keywords;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Results [published_date = " + published_date + ", asset_id = " + asset_id + ", type = " + type + ", url = " + url + ", section = " + section + ", des_facet = " + des_facet + ", id = " + id + ", title = " + title + ", byline = " + byline + ", source = " + source + ", views = " + views + ", column = " + column + ", adx_keywords = " + adx_keywords + ", media = " + media + "]";
    }
}
