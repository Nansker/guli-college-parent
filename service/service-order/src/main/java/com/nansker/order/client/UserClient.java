package com.nansker.order.client;

import com.nansker.entity.user.SysMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Nansker
 * @date: 2023/9/22 18:28
 * @description: TODO
 */
@Component
@FeignClient("service-user")
public interface UserClient {
	@GetMapping("/user/{id}")
	SysMember getUserInfoById(@PathVariable String id);
}