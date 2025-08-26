import javax.crypto.Cipher; // For encryption and decryption operations
import javax.crypto.spec.SecretKeySpec; // For creating a key specification from a byte array
import java.util.Base64; // For encoding/decoding binary data to/from Base64 strings
public class SimpleAES {
 public static void main(String[] args) throws Exception {
 // Define a 16-byte secret key (AES-128 requires 16 bytes)
 String key = "1234567890123456";
 // Message to encrypt
 String message = "Hello AES!";
 // Create AES key from the string
 SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
 // Get Cipher instance for AES with ECB mode and PKCS5 padding
 Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
 // Initialize cipher in ENCRYPT_MODE with the secret key
 cipher.init(Cipher.ENCRYPT_MODE, secretKey);
 // Encrypt the message and encode it as Base64 to make it readable
 String encrypted = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes()));
 // Re-initialize the cipher in DECRYPT_MODE with the same secret key
 cipher.init(Cipher.DECRYPT_MODE, secretKey);
 // Decrypt the Base64-encoded ciphertext back into a readable string
 String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
 // Print the encrypted and decrypted strings
 System.out.println("Encrypted: " + encrypted);
 System.out.println("Decrypted: " + decrypted);
 }
}