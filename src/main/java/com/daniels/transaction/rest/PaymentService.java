package com.daniels.transaction.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniels.transaction.TransactionBo;

@Component
@Path("/sample")
public class PaymentService {

	@Autowired
	TransactionBo transactionBo;

	@GET
	@Path("/daniels")
	public Response savePayment() {

		String result = transactionBo.save();

		return Response.status(200).entity(result).build();

	}

}