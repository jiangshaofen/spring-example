package com.example.security.controller;

import org.apache.log4j.Logger;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  

/**
 * 
 * @author jiang
 *
 */
@Controller
@RequestMapping(value = "/main")
public class MainController {
    protected static Logger logger = Logger.getLogger("MainController");
  
    /** 
     * 跳转到common页面
     *  
     * @return
     */
    @RequestMapping(value = "/common", method = RequestMethod.GET)
    public String getCommonPage() {
        logger.debug("Received request to show common page");
        return "common";
    }
  
    /** 
     * 跳转到admin页面
     *  
     * @return
     */   
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAadminPage() {
        logger.debug("Received request to show admin page");
        return "admin";
    }
    
    /** 
     * 跳转到user页面
     *  
     * @return
     */   
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserPage() {
        logger.debug("Received request to show user page");
        return "user";
    }
}  
