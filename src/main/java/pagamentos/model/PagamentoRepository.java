package pagamentos.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PagamentoRepository {
		
		private static List<Pagamento> pagamentos;
		private static Long cont = 0L;
		
		static {
			pagamentos = new ArrayList<Pagamento>();

			
			Pagamento p1 = new Pagamento();
			p1.setId(1L);
			p1.setCliente("Barbara Langa");
			p1.setConta(65656);
			p1setCredito(150000)
			p1.setMensalidades( Arrays.asList("Primeira","Segunda","Terceira") );
	        p1.setValorMensalidade(50000)
			
			pagamentos.add(p1);
			
			Pagamento  p2 = new Pagamento();
			p2.setId(2L);
			p2.setCliente("Ambari Edson");
			p2.setConta(56568);
			p2.setCredito(300000)
			p2.setMensalidades( Arrays.asList("Primeira","Segunda","Terceira") );
	        p2.setValorMensalidade(100000)
			                                  
			
			pagamentos.add(p2);
			
			cont = 2L;
		}

		public List<Pagamento> getPagamentos(){
			
			return pagamentos;
		}
		
		public Pagamento buscarPorId(Long id){
			
			Pagamento p = new Pagamento();
			p.setId( id );
				
			int index = pagamentos.indexOf( p );		
			
			if( index != -1){
				return pagamentos.get( index );
			}
			return null;
		}

		public void save(Pagamento pagamento) {
			cont++;
			pagamento.setId( cont );
			pagamentos.add( pagamento );
			
		}

		public void delete(Long id) {
			
			Pagamento p = new Pagamento();
			p.setId( id );
				
			int index = pagamentos.indexOf( p );		
			
			pagamentos.remove( index );
			
			
		}

		public void update(Pagamento pagamento) {
			
			Pagamento p = buscarPorId( pagamento.getId() );
			
			p.setConta( pagamento.getConta() );
			p.setCredito( pagamento.getCredito() );
			p.setDuracao( pagamento.getDuracao() );
			p.setValorMensalidade(pagamento.getValorMensalidade() );
			p.setCast( pagamento.getCast() );
			p.setMensalidades( pagamento.getMensalidades() );
			
		}
		
	
}
