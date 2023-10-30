public class XorCipher 
{
    private String key;

    public XorCipher(String key) 
    {
        this.key=key;
    }

    public String encode(String plaintext) 
    {
        StringBuilder ciphertext=new StringBuilder();
        int len=plaintext.length();
        for (int i=0;i<len;++i) 
        {
            char plainChar=plaintext.charAt(i);
            char keyChar=key.charAt(i%key.length());
            char encryptedChar=(char)(plainChar^keyChar);
            ciphertext.append(encryptedChar);
        }
        return ciphertext.toString().substring(0,len);
    }

    public String decode(String ciphertext) 
    {
        return encode(ciphertext); 
    }
}

