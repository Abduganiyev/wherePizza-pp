package com.webbrain.wherepizza.repository;

import com.webbrain.wherepizza.entity.Dough;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoughRepository extends JpaRepository<Dough, Long> {
}
