import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class deleteDuplicityData {
    public static void main(String[] args) {
        String inputFile = System.getProperty("user.dir")+"/src/main/java/csvInput.csv";
        String outputFile = System.getProperty("user.dir")+"/src/main/java/csvOutput.csv";

        try {
            Set<String> uniqueData = new HashSet<>();
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            String line;

            while ((line = reader.readLine())!= null){
                String [] data = line.split(";");
                String uniqueData2 = data[0].trim();

                if (!uniqueData.contains(uniqueData2)){
                    writer.write(line);
                    writer.newLine();
                    uniqueData.add(uniqueData2);
                }
            }
            reader.close();
            writer.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
