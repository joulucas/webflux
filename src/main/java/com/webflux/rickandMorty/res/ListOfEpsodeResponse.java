package com.webflux.rickandMorty.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ListOfEpsodeResponse {

    private List<EpisodeResponse> results;
}
