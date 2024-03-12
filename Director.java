public class Director extends User{
    private int classNumber;
    public Director(int userId, String password,int classNumber) {
        super(userId, password);
        this.classNumber=classNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}
