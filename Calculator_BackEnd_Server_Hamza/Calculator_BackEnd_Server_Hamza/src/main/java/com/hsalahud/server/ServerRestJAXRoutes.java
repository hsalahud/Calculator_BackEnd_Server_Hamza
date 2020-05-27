package com.hsalahud.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ServerRestJAXRoutes {

    @GET
    @Path("/{num1}/{operation}/{num2}/{isDecimalInDisplay}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAnswer(@PathParam("num1") String num1, @PathParam("operation") String operation, @PathParam("num2") String num2, @PathParam("isDecimalInDisplay") String isDecimalInDisplayString) {

        //Below is the logic to calculate values based on the operation and values sent through the parameters
        //of the URL
        double firstValue = Double.parseDouble(num1);
        boolean isDecimalInDisplay = Boolean.parseBoolean(isDecimalInDisplayString);
        double answer;

        switch (operation){

            case "plus":

                answer = firstValue + Double.parseDouble(num2);
                if (num1.contains(".") || isDecimalInDisplay == true){
                    return Response.status(200).entity(Double.toString(answer)).build();
                }else {
                    int answerAsInt = (int) answer;
                    return Response.status(200).entity(Integer.toString(answerAsInt)).build();
                }

            case "minus":
                answer = firstValue - Double.parseDouble(num2);
                if (num1.contains(".") || isDecimalInDisplay == true){
                    return Response.status(200).entity(Double.toString(answer)).build();
                }else {
                    int answerAsInt = (int) answer;
                    return Response.status(200).entity(Integer.toString(answerAsInt)).build();
                }

            case "multiply":
                answer = firstValue * Double.parseDouble(num2);
                if (num1.contains(".") || isDecimalInDisplay == true){
                    return Response.status(200).entity(Double.toString(answer)).build();
                }else {
                    int answerAsInt = (int) answer;
                    return Response.status(200).entity(Integer.toString(answerAsInt)).build();
                }

            case "divide":
                answer = firstValue / Double.parseDouble(num2);

                if (firstValue % Double.parseDouble(num2)==0){
                    int answerAsInt = (int)(double) answer;
                    return Response.status(200).entity(Integer.toString(answerAsInt)).build();
                }else{
                    return Response.status(200).entity(Double.toString(answer)).build();
                }

            default:
                return Response.status(200).entity("#ERROR!").build();
        }
    }


}
