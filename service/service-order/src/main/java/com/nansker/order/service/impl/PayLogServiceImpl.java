package com.nansker.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.entity.order.PayLog;
import com.nansker.order.service.PayLogService;
import com.nansker.order.mapper.PayLogMapper;
import org.springframework.stereotype.Service;

/**
* @author Nansker
* @description 针对表【pay_log(支付日志表)】的数据库操作Service实现
* @createDate 2023-09-22 16:11:23
*/
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog>
    implements PayLogService{

}




