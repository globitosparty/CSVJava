import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class deleteDuplicityData {
    public static void main(String[] args) {
        //define route of the csvFiles, the System get property get the actual dir of the project, doesn't matter the folder where exist.
        String inputFile = System.getProperty("user.dir")+"/src/main/java/csvInput.csv";
        String outputFile = System.getProperty("user.dir")+"/src/main/java/csvOutput.csv";

        try {
            //define reader and writer to csvFiles and the setData to a csv file Output
            Set<String> uniqueData = new HashSet<>();
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            String line;

            while ((line = reader.readLine())!= null){

                //define the split character separate of a csvInput, and return the output with the same character
                String [] data = line.split(";");

                //delete the blank spaces before and after the text
                String uniqueData2 = data[0].trim();

                if (!uniqueData.contains(uniqueData2)){

                //write the data if not exist in the new csv
                    writer.write(line);
                    writer.newLine();
                    uniqueData.add(uniqueData2);
                }
            }
            //close the reader and the writer
            reader.close();
            writer.close();

        }
        catch (Exception e){
            //shows the issue if exist an error
            e.printStackTrace();
        }
    }
}
