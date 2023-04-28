package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.service.PessoaService;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pessoa")
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

  @Inject
  PessoaService pessoaService;

  @POST
  public Response salvar(LoginDto loginDto)
      throws InvalidKeySpecException, NoSuchAlgorithmException {
    pessoaService.salvar(loginDto);
    return Response.ok().build();
  }

  @DELETE
  public Response deletar(@QueryParam("token") String token) throws AcessoNaoAutorizadoException {
    pessoaService.deletar(token);
    return Response.ok().build();
  }
}
