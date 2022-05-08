package com.example.mybookslistroomretrofitmvvm.models;

import com.example.mybookslistroomretrofitmvvm.models.ImageLinks;
import com.example.mybookslistroomretrofitmvvm.models.IndustryIdentifier;
import com.example.mybookslistroomretrofitmvvm.models.PanelizationSummary;
import com.example.mybookslistroomretrofitmvvm.models.ReadingModes;

import java.io.Serializable;
import java.util.ArrayList;

public class VolumeInfo implements Serializable {
        public String title;
        public ArrayList<String> authors;
        public String publisher;
        public String publishedDate;
        public String description;
        public ArrayList<IndustryIdentifier> industryIdentifiers;
        public ReadingModes readingModes;
        public int pageCount;
        public String printType;
        public int averageRating;
        public int ratingsCount;
        public String maturityRating;
        public boolean allowAnonLogging;
        public String contentVersion;
        public String language;
        public String previewLink;
        public String infoLink;
        public String canonicalVolumeLink;
        public PanelizationSummary panelizationSummary;
        public String subtitle;
        public ImageLinks imageLinks;
        public ArrayList<String> categories;


    public VolumeInfo(String title, ArrayList<String> authors, String publisher, String publishedDate,
                      String description, ArrayList<IndustryIdentifier> industryIdentifiers, ReadingModes readingModes,
                      int pageCount, String printType, int averageRating, int ratingsCount, String maturityRating,
                      boolean allowAnonLogging, String contentVersion, String language, String previewLink,
                      String infoLink, String canonicalVolumeLink, PanelizationSummary panelizationSummary,
                      String subtitle, ImageLinks imageLinks, ArrayList<String> categories) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.industryIdentifiers = industryIdentifiers;
        this.readingModes = readingModes;
        this.pageCount = pageCount;
        this.printType = printType;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
        this.maturityRating = maturityRating;
        this.allowAnonLogging = allowAnonLogging;
        this.contentVersion = contentVersion;
        this.language = language;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
        this.panelizationSummary = panelizationSummary;
        this.subtitle = subtitle;
        this.imageLinks = imageLinks;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<IndustryIdentifier> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public void setIndustryIdentifiers(ArrayList<IndustryIdentifier> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public ReadingModes getReadingModes() {
        return readingModes;
    }

    public void setReadingModes(ReadingModes readingModes) {
        this.readingModes = readingModes;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public boolean isAllowAnonLogging() {
        return allowAnonLogging;
    }

    public void setAllowAnonLogging(boolean allowAnonLogging) {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public PanelizationSummary getPanelizationSummary() {
        return panelizationSummary;
    }

    public void setPanelizationSummary(PanelizationSummary panelizationSummary) {
        this.panelizationSummary = panelizationSummary;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }
}
