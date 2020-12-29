package com.danvarga.msscbrewery.web.mappers;

import com.danvarga.msscbrewery.domain.Beer;
import com.danvarga.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

// Set to use the custom DateMapper.
@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
