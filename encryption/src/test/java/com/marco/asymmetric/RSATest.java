package com.marco.asymmetric;

import org.junit.jupiter.api.Test;

import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RSATest {

    @Test
    void testVerifySuccess() throws Exception {
        // Given
        KeyPair keypair = RSA.generateKeyPair();
        String originalText = "this is RSA";

        // When
        byte[] encryptedData = RSA.encrypt(originalText, keypair.getPublic());
        String decryptedText = RSA.decrypt(encryptedData, keypair.getPrivate());

        // Then
        assertEquals(originalText, decryptedText);
    }

    @Test
    void testVerifyFailed() throws Exception {
        // Given
        KeyPair keypair = RSA.generateKeyPair();
        String originalText = "this is RSA";
        String wrongText = "this is not RSA";

        // When
        byte[] encryptedData = RSA.encrypt(originalText, keypair.getPublic());
        String decryptedText = RSA.decrypt(encryptedData, keypair.getPrivate());

        // Then
        assertNotEquals(wrongText, decryptedText);
    }
}
