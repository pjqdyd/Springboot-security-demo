package com.pjqdyd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @Description:  [商品Controller层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    /**
     * 商品列表页
     */
    @RequestMapping("/list")
    public String list(){
        return "product/list";
    }

    /**
     * 商品添加页
     */
    @RequestMapping("/add")
    public String add(){
        return "product/add";
    }

    /**
     * 商品修改页
     */
    @RequestMapping("/update")
    public String update(){
        return "product/update";
    }

    /**
     * 商品删除页
     */
    @RequestMapping("/delete")
    public String delete(){
        return "product/delete";
    }

}
