package com.sample.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by akram on 19/11/18.
 */

public class Media {
    private String subtype;

    private String approved_for_syndication;

    private String caption;
    @SerializedName("media-metadata")
    private List<MultiMedia> media_metadata;

    private String copyright;

    private String type;

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getApproved_for_syndication() {
        return approved_for_syndication;
    }

    public void setApproved_for_syndication(String approved_for_syndication) {
        this.approved_for_syndication = approved_for_syndication;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<MultiMedia> getMultiMedia() {
        return media_metadata;
    }

    public void setMultiMedia(List<MultiMedia> metadata) {
        this.media_metadata = media_metadata;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Media [subtype = " + subtype + ", approved_for_syndication = " + approved_for_syndication + ", caption = " + caption + ", copyright = " + copyright + ", type = " + type + "]";
    }
}
