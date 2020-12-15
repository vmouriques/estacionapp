package br.com.estacionamento.estacionapp.controller.form;

import br.com.estacionamento.estacionapp.modelo.Ticket;
import br.com.estacionamento.estacionapp.modelo.Veiculo;

public class TicketForm {
	
	private Veiculo veiculo;
	
	public TicketForm(Veiculo veiculo) {
		super();
		this.veiculo = veiculo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public TicketForm() {
	}

	public Ticket converter() {
		return new Ticket(veiculo);
	}
	
}
