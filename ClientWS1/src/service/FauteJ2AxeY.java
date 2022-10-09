
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour fauteJ2AxeY complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� xball.
     * 
     */
    public int getXball() {
        return xball;
    }

    /**
     * D�finit la valeur de la propri�t� xball.
     * 
     */
    public void setXball(int value) {
        this.xball = value;
    }

    /**
     * Obtient la valeur de la propri�t� yball.
     * 
     */
    public int getYball() {
        return yball;
    }

    /**
     * D�finit la valeur de la propri�t� yball.
     * 
     */
    public void setYball(int value) {
        this.yball = value;
    }

    /**
     * Obtient la valeur de la propri�t� width.
     * 
     */
    public int getWidth() {
        return width;
    }

    /**
     * D�finit la valeur de la propri�t� width.
     * 
     */
    public void setWidth(int value) {
        this.width = value;
    }

    /**
     * Obtient la valeur de la propri�t� height.
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * D�finit la valeur de la propri�t� height.
     * 
     */
    public void setHeight(int value) {
        this.height = value;
    }

    /**
     * Obtient la valeur de la propri�t� widthTerrain.
     * 
     */
    public int getWidthTerrain() {
        return widthTerrain;
    }

    /**
     * D�finit la valeur de la propri�t� widthTerrain.
     * 
     */
    public void setWidthTerrain(int value) {
        this.widthTerrain = value;
    }

    /**
     * Obtient la valeur de la propri�t� xTerrain.
     * 
     */
    public int getXTerrain() {
        return xTerrain;
    }

    /**
     * D�finit la valeur de la propri�t� xTerrain.
     * 
     */
    public void setXTerrain(int value) {
        this.xTerrain = value;
    }

    /**
     * Obtient la valeur de la propri�t� xRebons.
     * 
     */
    public int getXRebons() {
        return xRebons;
    }

    /**
     * D�finit la valeur de la propri�t� xRebons.
     * 
     */
    public void setXRebons(int value) {
        this.xRebons = value;
    }

}
