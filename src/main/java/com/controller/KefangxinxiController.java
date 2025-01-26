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

import com.entity.KefangxinxiEntity;
import com.entity.view.KefangxinxiView;

import com.service.KefangxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 客房信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-20 08:32:43
 */
@RestController
@RequestMapping("/kefangxinxi")
public class KefangxinxiController {
    @Autowired
    private KefangxinxiService kefangxinxiService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KefangxinxiEntity kefangxinxi, 
		HttpServletRequest request){

        EntityWrapper<KefangxinxiEntity> ew = new EntityWrapper<KefangxinxiEntity>();


		PageUtils page = kefangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefangxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KefangxinxiEntity kefangxinxi, 
		HttpServletRequest request){
        EntityWrapper<KefangxinxiEntity> ew = new EntityWrapper<KefangxinxiEntity>();

		PageUtils page = kefangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefangxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KefangxinxiEntity kefangxinxi){
       	EntityWrapper<KefangxinxiEntity> ew = new EntityWrapper<KefangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kefangxinxi, "kefangxinxi")); 
        return R.ok().put("data", kefangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KefangxinxiEntity kefangxinxi){
        EntityWrapper< KefangxinxiEntity> ew = new EntityWrapper< KefangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kefangxinxi, "kefangxinxi")); 
		KefangxinxiView kefangxinxiView =  kefangxinxiService.selectView(ew);
		return R.ok("查询客房信息成功").put("data", kefangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KefangxinxiEntity kefangxinxi = kefangxinxiService.selectById(id);
		kefangxinxi.setClicknum(kefangxinxi.getClicknum()+1);
		kefangxinxi.setClicktime(new Date());
		kefangxinxiService.updateById(kefangxinxi);
        return R.ok().put("data", kefangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KefangxinxiEntity kefangxinxi = kefangxinxiService.selectById(id);
		kefangxinxi.setClicknum(kefangxinxi.getClicknum()+1);
		kefangxinxi.setClicktime(new Date());
		kefangxinxiService.updateById(kefangxinxi);
        return R.ok().put("data", kefangxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        KefangxinxiEntity kefangxinxi = kefangxinxiService.selectById(id);
        if(type.equals("1")) {
        	kefangxinxi.setThumbsupnum(kefangxinxi.getThumbsupnum()+1);
        } else {
        	kefangxinxi.setCrazilynum(kefangxinxi.getCrazilynum()+1);
        }
        kefangxinxiService.updateById(kefangxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KefangxinxiEntity kefangxinxi, HttpServletRequest request){
    	kefangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kefangxinxi);

        kefangxinxiService.insert(kefangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KefangxinxiEntity kefangxinxi, HttpServletRequest request){
    	kefangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kefangxinxi);

        kefangxinxiService.insert(kefangxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KefangxinxiEntity kefangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kefangxinxi);
        kefangxinxiService.updateById(kefangxinxi);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kefangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,KefangxinxiEntity kefangxinxi, HttpServletRequest request,String pre){
        EntityWrapper<KefangxinxiEntity> ew = new EntityWrapper<KefangxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = kefangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kefangxinxi), params), params));
        return R.ok().put("data", page);
    }









}
