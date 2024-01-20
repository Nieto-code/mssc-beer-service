package org.rnieto.msscbeerservice.bootstrap;

import org.rnieto.msscbeerservice.domain.Beer;
import org.rnieto.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.crypto.spec.PSource;
import java.math.BigDecimal;

@Component

public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        System.out.println("Checking beers...");
        if(beerRepository.count() == 0){
            System.out.println("Loading beers...");
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(333701000001L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy cats")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(333701045001L)
                    .price(new BigDecimal("11.95"))
                    .build());

            System.out.println("Beers loaded succesfully! " + beerRepository.count());
        }
        System.out.println("Beers already loaded, initiating...");

    }
}
