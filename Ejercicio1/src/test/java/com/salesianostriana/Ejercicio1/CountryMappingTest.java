package com.salesianostriana.Ejercicio1;
import com.salesianostriana.Ejercicio1.model.Pais;
import com.salesianostriana.Ejercicio1.repositorios.PaisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest(properties={"spring.sql.init.mode=never", "spring.jpa.hibernate.ddl-auto=create-drop"})
class CountryMappingTest {
    @Autowired PaisRepository countries;
    @Autowired EntityManager entities;
    @Autowired JdbcTemplate sql;
    @Test void repositoryAndNativeColumnsReadTheSameStoredName() {
        Pais saved = countries.saveAndFlush(new Pais("Demo country")); entities.clear();
        assertEquals("Demo country", countries.findById(saved.getId()).orElseThrow().getName());
        assertEquals("Demo country", sql.queryForObject("SELECT name FROM country WHERE id=?", String.class, saved.getId()));
    }
    @Test void databaseRejectsANullNameEvenOutsideTheRepository() {
        assertThrows(DataIntegrityViolationException.class, () -> sql.update("INSERT INTO country (id,name) VALUES (?,NULL)", 1000L));
    }
}
