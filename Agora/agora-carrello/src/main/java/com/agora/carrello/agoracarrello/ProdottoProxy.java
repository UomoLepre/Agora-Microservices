package com.agora.carrello.agoracarrello;

import com.agora.carrello.agoracarrello.entity.Prodotto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@FeignClient(name = "catalogo",url="http://localhost:8000/")

public interface ProdottoProxy {
        @GetMapping("/public/prodotto/{id}")
        Prodotto recuperaProdotto(@PathVariable("id") Integer id);
}
