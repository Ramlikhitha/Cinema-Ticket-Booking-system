package model;

public class Show {
    private int movie_id;
    private int  auditorium_id;
    private String show_time;
    private String end_time;

    public Show(int movie_id,int auditorium_id,String show_time,String end_time){
        this.movie_id=movie_id;
        this.auditorium_id=auditorium_id;
        this.show_time=show_time;
        this.end_time=end_time;

    }

    public int getMovie_id() {
        return movie_id;
    }

    public int getAuditorium_id() {
        return auditorium_id;
    }

    public String getShow_time() {
        return show_time;
    }

    public String getEnd_time() {
        return end_time;
    }
}
