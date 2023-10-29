

public class FileHandler 
{

    public static void writeToFile(String fileName, String content) 
    {
        try (FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) 
            {

            bufferedWriter.write(content);
            System.out.println("Data has been written to the file: "+fileName);
        } 
        catch (IOException e) 
        {
            System.err.println("Error writing to the file: "+ e.getMessage());
        }
    }

    public static String readFromFile(String fileName) 
    {
        try (FileReader fileReader=new FileReader(fileName);
            BufferedReader bufferedReader=new BufferedReader(fileReader)) 
            {

            StringBuilder content = new StringBuilder();
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
