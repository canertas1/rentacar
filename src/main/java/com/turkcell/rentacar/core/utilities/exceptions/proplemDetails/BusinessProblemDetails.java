package com.turkcell.rentacar.core.utilities.exceptions.proplemDetails;

public class BusinessProblemDetails extends ProblemDetails {

    public BusinessProblemDetails(){

        setTitle("Business Rule Violation");
        setType("http://mydomain.com/exceptions/business");
        setStatus("400");
    }

}
