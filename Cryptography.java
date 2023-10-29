import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class Cryptography {

    public Cryptography()
    {
        Scanner scanner=new Scanner(System.in);

        while (true) 
        {
            System.out.println("Choose an option:");
            System.out.println("1. Caesar Encryption");
            System.out.println("2. Caesar Decryption");
            System.out.println("3. Vigenre Encryption");
            System.out.println("4. Vigenre Decryption");
            System.out.println("5. XOR Encryption");
            System.out.println("6. XOR Decryption");
            System.out.println("7. RSA Encryption");
            System.out.println("8. RSA Decryption");
            System.out.println("9. Exit");
            int choice;
            try
            {
                choice=scanner.nextInt(); 
                if(choice>9 || choice<1) 
                {
                    System.out.println("Invalid choice");
                    continue;
                }
            }
            catch(Exception e)
            {
                System.out.println("Invalid choice");
                continue;
            }
            if(choice==1)
            {
                FileHand file=new FileHand();
                Scanner fscanner=new Scanner(System.in);

                System.out.println("Enter file name of plaintext:");
                //String filename=fscanner.nextLine();
                String filename="F:\\Java-Project\\first.txt";
                String plaintext=file.readFromFile(filename);
                System.out.println("Plain text in the file is "+plaintext);
                
                System.out.println("Enter shift of position");
                int shift=fscanner.nextInt();
                CaesarCipher caesarCipher=new CaesarCipher(shift);
                String ciphertext=caesarCipher.encode(plaintext);

                System.out.println("Enter filename of where to save decrypted file");
                String destfilename=fscanner.nextLine();
                file.writeToFile(destfilename,ciphertext);
                
                

            }
            
            
        }
    }
}
