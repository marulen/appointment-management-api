package com.marulen.appointment.model;

public class Client {
    
    private final String name;
    private final String email;

    public Client(String name, String email) {
        validateRequiredText(name, "Name");
        validateRequiredText(email, "Email");

        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private static void validateRequiredText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or blank");
        }

    }
}
