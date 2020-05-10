package com.romeoDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.romeo.model.TbHistorial;

public class HistorialDao {

	public void agregarDatosHistorial(TbHistorial his) {
		EntityManager em;
		EntityManagerFactory emf;
		
		emf = Persistence.createEntityManagerFactory("logueo");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(his);
		em.flush();
		em.getTransaction().commit();
	}
	
	public List<Object> historial(){
		List<Object> HISTO= new ArrayList();
		
		EntityManager em;
		EntityManagerFactory emf;
		
		emf = Persistence.createEntityManagerFactory("logueo");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			HISTO=em.createQuery("SELECT his.idHistorial, his.tbUsuariop.idUsuarios, his.fecha FROM, "
					+ " usu.nombre_usuario, usu.apellido_usuario"
					+ " TbHistorial AS his "
					+ " INNER JOIN tbUsuariop AS usu ON usu.idUsuarios=his.tbUsuariop.idUsuarios").getResultList();
			em.getTransaction().commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
		}
		return HISTO;
	}
	
}
