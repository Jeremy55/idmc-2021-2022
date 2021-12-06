package fr.unilorraine.idmc.gamescatalog.core;

import lombok.SneakyThrows;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Locale;

public class SHA256Checker implements PasswordChecker {

    @SneakyThrows
    public SHA256Checker(){
        MessageDigest.getInstance("SHA-256");
    }

    @SneakyThrows
    public boolean areEqual(String password, String hash){
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(hash.getBytes());
        byte[] digest = md.digest();
        String targetEnc = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return password.equalsIgnoreCase(targetEnc);
    }
}
