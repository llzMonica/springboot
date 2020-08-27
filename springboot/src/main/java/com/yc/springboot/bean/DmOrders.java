package com.yc.springboot.bean;

import java.sql.Timestamp;
import java.util.List;

public class DmOrders {
    private Integer id;

    private Double total;

    private Timestamp createtime;

    private Integer state;

    private Integer uid;

    private Integer aid;
    
    private List<DmOrderitem> orderitem;
    
    public List<DmOrderitem> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(List<DmOrderitem> orderitem) {
        this.orderitem = orderitem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

	@Override
	public String toString() {
		return "DmOrders [id=" + id + ", total=" + total + ", createtime=" + createtime + ", state=" + state + ", uid="
				+ uid + ", aid=" + aid + ", orderitem=" + orderitem + "]";
	}
    
    
}