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

import br.com.leandrocolevati.JasperReportsF12014v2REST.model.dto.PilotoDTO;
import br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity.Piloto;
import br.com.leandrocolevati.JasperReportsF12014v2REST.peristence.PilotoRepository;

@RestController
@RequestMapping("/api")
public class PilotoController {

	@Autowired
	private PilotoRepository pRep;
	
	@Autowired
	private EquipeController eCont;
	
	@GetMapping("/piloto")
	public List<PilotoDTO> listaPilotos() {
		List<Piloto> pilotos = pRep.findAll();
		List<PilotoDTO> pilotosDTO = convertListPilotoListPilotoDTO(pilotos);
		return pilotosDTO;
	}
	
	@GetMapping("/piloto/{numeroPiloto}")
	public ResponseEntity<PilotoDTO> consultaPiloto(
			@PathVariable(value = "numeroPiloto") int numeroPiloto) {
		Piloto piloto = pRep.findById(numeroPiloto).orElseThrow(
				() -> new ResourceNotFoundException(numeroPiloto+" inválido"));
		PilotoDTO pilotoDTO = convertPilotoPilotoDTO(piloto);
		return ResponseEntity.ok().body(pilotoDTO);
	}
	
	@PostMapping("/piloto")
	public ResponseEntity<String> adicionaPiloto(
			@Valid @RequestBody Piloto p) {
		pRep.save(p);
		String saida = "Piloto adicionado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@PatchMapping("/piloto")
	public ResponseEntity<String> atualizaPiloto(
			@Valid @RequestBody Piloto p) {
		pRep.save(p);
		String saida = "Piloto atualizado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@DeleteMapping("/piloto")
	public ResponseEntity<String> excluiPiloto(
			@Valid @RequestBody Piloto p) {
		pRep.delete(p);
		String saida = "Piloto excluido com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	private List<PilotoDTO> convertListPilotoListPilotoDTO(List<Piloto> pilotos) {
		List<PilotoDTO> pilotosDTO = new ArrayList<PilotoDTO>();
		
		for (Piloto p : pilotos) {
			PilotoDTO pDTO = new PilotoDTO();
			pDTO.setNumero(p.getNumero());
			pDTO.setNome(p.getNome());
			pDTO.setEquipe(eCont.convertEquipeEquipeDTO(p.getEquipe()));
			
			pilotosDTO.add(pDTO);
		}
		return pilotosDTO;
	}
	
	public PilotoDTO convertPilotoPilotoDTO(Piloto p) {
		PilotoDTO pDTO = new PilotoDTO();
		pDTO.setNumero(p.getNumero());
		pDTO.setNome(p.getNome());
		pDTO.setEquipe(eCont.convertEquipeEquipeDTO(p.getEquipe()));
			
		return pDTO;
	}
	
}
