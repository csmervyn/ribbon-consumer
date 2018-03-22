package com.mervyn.binsiness.service.impl;

import com.mervyn.binsiness.service.IComputeService;
import com.mervyn.common.JsonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hexinxin
 * @Date: 2018/3/16
 * @Time: 17:03
 * @Description:
 */
@Service("computeService")
public class ComputeService implements IComputeService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${server.port}")
    String port;

    @Override
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public JsonResult<Integer> add(Integer augend, Integer addend) {
        String url = "http://add-service/compute/add?augend={augend}&addend={addend}";
        Map<String, Integer> paramMap = new HashMap<>();
        paramMap.put("augend",augend);
        paramMap.put("addend",addend);
        ResponseEntity<JsonResult>  responseEntity = restTemplate.getForEntity(url,JsonResult.class,paramMap);
        return responseEntity.getBody();
    }
    public JsonResult<Integer> addServiceFallback(Integer augend, Integer addend) {
        return new JsonResult<Integer>(null,"调用add service出错：" + port,Boolean.FALSE);
    }
}
