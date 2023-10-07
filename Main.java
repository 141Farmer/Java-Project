import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        /*
        String text;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the text to decrypt or encrypt");
        text=sc.nextLine();
        */



        String text="Hello4 , Universe I am Lords_Association !";
        System.out.println(text);

        CaesarCipher crypt1=new CaesarCipher(text);
        String encrypted_Text=crypt1.encrypt(6);
        System.out.println(encrypted_Text);

        CaesarCipher crypt2=new CaesarCipher(encrypted_Text);
        String decrypted_text=crypt2.decrypt(6);
        System.out.println(decrypted_text);
    }
    
}
