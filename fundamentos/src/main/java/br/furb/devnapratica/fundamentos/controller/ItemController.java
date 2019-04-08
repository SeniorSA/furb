package br.furb.devnapratica.fundamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.furb.devnapratica.fundamentos.dto.ItemDTO;
import br.furb.devnapratica.fundamentos.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/itens")
	public ResponseEntity<List<ItemDTO>> listarItens() {
		return new ResponseEntity<List<ItemDTO>>(itemService.listarItens(), HttpStatus.OK);
	}

	@PostMapping("/item")
	public ResponseEntity<ItemDTO> criarItem(@RequestBody ItemDTO itemDTO) {
		ItemDTO itemCriado = itemService.criarItem(itemDTO);
		return new ResponseEntity<ItemDTO>(itemCriado, HttpStatus.OK);
	}
}
