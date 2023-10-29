public class VigenereCipher 
{
    private String key;
    public VigenereCipher(String key) 
    {
        this.key = key;
    }
    public String encode(String text) 
    {
        StringBuilder result=new StringBuilder();
        int keyLength=key.length();
        int len=text.length();
        for (int i=0;i<len;i++) 
        {
            char plainChar=text.charAt(i);
            if(Character.isLetter(plainChar)) 
            {
                char keyChar=key.charAt(i%keyLength);
                int shift=Character.toUpperCase(keyChar)-'A';
                char encodedChar=shiftChar(plainChar,shift);
                result.append(encodedChar);
            } 
            else 
            {
                result.append(plainChar);
            }
        }
        return result.toString();
    }
    public String decode(String text) 
    {
        StringBuilder result=new StringBuilder();
        int keyLength=key.length();
        int len=text.length();
        for (int i = 0;i<len;i++) 
        {
            char encodedChar=text.charAt(i);
            if(Character.isLetter(encodedChar)) 
            {
                char keyChar=key.charAt(i%keyLength);
                int shift=Character.toUpperCase(keyChar)-'A';
                char plainChar=shiftChar(encodedChar,-shift);
                result.append(plainChar);
            } 
            else 
            {
                result.append(encodedChar);
            }
        }
        return result.toString();
    }
    private char shiftChar(char c,int shift) 
    {
        char base=Character.isUpperCase(c) ? 'A' : 'a';
        return (char)((c-base+shift+26)%26+base);
    }
}

// Usage:
// VigenereCipher cipher = new VigenereCipher("KEY");
// String encodedText = cipher.encode("Hello, World!");
// String decodedText = cipher.decode(encodedText);
