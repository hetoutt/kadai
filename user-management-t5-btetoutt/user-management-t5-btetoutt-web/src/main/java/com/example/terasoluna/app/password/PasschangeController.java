package com.example.terasoluna.app.password;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.example.terasoluna.domain.model.Account;
import com.example.terasoluna.domain.service.account.AccountService;
import com.example.terasoluna.domain.service.userdetails.AccountDetails;

@Controller
@SessionAttributes(value = { "passchangeForm" })
@RequestMapping("password")
public class PasschangeController {
	@Inject
    AccountService accountService;
	
    @Inject
    Mapper beanMapper;
	
    @ModelAttribute(value = "passchangeForm")
    public PasschangeForm setUpPasschangeForm() {
        return new PasschangeForm();
    }
    
    @RequestMapping(value = "/passchange", method = RequestMethod.POST)
    public String passchange_update(@AuthenticationPrincipal AccountDetails userDetails,
    		PasschangeForm passchangeform,
    		BindingResult result, RedirectAttributes attributes, SessionStatus sessionStatus){
    		

    	/*
            @AuthenticationPrincipal AccountDetails userDetails,
            @Validated({ Wizard1.class, Wizard2.class }) AccountUpdateForm form,
            BindingResult result, RedirectAttributes attributes, SessionStatus sessionStatus) {
        
        if (result.hasErrors()) {
            ResultMessages messages = ResultMessages.error();
            messages.add("e.st.ac.5001");
            throw new IllegalOperationException(messages);
        }
        */
    	
    	/*
    	 * beanMapperでAccountに引き継ぐには、受け取ったFormの型が同じ必要があるため、
    	 * passchangeAccountFormが必要
    	 */

        //Account account = beanMapper.map(passchangeform, Account.class);
        
        Account account = userDetails.getAccount();         
        account.setEncodedPassword(passchangeform.getPassword1());
        //account.setUserid(local_account.getUserid());
        
        System.out.println("inpass : "+passchangeform.getPassword1());
        System.out.println("outpass : "+account.getEncodedPassword());
        System.out.println("inuserid : "+passchangeform.getUserid());
        //System.out.println("outuserid : "+local_account.getUserid());
        System.out.println("@outuserid : "+account.getUserid());
        
    	accountService.passupdate(account);
        userDetails.setAccount(account);
        attributes.addFlashAttribute("account", account);
        sessionStatus.setComplete();

        return "redirect:/password/passchange?finish";
    }
    
    @RequestMapping(value = "/passchange", method = RequestMethod.GET, params = "finish")
    public String passchange_finish(){
    	return "password/finish";
    }
    
    @RequestMapping(value = "/passchange", method = RequestMethod.GET, params = "home")
    public String home(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "top/menu";
    }
    
}
