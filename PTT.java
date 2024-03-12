import java.util.ArrayList;
import java.util.List;

public class PTT {
    private int ID;
    private String major;//Chinese Math English
    private int majorLevel;
    private int classNumber;
    private boolean needTraining;


    public PTT(int ID, String major, int majorLevel) {
        this.ID = ID;
        this.major = major;
        this.majorLevel = majorLevel;
        // the teacher need training if not at max skill level at 5
        this.needTraining = (majorLevel < 5);
    }

    // Getters and setters for each ptt part


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getMajorLevelLevel() {
        return majorLevel;
    }

    public void setMajorLevel(int majorLevel) {
        this.majorLevel = majorLevel;
        this.needTraining = (majorLevel < 5);
    }

    public int getMajorLevel() {
        return majorLevel;
    }

    public void setNeedTraining(boolean needTraining) {
        this.needTraining = needTraining;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public boolean isNeedTraining() {
        return needTraining;
    }

    @Override
    public String toString() {
        return "PTT{" +
                "ID=" + ID +
                ", major=" + major  +
                ", majorLevel=" + majorLevel +
                ", classNumber=" + classNumber +
                ", needTraining=" + needTraining +
                '}';
    }
}

