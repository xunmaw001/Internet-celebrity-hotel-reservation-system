package com.dao;

import com.entity.DiscusskefangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusskefangxinxiVO;
import com.entity.view.DiscusskefangxinxiView;


/**
 * 客房信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-20 08:32:43
 */
public interface DiscusskefangxinxiDao extends BaseMapper<DiscusskefangxinxiEntity> {
	
	List<DiscusskefangxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusskefangxinxiEntity> wrapper);
	
	DiscusskefangxinxiVO selectVO(@Param("ew") Wrapper<DiscusskefangxinxiEntity> wrapper);
	
	List<DiscusskefangxinxiView> selectListView(@Param("ew") Wrapper<DiscusskefangxinxiEntity> wrapper);

	List<DiscusskefangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusskefangxinxiEntity> wrapper);
	
	DiscusskefangxinxiView selectView(@Param("ew") Wrapper<DiscusskefangxinxiEntity> wrapper);
	

}
