package br.furb.devnapratica.fundamentos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.furb.devnapratica.fundamentos.dto.ItemDTO;
import br.furb.devnapratica.fundamentos.dto.PedidoDTO;
import br.furb.devnapratica.fundamentos.entity.ItemEntity;
import br.furb.devnapratica.fundamentos.entity.PedidoEntity;
import br.furb.devnapratica.fundamentos.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<PedidoDTO> listarPedidos() {
		List<PedidoDTO> pedidos = new ArrayList<PedidoDTO>();
		for (PedidoEntity entity : pedidoRepository.findAll()) {
			List<ItemDTO> itens = new ArrayList<ItemDTO>();
			for (ItemEntity itemEntity : entity.getItens()) {
				ItemDTO itemDTO = new ItemDTO();
				itemDTO.setId(itemEntity.getId());
				itemDTO.setNome(itemEntity.getNome());
				itemDTO.setQuantidade(itemEntity.getQuantidade());
				itens.add(itemDTO);
			}
			PedidoDTO pedido = new PedidoDTO();
			pedido.setId(entity.getId());
			pedido.setItens(itens);
			pedido.setDataPedido(entity.getDataPedido());
			pedidos.add(pedido);
		}
		return pedidos;
	}

	public void criarPedido(PedidoDTO pedidoDTO) {
		PedidoEntity pedidoEntity = new PedidoEntity();
		List<ItemEntity> itens = new ArrayList<>();
		for (ItemDTO item : pedidoDTO.getItens()) {
			ItemEntity entity = new ItemEntity();
			entity.setId(item.getId());
			entity.setNome(item.getNome());
			entity.setQuantidade(item.getQuantidade());
			itens.add(entity);
		}
		pedidoEntity.setItens(itens);
		pedidoEntity.setDataPedido(pedidoDTO.getDataPedido());
		pedidoRepository.save(pedidoEntity);
	}

	public Long getTotalPedidos(Long idPedido) {
		PedidoEntity pedidoEntity = pedidoRepository.findById(idPedido).get();
		Long total = 0L;
		for (ItemEntity itemEntity : pedidoEntity.getItens()) {
			total += itemEntity.getQuantidade();
		}
		return total;
	}
}
