package com.pinyougou.solrutil;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Dynamic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class TbItem implements Serializable {
    @Field
    private Long id;
    @Field("item_title")
    private String title;
    @Field("item_price")
    private BigDecimal price;
    @Field("item_image")
    private String image;
    @Field("item_goodsid")
    private Long goodsId;
    @Field("item_category")
    private String category;
    @Field("item_brand")
    private String brand;
    @Field("item_seller")
    private String seller;
    @Dynamic
    @Field("item_spec_*")
    private Map<String,String> specMap;
    public Map<String, String> getSpecMap() {
        return specMap;
    }
    public void setSpecMap(Map<String, String> specMap) {
        this.specMap = specMap;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}