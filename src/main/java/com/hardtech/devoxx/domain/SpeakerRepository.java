package com.hardtech.devoxx.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

    Speaker findByTwitter(String twitter);

    Collection<Speaker> findByLastName(String lastName);

}