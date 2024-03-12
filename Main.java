public class Main {
    public static void main(String[] args) {
        DataModel dataModel=new DataModel();
        FileManager fileManager = new FileManager("requirements.txt", "user.txt", "PTTs.txt");

        fileManager.loadRequirementData(dataModel);
        fileManager.loadUesrData(dataModel);
        fileManager.loadPttData(dataModel);

        Homepage.LoginPage(dataModel);
    }
}
