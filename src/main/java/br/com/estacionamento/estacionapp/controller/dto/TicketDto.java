package br.com.estacionamento.estacionapp.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import br.com.estacionamento.estacionapp.modelo.Ticket;
import br.com.estacionamento.estacionapp.modelo.Veiculo;

public class TicketDto {
	
	private Long id;
	private Veiculo veiculo;
	private LocalDateTime dataHoraEntrada;
	private LocalDateTime dataHoraSaida;
	private Double valor;
	
	public TicketDto(Ticket ticket) {
		this.id = ticket.getId();
		this.veiculo = ticket.getVeiculo();
		this.dataHoraEntrada = ticket.getDataHoraEntrada();
		this.dataHoraSaida = ticket.getDataHoraSaida();
		this.valor = ticket.getValor();
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}
	
	public LocalDateTime getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public static List<TicketDto> converter(List<Ticket> ticket) {
		return ticket.stream().map(TicketDto::new).collect(Collectors.toList());
	}
	
}
