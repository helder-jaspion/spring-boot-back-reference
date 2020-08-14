package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Paciente {

	private Long id;

	private String nome;

	@JsonBackReference
	private List<Pedido> pedidos;

	public void addPedidos(Pedido... pedido) {
		if (pedidos == null) {
			pedidos = new ArrayList<>();
		}

		pedidos.addAll(Arrays.asList(pedido));
	}

}
