package com.pinyougou.sellergoods.service;

import entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<TbBrand> findAll();
    public PageResult findPage(int pageNum, int pageSize);
    public void add(TbBrand brand);
    public void update(TbBrand brand);
    public TbBrand findOne(Long id);
    public void delete(Long [] ids);
    public PageResult findPage(TbBrand brand, int pageNum,int pageSize);
    List<Map> selectOptionList();
}
