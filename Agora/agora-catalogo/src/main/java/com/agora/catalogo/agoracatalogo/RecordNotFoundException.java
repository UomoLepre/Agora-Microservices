package com.agora.catalogo.agoracatalogo;

public class RecordNotFoundException extends Exception {
    public RecordNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}