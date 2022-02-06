package com.webflux.rickandMorty.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import java.util.List;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class CharacterResponse {

    private String id;
    private String name;
    private String status;
    private String species;
    private String image;
    private List<String> episode;
    
}
