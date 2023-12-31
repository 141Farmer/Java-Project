import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.logging.FileHandler;

public class FileHand 
{

    public int writeToFile(String fileName, String content) 
    {
        try(FileWriter fileWriter=new FileWriter(fileName);BufferedWriter bufferedWriter=new BufferedWriter(fileWriter)) 
        {
            bufferedWriter.write(content);
            System.out.println("Data has been written to the file: "+fileName);
            return 0;
        } 
        catch (Exception e) 
        {
            System.err.println("Error writing to the file: "+ e.getMessage());
            return -1;
        }
    }

    public String readFromFile(String fileName) 
    {
        try(FileReader fileReader=new FileReader(fileName);BufferedReader bufferedReader=new BufferedReader(fileReader)) 
        {
            StringBuilder content=new StringBuilder();
            String line;
            while((line=bufferedReader.readLine())!=null) 
            {
                content.append(line).append("\n");
            }
            return content.toString();
        } 
        catch (IOException e) 
        {
            System.err.println("Error reading from the file: " + e.getMessage());
            return null;
        }
    }
}
