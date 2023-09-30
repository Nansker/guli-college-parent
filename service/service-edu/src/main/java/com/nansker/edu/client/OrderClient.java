package com.nansker.edu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Nansker
 * @date 2023/9/24 17:05
 * @description TODO
 */
@Component
@FeignClient(name = "service-order", fallback = OrderFileDegradeFeignClient.class)
public interface OrderClient {
	@GetMapping("/order/isBuyCourse/{userId}/{courseId}")
	Boolean getBuyStatusByCourseId(@PathVariable("userId") String userId, @PathVariable("courseId") String courseId);
}
