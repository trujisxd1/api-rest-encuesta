package com.api.rest.controller;


import com.api.rest.model.Encuesta;
import com.api.rest.repository.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@RestController
public class EncuestaController {

    @Autowired
    private EncuestaRepository encuestaRepository;



    @GetMapping("/encuestas")
    public ResponseEntity<Iterable<Encuesta>> listarTodasLasEncuestas(){

        return new ResponseEntity<>(encuestaRepository.findAll(),HttpStatus.OK);



    }

    @PostMapping("/encuestas")

    public  ResponseEntity<?> crearEncuesta(@RequestBody Encuesta  encuesta){

         encuesta =encuestaRepository.save(encuesta);

        HttpHeaders httpHeaders = new HttpHeaders();

        URI newEncuestauri= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(encuesta.getId()).toUri();
        httpHeaders.setLocation(newEncuestauri);

        return new ResponseEntity<>(null,httpHeaders, HttpStatus.CREATED);

    }

    @GetMapping("/encuestas/{id}")
    public  ResponseEntity<?>encuestaid(@PathVariable ("id") Integer id ){

       Optional<Encuesta> encuesta= encuestaRepository.findById(id);

       if(encuesta.isPresent()){

           return  new ResponseEntity<>(encuesta,HttpStatus.OK);
       }else {

           return new ResponseEntity<>(null,  HttpStatus.NOT_FOUND);
       }


    }
    @PutMapping("/encuestas/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Encuesta encuesta ,@PathVariable("id") Integer id){

encuesta.setId(id);
Encuesta e = encuestaRepository.save(encuesta);

return  new ResponseEntity<>(HttpStatus.OK);



    }
    @DeleteMapping("/encuestas/{id}")
    public ResponseEntity<?>eliminar(@PathVariable ("id") Integer id){
        encuestaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}

