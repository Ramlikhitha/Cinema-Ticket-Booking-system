package model;



public class Movie {

    private String title;
    private String language;
    private int duration_min;
    private String certification;

    //Movie Table
    public Movie(String title,String language,int duration_min,String certification){
        this.title=title;
        this.language=language;
        this.duration_min=duration_min;
        this.certification=certification;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public int getDuration_min() {
        return duration_min;
    }

    public String getCertification() {
        return certification;
    }


}
