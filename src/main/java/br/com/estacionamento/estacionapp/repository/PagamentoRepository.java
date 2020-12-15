package br.com.estacionamento.estacionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.estacionapp.modelo.Ticket;

public interface PagamentoRepository  extends JpaRepository<Ticket, Long> {

	Ticket findByVeiculoPlaca(String placa);
	
}
