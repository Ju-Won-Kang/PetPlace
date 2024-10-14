package com.petplace.common;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

import com.google.common.hash.Hashing;

/**
 * packageName    : com.petplace.common
 * fileName       : ShaUtil
 * author         : jun
 * date           : 2024. 10. 4.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 4.        jun       최초 생성
 */
public class ShaUtil {

    public static String getSalt(){
        SecureRandom random =  new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    public static String sha256WithSaltEncode(String plainText, String salt){
        return Hashing.sha256().hashString(plainText + salt, StandardCharsets.UTF_8).toString();
    }
}
