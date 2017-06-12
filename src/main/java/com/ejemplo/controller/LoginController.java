package com.ejemplo.controller;

import com.ejemplo.constant.ViewConstant;
import com.ejemplo.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);



    @GetMapping("/")
    public String redirectToLogin(){

        LOG.info("METHOD: redirectToLogin");
        return "redirect:/login";

    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam (name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout){

        LOG.info("METHOD: showLoginForm -- PARAMS: error = " + error + " logout = " + logout);


        //para mostrar mensaje de logout
        model.addAttribute("logout", logout);
        //para pasar si existion algun error
        model.addAttribute("error", error);
        //para pasar los datos del model a la vista
        model.addAttribute("userCredentials", new UserCredential());

        return ViewConstant.LOGIN;
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute (name = "userCredentials") UserCredential userCredential){

        LOG.info("METHOD: logincheck -- PARAMS:  = " + userCredential.toString());

        if (userCredential.getUserName().equals("user") && userCredential.getPassword().equals("user")){

            LOG.info("Returning to contacts view");
            return "redirect:/contacts/";
        }

        else {

            LOG.info("Returning to loggin error");
            return "redirect:/login?error";
        }

    }
}
