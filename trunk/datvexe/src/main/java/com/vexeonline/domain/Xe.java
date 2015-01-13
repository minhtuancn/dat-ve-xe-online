/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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

/*	@Column(nullable = false, length = 20)
	private String loaiXe;

	@Column(nullable = false)
	private int soCho;

	@Column(length = 50)
	private String hinhAnh;*/

	@ManyToOne
	private VehicleType type;
	
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(name = "idXe"))
	@Column(length = 3)
	private Set<String> viTris = new HashSet<String>(0);

	@Column(nullable = false)
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

	/*@RequiredStringValidator(key = "require.loaiXe", trim = true)
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
	}*/

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
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

	public Set<String> getViTris() {
		return viTris;
	}

	public void setViTris(Set<String> viTris) {
		this.viTris = viTris;
	}
}
