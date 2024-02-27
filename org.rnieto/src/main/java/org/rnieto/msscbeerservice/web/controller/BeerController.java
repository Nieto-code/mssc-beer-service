package org.rnieto.msscbeerservice.web.controller;

import org.rnieto.msscbeerservice.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerDTO(@PathVariable("beerId")UUID beerId) {
       //todo implement get entity
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDTO> saveNewBeer(@Validated @RequestBody BeerDTO beerDTO) {
        //todo implement get entity
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDTO> saveUpdatedBeer(@PathVariable("beerId")UUID beerId, @Validated @RequestBody BeerDTO beerDTO) {
        //todo implement get entity
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{beerId}")
    public ResponseEntity<BeerDTO> deleteBeerDTO(@PathVariable("beerId")UUID beerId) {
        //todo implement get entity
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }
}
