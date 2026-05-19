package com.universidad.remolina_post1_u12;

import com.universidad.remolina_post1_u12.model.Producto;
import com.universidad.remolina_post1_u12.repository.ProductoRepository;
import com.universidad.remolina_post1_u12.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository repo;

    @InjectMocks
    private ProductoService service;

    @Test
    void listarTodos_retornaListaDeProductos() {
        Producto p = new Producto("Laptop", 2500000.0, "Laptop 16GB");
        when(repo.findAll()).thenReturn(List.of(p));

        List<Producto> resultado = service.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals("Laptop", resultado.get(0).getNombre());
        verify(repo, times(1)).findAll();
    }

    @Test
    void guardar_retornaProductoGuardado() {
        Producto p = new Producto("Mouse", 45000.0, "Mouse inalámbrico");
        when(repo.save(p)).thenReturn(p);

        Producto resultado = service.guardar(p);

        assertNotNull(resultado);
        assertEquals("Mouse", resultado.getNombre());
        verify(repo, times(1)).save(p);
    }
}