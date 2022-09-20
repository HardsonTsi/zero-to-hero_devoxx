package com.hardtech.devoxx.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpeakerRepositoryTest {

    @Autowired
    private SpeakerRepository speakerRepository;

    @Test
    void testFindByTwitter() {
        Speaker dave = speakerRepository.save(new Speaker("David", "Syer", "dave_syer"));
        Speaker nicoll = speakerRepository.save(new Speaker("Stéphane", "Nicoll", "stephane_nicoll"));
        Speaker clozel = speakerRepository.save(new Speaker("brian", "clozel", "brian_clozel"));
        System.out.println(speakerRepository.findByTwitter("dave_syer").getTwitter());
    }


}