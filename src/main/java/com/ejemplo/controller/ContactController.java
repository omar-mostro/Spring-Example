package com.ejemplo.controller;

import com.ejemplo.constant.ViewConstant;
import com.ejemplo.model.ContactModel;
import com.ejemplo.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {


    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImp")
    private ContactService contactService;


    @GetMapping("/")
    public ModelAndView index(){

        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);

        //System.out.println(contactService.showAllContacts());

        mav.addObject("contacts", contactService.showAllContacts());

        return mav;
    }

    @GetMapping("/contactform")
    public String redirectContactForm(Model model ){

        model.addAttribute("contactModel", new ContactModel());

        return ViewConstant.CONTACT_FORM;
    }

    @PostMapping("/contactform")
    public String guardarContact(@ModelAttribute ("contactModel") ContactModel contactModel,
                                 Model model){

        LOG.info("Form Parameters: " + contactModel.toString());

        if (contactService.addContact(contactModel) != null){

            model.addAttribute("result", 1);
            return "redirect:/contacts/";

        }

        return null;
    }

    @GetMapping("/delete")
    public String deleteContact(@RequestParam (name = "id", required = true) int id){

        contactService.deleteContact(id);

        return "redirect:/contacts/";
    }

    @GetMapping("/modify")
    public ModelAndView modifyContact(@RequestParam (name = "id", required = true) int id){

        ModelAndView mav = new ModelAndView(ViewConstant.CONTACT_FORM);

        //System.out.println(contactService.showOne(id));
        mav.addObject("contactModel", contactService.showOne(id));
        return mav;

    }


}
