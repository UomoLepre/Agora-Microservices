package com.agora.carrello.agoracarrello.repository;

import com.agora.carrello.agoracarrello.entity.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepository  extends JpaRepository<Carrello,Integer> {

}
