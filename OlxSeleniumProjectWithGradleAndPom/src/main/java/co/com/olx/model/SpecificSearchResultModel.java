package co.com.olx.model;

public class SpecificSearchResultModel {
	
	private String departament;
	private String city;
	private String category;
	private String subcategory;
	
	public SpecificSearchResultModel(String departamento, String ciudad, String categoria, String subcategoria) {
		this.departament = departamento;
		this.city = ciudad;
		this.category = categoria;
		this.subcategory = subcategoria;
	}
	
	public SpecificSearchResultModel() {
		
	}

	public String getDepartament() {
		return departament;
	}

	public void setDepartament(String departamento) {
		this.departament = departamento;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String ciudad) {
		this.city = ciudad;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String categoria) {
		this.category = categoria;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategoria) {
		this.subcategory = subcategoria;
	}

	
}
