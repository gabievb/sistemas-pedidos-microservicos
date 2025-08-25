package Pedidos.service;

import Pedidos.dto.ProdutoClient;
import Pedidos.dto.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private final ProdutoClient produtoClient;

    public PedidoService(ProdutoClient produtoClient) {
        this.produtoClient = produtoClient;
    }

    public List<ProdutoDTO> buscarTodosProdutos() {
        return produtoClient.listarProdutos();
    }

    public List<ProdutoDTO> buscarProdutosPorId(List<Long> id){
        List<ProdutoDTO> produtos = produtoClient.listarProdutos();

        return produtos.stream()
                .filter(p -> id.contains(p.getId()))
                .collect(Collectors.toList());
    }
}
