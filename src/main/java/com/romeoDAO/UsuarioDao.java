package com.romeoDAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.romeo.model.TbUsuariop;



public class UsuarioDao {

	public List<TbUsuariop> ingresoUsuario(TbUsuariop usu) {
		List<TbUsuariop> Usuarios = new ArrayList();
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("logueo");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Usuarios = em.createQuery("from TbUsuariop as u where u.usuario = '"+usu.getUsuario()+"' and u.contrasenia='"+usu.getContrasenia()+"'").getResultList();
			
			em.getTransaction().commit();
			
			for(TbUsuariop datosids: Usuarios) {
				usu.setIdUsuarios(datosids.getIdUsuarios());
				
			}
			
		} catch (Exception e) {
			System.out.println(e+"ERROR");
		}
		
		return Usuarios;
	}

}
