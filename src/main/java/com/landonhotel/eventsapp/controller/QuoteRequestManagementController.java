package com.landonhotel.eventsapp.controller;

//To build a quote feature. Once a customer submits a request for an estimate, someone on the event sales team needs to review and
// respond to those requests. Implementing a feature like this will require us to use some of those other request mapping options.

import com.landonhotel.eventsapp.domain.QuoteRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


public class QuoteRequestManagementController {

    @GetMapping(path ="/quoteRequests")
    public String listRequests()
    {

        return "quoteRequestList";
    }

    @GetMapping(path = "/quoteRequests", params = "eventType=wedding") //check request based on parameter & parameter condition
    public String listWeddingRequests()
    {

        return "quoteRequestList";
    }

    @GetMapping("/quoteRequests/{quoteId}") //map handler based on pattern of URI
    public ModelAndView viewQuoteRequest(@PathVariable int quoteId) //annotation pathVariable is used to get access to quote number.
    {
        QuoteRequest quoteRequestBean = new QuoteRequest();
        quoteRequestBean.setBudget(5000);
        quoteRequestBean.setEventType("wedding");

        ModelAndView mav = new ModelAndView(); //to send model as well as logical view name
        mav.addObject("quoteRequestBean",quoteRequestBean); //add object
        mav.setViewName("quoteRequestDetail");

        return mav;

        //refer to quoteId in the implementation
        //return "quoteRequestDetail"; //this is view name that i want to return to sales rep so they can view details of particular quote request.
    }

    @GetMapping("/quoteRequest/social/{id}")
    public String viewRequestSocial(@PathVariable int id)
    {
        String returnViewName = "quoteRequestSocialEventDetail";

        boolean someCondition = true;
        if(someCondition){
            returnViewName = "redirect:/quoteRequest/wedding/{id}";
        }

        return returnViewName;
    }

    //Here we are returning JSON response and not webpage
    @GetMapping
    @ResponseBody
    public QuoteRequest viewQuoteRequestApi()
    {
        QuoteRequest quoteRequest = new QuoteRequest();
        quoteRequest.setBudget(10000);

        return quoteRequest; //return entire quoteRequest object as response body in JSON format.
    }

    @PostMapping("/quoteDetail")
    public String updateQuoteRequest(@ModelAttribute QuoteRequest formBean) //Need model attribute to pull model bean data.
    {

        //implement a save of all of the form bean information

        return "quoteRequestDetail";
    }

    //MODEL METHOD
    @ModelAttribute
    public void addCommonAttribute(@RequestParam String eventType, Model model)
    {
        //anytime request handler mapping is called, that particular implementation can have access to this common message i.e.
        //wedding vs. corporate meetings
        String customMessage = "You are viewing requests for" + eventType;
        model.addAttribute("eventTypeMessage", customMessage);
    }

}
