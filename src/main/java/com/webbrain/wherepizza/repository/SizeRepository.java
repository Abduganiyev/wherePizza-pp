package com.webbrain.wherepizza.repository;

import com.webbrain.wherepizza.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long>{
}
