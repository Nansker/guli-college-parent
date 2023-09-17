package com.nansker.cms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nansker.cms.domain.CrmBanner;
import com.nansker.cms.domain.dto.BannerDto;

import java.util.List;
import java.util.Map;

/**
 * @author Nansker
 * @description 针对表【crm_banner(首页banner表)】的数据库操作Service
 * @createDate 2023-09-17 23:24:00
 */
public interface CrmBannerService extends IService<CrmBanner> {
	/**
	 * @return java.util.List<com.nansker.cms.domain.CrmBanner>
	 * @author Nansker
	 * @date 2023/9/17 23:25
	 * @description 获取所有轮播图
	 */
	List<CrmBanner> getAllBanner();

	/**
	 * @param bannerDto
	 * @return java.util.Map
	 * @author Nansker
	 * @date 2023/9/17 23:25
	 * @description 分页查询轮播图列表
	 */
	Page getBannerList(BannerDto bannerDto);

}
