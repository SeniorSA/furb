package br.furb.devnapratica.fundamentos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import br.furb.devnapratica.fundamentos.service.PedidoService;

public class PedidoControllerTest {
	private static final Long mockId = 1L;

	@InjectMocks
	private PedidoController pedidoController;

	@Mock
	private PedidoService pedidoService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getTotalItems_should_returnFive() {
		
		Mockito.when(pedidoService.getTotalPedidos(mockId)).thenReturn(5L);
		
		ResponseEntity<Long> result = pedidoController.getTotalItems(mockId);

		assertEquals(5L, (long) result.getBody());
	}

}
