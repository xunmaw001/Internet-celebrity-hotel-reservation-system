package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.KefangtuidingEntity;
import com.entity.view.KefangtuidingView;

import com.service.KefangtuidingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 客房退订
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-20 08:32:43
 */
@RestController
@RequestMapping("/kefangtuiding")
public class KefangtuidingController {
    @Autowired
    private KefangtuidingService kefangtuidingService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KefangtuidingEntity kefangtuiding, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("kehu")) {
			kefangtuiding.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KefangtuidingEntity> ew = new EntityWrapper<KefangtuidingEntity>();


		PageUtils page = kefangtuidingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefangtuiding), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KefangtuidingEntity kefangtuiding, 
		HttpServletRequest request){
        EntityWrapper<KefangtuidingEntity> ew = new EntityWrapper<KefangtuidingEntity>();

		PageUtils page = kefangtuidingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefangtuiding), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KefangtuidingEntity kefangtuiding){
       	EntityWrapper<KefangtuidingEntity> ew = new EntityWrapper<KefangtuidingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kefangtuiding, "kefangtuiding")); 
        return R.ok().put("data", kefangtuidingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KefangtuidingEntity kefangtuiding){
        EntityWrapper< KefangtuidingEntity> ew = new EntityWrapper< KefangtuidingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kefangtuiding, "kefangtuiding")); 
		KefangtuidingView kefangtuidingView =  kefangtuidingService.selectView(ew);
		return R.ok("查询客房退订成功").put("data", kefangtuidingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KefangtuidingEntity kefangtuiding = kefangtuidingService.selectById(id);
        return R.ok().put("data", kefangtuiding);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KefangtuidingEntity kefangtuiding = kefangtuidingService.selectById(id);
        return R.ok().put("data", kefangtuiding);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KefangtuidingEntity kefangtuiding, HttpServletRequest request){
    	kefangtuiding.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kefangtuiding);

        kefangtuidingService.insert(kefangtuiding);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KefangtuidingEntity kefangtuiding, HttpServletRequest request){
    	kefangtuiding.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kefangtuiding);

        kefangtuidingService.insert(kefangtuiding);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KefangtuidingEntity kefangtuiding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kefangtuiding);
        kefangtuidingService.updateById(kefangtuiding);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kefangtuidingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
