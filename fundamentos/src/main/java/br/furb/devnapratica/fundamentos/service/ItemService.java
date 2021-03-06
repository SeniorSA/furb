package br.furb.devnapratica.fundamentos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.furb.devnapratica.fundamentos.dto.ItemDTO;
import br.furb.devnapratica.fundamentos.entity.ItemEntity;
import br.furb.devnapratica.fundamentos.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<ItemDTO> listarItens() {
		List<ItemDTO> itens = new ArrayList<ItemDTO>();
		for (ItemEntity entity : itemRepository.findAll()) {
			ItemDTO item = new ItemDTO();
			item.setId(entity.getId());
			item.setNome(entity.getNome());
			item.setQuantidade(entity.getQuantidade());
			itens.add(item);
		}
		return itens;
	}

	public ItemDTO criarItem(ItemDTO itemDTO) {
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setNome(itemDTO.getNome());
		itemEntity.setQuantidade(itemDTO.getQuantidade());

		ItemEntity itemCriado = itemRepository.save(itemEntity);
		ItemDTO itemDTOCriado = new ItemDTO();
		itemDTOCriado.setId(itemCriado.getId());
		itemDTOCriado.setNome(itemCriado.getNome());
		itemDTOCriado.setQuantidade(itemCriado.getQuantidade());
		return itemDTOCriado;
	}

}
