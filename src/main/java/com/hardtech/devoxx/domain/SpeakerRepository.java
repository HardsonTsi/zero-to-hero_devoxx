package com.hardtech.devoxx.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

    @RestResource(path = "by-twitter")
    Speaker findByTwitter(@Param("id") String twitter);

    Collection<Speaker> findByLastName(String lastName);

}