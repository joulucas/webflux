package com.webflux.rickandMorty.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import java.util.List;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class EpisodeResponse {

    private String id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String url;
    
}
