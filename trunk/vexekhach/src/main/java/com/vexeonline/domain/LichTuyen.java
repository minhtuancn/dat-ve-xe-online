/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
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

import org.hibernate.annotations.Type;

import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

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

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private NgayCuaTuan thu;

	@Type(type = "time")
	@Column(nullable = false)
	private Time gioDi;

	@ManyToOne
	@JoinColumn(nullable = false)
	private TuyenXe tuyenXe;

	/**
	 * follow hour
	 */
	@Column(nullable = false, precision = 2)
	private double tongThoiGian;

	@OneToMany(mappedBy = "lichTuyen")
	private Set<ChuyenXe> chuyenXes = new HashSet<ChuyenXe>(0);

	@ManyToOne
	@JoinColumn(nullable = false)
	private Xe xe;

	@OneToMany(mappedBy = "lichTuyen")
	private Set<GiaVe> giaVes = new HashSet<GiaVe>(0);

	/**
	 * @author Tung
	 */
	public LichTuyen() {

	}

	public Integer getIdLichTuyen() {
		return idLichTuyen;
	}

	public void setIdLichTuyen(Integer idLichTuyen) {
		this.idLichTuyen = idLichTuyen;
	}

	@RequiredFieldValidator(key = "require.thu")
	public NgayCuaTuan getThu() {
		return thu;
	}

	public void setThu(NgayCuaTuan thu) {
		this.thu = thu;
	}

	@RequiredFieldValidator(key = "require.gioDi")
	public Time getGioDi() {
		return gioDi;
	}

	public void setGioDi(Time gioDi) {
		this.gioDi = gioDi;
	}

	@RequiredFieldValidator(key = "require.tongThoiGian")
	@DoubleRangeFieldValidator(key = "double.tongThoiGian", minExclusive = "0.0")
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

	public Set<ChuyenXe> getChuyenXes() {
		return chuyenXes;
	}

	public void setChuyenXes(Set<ChuyenXe> chuyenXes) {
		this.chuyenXes = chuyenXes;
	}

}
