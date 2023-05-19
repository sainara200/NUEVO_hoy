package app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.TbCategoria;
import model.TbProducto;
import model.TbProveedor;
import model.TbTipo;
import model.TbUsuario; 

public class JPATESTProductos {

	
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("clase_02");
		EntityManager em = fabrica.createEntityManager();
		EntityManager entity=Utiles.getEntityManagerFactory().createEntityManager();


		List<TbProducto> lstProducts = em.createQuery("Select a From TbProducto a" ,TbProducto.class).getResultList();
		System.out.println("==============================================");
		
		/*Mostrar cantidad de usuarios*/
		System.out.println("nro de productos registrados:" +lstProducts.size());
		System.out.println("==============================================");
		
		/*Listar todos los usuarios*/
		System.out.println("Lista de productos:");
		System.out.println("-----------------");
		for(TbProducto p: lstProducts){
			System.out.println("producto: "+p.getDesProd()+ " precio:" + p.getPreProd()+ " categoria:"+ p.getTbCategoria().getDescripcion());
		}
		 
		System.out.println("==============================================");
		
		
		
		
		    
		     

		 
		
		/*
		// Crear un objeto de Usuario a grabar
		TbProducto o = new TbProducto();
				o.setIdProd("P0116");
				o.setDesProd("PILA REUTILIZABLE");
				o.setStkProd(12);				
				o.setPreProd(15.5); 
				// Crear una instancia de TbCategoria y asignarla a o
				TypedQuery<TbCategoria> query = entity.createQuery("SELECT t FROM TbCategoria t WHERE t.descripcion = :nombre", TbCategoria.class);
				String categoriaNombre = "Cremas";
				query.setParameter("nombre", categoriaNombre);

				List<TbCategoria> resultados = query.getResultList();

				if (!resultados.isEmpty()) {
					TbCategoria categoria = resultados.get(0);
					o.setTbCategoria(categoria); }
				o.setEstProd((byte) 1); 
				// Crear una instancia de TbProveedor y asignarla a o 
			    TypedQuery<TbProveedor> query2 = entity.createQuery("SELECT t FROM TbProveedor t WHERE t.nombreRs = :nombre", TbProveedor.class);
				String provNombre = "La Naturista";
				query2.setParameter("nombre", provNombre);

				List<TbProveedor> resultados2 = query2.getResultList();

				if (!resultados2.isEmpty()) {
					TbProveedor prov = resultados2.get(0);
					o.setTbProveedor(prov);  }
				// 3. empezar mi transacción
				em.getTransaction().begin();
				// proceso a realizar (persistencia)
				 em.persist(o); 
				// 4. confirmar la transacción
				em.getTransaction().commit();
				
				System.out.println(o); 
				System.out.println("Producto registrado");
				System.out.println(); 
				
				  */
				
			/*	//ACTUALIZAR
				
						// Obtener el producto existente de la base de datos
						TbProducto productoExistente = em.find(TbProducto.class, "P0116");

						if (productoExistente != null) {
						    // Actualizar solo las propiedades necesarias
						    productoExistente.setDesProd("Jamon Iberiano Actualizado");
						    productoExistente.setStkProd(12);	

						    
						 // Crear una instancia de TbCategoria y asignarla a o
							TypedQuery<TbCategoria> query = entity.createQuery("SELECT t FROM TbCategoria t WHERE t.descripcion = :nombre", TbCategoria.class);
							String categoriaNombre = "Cremas";
							query.setParameter("nombre", categoriaNombre);

							List<TbCategoria> resultados = query.getResultList();

							if (!resultados.isEmpty()) {
								TbCategoria categoria = resultados.get(0);
								productoExistente.setTbCategoria(categoria); }
							 
							// Crear una instancia de TbProveedor y asignarla a o 
						    TypedQuery<TbProveedor> query2 = entity.createQuery("SELECT t FROM TbProveedor t WHERE t.nombreRs = :nombre", TbProveedor.class);
							String provNombre = "La Naturista";
							query2.setParameter("nombre", provNombre);

							List<TbProveedor> resultados2 = query2.getResultList();

							if (!resultados2.isEmpty()) {
								TbProveedor prov = resultados2.get(0);
								productoExistente.setTbProveedor(prov);  } 
						    
						    // 3. Empezar mi transacción
						    em.getTransaction().begin();
						    // Proceso a realizar (persistencia)
						    em.merge(productoExistente);
						    // 4. Confirmar la transacción
						    em.getTransaction().commit();

						    System.out.println(productoExistente);
						    System.out.println("Producto actualizado");
						    System.out.println();
						} else {
						    System.out.println("El producto no existe en la base de datos");
						}
				*/
				
				/*
				
				//BUSCAR
						TbProducto productoExistente = em.find(TbProducto.class, "P01161"); 
						if (productoExistente != null) { 
							
							
							System.out.println("==================================ENCONTRADO");
							System.out.println("producto: "+productoExistente.getDesProd()+ " precio:" + productoExistente.getPreProd()+ " categoria:"+ productoExistente.getTbCategoria().getDescripcion());							 
						}else {
							System.out.println();
							System.out.println("Producto no encontrado");  
						} 	
						
						*/
						
				//ELIMINAR 		
						 
						// Buscar el producto en la base de datos
						TbProducto productoExistente = em.find(TbProducto.class, "P0116");

						if (productoExistente != null) {
						    // Imprimir los detalles del producto antes de eliminarlo
						    System.out.println("Producto a eliminar:");
						    System.out.println("Descripción: " + productoExistente.getDesProd());
						    System.out.println("Precio: " + productoExistente.getPreProd());
						    System.out.println("Categoría: " + productoExistente.getTbCategoria().getDescripcion());

						    // Iniciar la transacción
						    em.getTransaction().begin();

						    // Eliminar el producto
						    em.remove(productoExistente);

						    // Confirmar la transacción
						    em.getTransaction().commit();

						    System.out.println("Producto eliminado exitosamente");
						} else {
						    System.out.println("Producto no encontrado");
						}
				
				
				
				
				
				
				
		
		
		
}
}
	 