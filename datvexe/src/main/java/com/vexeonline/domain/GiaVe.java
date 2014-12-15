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

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

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

	}
	
	

	public GiaVe(Date ngayBatDau, Date ngayKetThuc, int giaVe) {
		super();
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.giaVe = giaVe;
	}

	public Integer getIdGiaVe() {
		return idGiaVe;
	}

	public void setIdGiaVe(Integer idGiaVe) {
		this.idGiaVe = idGiaVe;
	}

	@RequiredFieldValidator(key = "require.lichtuyen")
	public LichTuyen getLichTuyen() {
		return lichTuyen;
	}

	public void setLichTuyen(LichTuyen lichTuyen) {
		this.lichTuyen = lichTuyen;
	}

	@RequiredFieldValidator(key = "require.ngayBatDau")
	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngaybatDau) {
		this.ngayBatDau = ngaybatDau;
	}

	@RequiredFieldValidator(key = "require.ngayKetThuc")
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	@IntRangeFieldValidator(key = "range.giaVe", min = "0")
	public int getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}

	@Override
	public String toString() {
		return "GiaVe [idGiaVe=" + idGiaVe + ", lichTuyen=" + lichTuyen
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc
				+ ", giaVe=" + giaVe + "]";
	}
}
