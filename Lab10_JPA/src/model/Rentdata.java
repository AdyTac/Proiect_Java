package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rentdata database table.
 * 
 */
@Entity
@NamedQuery(name="Rentdata.findAll", query="SELECT r FROM Rentdata r")
public class Rentdata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRentData;

	private String pickUpData;

	private String returnData;

	public Rentdata() {
	}

	public int getIdRentData() {
		return this.idRentData;
	}

	public void setIdRentData(int idRentData) {
		this.idRentData = idRentData;
	}

	public String getPickUpData() {
		return this.pickUpData;
	}

	public void setPickUpData(String pickUpData) {
		this.pickUpData = pickUpData;
	}

	public String getReturnData() {
		return this.returnData;
	}

	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}

}