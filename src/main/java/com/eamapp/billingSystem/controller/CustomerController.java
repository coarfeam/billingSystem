package com.eamapp.billingSystem.controller;

import com.eamapp.billingSystem.model.entity.Customer;
import com.eamapp.billingSystem.model.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("customer")
@RequestMapping("customer")
public class CustomerController {

    private ICustomerService service;
    public CustomerController(ICustomerService service){
        this.service = service;
    }

    @GetMapping({""})
    public String listCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("title", "Facturación | Customer");
        model.addAttribute("customer", customer);
        model.addAttribute("customers", service.listCustomers());
        return "customer/customer";
    }

    @GetMapping("/register")
    public String registerCustomer(Model model, Customer customer){
        model.addAttribute("customer", customer);
        return "customer/register";
    }

    @PostMapping({"/register",""})
    public String saveCustomer(Customer customer, SessionStatus status){
        service.saveCustomer(customer);
        status.setComplete();
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String formEditCustomer(@PathVariable Long id, Model model){
        model.addAttribute("customer", service.getCustomerById(id));
        return "customer/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "redirect:/customer";
    }

    @PostMapping({"/{id}","edit/{id}"})
    public String updateCustomer(@PathVariable Long id, @ModelAttribute("customer") Customer customer, SessionStatus status){
        Customer existCustomer = service.getCustomerById(id);
        existCustomer.setId(id);
        existCustomer.setName(customer.getName());
        existCustomer.setLastName(customer.getLastName());
        existCustomer.setEmail(customer.getEmail());
        existCustomer.setCreateAt(customer.getCreateAt());
        status.setComplete();
        service.updateCustomer(existCustomer);
        return "redirect:/customer";
    }
}
