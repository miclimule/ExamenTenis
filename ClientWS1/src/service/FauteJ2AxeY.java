
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour fauteJ2AxeY complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="fauteJ2AxeY">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xball" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="yball" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="widthTerrain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="xTerrain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="xRebons" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fauteJ2AxeY", propOrder = {
    "xball",
    "yball",
    "width",
    "height",
    "widthTerrain",
    "xTerrain",
    "xRebons"
})
public class FauteJ2AxeY {

    protected int xball;
    protected int yball;
    protected int width;
    protected int height;
    protected int widthTerrain;
    protected int xTerrain;
    protected int xRebons;

    /**
     * Obtient la valeur de la propriété xball.
     * 
     */
    public int getXball() {
        return xball;
    }

    /**
     * Définit la valeur de la propriété xball.
     * 
     */
    public void setXball(int value) {
        this.xball = value;
    }

    /**
     * Obtient la valeur de la propriété yball.
     * 
     */
    public int getYball() {
        return yball;
    }

    /**
     * Définit la valeur de la propriété yball.
     * 
     */
    public void setYball(int value) {
        this.yball = value;
    }

    /**
     * Obtient la valeur de la propriété width.
     * 
     */
    public int getWidth() {
        return width;
    }

    /**
     * Définit la valeur de la propriété width.
     * 
     */
    public void setWidth(int value) {
        this.width = value;
    }

    /**
     * Obtient la valeur de la propriété height.
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * Définit la valeur de la propriété height.
     * 
     */
    public void setHeight(int value) {
        this.height = value;
    }

    /**
     * Obtient la valeur de la propriété widthTerrain.
     * 
     */
    public int getWidthTerrain() {
        return widthTerrain;
    }

    /**
     * Définit la valeur de la propriété widthTerrain.
     * 
     */
    public void setWidthTerrain(int value) {
        this.widthTerrain = value;
    }

    /**
     * Obtient la valeur de la propriété xTerrain.
     * 
     */
    public int getXTerrain() {
        return xTerrain;
    }

    /**
     * Définit la valeur de la propriété xTerrain.
     * 
     */
    public void setXTerrain(int value) {
        this.xTerrain = value;
    }

    /**
     * Obtient la valeur de la propriété xRebons.
     * 
     */
    public int getXRebons() {
        return xRebons;
    }

    /**
     * Définit la valeur de la propriété xRebons.
     * 
     */
    public void setXRebons(int value) {
        this.xRebons = value;
    }

}
