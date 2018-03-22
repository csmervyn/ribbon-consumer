package com.mervyn.binsiness.controller;

import com.mervyn.binsiness.service.IComputeService;
import com.mervyn.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hexinxin
 * @Date: 2018/3/14
 * @Time: 13:25
 * @Description:
 */
@RestController
public class ConsumerController {
    @Autowired
    private IComputeService computeService;

    @RequestMapping(value = "/add",method= RequestMethod.GET)
    public JsonResult<Integer> add(@RequestParam Integer augend, @RequestParam Integer addend) {
       return computeService.add(augend,addend);
    }
}
