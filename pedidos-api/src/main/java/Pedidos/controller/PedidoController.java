package Pedidos.controller;

import Pedidos.dto.ProdutoDTO;
import Pedidos.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/produtos")
    public List<ProdutoDTO> listarProdutosDisponiveis(){
        return pedidoService.buscarTodosProdutos();
    }

    @PostMapping
    public List<ProdutoDTO> criarPedido(@RequestBody List<Long> idsProdutos){
        return pedidoService.buscarProdutosPorId(idsProdutos);
    }
}
