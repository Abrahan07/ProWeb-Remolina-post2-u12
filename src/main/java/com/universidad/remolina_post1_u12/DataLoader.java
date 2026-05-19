package com.universidad.remolina_post1_u12;

import com.universidad.remolina_post1_u12.model.Producto;
import com.universidad.remolina_post1_u12.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository repo;

    public DataLoader(ProductoRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            repo.save(new Producto("Laptop", 2500000.0, "Laptop 16GB RAM"));
            repo.save(new Producto("Mouse", 45000.0, "Mouse inalámbrico"));
            repo.save(new Producto("Teclado", 85000.0, "Teclado mecánico"));
        }
    }
}