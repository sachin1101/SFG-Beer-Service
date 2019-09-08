package com.example.sfgbeerservice.bootstrap;

import com.example.sfgbeerservice.domain.Beer;
import com.example.sfgbeerservice.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class BeerDataLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;


    @Autowired
    public BeerDataLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadBeerData();
    }

    private void loadBeerData() {
        if(beerRepository.count() == 0)
        {
            beerRepository.save(Beer.builder()
                    .beerName("Beer One")
                    .beerStyleEnum("IPA")
                    .quantityOnHand(200)
                    .upc(12123432647L)
                    .price(new BigDecimal(29.99))
                    .id(UUID.randomUUID())
                    .version(1L)
                    .build());


            beerRepository.save(Beer.builder()
                    .beerName("Beer Two")
                    .beerStyleEnum("IPA")
                    .quantityOnHand(100)
                    .upc(532647L)
                    .price(new BigDecimal(19.99))
                    .id(UUID.randomUUID())
                    .version(1L)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Beer Three")
                    .beerStyleEnum("IPA")
                    .quantityOnHand(60)
                    .upc(132647L)
                    .price(new BigDecimal(9.99))
                    .id(UUID.randomUUID())
                    .version(1L)
                    .build());
        }

        System.out.println("Beer Count::" + beerRepository.count());
    }
}
