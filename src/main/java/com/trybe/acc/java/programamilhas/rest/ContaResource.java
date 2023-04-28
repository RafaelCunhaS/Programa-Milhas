package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.ContaService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/conta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContaResource {

  @Inject
  ContaService contaService;

  @GET
  @Path("/saldo")
  public SaldoResult saldo(@QueryParam(value = "token") String token)
      throws AcessoNaoAutorizadoException {
    return contaService.saldo(token);
  }

  @GET
  @Path("/extrato")
  public List<Lancamento> extrato(@QueryParam(value = "token") String token)
      throws AcessoNaoAutorizadoException {
    return contaService.extrato(token);
  }
}
