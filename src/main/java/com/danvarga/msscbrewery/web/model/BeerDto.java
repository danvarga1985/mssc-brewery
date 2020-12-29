package com.danvarga.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    /*
     OffsetDateTime is generic enough to be used in public facing interfaces.
     TimeStamp (used on domain.Beer) on the other hand is used solely for databases;
    */
    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;
}
