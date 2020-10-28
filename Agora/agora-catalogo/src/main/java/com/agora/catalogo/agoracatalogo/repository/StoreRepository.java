package com.agora.catalogo.agoracatalogo.repository;

import com.agora.catalogo.agoracatalogo.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store ,Integer> {

    @Query(value = "SELECT * FROM STORE WHERE CATEGORIA=?1", nativeQuery = true)
    List<Store> getByCategoria(String categoria);

}
