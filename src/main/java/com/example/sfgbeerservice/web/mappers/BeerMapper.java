package com.example.sfgbeerservice.web.mappers;

import com.example.sfgbeerservice.domain.Beer;
import com.example.sfgbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDto beerDto);
    BeerDto beerToBeerDto(Beer beer);

}
