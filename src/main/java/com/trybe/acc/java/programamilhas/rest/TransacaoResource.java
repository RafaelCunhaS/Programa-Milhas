package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.ResgateProdutoDto;
import com.trybe.acc.java.programamilhas.dto.TransferenciaDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.exception.SaldoInsuficienteException;
import com.trybe.acc.java.programamilhas.service.TransacaoService;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/transacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransacaoResource {

  @Inject
  TransacaoService transacaoService;

  @POST
  @Path("/transferencia")
  public Response transferencia(@QueryParam(value = "token") String token,
      @Valid TransferenciaDto transferenciaDto) throws InvalidKeySpecException,
      NoSuchAlgorithmException, AcessoNaoAutorizadoException, SaldoInsuficienteException {
    transacaoService.transferencia(token, transferenciaDto);
    return Response.ok().build();
  }

  @POST
  @Path("/resgate-produto")
  public Response resgateProduto(@QueryParam(value = "token") String token,
      ResgateProdutoDto resgateProdutoDto)
      throws SaldoInsuficienteException, AcessoNaoAutorizadoException {
    transacaoService.resgateProduto(token, resgateProdutoDto);
    return Response.ok().build();
  }
}
