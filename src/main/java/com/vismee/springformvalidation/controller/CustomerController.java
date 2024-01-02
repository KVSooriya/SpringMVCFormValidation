package com.vismee.springformvalidation.controller;

import com.vismee.springformvalidation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController
{
    /* @InitBinder - pre-process every web request coming into the controller
    We are using InitBinder to register custom editor - StringTrimmerEditor
    StringTrimmerEditor - class defined in Spring API. Purpose : trim leading/trailing whitespaces from String
    */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
        StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,trimmer);
    }

    // maps to the root url so that form will be shown automatically
    @GetMapping("/")
    public String showForm(Model model)
    {
        model.addAttribute("customer",new Customer());
        return "customer-form";
    }

    /* @Valid - to perform validation
       BindingResult - the results of the validation will be placed in the BindingResult object
     */
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult result)
    {
        // debugging bindingResult to get more info on error codes
        System.out.println(result);

        System.out.println("LastName : |" +theCustomer.getLastName() +"|");

        // If there are validation errors, return the same form with errors displayed. else move on to success page
        if(result.hasErrors())
            return "customer-form";

        return "customer-confirmation";
    }

}
