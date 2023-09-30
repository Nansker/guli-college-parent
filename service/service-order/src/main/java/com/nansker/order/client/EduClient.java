package com.nansker.order.client;

import com.nansker.entity.vo.CourseDetailsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Nansker
 * @date: 2023/9/22 18:29
 * @description: TODO
 */
@Component
@FeignClient("service-edu")
public interface EduClient {
	@GetMapping("/edu/front/course/details/vo/{id}")
	CourseDetailsVo getCourseDetails(@PathVariable("id") String id);
}