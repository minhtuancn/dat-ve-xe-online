/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class ChuyenXe implements Serializable {
	private static final long serialVersionUID = -5123060603099988251L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer idChuyenXe;

	@Column(length = 50)
	private String taiXe;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date ngayDi;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TrangThaiChuyenXe trangThai;

	@ManyToOne
	@JoinColumn(nullable = false)
	private LichTuyen lichChuyen;

	/**
	 * @author Tung
	 */
	public ChuyenXe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Tung
	 * @param idChuyenXe
	 * @param taiXe
	 * @param ngayDi
	 * @param trangThai
	 * @param idLichChuyen
	 */
	public ChuyenXe(Integer idChuyenXe, String taiXe, Date ngayDi,
			TrangThaiChuyenXe trangThai, LichTuyen lichChuyen) {
		super();
		this.idChuyenXe = idChuyenXe;
		this.taiXe = taiXe;
		this.ngayDi = ngayDi;
		this.trangThai = trangThai;
		this.lichChuyen = lichChuyen;
	}

	public Integer getIdChuyenXe() {
		return idChuyenXe;
	}

	public void setIdChuyenXe(Integer idChuyenXe) {
		this.idChuyenXe = idChuyenXe;
	}

	public String getTaiXe() {
		return taiXe;
	}

	public void setTaiXe(String taiXe) {
		this.taiXe = taiXe;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public TrangThaiChuyenXe getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiChuyenXe trangThai) {
		this.trangThai = trangThai;
	}

	public LichTuyen getLichChuyen() {
		return lichChuyen;
	}

	public void setLichChuyen(LichTuyen lichChuyen) {
		this.lichChuyen = lichChuyen;
	}

}
