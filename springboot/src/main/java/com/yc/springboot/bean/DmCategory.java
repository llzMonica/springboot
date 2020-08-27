package com.yc.springboot.bean;

import java.util.List;

import org.apache.ibatis.type.Alias;

//@Alias("hello")  使用注解可以作为类的别名
public class DmCategory {
    private Integer id;

    private String cname;

    private Integer pid;
    
    private List<DmCategory> children;
    

    public List<DmCategory> getChildren() {
		return children;
	}

	public void setChildren(List<DmCategory> children) {
		this.children = children;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	@Override
	public String toString() {
		return "DmCategory [id=" + id + ", cname=" + cname + ", pid=" + pid + "]";
	}
    
    
}