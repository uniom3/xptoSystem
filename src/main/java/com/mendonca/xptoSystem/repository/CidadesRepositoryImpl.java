package com.mendonca.xptoSystem.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mendonca.xptoSystem.entities.Cidades;

@Repository
public class CidadesRepositoryImpl {
	
	@PersistenceContext
	    EntityManager entityManager;

	    public List<Cidades> findCidadesByFiltro(String coluna,String filtro){ //Retorna pesquisa por coluna 

	        StringBuilder consultvalue = new StringBuilder();
	        consultvalue.append("Select obj FROM Cidades obj WHERE " +getNameColumn(coluna) +" LIKE :filtro ORDER BY obj.name ");
	        TypedQuery<Cidades> query = entityManager.createQuery(consultvalue.toString(), Cidades.class);
	        

	        switch (coluna) {
	            case "ibge_id" : query.setParameter("filtro", new String(filtro));break;
	            case "lat" : query.setParameter("filtro", new String(filtro));break;
	            case "lon" : query.setParameter("filtro", new String(filtro));break;
	            default:
	                query.setParameter("filtro", "%"+filtro+"%");
	        }

	        return query.getResultList();
	    }

	    public List<Object> findByColuna(String coluna){ //Retorna o numero de registro por coluna

	        StringBuilder consultvalue = new StringBuilder();
	        consultvalue.append("Select COUNT( obj."+getNameColumn(coluna)+") FROM Cidades obj WHERE obj."+getNameColumn(coluna)+" != ''");
	        @SuppressWarnings("unchecked")
			TypedQuery<Object> query = (TypedQuery<Object>) entityManager.createQuery(consultvalue.toString());	        
	        return query.getResultList();
	    }
	    
	    private String getNameColumn(String coluna) {
	        switch (coluna) {
	            case "ibge_id" : return "idIbge";
	            case "uf" : return "uf";
	            case "name" : return "name";
	            case "no_accents" : return "no_accents";
	            case "alternative_names" : return "alternative_names";
	            case "capital" : return "capital";
	            case "microregion" : return "microregion";
	            case "mesoregion" : return "mesoregion";
	            case "lat" : return "lat";
	            case "lon" : return "lon";
	            default:
	                throw new RuntimeException("A Coluna não foi encontrada.");
	        }
	    }

	}
