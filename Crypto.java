import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {

    static void encryptData(int cipherMode,String key,String inputString,File outputFile){
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);

            byte[] outputBytes = cipher.doFinal(inputString.getBytes());

            FileOutputStream outputStream = new FileOutputStream(outputFile, true);
            outputStream.write(outputBytes);
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException e) {
            e.printStackTrace();
        }

    }

    static void decryptFile(int cipherMode,String key,File inputFile,File outputFile){
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String key = "xsdertyuop123654";
        File encryptedFile = new File("C://workspace//text.encrypted");
        File decryptedFile = new File("C://workspace//decrypted-text.txt");

        try {
           Crypto.encryptData(Cipher.ENCRYPT_MODE,key,"2nd encryption ",encryptedFile);

            Crypto.decryptFile(Cipher.DECRYPT_MODE,key,encryptedFile,decryptedFile);
            System.out.println("File decrypted succefully");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}