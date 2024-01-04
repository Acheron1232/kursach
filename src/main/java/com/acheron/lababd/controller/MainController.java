package com.acheron.lababd.controller;

import com.acheron.lababd.entity.*;
import com.acheron.lababd.repo.*;
import com.acheron.lababd.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final UserRepository userRepository;
    private final ComputerComponentRepository computerComponentRepository;
    private final ComputerComponentConfRepository computerComponentConfRepository;
    private final UserService userService;
    private final ComputerRepository computerRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        orderDetailRepository.delete(orderDetailRepository.findByOrder(orderRepository.findById(id).get()).get());
        return "redirect:/all";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
       model.addAttribute("order",orderRepository.findById(id).get());
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String edit1(@PathVariable Long id, HttpServletRequest request,Principal principal){
        orderRepository.save(new Order(id,userRepository.findByEmail(principal.getName()).get(),request.getParameter("deliveryAddress"),request.getParameter("paymentMethod"),null));
        return "redirect:/all";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @GetMapping("/order/{id}")
    public String order(@PathVariable Long id,Model model){
        model.addAttribute("order",orderDetailRepository.findByOrder(orderRepository.findById(id).get()).get());
        return "order";
    }
    @PostMapping("/registration")
    public String registration1(HttpServletRequest request){
        userService.save(new User(null,request.getParameter("username"),request.getParameter("email"), User.Role.USER,request.getParameter("password")));
        return "redirect:/login";
    }
    @GetMapping("/all")
    public String getAllOrders(Model model, HttpServletRequest request,Principal principal){
        model.addAttribute("orders",orderRepository.findAll((request.getParameter("checkbox1")==null||request.getParameter("checkbox1").isEmpty()||request.getParameter("checkbox1").equals("off"))?Sort.by(Sort.Direction.ASC,"orderId"):Sort.by(Sort.Direction.DESC,"orderId")));
        model.addAttribute("principalll",principal);
        return "allOrders";
    }
    @GetMapping("/allAdmin")
    public String getAllOrders1(Model model, HttpServletRequest request,Principal principal){
        model.addAttribute("principalll",principal);
        model.addAttribute("permit",true);
        model.addAttribute("orders",orderRepository.findAll((request.getParameter("checkbox1")==null||request.getParameter("checkbox1").isEmpty()||request.getParameter("checkbox1").equals("off"))?Sort.by(Sort.Direction.ASC,"orderId"):Sort.by(Sort.Direction.DESC,"orderId")));
        return "allOrders";
    }
    @GetMapping("/addComputerComponent/{id}")
    public String addComputerComponent(@PathVariable Long id, Model model, HttpServletRequest request,Principal principal){
        model.addAttribute("id",id);
        return "addComputerComponent";
    }
    @PostMapping("/addComputerComponent/{id}")
    public String addComputerComponentPost(@PathVariable Long id, Model model, HttpServletRequest request,Principal principal){
        computerComponentRepository.save(new ComputerComponent(null,request.getParameter("componentName"),computerRepository.findById(id).get()));
        return "redirect:/all";
    }
    @GetMapping("/addComputerConfigurationConf/{id}")
    public String addComputerComponent1(@PathVariable Long id, Model model, HttpServletRequest request,Principal principal){
        model.addAttribute("id",id);
        return "addComputerComponentConf";
    }
    @PostMapping("/addComputerConfigurationConf/{id}")
    public String addComputerComponentPost1(@PathVariable Long id, Model model, HttpServletRequest request,Principal principal){
        computerComponentConfRepository.save(new ComputerConfigurationComponent(null,computerRepository.findById(id).get(),request.getParameter("componentName")));
        return "redirect:/all";
    }

    @PostMapping("/addorder")
    public String addOrder(Model model, HttpServletRequest request, Principal principal){
        Order order = orderRepository.save(new Order(null, userRepository.findByEmail(principal.getName()).orElse(null), request.getParameter("address"), request.getParameter("payment"),null));
        Computer computer = computerRepository.save(new Computer(null, request.getParameter("type"), request.getParameter("configuration"), Double.valueOf(request.getParameter("price")),null,null));
        orderDetailRepository.save(new OrderDetail(null,order,computer));
        return "redirect:/all";
    }
}
