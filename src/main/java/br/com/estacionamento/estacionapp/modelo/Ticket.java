package br.com.estacionamento.estacionapp.modelo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "data_hora_entrada")
	private LocalDateTime dataHoraEntrada = LocalDateTime.now();
	
	@Column(name = "data_hora_saida")
	private LocalDateTime dataHoraSaida;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Veiculo veiculo;
	
	private Double valor;
	
	private boolean status;
	
	public Ticket() {
	}
	
	public Ticket(Ticket ticket) {
		this.veiculo = ticket.getVeiculo();
		this.valor = 0.0;
	}
	
	public Ticket(Veiculo veiculo) {
		super();
		this.veiculo = veiculo;
		this.valor = 0.0;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double calcularPagamento() {
		float duracao;
		this.dataHoraSaida = LocalDateTime.now(ZoneId.of("GMT-3"));
		duracao = ChronoUnit.HOURS.between(this.dataHoraEntrada, this.dataHoraSaida);
		this.status = true;
		if (duracao < 1) {
			valor = 5.0;
		} else {
			float horas = duracao - 1;
			valor = (horas * 2) + 5.0;
		}
		return valor;
	}
}
