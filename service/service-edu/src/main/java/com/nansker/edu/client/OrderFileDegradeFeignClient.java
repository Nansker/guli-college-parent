package com.nansker.edu.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Nansker
 * @date 2023/9/24 20:30
 * @description TODO
 */
@Slf4j
@Component
public class OrderFileDegradeFeignClient implements OrderClient {

	@Override
	public Boolean getBuyStatusByCourseId(String userId, String courseId) {
		log.info("getBuyStatusByCourseId(" + userId + "," + courseId + ") " + " 服务出现问题 ");
		return false;
	}

}
