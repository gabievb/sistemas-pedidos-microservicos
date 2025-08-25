package Pedidos.dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "produto-api")
public interface ProdutoClient {

    @GetMapping("/produtos")
    List<ProdutoDTO> listarProdutos();
}
