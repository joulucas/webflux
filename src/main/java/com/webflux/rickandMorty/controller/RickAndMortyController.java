package com.webflux.rickandMorty.controller;

import com.webflux.rickandMorty.client.RickAndMortyClient;
import com.webflux.rickandMorty.res.EpisodeResponse;
import com.webflux.rickandMorty.res.ListOfEpsodeResponse;
import com.webflux.rickandMorty.res.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.webflux.rickandMorty.res.CharacterResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {

    RickAndMortyClient rickAndMortyclient;

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
        return rickAndMortyclient.findAndCharacterById(id);
    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id){
        return rickAndMortyclient.findAndLocationById(id);
    }

    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
        return rickAndMortyclient.findAndEpisodeById(id);
    }

    @GetMapping("/episodes")
    public Flux<ListOfEpsodeResponse> getAllEpsiodes(){
        return rickAndMortyclient.getAllEpsodes();
    }
}
