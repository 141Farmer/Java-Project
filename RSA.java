import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA 
{
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    public RSA(int bits) 
    {
        generateKeys(bits);
    }

    public void generateKeys(int bits) 
    {
        SecureRandom random=new SecureRandom();
        BigInteger p=new BigInteger(bits,100,random);
        BigInteger q = new BigInteger(bits,100,random);

        modulus=p.multiply(q);
        BigInteger phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); // phi=(p-1)*(q-1)

        publicKey=new BigInteger("65537"); 
        privateKey=publicKey.modInverse(phi); // d = n^-1 % phi
    }

    public BigInteger encrypt(BigInteger message) 
    {
        return message.modPow(publicKey,modulus); // c = m ^ pubkey mod n
    }

    public BigInteger decrypt(BigInteger ciphertext) 
    {
        return ciphertext.modPow(privateKey,modulus); // m = c ^ privkey(d) mod n
    }

    public byte[] textToBytes(String text)
    {
        return text.getBytes();
    }

    public String bytesToNum(byte[] bytes)
    {
        return new BigInteger(bytes);
    } 

    public String encrypt(String plaintext) 
    {
        BigInteger encrypted=encrypt(bytesToNum(textToBytes(plaintext)));
        return encrypted.toString();
    }

    public String decrypt(String ciphertext) 
    {
        BigInteger decrypted=decrypt(new BigInteger(ciphertext));
        return new String(decrypted.toByteArray());
    }
}
