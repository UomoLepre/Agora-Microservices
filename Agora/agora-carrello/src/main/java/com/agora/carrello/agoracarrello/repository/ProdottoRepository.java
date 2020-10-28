package com.agora.carrello.agoracarrello.repository;

import com.agora.carrello.agoracarrello.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Integer> {

@Query( value = "SELECT * FROM PRODOTTO WHERE ID_CARRELLO=?1",nativeQuery = true)
   List<Prodotto> getByIdCarrello(Integer idCarrello);


}
