package pagamentos.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import pagamentos.model.Pagamento;
import pagamentos.model.PagamentoRepository;

@Path("/pagamentos")
public class PagamentoController {

	private PagamentoRepository pagamentoRepository = new PagamentoRepository();
	
	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Response listar(){
		
		List<Pagamento> pagamentos = pagamentoRepository.getPagamentos();

		GenericEntity<List<Pagamento>> entity = new GenericEntity<List<Pagamento>>(pagamentos) {};
		
		return Response.status( 200 ).entity(entity).build();
		
	}
	
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Response buscarPorId( @PathParam("id") Long id ){

		Pagamento Pagamento = pagamentoRepository.buscarPorId(id);
		if(Pagamento != null) {
			return Response.ok( Pagamento ).build();
		}else {
			return Response.status( Status.NOT_FOUND).build();
		}
	}
	
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Response adicionar( Pagamento Pagamento ){

		pagamentoRepository.save(Pagamento);
		
		URI uri = URI.create( "/pagamentos/pagamentos/"+Pagamento.getId() );
		
		return Response.created( uri ).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deletar( @PathParam("id") Long id ){

		pagamentoRepository.delete(id);
		return Response.status( Status.OK ).build();
	}
	
	
	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Response alterar(@PathParam("id") Long id ,  Pagamento Pagamento){
		
		Pagamento p = pagamentoRepository.buscarPorId( id );
		
		if( p == null ){
			return Response.status( Status.NOT_FOUND ).build();
		}else{
			pagamentoRepository.update( Pagamento );
			return Response.status( 200 ).entity(Pagamento).build();
		}
		
		
	}
	
}
