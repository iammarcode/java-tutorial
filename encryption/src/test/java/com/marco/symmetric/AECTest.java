package com.marco.symmetric;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class AECTest {
    @Test
    public void testVerifySuccess() throws Exception {
        // Given
        String originalText = "This is Marco";
        IvParameterSpec ivParameterSpec = AEC.generateIv();
        SecretKey secretKey = AEC.generateKey();

        // When
        byte[] cipherText = AEC.encrypt(originalText, secretKey, ivParameterSpec);
        String decryptText = AEC.decrypt(cipherText, secretKey, ivParameterSpec);

        // Then
        assertEquals(originalText, decryptText);
    }

    @Test
    public void testVerifyFailed() throws Exception {
        // Given
        String originalText = "This is Marco";
        String wrongText = "This is not Marco";
        IvParameterSpec ivParameterSpec = AEC.generateIv();
        SecretKey secretKey = AEC.generateKey();

        // When
        byte[] cipherText = AEC.encrypt(originalText, secretKey, ivParameterSpec);
        String decryptText = AEC.decrypt(cipherText, secretKey, ivParameterSpec);

        // Then
        assertNotEquals(wrongText, decryptText);
    }

    @Test
    public void testSecretKeyUnique() throws Exception {
        // Given
        String secretKey1 = Base64.getEncoder().encodeToString(AEC.generateKey().getEncoded());
        String secretKey2 = Base64.getEncoder().encodeToString(AEC.generateKey().getEncoded());

        // When & Then
        assertNotEquals(secretKey1, secretKey2);
    }

    @Test
    public void testVIUnique() throws Exception {
        // Given
        String IV1 = Base64.getEncoder().encodeToString(AEC.generateIv().getIV());
        String IV2 = Base64.getEncoder().encodeToString(AEC.generateIv().getIV());

        // When & Then
        assertNotEquals(IV1, IV2);
    }
}
