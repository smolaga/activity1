package com.fimc.calculator.resource;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.fimc.calculator.resource.MessageResponse;
import com.fimc.calculator.model.SuccessResponse;

@Component
@Path("/calculator")
public class CalculatorResource {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculator(CalculatorRequest calculatorRequest) {
    	MessageResponse messageResponse = new MessageResponse();
        CalculatorResponse calculatorResponse = new CalculatorResponse();
        SuccessResponse successResponse = new SuccessResponse();
        if (calculatorResponse.getOperator(calculatorRequest.getOperator()).equals("invalid")) {
        	/*messageResponse.setMessage("Invalid operator");*/
            return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
        }
        else {
            DecimalFormat df = new DecimalFormat("#.#####");
            successResponse.setAction(calculatorResponse.getOperator(calculatorRequest.getOperator()));
            successResponse.setResult(df.format(calculatorResponse.calculate(calculatorRequest)));
            return Response.ok().entity(successResponse).build();
        }
    }

}
