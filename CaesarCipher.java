import java.util.ArrayList;

public class CaesarCipher implements Cryption
{
    private int shift;

    public CaesarCipher(int shift) 
    {
        this.shift=shift;
    }
    
    public String encode(String text) 
    {
        StringBuilder result=new StringBuilder();
        int len=text.length();
        for(int i=0;i<len;i++) 
        {
            char c=text.charAt(i);
            if(Character.isLetter(c)) 
            {
                char base=Character.isUpperCase(c) ? 'A' : 'a';
                char encodedChar=(char)((c-base+shift)%26+base);
                result.append(encodedChar);
            } 
            else 
            {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    public String encode(String text, int shift) 
    {
        this.shift = shift;
        return encode(text);
    }

    public String decode(String text) 
    {
        return encode(text,26-shift);
    }

    public ArrayList<String> bruteForceDecode(String text)
    {
        ArrayList<String> texts=new ArrayList<String>();
        for(int i=0;i<26;++i)
        {
            texts.add(encode(text,i));
        }
        return texts;
    }
}
