package br.com.estacionamento.estacionapp.controller;

import java.net.URI;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.estacionamento.estacionapp.controller.dto.TicketDto;
import br.com.estacionamento.estacionapp.controller.form.TicketForm;
import br.com.estacionamento.estacionapp.modelo.Ticket;
import br.com.estacionamento.estacionapp.repository.PagamentoRepository;
import br.com.estacionamento.estacionapp.repository.TicketRepository;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@GetMapping
	public List<Ticket> lista(String placa) {
		if (placa == null) {
			List<Ticket> tickets = ticketRepository.findAll();
			return tickets;
		} else {
			List<Ticket> tickets = ticketRepository.findByVeiculoPlaca(placa);
			return tickets;
		}
	}
	
	@GetMapping("/{id}")
	public TicketDto detalhar(@PathVariable Long id) {
		Ticket ticket = ticketRepository.getOne(id);
		return new TicketDto(ticket);
	}
	
	@PostMapping
	public ResponseEntity<Ticket> cadastrar(@RequestBody TicketForm form, UriComponentsBuilder uriBuilder) {
		Ticket ticket = form.converter();
		ticketRepository.save(ticket);
		
		URI uri = uriBuilder.path("/tickets/{id}").buildAndExpand(ticket.getId()).toUri();
		return ResponseEntity.created(uri).body(ticket);
	}
	
	@PutMapping("/finalizar/{placa}")
	@Transactional
	public ResponseEntity<TicketDto> gerarPagamento(@PathVariable String placa){
		Ticket ticket = pagamentoRepository.findByVeiculoPlaca(placa);
		ticket.calcularPagamento();
		return ResponseEntity.ok(new TicketDto(ticket));
	}
}
