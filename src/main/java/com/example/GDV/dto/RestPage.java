package com.example.GDV.dto;

import java.util.List;
import lombok.Data;
import org.springframework.data.domain.Page;

/**
 *
 * @author dilatali
 */

@Data
public class RestPage {

    List data;

    int nbElements=0;
    long totalElements=0;

    int pageSize=0;
    int page=0;
    int totalPage=0;

    public RestPage(Page page) {

        nbElements = page.getNumberOfElements();

        totalElements= page.getTotalElements();

        this.page=page.getNumber()>page.getTotalPages()? 1 :page.getNumber() +1;

        pageSize=page.getSize();

        totalPage=page.getTotalPages();

    }
}

