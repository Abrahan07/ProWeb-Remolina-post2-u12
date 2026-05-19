package com.universidad.remolina_post1_u12.repository;

import com.universidad.remolina_post1_u12.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {}