import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileManager {

    private String FilePath = "Data.txt";


    // 从文件加载数据到DataModel

    public void readData(DataModel dataModel) {
        //DataModel dataModel = new DataModel();

        try (BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                String type = data[0].trim();

                if (type.equals("Director")) {
                    dataModel.addDirector(new Director(Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3])));
                } else if (type.equals("Administrator")) {
                    dataModel.addAdministrator(new Administrator(Integer.parseInt(data[1]), data[2]));
                } else if (type.equals("PTT")) {
                    dataModel.addPTT(new PTT(Integer.parseInt(data[1]), data[2], data[3], Integer.parseInt(data[4])));
                } else if (type.equals("Requirement")) {
                    dataModel.addRequirement(new Requirement(Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Boolean.parseBoolean(data[5])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void saveData(DataModel dataModel) {
        List<User> administratorInfo = new ArrayList<>();
        List<Director> directorInfo = new ArrayList<>();
        List<PTT> pttsInfo = new ArrayList<>();
        List<Requirement> requirementsInfo = new ArrayList<>();
        //dataModel.getUserList();
        dataModel.getDirectors();
        dataModel.getPTTs();
        dataModel.getRequirementList();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath))) {
            // Write users
            for (User user : administratorInfo) {
                if (user.getRole().equals("Administrator")) {
                    String userData = "User, " + user.toString();
                    writer.write(userData);
                    writer.newLine();
                }
            }

            // Write directors
            for (Director director : directorInfo) {
                String directorData = "Director, " + director.toString();
                writer.write(directorData);
                writer.newLine();
            }

            // Write PTTs
            for (PTT ptt : pttsInfo) {
                String pttData = "Ptt, " + ptt.toString();
                writer.write(pttData);
                writer.newLine();
            }

            // Write requirements
            for (Requirement requirement : requirementsInfo) {
                String requirementData = "Requirement, " + requirement.toString();
                writer.write(requirementData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            return;
        }
        System.out.println("Data saved successfully.");
    }


}


