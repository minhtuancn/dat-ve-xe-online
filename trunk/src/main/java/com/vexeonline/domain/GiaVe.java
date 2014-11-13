/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Tung
 *
 */
@Entity
public class GiaVe implements Serializable {
	private static final long serialVersionUID = 6278119685524435760L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer idGiaVe;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private LichTuyen lichTuyen;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date ngayBatDau;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date ngayKetThuc;

	/**
	 * unit : VND
	 */
	@Column(nullable = false)
	private int giaVe;

	/**
	 * @author Tung
	 */
	public GiaVe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Tung
	 * @param idGiaVe
	 * @param lichTuyen
	 * @param ngaybatDau
	 * @param ngayKetThuc
	 * @param giaVe
	 */
	public GiaVe(Integer idGiaVe, LichTuyen lichTuyen, Date ngaybatDau,
			Date ngayKetThuc, int giaVe) {
		super();
		this.idGiaVe = idGiaVe;
		this.lichTuyen = lichTuyen;
		this.ngayBatDau = ngaybatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.giaVe = giaVe;
	}

	public Integer getIdGiaVe() {
		return idGiaVe;
	}
	
	public void setIdGiaVe(Integer idGiaVe) {
		this.idGiaVe = idGiaVe;
	}

	public LichTuyen getLichTuyen() {
		return lichTuyen;
	}

	public void setLichTuyen(LichTuyen lichTuyen) {
		this.lichTuyen = lichTuyen;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngaybatDau) {
		this.ngayBatDau = ngaybatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}
}
