package com.danvarga.msscbrewery.web.controllers.v2;

import com.danvarga.msscbrewery.services.v2.BeerServiceV2;
import com.danvarga.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> handlePost(@RequestBody BeerDtoV2 beerDto) {

        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // TODO: add hostname to url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping({"/{beerId}"})
    public void handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {

        beerServiceV2.updateBeer(beerId, beerDto);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{beerId}")
    public void deleteBeerById(@PathVariable("beerId") UUID beerId) {
        beerServiceV2.deleteById(beerId);
    }
}

