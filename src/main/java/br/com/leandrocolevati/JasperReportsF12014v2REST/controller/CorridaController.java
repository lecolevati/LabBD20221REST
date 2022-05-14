package br.com.leandrocolevati.JasperReportsF12014v2REST.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandrocolevati.JasperReportsF12014v2REST.model.dto.CorridaDTO;
import br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity.Corrida;
import br.com.leandrocolevati.JasperReportsF12014v2REST.peristence.CorridaRepository;

@RestController
@RequestMapping("/api")
public class CorridaController {

	@Autowired
	private CorridaRepository cRep;
	
	@GetMapping("/corrida")
	public List<CorridaDTO> listaCorridas() {
		List<Corrida> corridas = cRep.findAll();
		List<CorridaDTO> corridasDTO = convertListCorridaListCorridaDTO(corridas);
		return corridasDTO;
	}
	
	@GetMapping("/corrida/{codigoCorrida}")
	public ResponseEntity<CorridaDTO> consultaCorrida(
			@PathVariable(value = "codigoCorrida") int codigoCorrida) {
		Corrida corrida = cRep.findById(codigoCorrida).orElseThrow(
				() -> new ResourceNotFoundException(codigoCorrida+" inválido"));
		CorridaDTO CorridaDTO = convertCorridaCorridaDTO(corrida);
		return ResponseEntity.ok().body(CorridaDTO);
	}
	
	@PostMapping("/corrida")
	public ResponseEntity<String> adicionaCorrida(
			@Valid @RequestBody Corrida c) {
		cRep.save(c);
		String saida = "Corrida adicionada com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@PatchMapping("/corrida")
	public ResponseEntity<String> atualizaCorrida(
			@Valid @RequestBody Corrida c) {
		cRep.save(c);
		String saida = "Corrida atualizada com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@DeleteMapping("/corrida")
	public ResponseEntity<String> excluiCorrida(
			@Valid @RequestBody Corrida c) {
		cRep.delete(c);
		String saida = "Corrida excluida com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	private List<CorridaDTO> convertListCorridaListCorridaDTO(List<Corrida> corridas) {
		List<CorridaDTO> corridasDTO = new ArrayList<CorridaDTO>();
		for (Corrida c : corridas) {
			CorridaDTO cDTO = new CorridaDTO();
			cDTO.setCodigo(c.getCodigo());
			cDTO.setPais(c.getPais());
			
			corridasDTO.add(cDTO);
		}
		return corridasDTO;
	}
	
	public CorridaDTO convertCorridaCorridaDTO(Corrida c) {
		CorridaDTO cDTO = new CorridaDTO();
		cDTO.setCodigo(c.getCodigo());
		cDTO.setPais(c.getPais());
			
		return cDTO;
	}
	
}
