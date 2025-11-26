package model;
import lombok.Getter;
import lombok.Setter;

/**
 * Repräsentiert ein Produkt mit ID, Name, Kategorie, Einheit und Menge.
 *
 * @author Ramis Ekici
 * @version 23-09-2025
 */
@Getter
@Setter
public class ProductData {
    /**
     * Standardkonstruktor.
     */
    public ProductData(){

    }


    private String productID;
    private String productName;
    private String productCategory;
    private String productUnit;
    private int productQuantity;

    /**
     * Konstruktor zum Setzen aller Produktinformationen.
     *
     * @param productID ID des Produkts
     * @param productName Name des Produkts
     * @param productCategory Kategorie des Produkts
     * @param productUnit Einheit des Produkts
     * @param productQuantity Menge des Produkts
     */
    public ProductData(String productID, String productName, String productCategory, String productUnit, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productUnit = productUnit;
        this.productQuantity = productQuantity;
    }

    /**
     * Gibt eine textuelle Darstellung des Produkts zurück.
     *
     * @return Informationen über das Produkt als String
     */
    @Override
    public String toString() {
        return "ProductData{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory=" + productCategory +
                ", productUnit='" + productUnit + '\'' +
                '}';
    }
}

