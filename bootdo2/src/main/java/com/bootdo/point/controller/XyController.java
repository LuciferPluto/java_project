package com.bootdo.point.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.point.domain.XyDO;
import com.bootdo.point.service.XyService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * InnoDB free: 9216 kB
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 09:11:43
 */
 
@Controller
@RequestMapping("/point/xy")
public class XyController {
	@Autowired
	private XyService xyService;
	
	@GetMapping()
	String Xy(){
	    return "point/xy/xy";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<XyDO> xyList = xyService.list(query);
		int total = xyService.count(query);
		PageUtils pageUtils = new PageUtils(xyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "point/xy/add";
	}

	@GetMapping("/edit/{pointId}")
	String edit(@PathVariable("pointId") String pointId,Model model){
		XyDO xy = xyService.get(pointId);
		model.addAttribute("xy", xy);
	    return "point/xy/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( XyDO xy){
		if(xyService.save(xy)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( XyDO xy){
		xyService.update(xy);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( String pointId){
		if(xyService.remove(pointId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") String[] pointIds){
		xyService.batchRemove(pointIds);
		return R.ok();
	}
	
}
