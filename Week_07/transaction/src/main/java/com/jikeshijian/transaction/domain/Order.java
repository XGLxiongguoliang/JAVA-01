package com.jikeshijian.transaction.domain;

import java.util.Date;

/**
 * @program com.jikeshijian.transaction.domain
 * @description 订单实体类
 * @auther Mr.Xiong
 * @create 2021-03-06 14:33:32
 */
public class Order {
    //主键自增id
    private Long id;
      //订单编号
    private String orderNumber;
    //卖家账号
    private String sellAccount;
    //买家账号
    private String buyAccount;
    //商品编号
    private String productNumber;
    //购买数量
    private Integer buyNum;
    //商品单价
    private Double price;
    //商品描述
    private String detail;
    //下单时间
    private Date orderTime;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSellAccount() {
        return sellAccount;
    }

    public void setSellAccount(String sellAccount) {
        this.sellAccount = sellAccount;
    }

    public String getBuyAccount() {
        return buyAccount;
    }

    public void setBuyAccount(String buyAccount) {
        this.buyAccount = buyAccount;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
