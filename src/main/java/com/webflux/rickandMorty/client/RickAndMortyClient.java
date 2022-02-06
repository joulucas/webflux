package com.webflux.rickandMorty.client;

import com.webflux.rickandMorty.res.EpisodeResponse;
import com.webflux.rickandMorty.res.ListOfEpsodeResponse;
import com.webflux.rickandMorty.res.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.webflux.rickandMorty.res.CharacterResponse;

@Service
@Slf4j
public class RickAndMortyClient {

    private final WebClient webClient;

    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }


    public Mono<CharacterResponse> findAndCharacterById(String id) {
        log.info("buscando o personagem com o id [{}] ", id);
        return webClient.get()
                .uri("/character/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique o id")))
                .bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findAndLocationById(String id) {
        log.info("buscando a location com o id [{}] ", id);
        return webClient.get()
                .uri("/location/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique o id")))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findAndEpisodeById(String id) {
        log.info("buscando a episode com o id [{}] ", id);
        return webClient.get()
                .uri("/episode/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique o id")))
                .bodyToMono(EpisodeResponse.class);
    }

    public Flux<ListOfEpsodeResponse> getAllEpsodes() {
        log.info("Listanto todos epsodios " );
        return webClient.get()
                .uri("/episode/" )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique o id")))
                .bodyToFlux(ListOfEpsodeResponse.class);
    }

}
