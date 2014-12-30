/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * @author Tung
 *
 */
@Entity
public class Xe implements Serializable {
	private static final long serialVersionUID = -7138847134804774745L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer idXe;

	@Column(nullable = false, unique = true, length = 10)
	private String bienSoXe;

	@Column(nullable = false, length = 20)
	private String loaiXe;

	@Column(nullable = false)
	private int soCho;

	@Column(length = 50)
	private String hinhAnh;
	
	private boolean isActive;

	@ManyToOne
	@JoinColumn(nullable = false)
	private NhaXe nhaXe;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<TienIch> tienIchs = new HashSet<TienIch>(0);

	/**
	 * @author Tung
	 */
	public Xe() {

	}

	public Integer getIdXe() {
		return idXe;
	}

	public void setIdXe(Integer idXe) {
		this.idXe = idXe;
	}

	@RequiredStringValidator(key = "require.bienSoXe", trim = true)
	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	@RequiredStringValidator(key = "require.loaiXe", trim = true)
	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	@RequiredFieldValidator(key = "require.soCho")
	@IntRangeFieldValidator(key = "int.soCho", min = "1")
	public int getSoCho() {
		return soCho;
	}

	public void setSoCho(int soCho) {
		this.soCho = soCho;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public NhaXe getNhaXe() {
		return nhaXe;
	}

	public void setNhaXe(NhaXe nhaXe) {
		this.nhaXe = nhaXe;
	}

	public Set<TienIch> getTienIchs() {
		return tienIchs;
	}

	public void setTienIchs(Set<TienIch> tienIchs) {
		this.tienIchs = tienIchs;
	}

	@Override
	public String toString() {
		return "Xe [idXe=" + idXe + ", bienSoXe=" + bienSoXe + ", loaiXe="
				+ loaiXe + ", soCho=" + soCho + ", hinhAnh=" + hinhAnh
				+ ", isActive=" + isActive + ", nhaXe=" + nhaXe + ", tienIchs="
				+ tienIchs + "]";
	}
}
