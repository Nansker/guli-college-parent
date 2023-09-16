package com.nansker.cms.domain.dto;

import com.nansker.cms.domain.CrmBanner;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Nansker
 * @date 2023/9/15 15:26
 * @description TODO
 */
@Data
public class BannerDto extends CrmBanner implements Serializable {
	private int pageNum;
	private int pageSize;
}
