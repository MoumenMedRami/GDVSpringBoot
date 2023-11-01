package com.example.GDV.handlers;


import com.example.GDV.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


//// calas de securité intercepté tous les exeption de rementer au frontend pour evité le piratage

@Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class ErrorDto {

        private Integer httpCode;

        private ErrorCodes code;

        private String message;

        private List<String> errors = new ArrayList<>();

    }
