package com.agora.catalogo.agoracatalogo.repository;

import com.agora.catalogo.agoracatalogo.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Integer> {

   @Query( value = "SELECT * FROM PRODOTTO WHERE PARTITA_IVA=?1",nativeQuery = true)
   List<Prodotto> getByPartitaIva(Integer partitaIva);

}
