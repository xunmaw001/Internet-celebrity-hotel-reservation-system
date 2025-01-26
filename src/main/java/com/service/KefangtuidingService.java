package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KefangtuidingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KefangtuidingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KefangtuidingView;


/**
 * 客房退订
 *
 * @author 
 * @email 
 * @date 2023-04-20 08:32:43
 */
public interface KefangtuidingService extends IService<KefangtuidingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KefangtuidingVO> selectListVO(Wrapper<KefangtuidingEntity> wrapper);
   	
   	KefangtuidingVO selectVO(@Param("ew") Wrapper<KefangtuidingEntity> wrapper);
   	
   	List<KefangtuidingView> selectListView(Wrapper<KefangtuidingEntity> wrapper);
   	
   	KefangtuidingView selectView(@Param("ew") Wrapper<KefangtuidingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KefangtuidingEntity> wrapper);
   	

}

