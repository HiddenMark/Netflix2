package com.everis.d4i.tutorial.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmRest implements Serializable {

    private static final long serialVersionUID = 3045052550331442918L;

    private Long id;

    private String name;

    private String language;

    private String shortDescription;

    private String longDescription;

    private Integer year;

    private Integer duration;

}