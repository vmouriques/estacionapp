package br.com.estacionamento.estacionapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import  br.com.estacionamento.estacionapp.modelo.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	List<Ticket> findByVeiculoPlaca(String placa);

}