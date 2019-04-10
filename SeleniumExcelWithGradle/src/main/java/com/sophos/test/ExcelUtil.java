package com.sophos.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;
	private Iterator<Row> filas;
	private Iterator<Cell> celdas;
	
	public ExcelUtil(FileInputStream archivo) {
	try {
		this.libro = new XSSFWorkbook(archivo);
		this.hoja = libro.getSheetAt(0);
		this.filas = this.hoja.iterator();
		
	} catch (FileNotFoundException e) {
		System.err.println("Error al cargar el archivo");
	} catch (IOException e) {
		System.err.println("Error al cargar el libro");
	}
	
	}
	public XSSFWorkbook getLibro() {
		return libro;
	}
	public void setLibro(XSSFWorkbook libro) {
		this.libro = libro;
	}
	
	public XSSFSheet getHoja() {
		return hoja;
	}
	public void setHoja(XSSFSheet hoja) {
		this.hoja = hoja;
	}
	public Iterator<Row> getFilas() {
		return filas;
	}
	public void setFilas(Iterator<Row> filas) {
		this.filas = filas;
	}
	public Iterator<Cell> getCeldas() {
		return celdas;
	}
	public void setCeldas(Iterator<Cell> celdas) {
		this.celdas = celdas;
	}
	
	public ArrayList<String> leerExcel(int columna) {
		Row fila;
		Cell celda;
		ArrayList<String> datos = new ArrayList<>();
		while(filas.hasNext()) {
			fila = filas.next();
			celdas = fila.cellIterator();
			while (celdas.hasNext()) {
				celda = celdas.next();
				if(celda.getColumnIndex() == columna)
					datos.add(celda.getStringCellValue());				
			}
		}
		return datos;
	}
	
	public void escribirExcel(Row filaActual, String valor) {
		Cell cell = filaActual.createCell(filaActual.getLastCellNum());
		cell.setCellValue(valor);
	}
	public void clear() throws IOException {
		libro.close();
	}
}
