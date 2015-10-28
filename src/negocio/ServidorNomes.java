package negocio;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServidorNomes {

	Map<String, List<RegistroServidor>> servicos;

	public ServidorNomes() {
		servicos = new HashMap<String, List<RegistroServidor>>();
	}

	public void adicionarServico(RegistroServidor service) 
	{System.out.println(service);
		if (servicos.containsKey(service.getNomeServico())) 
		{
			List<RegistroServidor> list = servicos.get(service.getNomeServico());
			service.setIdentificador("" + (list.size() + 1) + "");
			list.add(service);
		} else
		{
			List<RegistroServidor> newList = new ArrayList<RegistroServidor>();
			service.setIdentificador("1");
			newList.add(service);
			servicos.put(service.getNomeServico(), newList);
		}
		System.out.println(this);
	}
	
	public RegistroServidor recuperarServico(String nome){
		if (servicos.containsKey(nome)) {
			List<RegistroServidor> list = servicos.get(nome);
			RegistroServidor retorno =  list.get(0);
			for(RegistroServidor rs:list){
				if(retorno.getRequisicoes()>rs.getRequisicoes()){
					retorno = rs;
				}
			}
			
			retorno.setRequisicoes(retorno.getRequisicoes()+1);
			
			return retorno;
		}
		return null;
	}
	
	public String nomesServicos(){
		StringBuilder nomes = new StringBuilder();
		Set<String> set = servicos.keySet();
		for(String s:set){
			nomes.append("("+s+")");
		}
		return nomes.toString();
	}

	@Override
	public String toString() {
		return "ServidorNomes [servicos=" + servicos + "]";
	}
	
	
}
