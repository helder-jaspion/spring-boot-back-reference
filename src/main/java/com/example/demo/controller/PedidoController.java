package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Medico;
import com.example.demo.model.Paciente;
import com.example.demo.model.Pedido;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/pedido")
@Slf4j
public class PedidoController {

	@GetMapping
	public List<Pedido> findPedidos() {

		Medico medico1 = new Medico(1L, "Médico 1", null);
//		Medico medico2 = Medico.builder().id(2L).nome("Médico 2").build();

		Paciente paciente1 = new Paciente(1L, "Paciente 1", null);
		Paciente paciente2 = new Paciente(2L, "Paciente 2", null);
//		Paciente paciente3 = Paciente.builder().id(3L).nome("Paciente 3").build();

		Pedido pedido1 = new Pedido(1L, "Pedido 1", paciente1, medico1);
		Pedido pedido2 = new Pedido(2L, "Pedido 2", paciente1, medico1);
		Pedido pedido3 = new Pedido(3L, "Pedido 3", paciente2, medico1);

		medico1.addPedidos(pedido1, pedido2, pedido3);

		paciente1.addPedidos(pedido1, pedido2);
		paciente1.addPedidos(pedido3);

		List<Pedido> pedidos = new ArrayList<>();
//
		pedidos.add(pedido1);
		pedidos.add(pedido2);
		pedidos.add(pedido3);

		return pedidos;
	}

	@PostMapping
	public void savePedido(@RequestBody Pedido pedido) {
		log.info(pedido.toString());

		// TODO consultar paciente pelo pedido.paciente.id
		// TODO consultar medico pelo pedido.medico.id

		// TODO salvar
	}
}