package com.entity.view;

import com.entity.KefangtuidingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 客房退订
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-20 08:32:43
 */
@TableName("kefangtuiding")
public class KefangtuidingView  extends KefangtuidingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KefangtuidingView(){
	}
 
 	public KefangtuidingView(KefangtuidingEntity kefangtuidingEntity){
 	try {
			BeanUtils.copyProperties(this, kefangtuidingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
