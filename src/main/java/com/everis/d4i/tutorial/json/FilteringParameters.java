package com.everis.d4i.tutorial.json;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FilteringParameters {

    String name;

    Integer year;

    String country;

    List<String> languages;

    Integer category;

    List<String> subcategories;

    Integer minimumDuration;
}
