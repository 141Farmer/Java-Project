import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class RSA {
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    public RSA(String publicKey) {
        this.publicKey=new BigInteger(publicKey);
        generateKeys();
    }

    public void generateKeys() 
    {
        SecureRandom random = new SecureRandom();
        BigInteger p = new BigInteger(512, 100, random);
        BigInteger q = new BigInteger(512, 100, random);

        modulus = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        //publicKey = new BigInteger("65537");
        privateKey = publicKey.modInverse(phi);
    }

    public BigInteger encode(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    public BigInteger decode(BigInteger ciphertext) {
        return ciphertext.modPow(privateKey, modulus);
    }

    public byte[] textToBytes(String text) {
        return text.getBytes();
    }

    public String bytesToNum(byte[] bytes) {
        return new BigInteger(bytes);
    }

    /*public String encode(String plaintext) {
        BigInteger encoded = encode(new BigInteger(plaintext));
        return encoded.toString();
    }

    public String decode(String ciphertext) {
        BigInteger decoded = decode(new BigInteger(ciphertext));
        return decoded.toString();
    }*/

    // New methods for encoding and decoding using BigInteger
    public String encodeMessage(String message) {
        BigInteger messageNum = new BigInteger(message.getBytes());
        BigInteger encoded = encode(messageNum);
        return encoded.toString();
    }

    public String decodeMessage(String ciphertext) {
    BigInteger decoded = decode(new BigInteger(ciphertext));
    byte[] bytes = decoded.toByteArray();
    return new String(bytes, StandardCharsets.UTF_8);
}


}
