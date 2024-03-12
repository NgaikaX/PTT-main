import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileManager {
    private String requirementsFilePath;
    private String usersFilePath;
    private String pttsFilePath;

    public FileManager(String requirementsFilePath, String usersFilePath, String pttsFilePath) {
        this.requirementsFilePath = requirementsFilePath;
        this.usersFilePath = usersFilePath;
        this.pttsFilePath = pttsFilePath;
    }

    // 从文件加载数据到DataModel
    public void loadRequirementData(DataModel dataModel) {
        try (BufferedReader reader = new BufferedReader(new FileReader(requirementsFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                dataModel.addRequirement(new Requirement(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Boolean.parseBoolean(parts[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUesrData(DataModel dataModel) {
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts[2].equals("Administrator")) {
                    dataModel.addAdministrator(new Administrator(Integer.parseInt(parts[0]), parts[1]));
                } else if (parts[2].equals("Director")) {
                    dataModel.addDirector(new Director(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPttData(DataModel dataModel) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pttsFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                dataModel.addPTT(new PTT(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 将DataModel的数据保存到文件
    public void saveData(DataModel model) {
        // 实现将数据保存到文件的逻辑
    }
}
