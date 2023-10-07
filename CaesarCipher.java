import java.util.Scanner;
public class CaesarCipher 
{
    private String text;
    public CaesarCipher()
    {

    }
    public CaesarCipher(String text)
    {
        this.text=text;
    }
    public String encrypt(int key) 
    {
        StringBuilder result=new StringBuilder();
        for (char c:text.toCharArray()) 
        {
            if(Character.isAlphabetic(c)) 
            {
                char base=Character.isUpperCase(c) ? 'A' : 'a';
                c=(char)(base+(c-base+key)%26);
            }
            result.append(c);
        }
        return result.toString();
    }
    public String decrypt(int key) 
    {
        StringBuilder result=new StringBuilder();
        for(char c:text.toCharArray()) 
        {
            if(Character.isAlphabetic(c)) 
            {
                char base=Character.isUpperCase(c) ? 'A' : 'a';
                c=(char)(base+(c-base-key+26)%26);
            }
            result.append(c);
        }
        return result.toString();
    }

    public void CaesarCipherStart() 
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter 'encrypt', 'decrypt', or 'bruteforce': ");
        String choice=scanner.nextLine();
        if (choice.equals("encrypt") || choice.equals("decrypt")) 
        {
            System.out.println("Enter the key to work with");
            int key=(scanner.nextInt());
            if(choice.equals("encrypt")) 
            {
                String encryptedText=encrypt(key);
                System.out.println("Encrypted text: "+encryptedText);
            } 
            else 
            {
                String decryptedText=decrypt(key);
                System.out.println("Decrypted text: "+decryptedText);
            }
        }
        else if(choice.equals("bruteforce")) 
        {
            for (int key=0;key<26;++key) 
            {
                String decryptedText=decrypt(key);
                System.out.println("Key "+key+": "+decryptedText);
            }
        }
        else
        {
            System.out.println("Invalid choice. Please enter 'encrypt', 'decrypt', or 'bruteforce'.");
        }
    }
}
