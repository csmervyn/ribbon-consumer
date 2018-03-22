package com.mervyn.binsiness.service;


import com.mervyn.common.JsonResult;

/**
 * @author hexinxin
 * @Date: 2018/3/16
 * @Time: 17:02
 * @Description:
 */
public interface IComputeService {
    public JsonResult<Integer> add(Integer augend, Integer addend);
}
