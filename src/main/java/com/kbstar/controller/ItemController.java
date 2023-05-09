package com.kbstar.controller;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.service.CartService;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/item")          //라우터 생성 같은건가..
public class ItemController {

    @Autowired
    ItemService itemService;
    @Autowired
    CartService cartService;

    String dir = "item/";

    //127.0.0.1/item
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"add");
        return "index";
    }
    @RequestMapping("/addcart")
    public String addcart(Model model, Cart cart) throws Exception {
        cartService.register(cart);
        return "redirect:/item/allcart?id="+cart.getCust_id();
    }

    @RequestMapping("/delcart")
    public String delcart(Model model, Integer id, HttpSession session) throws Exception {  //Integer id는 cart_id, session은 로그인 정보에서 cust_id를 빼내는 용도.
        cartService.remove(id);
        if(session != null){
            Cust cust = (Cust) session.getAttribute("logincust");
            return "redirect:/item/allcart?id="+cust.getId();
        }
            return "redirect:/";
    }

    @RequestMapping("/get")
    public String get(Model model, Integer id) throws Exception {
        Item item = null;
        item = itemService.get(id);
        model.addAttribute("gitem", item);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"get");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model) throws Exception {

        List<Item> list = null;
        try {
            list = itemService.get();
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");
        }
        model.addAttribute("allitem", list);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"all");
        return "index";
    }

    @RequestMapping("/allcart")
    public String allcart(Model model, String id) throws Exception {
        List<Cart> list = null;
        try {
            list = cartService.getMyCart(id);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");
        }
        model.addAttribute("allcart", list);
        model.addAttribute("center", "cart");
        return "index";
    }

    @RequestMapping("/allpage")
    public String allpage(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) throws Exception {

        PageInfo<Item> pageinfo;
        try {
           pageinfo = new PageInfo<>(itemService.getPage(pageNo), 5);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");
        }
        model.addAttribute("target", "item"); // view/page.jsp를 만들어서 어디에서나 쓸 수 있게 만듬

        model.addAttribute("cpage", pageinfo);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"allpage");
        return "index";
    }
}
