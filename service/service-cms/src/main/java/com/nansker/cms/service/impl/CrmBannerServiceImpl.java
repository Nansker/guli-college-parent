package com.nansker.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.cms.domain.CrmBanner;
import com.nansker.cms.domain.dto.BannerDto;
import com.nansker.cms.service.CrmBannerService;
import com.nansker.cms.mapper.CrmBannerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Nansker
* @description 针对表【crm_banner(首页banner表)】的数据库操作Service实现
* @createDate 2023-09-17 23:24:00
*/
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner>
    implements CrmBannerService{

	@Override
	public List<CrmBanner> getAllBanner() {
		List<CrmBanner> banners = list();
		return banners;
	}

	@Override
	public Page getBannerList(BannerDto bannerDto) {
		LambdaQueryWrapper<CrmBanner> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.like(StringUtils.isNotEmpty(bannerDto.getId()),CrmBanner::getId,bannerDto.getId());
		queryWrapper.like(StringUtils.isNotEmpty(bannerDto.getTitle()),CrmBanner::getTitle,bannerDto.getTitle());
		queryWrapper.orderByAsc(CrmBanner::getSort);
		Page<CrmBanner> page = new Page<>(bannerDto.getPageNum(), bannerDto.getPageSize());
		Page<CrmBanner> result = page(page, queryWrapper);
		return result;
	}

}




