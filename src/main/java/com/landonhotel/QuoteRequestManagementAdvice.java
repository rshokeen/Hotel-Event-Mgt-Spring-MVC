package com.landonhotel;

import com.landonhotel.eventsapp.controller.QuoteRequestController;
import com.landonhotel.eventsapp.controller.QuoteRequestManagementController;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice(assignableTypes = {
        QuoteRequestController.class,
        QuoteRequestManagementController.class
})
public class QuoteRequestManagementAdvice {

    //Binder Method - to format event dates for front end users as well
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        dateFormat.setLenient(false);

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));


    }
}
