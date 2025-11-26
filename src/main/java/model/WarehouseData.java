package model;
// import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Repräsentiert ein Lager mit Basisinformationen und einer Menge an Produkten.
 * Bietet Methoden zum Abrufen und Verwalten von Produkten.
 *
 * @author Ramis Ekici
 * @version 23-09-2025
 */
// @JacksonXmlRootElement(localName = "warehouse")
public class WarehouseData {
	
	private String warehouseID;
	private String warehouseName;
	private String timestamp;
	private String warehouseAddress;
	private String warehousePostalCode;
	private String warehouseCity;
	private String warehouseCountry;
	private Set<ProductData> products;

	/**
	 * Standardkonstruktor. Initialisiert den Zeitstempel.
	 */
	public WarehouseData() {
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}


	/**
	 * Liefert ein Produkt anhand seiner ID.
	 *
	 * @param productID ID des Produkts
	 * @return Produkt oder null, falls nicht gefunden
	 */
	public ProductData getProduct(String productID) {
		if (products == null) {
			return null;
		}
		Iterator<ProductData> iterator = products.iterator();
		while (iterator.hasNext()) {
			ProductData product = iterator.next();
			if (product.getProductID().equals(productID)) {
				return product;
			}
		}
		return null;
	}



	/**
	 * Fügt ein Produkt dem Lager hinzu, falls es noch nicht vorhanden ist.
	 *
	 * @param product Produkt, das hinzugefügt werden soll
	 * @return true, falls hinzugefügt, sonst false
	 */
	public boolean addProduct(ProductData product) {
		if (this.products == null) {
			return false;
		}

		if (this.products.contains(product)) {
			return false;
		}

		return this.products.add(product);
	}

	/**
	 * Liefert alle Produkte des Lagers.
	 *
	 * @return Menge der Produkte
	 */
	public Set<ProductData> getProducts() {
		return products;
	}

	/**
	 * Setzt die Menge der Produkte im Lager.
	 *
	 * @param products Menge der Produkte
	 */
	public void setProducts(Set<ProductData> products) {
		this.products = products;
	}

	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public String getWarehousePostalCode() {
		return warehousePostalCode;
	}

	public void setWarehousePostalCode(String warehousePostalCode) {
		this.warehousePostalCode = warehousePostalCode;
	}

	public String getWarehouseCity() {
		return warehouseCity;
	}

	public void setWarehouseCity(String warehouseCity) {
		this.warehouseCity = warehouseCity;
	}

	public String getWarehouseCountry() {
		return warehouseCountry;
	}

	public void setWarehouseCountry(String warehouseCountry) {
		this.warehouseCountry = warehouseCountry;
	}


	public String getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gibt eine textuelle Darstellung des Lagers zurück.
	 *
	 * @return Informationen über das Lager als String
	 */
	@Override
	public String toString() {
		return "WarehouseData{" +
				"warehouseID='" + warehouseID + '\'' +
				", warehouseName='" + warehouseName + '\'' +
				", timestamp='" + timestamp + '\'' +
				", warehouseAddress='" + warehouseAddress + '\'' +
				", warehousePostalCode='" + warehousePostalCode + '\'' +
				", warehouseCity='" + warehouseCity + '\'' +
				", warehouseCountry='" + warehouseCountry + '\'' +
				'}';
	}



}
