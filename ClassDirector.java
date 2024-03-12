public class ClassDirector {
    String name;
    private int classNumber;

    public ClassDirector(String name, int classNumber) {
        this.name = name;
        this.classNumber = classNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}
