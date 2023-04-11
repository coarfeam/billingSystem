package com.eamapp.billingSystem.controller;

import com.eamapp.billingSystem.model.entity.Customer;
import com.eamapp.billingSystem.model.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("customer")
@RequestMapping("customer")
public class CustomerController {

    private ICustomerService service;
    public CustomerController(ICustomerService service){
        this.service = service;
    }

    @GetMapping({"/",""})
    public String listCustomer(Model model){
        model.addAttribute("title", "Facturación | Customer");
        model.addAttribute("customers", service.listCustomers());
        return "customer/customer";
    }

    @PostMapping("")
    public String saveCustomer(@ModelAttribute("customer")Customer customer, BindingResult result, RedirectAttributes flash, SessionStatus status){
        if (result.hasErrors()){
            return "customer/customer";
        }
        flash.addAttribute("success", "cliente guardado con exito");
        service.saveCustomer(customer);
        status.setComplete();
        return "redirect:/customer";
    }
}
