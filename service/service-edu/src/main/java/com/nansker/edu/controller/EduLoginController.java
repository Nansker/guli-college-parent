package com.nansker.edu.controller;

import com.nansker.commonutils.result.ResultData;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nansker
 * @date 2023/8/8 5:31
 * @description TODO
 */
@RestController
@RequestMapping("/edu/user")
public class EduLoginController {

    /**
     * @author Nansker
     * @date 2023/8/8 5:38
     * @description TODO
    */
    @PostMapping("/login")
    public ResultData login() {
        return ResultData.ok().data("登陆测试");
    }
    @GetMapping("/info")
    public ResultData info() {
        return ResultData.ok().data("用户信息");
    }
}
