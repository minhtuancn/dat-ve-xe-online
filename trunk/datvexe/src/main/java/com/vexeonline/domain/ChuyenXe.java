/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;
import java.sql.Date;
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

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

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

	@Type(type = "date")
	@Column(nullable = false)
	private Date ngayDi;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TrangThaiChuyenXe trangThai;

	@ManyToOne
	@JoinColumn(nullable = false)
	private LichTuyen lichTuyen;

	@OneToMany(mappedBy = "chuyenXe")
	private Set<VeXe> veXes = new HashSet<VeXe>(0);

	@OneToMany(mappedBy = "chuyenXe")
	private Set<DanhGia> danhGias = new HashSet<DanhGia>(0);

	/**
	 * @author Tung
	 */
	public ChuyenXe() {

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

	@RequiredFieldValidator(key = "require.ngayDi")
	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public TrangThaiChuyenXe getTrangThai() {
		return trangThai;
	}

	@RequiredFieldValidator(key = "require.trangThai")
	public void setTrangThai(TrangThaiChuyenXe trangThai) {
		this.trangThai = trangThai;
	}

	public LichTuyen getLichTuyen() {
		return lichTuyen;
	}

	public void setLichTuyen(LichTuyen lichTuyen) {
		this.lichTuyen = lichTuyen;
	}

	public Set<VeXe> getVeXes() {
		return veXes;
	}

	public void setVeXes(Set<VeXe> veXes) {
		this.veXes = veXes;
	}

	public Set<DanhGia> getDanhGias() {
		return danhGias;
	}

	public void setDanhGias(Set<DanhGia> danhGias) {
		this.danhGias = danhGias;
	}

}
