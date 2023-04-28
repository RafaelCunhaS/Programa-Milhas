package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import com.trybe.acc.java.programamilhas.service.DominioService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dominio")
@Produces(MediaType.APPLICATION_JSON)
public class DominioResource {

  @Inject
  DominioService dominioService;

  @GET
  @Path("/tipolancamento")
  public List<TipoLancamento> listarTiposLancamentos() {
    return dominioService.listarTiposLancamentos();
  }

  @GET
  @Path("/produto")
  public List<Produto> listarProdutos() {
    return dominioService.listarProdutos();
  }

  @GET
  @Path("/parceiro")
  public List<Parceiro> listarParceiros() {
    return dominioService.listarParceiros();
  }
}
