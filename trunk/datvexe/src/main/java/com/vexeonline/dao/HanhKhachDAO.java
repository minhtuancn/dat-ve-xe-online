package com.vexeonline.dao;

import com.vexeonline.domain.HanhKhach;

public interface HanhKhachDAO {
    public int save(HanhKhach hanhKhach);
    public HanhKhach getByEmail(String email);
    public HanhKhach getBySDT(String sdt);
}
