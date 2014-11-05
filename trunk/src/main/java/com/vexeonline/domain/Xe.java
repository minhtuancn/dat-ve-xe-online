/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	/**
	 * @author Tung
	 */
	public Xe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Tung
	 * @param idXe
	 * @param bienSoXe
	 * @param loaiXe
	 * @param soCho
	 * @param hinhAnh
	 * @param isActive
	 * @param idNhaXe
	 */
	public Xe(Integer idXe, String bienSoXe, String loaiXe, int soCho,
			String hinhAnh, boolean isActive, NhaXe nhaXe) {
		super();
		this.idXe = idXe;
		this.bienSoXe = bienSoXe;
		this.loaiXe = loaiXe;
		this.soCho = soCho;
		this.hinhAnh = hinhAnh;
		this.isActive = isActive;
		this.nhaXe = nhaXe;
	}

	public Integer getIdXe() {
		return idXe;
	}

	public void setIdXe(Integer idXe) {
		this.idXe = idXe;
	}

	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

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

}
