package com.salesianostriana.Ejercicio2;
import com.salesianostriana.Ejercicio2.model.Producto;
import com.salesianostriana.Ejercicio2.respositorios.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest(properties={"spring.sql.init.mode=never", "spring.jpa.hibernate.ddl-auto=create-drop"})
class ProductMappingTest {
    @Autowired ProductoRepository products;
    @Autowired EntityManager entities;
    @Autowired JdbcTemplate sql;
    @Test void longTextAndRenamedColumnsSurviveAPersistenceRoundTrip() {
        String description = "Fictional product description. ".repeat(30);
        Producto saved = products.saveAndFlush(new Producto("Sample item", 2.5, "https://example.invalid/item.png", description));
        entities.clear(); Producto loaded = products.findById(saved.getId()).orElseThrow();
        assertEquals("Sample item", loaded.getName()); assertEquals(2.5, loaded.getPrice());
        assertEquals(description, loaded.getDescription()); assertEquals("https://example.invalid/item.png", loaded.getImage());
        assertEquals("Sample item", sql.queryForObject("SELECT name FROM producto WHERE id=?", String.class, saved.getId()));
        assertEquals(2.5, sql.queryForObject("SELECT price FROM producto WHERE id=?", Double.class, saved.getId()));
    }
    @Test void databaseRejectsANullNameEvenOutsideTheRepository() {
        assertThrows(DataIntegrityViolationException.class, () -> sql.update("INSERT INTO producto (id,name,price) VALUES (?,NULL,?)", 1000L, 2.5));
    }
}
