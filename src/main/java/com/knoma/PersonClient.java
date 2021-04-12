package com.knoma;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

@Client("person")
public interface PersonClient {

    @Get("/")
    public HttpStatus index();
}