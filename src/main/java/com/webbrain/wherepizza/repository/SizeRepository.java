package com.webbrain.wherepizza.repository;

import com.webbrain.wherepizza.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long>{
}
