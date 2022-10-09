
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour faute complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="faute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xball" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="yball" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="point1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="point2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fauteType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="faute" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faute", propOrder = {
    "xball",
    "yball",
    "width",
    "height",
    "point1",
    "point2",
    "fauteType",
    "faute"
})
public class Faute {

    protected int xball;
    protected int yball;
    protected int width;
    protected int height;
    protected int point1;
    protected int point2;
    protected String fauteType;
    protected boolean faute;

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
     * Obtient la valeur de la propri�t� point1.
     * 
     */
    public int getPoint1() {
        return point1;
    }

    /**
     * D�finit la valeur de la propri�t� point1.
     * 
     */
    public void setPoint1(int value) {
        this.point1 = value;
    }

    /**
     * Obtient la valeur de la propri�t� point2.
     * 
     */
    public int getPoint2() {
        return point2;
    }

    /**
     * D�finit la valeur de la propri�t� point2.
     * 
     */
    public void setPoint2(int value) {
        this.point2 = value;
    }

    /**
     * Obtient la valeur de la propri�t� fauteType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFauteType() {
        return fauteType;
    }

    /**
     * D�finit la valeur de la propri�t� fauteType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFauteType(String value) {
        this.fauteType = value;
    }

    /**
     * Obtient la valeur de la propri�t� faute.
     * 
     */
    public boolean isFaute() {
        return faute;
    }

    /**
     * D�finit la valeur de la propri�t� faute.
     * 
     */
    public void setFaute(boolean value) {
        this.faute = value;
    }

}
