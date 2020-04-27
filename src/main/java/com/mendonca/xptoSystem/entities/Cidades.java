package com.mendonca.xptoSystem.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidades implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@Column(name = "COD_IBGE")
	private String ibge_id;
	
	//@Column(name = "UF")
	private String uf;
	
	//@Column(name = "CIDADE")
	private String name;	
	
	private String capital;
	
	//@Column(name = "LONGITUDE")
	private String lon;
	
	//@Column(name = "LATITUDE")
	private String lat;
	
	//@Column(name = "NO_ACENTO")
	private String no_accents;
	
	//@Column(name = "NOME_ALTERNATIVO")
	private String alternative_names;
	
	//@Column(name = "MICRO_REGIAO")
	private String microregion;
	
	//@Column(name = "MESO_REGIAO")
	private String mesoregion;
	
	
public Cidades() {
	
}


public Cidades(Integer id,String ibge_id, String uf, String name, String capital, String lon, String lat, String no_accents,
		String alternative_names, String microregion, String mesoregion) {
	super();
	this.id = id;
	this.ibge_id = ibge_id;
	this.uf = uf;
	this.name = name;
	this.capital = capital;
	this.lon = lon;
	this.lat = lat;
	this.no_accents = no_accents;
	this.alternative_names = alternative_names;
	this.microregion = microregion;
	this.mesoregion = mesoregion;
}


public String getIbge_id() {
	return ibge_id;
}


public void setIbge_id(String ibge_id) {
	this.ibge_id = ibge_id;
}


public String getUf() {
	return uf;
}


public void setUf(String uf) {
	this.uf = uf;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getCapital() {
	return capital;
}


public void setCapital(String capital) {
	this.capital = capital;
}


public String getLon() {
	return lon;
}


public void setLon(String lon) {
	this.lon = lon;
}


public String getLat() {
	return lat;
}


public void setLat(String lat) {
	this.lat = lat;
}


public String getNo_accents() {
	return no_accents;
}


public void setNo_accents(String no_accents) {
	this.no_accents = no_accents;
}


public String getAlternative_names() {
	return alternative_names;
}


public void setAlternative_names(String alternative_names) {
	this.alternative_names = alternative_names;
}


public String getMicroregion() {
	return microregion;
}


public void setMicroregion(String microregion) {
	this.microregion = microregion;
}


public String getMesoregion() {
	return mesoregion;
}


public void setMesoregion(String mesoregion) {
	this.mesoregion = mesoregion;
}

public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((capital == null) ? 0 : capital.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((uf == null) ? 0 : uf.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cidades other = (Cidades) obj;
	if (capital == null) {
		if (other.capital != null)
			return false;
	} else if (!capital.equals(other.capital))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (uf == null) {
		if (other.uf != null)
			return false;
	} else if (!uf.equals(other.uf))
		return false;
	return true;
}


@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Cidades [id=");
	builder.append(id);
	builder.append(", ibge_id=");
	builder.append(ibge_id);
	builder.append(", uf=");
	builder.append(uf);
	builder.append(", name=");
	builder.append(name);
	builder.append(", capital=");
	builder.append(capital);
	builder.append(", lon=");
	builder.append(lon);
	builder.append(", lat=");
	builder.append(lat);
	builder.append(", no_accents=");
	builder.append(no_accents);
	builder.append(", alternative_names=");
	builder.append(alternative_names);
	builder.append(", microregion=");
	builder.append(microregion);
	builder.append(", mesoregion=");
	builder.append(mesoregion);
	builder.append("]");
	return builder.toString();
}


	
}
