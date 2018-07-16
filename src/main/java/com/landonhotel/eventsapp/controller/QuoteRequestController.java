package com.landonhotel.eventsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.landonhotel.eventsapp.domain.QuoteRequest;

//Allow user to enter some details and request event quote from sales team.

@Controller
public class QuoteRequestController {

    @GetMapping ("/newquote") //To handle HTTP get requests. Return the page that user wants to fill to request quote
    public String beginQuoteRequest(Model model) {

        //add implementation later
        model.addAttribute("quoteRequestForm", new QuoteRequest());
        
    		return "newQuote"; //string maps to html file
    }

    @PostMapping //("/newQuoteConfirmation") //Once form is filled by user, save or post the quote
    public String submitQuoteRequest() {
        

        //add implementation later

        //once done, return user to new quote confirmation page; string maps to html file
    		return "newQuoteConfirmation";
    }

}
