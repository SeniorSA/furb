package br.furb.devnapratica.fundamentos.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.furb.devnapratica.fundamentos.dto.PedidoDTO;
import br.furb.devnapratica.fundamentos.service.PedidoService;

@RestController
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping("/pedidos")
	public ResponseEntity<List<PedidoDTO>> listarPedidos() {
		return new ResponseEntity<List<PedidoDTO>>(pedidoService.listarPedidos(), HttpStatus.OK);
	}

	@PostMapping("pedido")
	public ResponseEntity<Void> criarItem(@RequestBody PedidoDTO pedidoDTO) {
		pedidoService.criarPedido(pedidoDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/totalItems")
	public ResponseEntity<Long> getTotalItems(@PathParam(value = "pedido") Long idPedido){
		return new ResponseEntity<Long>(pedidoService.getTotalPedidos(idPedido), HttpStatus.OK);
	}
}
