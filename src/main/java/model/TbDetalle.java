package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_det_boleta database table.
 * 
 */
@Embeddable
public class TbDetalle implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="num_bol", insertable=false, updatable=false)
	private int numBol;

	@Column(name="id_prod", insertable=false, updatable=false)
	private String idProd;

	public TbDetalle() {
	}
	public int getNumBol() {
		return this.numBol;
	}
	public void setNumBol(int numBol) {
		this.numBol = numBol;
	}
	public String getIdProd() {
		return this.idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbDetalle)) {
			return false;
		}
		TbDetalle castOther = (TbDetalle)other;
		return 
			(this.numBol == castOther.numBol)
			&& this.idProd.equals(castOther.idProd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numBol;
		hash = hash * prime + this.idProd.hashCode();
		
		return hash;
	}
}