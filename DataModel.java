import java.util.ArrayList;
import java.util.List;

public class DataModel {
    private List<Requirement> requirementList = new ArrayList<>();
    private List<Director> directors = new ArrayList<>();
    private List<Administrator> administrators = new ArrayList<>();
    private List<PTT> PTTs = new ArrayList<>();//teachers
    private List<PTT> trainingList = new ArrayList<>();


    public DataModel() {
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    public List<PTT> getPTTs() {
        return PTTs;
    }

    public void setPTTs(List<PTT> PTTs) {
        this.PTTs = PTTs;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }


    public List<Requirement> getTeachingRequirements() {
       return requirementList;
    }


    // 创建PTT的方法
    public void createPTT() {
        // 实现创建PTT的逻辑
    }

    public void updateRequirementList(int updateNumber, Requirement Requirement) {
        requirementList.set(updateNumber, Requirement);
    }

    public void addRequirement(Requirement requirement) {
        if (requirement.getMajorLevel() >= 0 && requirement.getMajorLevel() < 4) {
            requirementList.add(requirement);
        }
    }

    public void addAdministrator(Administrator administrator) {
        administrators.add(administrator);

    }

    public void addDirector(Director director) {
        directors.add(director);
    }

    public void addPTT(PTT ptt) {
        PTTs.add(ptt);
    }

    public Director directorLogin(int id, String password,DataModel dataModel){
        for (Director director : directors) {
            if(director.getUserId()==id && director.getPassword().equals(password)){
                return director;
            }
        }
        return null;
    }
    public Administrator administratorLogin(int id, String password,DataModel dataModel){
        for (Administrator administrator : administrators) {
            if(administrator.getUserId()==id && administrator.getPassword().equals(password)){
                return administrator;
            }
        }
        return null;
    }
    

    public PTT getPttById(int id){
        for (PTT ptt : PTTs) {
            if(ptt.getID()==id){
                return ptt;
            }
        }
        return null;
    }

    public List<PTT> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(List<PTT> trainingList) {
        this.trainingList = trainingList;
    }
}

