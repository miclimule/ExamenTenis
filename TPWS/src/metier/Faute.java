package metier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Faute")
@XmlAccessorType(XmlAccessType.FIELD)
public class Faute {
	
	int xball = 0;
	int yball = 0;
	int width = 0;
	int height = 0;
	int point1 = 0;
	int point2 = 0;
	String fauteType = "";
	boolean faute;
	public Faute(int xball, int yball, int width, int height, int point1, int point2, String fauteType, boolean faute) {
		super();
		this.xball = xball;
		this.yball = yball;
		this.width = width;
		this.height = height;
		this.point1 = point1;
		this.point2 = point2;
		this.fauteType = fauteType;
		this.faute = faute;
	}
	public Faute() {
		super();
	}
	public int getXball() {
		return xball;
	}
	public void setXball(int xball) {
		this.xball = xball;
	}
	public int getYball() {
		return yball;
	}
	public void setYball(int yball) {
		this.yball = yball;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getPoint1() {
		return point1;
	}
	public void setPoint1(int point1) {
		this.point1 = point1;
	}
	public int getPoint2() {
		return point2;
	}
	public void setPoint2(int point2) {
		this.point2 = point2;
	}
	public String getFauteType() {
		return fauteType;
	}
	public void setFauteType(String fauteType) {
		this.fauteType = fauteType;
	}
	public boolean isFaute() {
		return faute;
	}
	public void setFaute(boolean faute) {
		this.faute = faute;
	}
	
}
