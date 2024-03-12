public class Requirement {
    int classNumber;
    String major;
    int majorLevel;//divide into 3 levels: 1/2/3
    int PTTNumber;
    private boolean assigned;

    public Requirement(int classNumber, String major, int majorLevel, int PTTNumber, boolean assigned) {
        this.classNumber = classNumber;
        this.major = major;
        this.majorLevel = majorLevel;
        this.PTTNumber = PTTNumber;
        this.assigned = assigned;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getMajorLevel() {
        return majorLevel;
    }

    public void setMajorLevel(int majorLevel) {
        this.majorLevel = majorLevel;
    }

    public int getPTTNumber() {
        return PTTNumber;
    }

    public void setPTTNumber(int PTTNumber) {
        this.PTTNumber = PTTNumber;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    @Override
    public String toString() {
        return "classNumber=" + classNumber +
                ", major=" + major +
                ", majorLevel=" + majorLevel +
                ", PTTNumber=" + PTTNumber +
                ", assigned=" + assigned;
    }
}
