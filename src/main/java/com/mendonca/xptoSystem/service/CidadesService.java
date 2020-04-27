package com.mendonca.xptoSystem.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendonca.xptoSystem.entities.Cidades;
import com.mendonca.xptoSystem.repository.CidadesRepository;
import com.mendonca.xptoSystem.repository.CidadesRepositoryImpl;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class CidadesService {

	@Autowired
	private CidadesRepository repo;
	
	@Autowired
	private CidadesRepositoryImpl impl;

	@Transactional
	public Cidades insert(Cidades obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public List<Cidades> findAll() {
		return repo.findAll();
	}

	

	public Optional<Cidades> findById(Integer id) {
		return repo.findById(id);
	}

	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}

	public List<Cidades> findByFilter(String column, String filter) {
		return impl.findCidadesByFiltro(column, filter);
	}
	
	public List<Object> findByColuna(String column) {
		return impl.findByColuna(column);
	}

	public List<Cidades> findCapital() {
		return repo.findByCapital();
	}

	public Object[] findByMenor() {
		return repo.findByMenor();
	}

	public Object[] findByMaior() {
		return repo.findByMaior();
	}

	public List<Object[]> findCidadeuf() {
		return repo.findCidadeUf();
	}

	public List<Cidades> findByIbge(String ibge) {
		return repo.findByIbge(ibge);
	}

	public List<Cidades> findByCidadePorEstado(String uf) {
		return repo.findByCidadePorEstado(uf.toUpperCase());
	}
	
	public Long findByTotal() {
		return repo.findByTotal();
	}

	public void readerInsert() throws IOException {
		List<String[]> cidades;

		Path path = Paths.get("src/main/resources/files/DesafioCidades-BackEnd.csv");
		
		Reader reader = Files.newBufferedReader(Paths.get(path.toString()));
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

		cidades = csvReader.readAll();
		for (String[] cidade : cidades) {

			Cidades cid = new Cidades(null, cidade[0], cidade[1], cidade[2], cidade[3], cidade[4], cidade[5], cidade[6],
					cidade[7], cidade[8], cidade[9]);
			repo.saveAll(Arrays.asList(cid));

		}

	}


}
