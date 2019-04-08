package br.furb.devnapratica.fundamentos.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.furb.devnapratica.fundamentos.dto.ClienteDTO;
import br.furb.devnapratica.fundamentos.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/clientes/buscar")
	public ResponseEntity<List<ClienteDTO>> buscarClientes(@PathParam(value = "nome") String nome) {
		return new ResponseEntity<List<ClienteDTO>>(clienteService.buscarClientes(nome), HttpStatus.OK);
	}

	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> listarClientes() {
		return new ResponseEntity<List<ClienteDTO>>(clienteService.listarClientes(), HttpStatus.OK);
	}

	@PostMapping("/cliente")
	public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
		ClienteDTO clienteCriado = clienteService.criarCliente(clienteDTO);
		return new ResponseEntity<ClienteDTO>(clienteCriado, HttpStatus.OK);
	}

	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
