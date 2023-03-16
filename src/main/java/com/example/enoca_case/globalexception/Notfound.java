package com.example.enoca_case.globalexception;

import jakarta.persistence.EntityNotFoundException;

public class Notfound extends EntityNotFoundException {
        public Notfound(String message) {
            super(message);

    }

}
