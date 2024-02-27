package org.rnieto.msscbeerservice.web.mappers;


import org.mapstruct.Mapper;
import org.rnieto.msscbeerservice.domain.Beer;
import org.rnieto.msscbeerservice.web.model.BeerDTO;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDTO beerDto);

}
