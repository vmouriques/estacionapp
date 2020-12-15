package br.com.estacionamento.estacionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estacionamento.estacionapp.modelo.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	Veiculo findByPlaca(String placa);
}
