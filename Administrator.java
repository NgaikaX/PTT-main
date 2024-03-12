import java.util.List;

public class Administrator extends User  {
    public Administrator(int userId, String password) {
        super(userId, password);
    }

    public void update(){
        System.out.println("Teaching requirement changes");
    }

    public List<String> getNotification(List<String>teachingRequirement){
        return teachingRequirement;
    }


}
