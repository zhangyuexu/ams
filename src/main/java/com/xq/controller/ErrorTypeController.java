package com.xq.controller;

import com.xq.pojo.ErrorType;
import com.xq.service.ErrorTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller//如果想用Thymeleaf就不能用RestController来返回json了
@RequestMapping("/qa/errtype")
public class ErrorTypeController {

    //Logger的导入包一定是org.slf4j.Logger和org.slf4j.LoggerFactory
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ErrorTypeService errorTypeService;

    public ErrorTypeController(ErrorTypeService errorTypeService) {
        this.errorTypeService = errorTypeService;
    }

    @GetMapping("add")
    public String add(){
        ErrorType errorType = new ErrorType();
        errorType.setErrorType("是问题a");

        int id = errorTypeService.addErrorType(errorType);

        return String.valueOf(id);
    }

//    @GetMapping("errortypes")
//    public Map<String, Object> findAllErrorType(HttpServletRequest request){
//        Map<String,Object> map = new HashMap<>();
//        List<ErrorType> list = errorTypeService.findAllErrorType();
//
//        map.put("code",200);
//        map.put("result",list);
//        request.setAttribute("errortypes",list);
//
//        return map;
//    }

    @GetMapping("errortypes")
    public String findAllErrorType(HttpServletRequest request){
        List<ErrorType> list = errorTypeService.findAllErrorType();
        request.setAttribute("list",list);
//        model.addAttribute("list",list);
        return "/tl/listEach";
    }

    @GetMapping("testlog")
    public String testLog(){
        logger.debug("这是debug信息");
        logger.info("这是info信息");
        logger.warn("这是warn信息");
        logger.error("这是error信息");

        return "测试logback on slf4j";
    }

    @GetMapping("edit")
    public String update(){
        ErrorType errorType = new ErrorType();
        errorType.setId(4);
        errorType.setErrorType("是问题");

        int id = errorTypeService.edit(errorType);

        return String.valueOf(id);
    }

    @GetMapping("delete")
    public String delete(Long id){
        int res = errorTypeService.delete(id);
        return String.valueOf(res);
    }
}
