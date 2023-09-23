package com.nansker.cms.controller;

import com.nansker.entity.cms.CrmBanner;
import com.nansker.cms.service.CrmBannerService;
import com.nansker.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

	@Cacheable(value = "banner",key = "'all'")
	@GetMapping("/all")
	public ResultData allBanner(){
		List<CrmBanner> banners = bannerService.getAllBanner();
		return ResultData.ok().data(banners);
	}
}
