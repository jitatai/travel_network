package com.jt.controller;

import com.jt.domain.Orders;
import com.jt.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

   /* @RequestMapping("findAll")
    public String findAll(Model model){
        List<Orders> ordersList = ordersService.findAll();
        model.addAttribute("ordersList",ordersList);
        return "orders-list";
    }*/

    @RequestMapping("findAllByPage")
    public String findAll(Model model,
                          @RequestParam(name = "page",defaultValue = "1")int page,
                          @RequestParam(name = "size",defaultValue = "4")int size){
        Page<Orders> ordersPage = ordersService.findAllByPage(page, size);
        System.out.println(ordersPage.getContent().size());
        model.addAttribute("ordersPage",ordersPage);
        return "orders-page-list";
    }

    @RequestMapping("findById")
    public String findById(@RequestParam(name = "id",required = true)String id,Model model){
        model.addAttribute("orders",ordersService.findById(id));
        return "orders-show";
    }


}
