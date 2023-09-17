package com.nansker.cms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nansker.cms.domain.CrmBanner;
import com.nansker.cms.domain.dto.BannerDto;
import com.nansker.cms.service.CrmBannerService;
import com.nansker.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
		Page result = bannerService.getBannerList(bannerDto);
		return ResultData.ok().pageData(result);
	}

	@Cacheable(value = "banner",key = "'byId:'+#id")
	@GetMapping("/{id}")
	public ResultData getBannerById(@PathVariable String id) {
		CrmBanner banner = bannerService.getById(id);
		return ResultData.ok().data(banner);
	}

	@CacheEvict(value = "banner", allEntries=true)
	@PostMapping
	public ResultData saveBanner(@RequestBody CrmBanner banner) {
		bannerService.save(banner);
		return ResultData.ok();
	}

	@CacheEvict(value = "banner", allEntries=true)
	@PutMapping
	public ResultData updateBanner(@RequestBody CrmBanner banner) {
		bannerService.updateById(banner);
		return ResultData.ok();
	}

	@CacheEvict(value = "banner", allEntries=true)
	@DeleteMapping("/{id}")
	public ResultData deleteBanner(@PathVariable String id) {
		bannerService.removeById(id);
		return ResultData.ok();
	}
}
