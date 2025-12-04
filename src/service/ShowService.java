package service;
import dao.ShowDAO;
import model.Show;
public class ShowService {
    private ShowDAO sd=new ShowDAO();
    public void createShow(Show show){
        sd.createShow(show);
    }
    public boolean checkConflict(int auditorium_id,String start_time){
        return sd.isShowConflict(auditorium_id,start_time);
    }

}
