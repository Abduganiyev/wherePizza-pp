package com.webbrain.wherepizza.repository;

import com.webbrain.wherepizza.model.StatusPizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface StatusRepository extends JpaRepository<StatusPizza, Long> {
}
