package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 客房信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-20 08:32:43
 */
@TableName("kefangxinxi")
public class KefangxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KefangxinxiEntity() {
		
	}
	
	public KefangxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 客房号
	 */
					
	private String kefanghao;
	
	/**
	 * 客房类型
	 */
					
	private String kefangleixing;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 房间面积
	 */
					
	private String fangjianmianji;
	
	/**
	 * 价格
	 */
					
	private Float jiage;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	/**
	 * 客房位置
	 */
					
	private String kefangweizhi;
	
	/**
	 * 可约时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date keyueshijian;
	
	/**
	 * 房间设施
	 */
					
	private String fangjiansheshi;
	
	/**
	 * 客房介绍
	 */
					
	private String kefangjieshao;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：客房号
	 */
	public void setKefanghao(String kefanghao) {
		this.kefanghao = kefanghao;
	}
	/**
	 * 获取：客房号
	 */
	public String getKefanghao() {
		return kefanghao;
	}
	/**
	 * 设置：客房类型
	 */
	public void setKefangleixing(String kefangleixing) {
		this.kefangleixing = kefangleixing;
	}
	/**
	 * 获取：客房类型
	 */
	public String getKefangleixing() {
		return kefangleixing;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：房间面积
	 */
	public void setFangjianmianji(String fangjianmianji) {
		this.fangjianmianji = fangjianmianji;
	}
	/**
	 * 获取：房间面积
	 */
	public String getFangjianmianji() {
		return fangjianmianji;
	}
	/**
	 * 设置：价格
	 */
	public void setJiage(Float jiage) {
		this.jiage = jiage;
	}
	/**
	 * 获取：价格
	 */
	public Float getJiage() {
		return jiage;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
	/**
	 * 设置：客房位置
	 */
	public void setKefangweizhi(String kefangweizhi) {
		this.kefangweizhi = kefangweizhi;
	}
	/**
	 * 获取：客房位置
	 */
	public String getKefangweizhi() {
		return kefangweizhi;
	}
	/**
	 * 设置：可约时间
	 */
	public void setKeyueshijian(Date keyueshijian) {
		this.keyueshijian = keyueshijian;
	}
	/**
	 * 获取：可约时间
	 */
	public Date getKeyueshijian() {
		return keyueshijian;
	}
	/**
	 * 设置：房间设施
	 */
	public void setFangjiansheshi(String fangjiansheshi) {
		this.fangjiansheshi = fangjiansheshi;
	}
	/**
	 * 获取：房间设施
	 */
	public String getFangjiansheshi() {
		return fangjiansheshi;
	}
	/**
	 * 设置：客房介绍
	 */
	public void setKefangjieshao(String kefangjieshao) {
		this.kefangjieshao = kefangjieshao;
	}
	/**
	 * 获取：客房介绍
	 */
	public String getKefangjieshao() {
		return kefangjieshao;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}
