package com.marulen.appointment.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientTest {
    
    @Test
    void shouldCreateClientWithValidData() {
        Client client = new Client("John Smith", "john@example.com");
        assertEquals("John Smith", client.getName());
        assertEquals("john@example.com", client.getEmail());
    }

    @ParameterizedTest
    @NullAndEmptySource 
    @ValueSource(strings = {" "}) 
    void shouldRejectInvalidName(String name) {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> new Client(name, "john@example.com")
        );
        assertEquals("Name cannot be null or blank", exception.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource 
    @ValueSource(strings = {" "})
    void shouldRejectInvalidEmail(String email) {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> new Client("John Smith", email)
        );
        assertEquals("Email cannot be null or blank", exception.getMessage());
    }

}
