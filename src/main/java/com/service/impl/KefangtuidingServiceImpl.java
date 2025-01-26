package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KefangtuidingDao;
import com.entity.KefangtuidingEntity;
import com.service.KefangtuidingService;
import com.entity.vo.KefangtuidingVO;
import com.entity.view.KefangtuidingView;

@Service("kefangtuidingService")
public class KefangtuidingServiceImpl extends ServiceImpl<KefangtuidingDao, KefangtuidingEntity> implements KefangtuidingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KefangtuidingEntity> page = this.selectPage(
                new Query<KefangtuidingEntity>(params).getPage(),
                new EntityWrapper<KefangtuidingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KefangtuidingEntity> wrapper) {
		  Page<KefangtuidingView> page =new Query<KefangtuidingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KefangtuidingVO> selectListVO(Wrapper<KefangtuidingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KefangtuidingVO selectVO(Wrapper<KefangtuidingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KefangtuidingView> selectListView(Wrapper<KefangtuidingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KefangtuidingView selectView(Wrapper<KefangtuidingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
