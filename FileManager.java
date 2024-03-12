import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    /*public void saveData(DataModel model) {
        // 实现将数据保存到文件的逻辑
    }*/

    ///////////DataAccess///////
    String file = "Data.txt";

    public void readData(DataModel dataModel){
        //DataModel dataModel = new DataModel();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0].trim();

                // If the data type is "User"
                if (type.equals("User")) {
                    String role = data[1].trim();
                    int id = Integer.parseInt(data[2].trim());
                    String password = data[3].trim();
                    if(role.equals("PTT")){
                        String major = data[4].trim();
                        int majorLevel = Integer.parseInt(data[5].trim());
                        boolean needTraining = Boolean.parseBoolean(data[6].trim());
                        PTT user = new PTT(id,password,major,majorLevel,needTraining);//TODO:need to change PTT
                        dataModel.addPTT(user);
                        //dataModel.addUser(user);
                    } else if(role.equals("Director")) {
                        int classNumber = Integer.parseInt(data[4].trim());
                        Director user = new Director(id, password,classNumber);
                        dataModel.addDirector(user);
                        //dataModel.addUser(user);
                    } else{
                        Administrator user = new Administrator(id,password);
                        //dataModel.addUser(user);
                    }
                } else if (type.equals("Requirement")) {
                    int classNumber = Integer.parseInt(data[1].trim());
                    String major = data[2].trim();
                    int majorLevel = Integer.parseInt(data[3].trim());
                    int PTTNumber = Integer.parseInt(data[4].trim());
                    dataModel.addRequirement(new Requirement(classNumber, major, majorLevel, PTTNumber));//TODO:need to check with requirement
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    public void saveData(DataModel dataModel){
        List<User> administratorInfo = new ArrayList<>();
        List<Director> directorInfo = new ArrayList<>();
        List<PTT> pttsInfo = new ArrayList<>();
        List<Requirement> requirementsInfo = new ArrayList<>();
        //dataModel.getUserList();
        dataModel.getDirectors();
        dataModel.getPTTs();
        dataModel.getRequirementList();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Write users
            for (User user : administratorInfo) {
                if(user.getRole().equals("Administrator")) {
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


