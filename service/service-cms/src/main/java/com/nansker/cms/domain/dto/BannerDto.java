package com.nansker.cms.domain.dto;

import com.nansker.cms.domain.CrmBanner;
import lombok.Data;

/**
 * @author Nansker
 * @date 2023/9/15 15:26
 * @description TODO
 */
@Data
public class BannerDto extends CrmBanner {
	private int pageNum;
	private int pageSize;
}
