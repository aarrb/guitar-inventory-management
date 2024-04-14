package edu.iu.aurabaza.Homework2.security;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
//key Generator Utilities
public class KeyGeneratorUtils {
    private KeyGeneratorUtils() {}
    static KeyPair generateRsaKey(){
        KeyPair keyPair;
        //try
        try {
            KeyPairGenerator keyPairGenerator =
                    KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
            //error handling
//catch
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return keyPair;
    }
}