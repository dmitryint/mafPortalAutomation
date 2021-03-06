package ru.st.selenium.model;

public class VideoGallery {
    private String title;
    private String rusTitle;
    private String club;
    private String tournament;
    private boolean showInGlobalGallery;
    private String youtubeLink;

    public VideoGallery(String title, String rusTitle, String club, String tournament, boolean showInGlobalGallery, String youtubeLink) {
        this.title = title;
        this.rusTitle = rusTitle;
        this.club = club;
        this.tournament = tournament;
        this.showInGlobalGallery = showInGlobalGallery;
        this.youtubeLink = youtubeLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRusTitle() {
        return rusTitle;
    }

    public void setRusTitle(String rusTitle) {
        this.rusTitle = rusTitle;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public boolean isShowInGlobalGallery() {
        return showInGlobalGallery;
    }

    public void setShowInGlobalGallery(boolean showInGlobalGallery) {
        this.showInGlobalGallery = showInGlobalGallery;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
}
