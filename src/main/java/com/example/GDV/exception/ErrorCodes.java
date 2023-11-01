package com.example.GDV.exception;

public enum ErrorCodes {

    UTILISATEUR_NOT_FOUND(1000),
    UTILISATEUR_NOT_VALID(1001),
    UTILISATEUR_ALREADY_IN_USE(1002),

    CHAUFFEUR_NOT_FOUND(2000),
    CHAUFFEUR_NOT_VALID(2001),
    CHAUFFEUR_ALREADY_IN_USE(2002),

    DEMANDE_NOT_FOUND(3000),
    DEMANDE_NOT_VALID(3001),
    DEMANDE_ALREADY_IN_USE(3002),

    REPONSE_NOT_FOUND(4000),
    REPONSE_NOT_VALID(4001),
    REPONSE_NON_MODIFIABLE(4002),
    REPONSE_ALREADY_EXISTS(4003),


    // Liste des exception techniaues
    UPDATE_PHOTO_EXCEPTION(14000),
    UNKNOWN_CONTEXT(14001);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }


}
