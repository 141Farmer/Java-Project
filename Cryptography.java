import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cryptography 
{
    public void consoleClear()
    {
        for(int i=0;i<54;i++) 
        {
            System.out.println(); 
        }
    }



    public String readInput()
    {
        FileHand file=new FileHand();
        System.out.println("Enter file name of where to read from");
        String filename=(new Scanner(System.in)).nextLine();
        String plaintext=file.readFromFile(filename);
        System.out.println("Plain text in the file is: "+plaintext);
        return plaintext;
    }

    public String writeInput()
    {
        System.out.println("Enter filename of where to save file");
        String destfilename=(new Scanner(System.in)).nextLine();
        return destfilename;
    }


    public Cryptography()
    {
        consoleClear();
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
            int choice=-1;
            try
            {
                choice=scanner.nextInt(); 
            }
            catch(Exception e)
            {
                System.out.println("Invalid choice");
                continue;
            }
            if(choice==1)
            {
                FileHand file=new FileHand();
                String plaintext=readInput();
                if(plaintext==null) continue;

                System.out.println("Enter shift of position for encryption");
                int shift;
                try
                {
                    shift=(new Scanner(System.in)).nextInt();
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                CaesarCipher caesarCipher=new CaesarCipher(shift);
                String ciphertext=caesarCipher.encode(plaintext);

                if((file.writeToFile(writeInput(),ciphertext))==-1) continue;
            }
            else if(choice==2)
            {
                FileHand file=new FileHand();
                String plaintext=readInput();
                if(plaintext==null) continue;

                System.out.println("Enter shift of position for decryption");
                int shift;
                try
                {
                    shift=(new Scanner(System.in)).nextInt();
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                CaesarCipher caesarCipher=new CaesarCipher(shift);
                String ciphertext=caesarCipher.decode(plaintext);

                if((file.writeToFile(writeInput(),ciphertext))==-1) continue;

            }
            else if(choice==3)
            {
                FileHand file=new FileHand();
                String plaintext=readInput();
                if(plaintext==null) continue;

                System.out.println("Enter key of text for encryption");
                String key;
                try
                {
                    key=(new Scanner(System.in)).nextLine();
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                VigenereCipher vigenereCipher=new VigenereCipher(key);
                String ciphertext=vigenereCipher.encode(plaintext);

                if((file.writeToFile(writeInput(),ciphertext))==-1) continue;

            }
            else if(choice==4)
            {
                FileHand file=new FileHand();
                String plaintext=readInput();
                if(plaintext==null) continue;

                System.out.println("Enter key of text for decryption");
                String key;
                try
                {
                    key=(new Scanner(System.in)).nextLine();
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                VigenereCipher vigenereCipher=new VigenereCipher(key);
                String ciphertext=vigenereCipher.decode(plaintext);

                if((file.writeToFile(writeInput(),ciphertext))==-1) continue;
            }
            else if(choice==5)
            {
                FileHand file=new FileHand();
                String plaintext=readInput();
                if(plaintext==null) continue;

                System.out.println("Enter key of text for encryption");
                String key;
                try
                {
                    key=(new Scanner(System.in)).nextLine();
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                XorCipher xorCipher=new XorCipher(key);
                String ciphertext=xorCipher.encode(plaintext);

                if((file.writeToFile(writeInput(),ciphertext))==-1) continue;
            }
            else if(choice==6)
            {
                FileHand file=new FileHand();
                String plaintext=readInput();
                if(plaintext==null) continue;

                System.out.println("Enter key of text for decryption");
                String key;
                try
                {
                    key=(new Scanner(System.in)).nextLine();
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                XorCipher xorCipher=new XorCipher(key);
                String ciphertext=xorCipher.decode(plaintext);

                if((file.writeToFile(writeInput(),ciphertext))==-1) continue;
            }
            else if(choice==7)
            {
                FileHand file=new FileHand();
                String plaintext=readInput();
                if(plaintext==null) continue;

                System.out.println("Enter public key for encryption");
                String publicKey;
                try
                {
                    publicKey=(new Scanner(System.in)).nextLine();
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                RSA rsa=new RSA(publicKey);
                String ciphertext=rsa.encodeMessage(plaintext);
                //String n=rsa.

                if((file.writeToFile(writeInput(),ciphertext))==-1) continue;
            }
            else if(choice==8)
            {
                FileHand file=new FileHand();
                String plaintext=readInput();
                if(plaintext==null) continue;

                System.out.println("Enter public key for decryption");
                String publicKey;
                try
                {
                    publicKey=(new Scanner(System.in)).nextLine();
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }
                RSA rsa=new RSA(publicKey);
                String ciphertext=rsa.decodeMessage(plaintext);

                if((file.writeToFile(writeInput(),ciphertext))==-1) continue;
            }
            else if(choice==9) 
            {
                System.out.println("Exiting system");
                consoleClear();
                break;
            }
            else
            {
                System.out.println("Invalid choice");
            }
            
            
        }
    }
}
