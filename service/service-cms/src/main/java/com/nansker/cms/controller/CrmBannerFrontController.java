package com.nansker.cms.controller;

import com.nansker.cms.domain.CrmBanner;
import com.nansker.cms.service.CrmBannerService;
import com.nansker.commonutils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Nansker
 * @date 2023/9/15 16:03
 * @description TODO
 */
@RestController
@RequestMapping("/cms/banner/front")
public class CrmBannerFrontController {
	@Autowired
	CrmBannerService bannerService;

	/**
	 * @author Nansker
	 * @date 2023/9/15 18:01
	 * @description 获取所有轮播图
	*/
	@GetMapping("/all")
	public ResultData allBanner(){
		List<CrmBanner> banners = bannerService.getAllBanner();
		return ResultData.ok().data(banners);
	}
}
