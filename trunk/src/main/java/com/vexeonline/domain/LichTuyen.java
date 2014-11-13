/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Tung
 *
 */
@Entity
public class LichTuyen implements Serializable {
	private static final long serialVersionUID = -8848042238912676710L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer idLichTuyen;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(nullable = false)
	private NgayCuaTuan thu;

	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date gioDi;

	@ManyToOne
	@JoinColumn(nullable = false)
	private TuyenXe tuyenXe;

	/**
	 * follow hour
	 */
	@Column(nullable = false, precision = 2)
	private double tongThoiGian;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Xe xe;

	@OneToMany(mappedBy = "lichTuyen")
	private Set<GiaVe> giaVes;

	/**
	 * @author Tung
	 */
	public LichTuyen() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Tung
	 * @param idLichTuyen
	 * @param thu
	 * @param gioDi
	 * @param tuyenXe
	 * @param tongThoiGian
	 * @param xe
	 */
	public LichTuyen(Integer idLichTuyen, NgayCuaTuan thu, Date gioDi,
			TuyenXe tuyenXe, double tongThoiGian, Xe xe) {
		super();
		this.idLichTuyen = idLichTuyen;
		this.thu = thu;
		this.gioDi = gioDi;
		this.tuyenXe = tuyenXe;
		this.tongThoiGian = tongThoiGian;
		this.xe = xe;
	}

	public Integer getIdLichTuyen() {
		return idLichTuyen;
	}

	public void setIdLichTuyen(Integer idLichTuyen) {
		this.idLichTuyen = idLichTuyen;
	}

	public NgayCuaTuan getThu() {
		return thu;
	}

	public void setThu(NgayCuaTuan thu) {
		this.thu = thu;
	}

	public Date getGioDi() {
		return gioDi;
	}

	public void setGioDi(Date gioDi) {
		this.gioDi = gioDi;
	}

	public double getTongThoiGian() {
		return tongThoiGian;
	}

	public void setTongThoiGian(double tongThoiGian) {
		this.tongThoiGian = tongThoiGian;
	}

	public TuyenXe getTuyenXe() {
		return tuyenXe;
	}

	public void setTuyenXe(TuyenXe tuyenXe) {
		this.tuyenXe = tuyenXe;
	}

	public Xe getXe() {
		return xe;
	}

	public void setXe(Xe xe) {
		this.xe = xe;
	}

	public Set<GiaVe> getGiaVes() {
		return giaVes;
	}

	public void setGiaVes(Set<GiaVe> giaVes) {
		this.giaVes = giaVes;
	}

}
