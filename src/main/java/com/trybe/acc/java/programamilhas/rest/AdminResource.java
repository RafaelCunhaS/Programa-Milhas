package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.LancamentoDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.AdminService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/admin")
public class AdminResource {

  @Inject
  AdminService adminService;

  /**
   * Método para fazer um resgate.
   */
  @POST
  @Path("/resgate")
  public Response resgate(@QueryParam(value = "token") String token, LancamentoDto lancamentoDto)
      throws AcessoNaoAutorizadoException {
    adminService.resgate(token, lancamentoDto);
    return Response.ok().build();
  }

  @POST
  @Path("/saldos")
  public List<SaldoResult> saldos(@QueryParam(value = "token") String token)
      throws AcessoNaoAutorizadoException {
    return adminService.saldos(token);
  }

}
