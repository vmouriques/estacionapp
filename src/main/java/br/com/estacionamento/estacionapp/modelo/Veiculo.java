package br.com.estacionamento.estacionapp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "modelo_veiculo")
	private String modelo;
	
	@NotEmpty
	@Column(name = "marca_veiculo")
	private String marca;
	
	@Column(name = "placa", unique = true)
	@NotEmpty(message = "Placa não pode estar vazia!")
	private String placa;
	
	public Veiculo() {
	}

	public Veiculo(String modelo, String marca, String placa) {

		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
