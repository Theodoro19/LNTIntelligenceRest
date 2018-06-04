package br.com.lnt.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.lnt.model.util.bloco;
import br.com.lnt.model.util.condominio;

@Stateless
public class CondominioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "omacorpProducao", type = PersistenceContextType.TRANSACTION)
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<condominio> listarCondominios() {
		List<condominio> listarTabela = new ArrayList<>();
		List<Object[]> lista = this.manager
				.createNativeQuery(
						"select codigo, nome, dt_cadastro from sigadm.dbo.cndcondo where data_baixa is null ")
				.getResultList();
		if (!lista.isEmpty()) {
			for (Object[] obj : lista) {
				condominio c = new condominio();
				if (obj[0] != null) {
					c.setCondominio(Integer.valueOf(obj[0].toString()));
				}
				if (obj[1] != null) {
					c.setNome(obj[1].toString());
				}
				if (obj[2] != null) {
					c.setData_cadastro((Date) obj[2]);
				}
				listarTabela.add(c);
			}
		}
		return listarTabela;
	}

	@SuppressWarnings("unchecked")
	public List<bloco> listarBlocos(int condominio) {
		List<bloco> listarTabela = new ArrayList<>();
		List<Object[]> lista = this.manager
				.createNativeQuery("select b.condominio, b.bloco, b.nome from sigadm.dbo.cndbloco b inner join "
						+ "sigadm.dbo.cndcondo c on c.codigo = b.condominio where c.data_baixa is null and b.condominio = :p1 ")
				.setParameter("p1", condominio).getResultList();
		if(!lista.isEmpty()){
			for(Object[]obj:lista){
				bloco b = new bloco();
				if(obj[0]!=null){
					b.setCondominio(Integer.valueOf(obj[0].toString()));
				}
				if(obj[1]!=null){
					b.setBloco(obj[1].toString());
				}
				if(obj[2]!=null){
					b.setNome(obj[2].toString());
				}
				listarTabela.add(b);
			}
		}
		return listarTabela;
	}

}
