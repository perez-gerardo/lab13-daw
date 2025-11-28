package com.tecsup.lab13daw.repository;

import com.tecsup.lab13daw.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

