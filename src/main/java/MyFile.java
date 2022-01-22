import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.xml.namespace.QName;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MyFile {
    public static void main(String[] args) throws IOException, ParseException {
        MyFile o=new MyFile();
        o.writeData();
        o.readFile();

        o.readJSONFile();
        o.writeJSONFile();
        o.updateJSON("name","sohel");


        o.writeJSONArray();
        o.readJsonArray(0);
        o.updateJSONArray(0,"name","helal");
        o.deleteJSONArray(0);

        }
         public static void writeData(){
            try {
                FileWriter fw = new FileWriter("MyFile.txt", true);
                fw.write("Hello World");
                fw.write("\r\n");   // write new line
                fw.write("Hello Java!");
                fw.write("\r\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    public static void readFile() throws IOException {
        FileReader reader = new FileReader("MyFile.txt");
        int character;
        while ((character = reader.read()) != -1) {
            System.out.print((char) character);
        }
        reader.close();
    }

    public static void writeJSONFile() throws IOException {
        JSONObject empObj=new JSONObject();
        empObj.put("name","Mr. Shajib");
        empObj.put("Department","IT");
        empObj.put("Designation","Software Engineer");
        JSONObject addressObj=new JSONObject();
        addressObj.put("present_address","Badda,Gulshan-1");
        addressObj.put("PO","Gulshan");
        addressObj.put("Area","Gulshan-1");
        empObj.put("address",addressObj);
        empObj.put("phone_number","01620141540");
        FileWriter file = new FileWriter("./src/main/resources/Employee.json");
        file.write(empObj.toJSONString());
        file.flush();
        System.out.print(empObj);
    }

    public static void readJSONFile() throws IOException, ParseException{
        try{
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("./src/main/resources/Employee.json"));
            JSONObject empObj = (JSONObject) obj;

            System.out.println(empObj);
            String name = (String) empObj.get("name");
            System.out.println(name);
            String department = (String) empObj.get("Department");
            System.out.println(department);
            String designation = (String) empObj.get("Designation");
            System.out.println(designation);

            JSONObject addressObj = (JSONObject) empObj.get("address");
            String area=(String) addressObj.get("Area");
            System.out.println(area);
            String po=(String) addressObj.get("PO");
            System.out.println(po);
            String present_address=(String) addressObj.get("present_address");
            System.out.println(present_address);

            String phone_number = (String) empObj.get("phone_number");
            System.out.println(phone_number);
        }
        catch (Exception e){

        }


    }

    public static void updateJSON(String key, String value) {
        try{
            String fileName="./src/main/resources/Employee.json";
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONObject empObj = (JSONObject) obj;
            System.out.println(empObj);
            empObj.put(key,value);
            FileWriter file = new FileWriter(fileName);
            file.write(empObj.toJSONString());
            file.flush();
            file.close();
            System.out.println("Updated!");
            System.out.print(empObj);
        }
        catch (Exception e){

        }
    }




    //JSON List
    public static void writeJSONArray(){
        try{
            char ch='y';
            String fileName="./src/main/resources/Student.json";
            do {
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(new FileReader(fileName));
                JSONObject studentObj = new JSONObject();

                Scanner input = new Scanner(System.in);
                System.out.println("Input student ID: ");
                studentObj.put("id", input.next());
                System.out.println("Input student name: ");
                studentObj.put("name", input.next());
                System.out.println("Input Department ");
                studentObj.put("department", input.next());

                JSONArray jsonArray = (JSONArray) obj;
                jsonArray.add(studentObj);
                System.out.print(jsonArray);
                FileWriter file = new FileWriter(fileName);
                file.write(jsonArray.toJSONString());
                file.flush();
                file.close();
                System.out.println("Saved!");
                System.out.print(jsonArray);
                System.out.println("\nDo you want to add more?[y/n]");
                ch=input.next().charAt(0);

            }
            while(ch!='n');
        }
        catch (Exception e){

        }


    }
 //JSON List
    public static void  readJsonArray(int ListPossition){
        try{
            String fileName="./src/main/java/resources/Student.json";
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONArray jsonArray = (JSONArray) obj;
            System.out.println(jsonArray);
            JSONObject json = (JSONObject) jsonArray.get(ListPossition);


            String name = (String) json.get("name");
            String roll = (String) json.get("roll");
            String section = (String) json.get("section");
            String _class = (String) json.get("class");
            System.out.println(name);
            System.out.println(roll);
            System.out.println(section);
            System.out.println(_class);

        }
        catch (Exception e){

        }
    }
    //JSON List
    public static void updateJSONArray(int index, String key, String value)  {
      try{
          String fileName="./src/main/java/resources/Student.json";
          JSONParser jsonParser = new JSONParser();
          Object obj = jsonParser.parse(new FileReader(fileName));
          JSONArray jsonArray = (JSONArray) obj;
          JSONObject jsonObject = (JSONObject) jsonArray.get(index);
          jsonObject.put(key, value);
          FileWriter file = new FileWriter(fileName);
          file.write(jsonArray.toJSONString());
          file.flush();
          file.close();
          System.out.println("Updated!");
          System.out.print(jsonArray);
      }
      catch (Exception e){

      }
    }


    //JSON List
    public static void deleteJSONArray(int index)  {
        try{
            String fileName="./src/main/java/resources/Student.json";
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONArray jsonArray = (JSONArray) obj;
            jsonArray.remove(index);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Deleted!");
            System.out.print(jsonArray);
        }
        catch (Exception e){

        }
    }



}

