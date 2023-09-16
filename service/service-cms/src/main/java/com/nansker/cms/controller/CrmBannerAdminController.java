package com.nansker.cms.controller;

import com.nansker.cms.domain.CrmBanner;
import com.nansker.cms.domain.dto.BannerDto;
import com.nansker.cms.service.CrmBannerService;
import com.nansker.commonutils.result.PageResultData;
import com.nansker.commonutils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nansker
 * @date 2023/9/15 16:03
 * @description TODO
 */
@RestController
@RequestMapping("/cms/banner/admin")
public class CrmBannerAdminController {
	@Autowired
	CrmBannerService bannerService;

	@GetMapping("/list")
	public ResultData listBanner(BannerDto bannerDto) {
		PageResultData bannerList = bannerService.getBannerList(bannerDto);
		return ResultData.ok().data(bannerList);
	}

	@GetMapping("/{id}")
	public ResultData getBannerById(@PathVariable String id) {
		CrmBanner banner = bannerService.getById(id);
		return ResultData.ok().data(banner);
	}

	@PostMapping
	public ResultData saveBanner(@RequestBody CrmBanner banner) {
		bannerService.save(banner);
		return ResultData.ok();
	}

	@PutMapping
	public ResultData updateBanner(@RequestBody CrmBanner banner) {
		bannerService.updateById(banner);
		return ResultData.ok();
	}

	@DeleteMapping("/{id}")
	public ResultData deleteBanner(@PathVariable String id) {
		boolean result = bannerService.removeById(id);
		return ResultData.ok();
	}
}
