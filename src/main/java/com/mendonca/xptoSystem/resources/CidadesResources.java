package com.mendonca.xptoSystem.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mendonca.xptoSystem.entities.Cidades;
import com.mendonca.xptoSystem.service.CidadesService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadesResources {

	@Autowired
	private CidadesService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cidades>> findAll() {
		List<Cidades> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Optional<Cidades>> find(@PathVariable Integer id) {
		Optional<Cidades> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/capitais", method = RequestMethod.GET)
	public ResponseEntity<List<Cidades>> findByCapital() {
		List<Cidades> list = service.findCapital();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/cidadeuf", method = RequestMethod.GET)
	public ResponseEntity<List<Object[]>> findCidadeUf() {
		List<Object[]> list = service.findCidadeuf();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/menor", method = RequestMethod.GET)
	public ResponseEntity<Object> findByMaiorEMenor() {
		Object[] list = service.findByMenor();
		return ResponseEntity.ok().body(list[0]);
	}
	
	@RequestMapping(value = "/maior", method = RequestMethod.GET)
	public ResponseEntity<Object> findByMaior() {
		Object[] list = service.findByMaior();
		return ResponseEntity.ok().body(list[0]);
	}
	
	@RequestMapping(value = "/ibge/{ibge}", method = RequestMethod.GET)
	public ResponseEntity<List<Cidades>> findByIbge(@PathVariable String ibge) {
		List<Cidades> list = service.findByIbge(ibge);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/uf/{uf}", method = RequestMethod.GET)
	public ResponseEntity<List<Cidades>> findByCidadePorEstado(@PathVariable String uf) {
		List<Cidades> list = service.findByCidadePorEstado(uf);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public ResponseEntity<Long> findByTotal() {
		Long list = service.findByTotal();
		return ResponseEntity.ok().body(list);
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Insert(@RequestBody Cidades obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	  @RequestMapping(value = "/filtro/{coluna}/{filtro}", method = RequestMethod.GET)
	    public ResponseEntity<?> countRecordsByColumn(@PathVariable(value = "coluna") String coluna,
	                                                  @PathVariable(value = "filtro") String filtro){
	        try{
	            List<Cidades> cidade = service.findByFilter(coluna,filtro);
	            return ResponseEntity.ok(cidade);
	        } catch (Exception e) {
	        	e.getMessage();
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	  
	  @RequestMapping(value = "/filtro/{coluna}", method = RequestMethod.GET)
	    public ResponseEntity<?> countRecordsByColumn(@PathVariable(value = "coluna") String coluna){
	        try{
	            List<Object> cidade = service.findByColuna(coluna);
	            return ResponseEntity.ok(cidade);
	        } catch (Exception e) {
	            e.getMessage();
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }

}
