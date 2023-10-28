public class XorCipher 
{
    private String key;

    public XorCipher(String key) 
    {
        this.key = key;
    }

    public String encrypt(String plaintext) 
    {
        StringBuilder ciphertext=new StringBuilder();
        int len=plaintext.length();
        for (int i=0;i<len;i++) 
        {
            char plainChar=plaintext.charAt(i);
            char keyChar=key.charAt(i%key.length());
            char encryptedChar=(char)(plainChar^keyChar);
            ciphertext.append(encryptedChar);
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) 
    {
        return encrypt(ciphertext); 
    }
}

// Usage:
// XorCipher cipher = new XorCipher("SECRET_KEY");
// String encryptedText = cipher.encrypt("Hello, World!");
// String decryptedText = cipher.decrypt(encryptedText);
