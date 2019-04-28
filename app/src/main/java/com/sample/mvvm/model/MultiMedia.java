package com.sample.mvvm.model;

/**
 * Created by akram on 19/11/18.
 */

public class MultiMedia {
    private String height;

    private String width;

    private String format;

    private String url;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MultiMedia [height = " + height + ", width = " + width + ", format = " + format + ", url = " + url + "]";
    }
}
