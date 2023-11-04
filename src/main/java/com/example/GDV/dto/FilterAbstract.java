package com.example.GDV.dto;

import lombok.Data;

@Data
public abstract class  FilterAbstract {

    private int page=0;

    private int limit=5;
}
