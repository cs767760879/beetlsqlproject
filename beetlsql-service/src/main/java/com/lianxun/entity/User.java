package com.lianxun.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import org.beetl.sql.core.annotatoin.Table;

import java.util.Date;


/* 
* 
* gen by beetlsql 2020-02-21
*/
@Table(name="test.t_user")
public class User extends BaseRowModel {
	@ExcelProperty(value = "id", index = 0)
	private Integer id ;
	@ExcelProperty(value = "年龄", index = 1)
	private Integer age ;
	@ExcelProperty(value = "姓名", index = 2)
	private String name ;
	@ExcelProperty(value = "创建日期", index = 3)
	private Date createDate ;

	public User() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	public Integer getAge(){
		return  age;
	}
	public void setAge(Integer age ){
		this.age = age;
	}
	
	public String getName(){
		return  name;
	}
	public void setName(String name ){
		this.name = name;
	}
	
	public Date getCreateDate(){
		return  createDate;
	}
	public void setCreateDate(Date createDate ){
		this.createDate = createDate;
	}
	

}
