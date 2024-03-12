public class Main {
    public static void main(String[] args) {
        DataModel dataModel=new DataModel();
        new FileManager().readData(dataModel);
        Homepage.LoginPage(dataModel);
    }
}
