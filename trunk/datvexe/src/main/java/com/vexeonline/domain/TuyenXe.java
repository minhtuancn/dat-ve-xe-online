/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Tung
 *
 */
@Entity
public class TuyenXe implements Serializable {
	private static final long serialVersionUID = 3883272584108357250L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer idTuyenXe;

	@ManyToOne
	@JoinColumn(nullable = false)
	private BenXe benDi;

	@ManyToOne
	@JoinColumn(nullable = false)
	private BenXe benDen;

	private int doDai;

	@Column(length = 500)
	private String moTa;

	@OneToMany(mappedBy = "tuyenXe")
	private Set<LichTuyen> lichTuyens = new HashSet<LichTuyen>(0);

	/**
	 * @author Tung
	 */
	public TuyenXe() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTuyenXe() {
		return idTuyenXe;
	}
	
	public void setIdTuyenXe(Integer idTuyenXe) {
		this.idTuyenXe = idTuyenXe;
	}

	public BenXe getBenDi() {
		return benDi;
	}

	public void setBenDi(BenXe benDi) {
		this.benDi = benDi;
	}

	public BenXe getBenDen() {
		return benDen;
	}

	public void setBenDen(BenXe benDen) {
		this.benDen = benDen;
	}

	public int getDoDai() {
		return doDai;
	}

	public void setDoDai(int doDai) {
		this.doDai = doDai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Set<LichTuyen> getLichTuyens() {
		return lichTuyens;
	}

	public void setLichTuyens(Set<LichTuyen> lichTuyens) {
		this.lichTuyens = lichTuyens;
	}

	@Override
	public String toString() {
		return "TuyenXe [idTuyenXe=" + idTuyenXe + ", benDi=" + benDi
				+ ", benDen=" + benDen + ", doDai=" + doDai + ", moTa=" + moTa
				+ ", lichTuyens=" + lichTuyens + "]";
	}
}
