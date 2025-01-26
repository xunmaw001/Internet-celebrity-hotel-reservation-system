package com.dao;

import com.entity.KefangtuidingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KefangtuidingVO;
import com.entity.view.KefangtuidingView;


/**
 * 客房退订
 * 
 * @author 
 * @email 
 * @date 2023-04-20 08:32:43
 */
public interface KefangtuidingDao extends BaseMapper<KefangtuidingEntity> {
	
	List<KefangtuidingVO> selectListVO(@Param("ew") Wrapper<KefangtuidingEntity> wrapper);
	
	KefangtuidingVO selectVO(@Param("ew") Wrapper<KefangtuidingEntity> wrapper);
	
	List<KefangtuidingView> selectListView(@Param("ew") Wrapper<KefangtuidingEntity> wrapper);

	List<KefangtuidingView> selectListView(Pagination page,@Param("ew") Wrapper<KefangtuidingEntity> wrapper);
	
	KefangtuidingView selectView(@Param("ew") Wrapper<KefangtuidingEntity> wrapper);
	

}
