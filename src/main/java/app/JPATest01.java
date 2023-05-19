package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.TbTipo;
import model.TbUsuario; 

public class JPATest01 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("clase_02");
		EntityManager em = fabrica.createEntityManager();

		List<TbUsuario> lstUsuarios = em.createQuery("Select a From TbUsuario a" ,TbUsuario.class).getResultList();
		System.out.println("==============================================");
		
		/*Mostrar cantidad de usuarios*/
		System.out.println("nro de usuarios:" +lstUsuarios.size());
		System.out.println("==============================================");
		
		/*Listar todos los usuarios*/
		System.out.println("Lista de usuarios:");
		System.out.println("-----------------");
		for(TbUsuario u: lstUsuarios){
			System.out.println("usuario: "+u.getNomUsua()+ " " + u.getApeUsua()+ " clave:"+ u.getClaUsua());
		}
		 
		System.out.println("==============================================");
		
		
		
		/*
		//inicializamos
		int opcion=0; 
		Scanner scanner=new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		TbUsuario usu;
		
		EntityManager entity=Utiles.getEntityManagerFactory().createEntityManager();
		 
		while(opcion!=5) {
			System.out.println("1.Ingresar nuevo usuario");
			System.out.println("2.Buscar usuario");
			System.out.println("3.Actualizar usuario");
			System.out.println("4.Eliminar un usuario");
			System.out.println("5.Salir de la interfaz");
			System.out.println("Elija...");
			
			opcion=scanner.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Digite el nombre;");
				usu=new TbUsuario(); 
				scanner.nextLine();
				usu.setNomUsua(scanner.nextLine());
				
				System.out.println("Digite el apellido;");
				usu.setApeUsua(scanner.nextLine()); 
				
				System.out.println("Digite la clave;");
				usu.setClaUsua(scanner.nextLine()); 
				 
				
				System.out.println("Digite el correo de usuario;");
				usu.setUsrUsua(scanner.nextLine()); 
				
				System.out.println("Digite la fecha de nacimiento de usuario;");
				String fechaNacimientoStr = scanner.nextLine();
				try {
				    Date fechaNacimiento = dateFormat.parse(fechaNacimientoStr);
				    usu.setFnaUsua(fechaNacimiento);
				} catch (ParseException e) {
				    System.out.println("Error al analizar la fecha de nacimiento.Ingrese en formato dd/MM/yyyy ");
				    e.printStackTrace();
				}
				
				System.out.println("Digite el estado de usuario;");
				String estadoStr = scanner.nextLine();
				try {
				    int estado = Integer.parseInt(estadoStr);
				    usu.setEstUsua(estado);
				} catch (NumberFormatException e) {
				    System.out.println("Asegúrese de ingresar un valor numérico.");
				    e.printStackTrace();
				}
				
				System.out.println("Digite el nombre del tipo de usuario;");
				String tipoNombre = scanner.nextLine();
				TypedQuery<TbTipo> query2 = entity.createQuery("SELECT t FROM TbTipo t WHERE t.descripcion = :nombre", TbTipo.class);
				query2.setParameter("nombre", tipoNombre);

				List<TbTipo> resultados = query2.getResultList();

				if (!resultados.isEmpty()) {
				    TbTipo tipo = resultados.get(0);
				    usu.setTbTipo(tipo); 
				    
				    entity.getTransaction().begin();
				    entity.persist(usu);
				    entity.getTransaction().commit();

				} else {
				    // Manejar el escenario si no se encuentra un TbTipo con el nombre especificado
				    System.out.println("No se encontró un tipo de usuario con el nombre especificado.");
				}
				
				System.out.println(usu); 
				System.out.println("Usuario registrado");
				System.out.println(); 
				break;
				
				
				
			case 2:
				System.out.println("Digite el codigo del usuario a buscar");
				
				usu=new TbUsuario();
				usu=entity.find(TbUsuario.class, scanner.nextLong());
				
				if (usu!=null) {
					System.out.println(usu);
					System.out.println();
				}else {
					System.out.println();
					System.out.println("Usuario no encontrado");
					List<TbUsuario> listaUsu=new ArrayList<>();
					Query query= entity.createQuery("SELECT t FROM TbUsuario t");
					listaUsu=query.getResultList();
					for(TbUsuario usus:listaUsu) {
						System.out.println(usus);
					}
				}System.out.println();
				
				 break; 
			
		case 3:
			
			System.out.println("Digite el codigo del usuario a actualizar");
			
			usu=new TbUsuario();
			usu=entity.find(TbUsuario.class, scanner.nextLong());
			
			if (usu!=null) {
				System.out.println(usu);
				System.out.println("Digite el nombre del usuario");
				scanner.nextLine();
				usu.setNomUsua(scanner.nextLine());
				
				System.out.println("Digite el apellido;");
				usu.setApeUsua(scanner.nextLine()); 
				
				System.out.println("Digite la clave;");
				usu.setClaUsua(scanner.nextLine()); 
				 
				
				System.out.println("Digite el correo de usuario;");
				usu.setUsrUsua(scanner.nextLine()); 
				
				
				System.out.println("Digite la fecha de nacimiento de usuario;");
				String fechaNacimientoStr2 = scanner.nextLine();
				try {
				    Date fechaNacimiento2 = dateFormat.parse(fechaNacimientoStr2);
				    usu.setFnaUsua(fechaNacimiento2);
				} catch (ParseException e) {
				    System.out.println("Error al analizar la fecha de nacimiento.Ingrese en formato dd/MM/yyyy ");
				    e.printStackTrace();
				}
				
				System.out.println("Digite el estado de usuario;");
				String estadoStr2 = scanner.nextLine();
				try {
				    int estado2 = Integer.parseInt(estadoStr2);
				    usu.setEstUsua(estado2);
				} catch (NumberFormatException e) {
				    System.out.println("Asegúrese de ingresar un valor numérico.");
				    e.printStackTrace();
				}
				
				System.out.println("Digite el nombre del tipo de usuario;");
				String tipoNombre2 = scanner.nextLine();
				TypedQuery<TbTipo> query3 = entity.createQuery("SELECT t FROM TbTipo t WHERE t.descripcion = :nombre", TbTipo.class);
				query3.setParameter("nombre", tipoNombre2);

				List<TbTipo> resultados2 = query3.getResultList();

				if (!resultados2.isEmpty()) {
				    TbTipo tipo = resultados2.get(0);
				    usu.setTbTipo(tipo); 
				    
				    entity.getTransaction().begin();
					entity.merge(usu);
					entity.getTransaction().commit();

				} else {
				    // Manejar el escenario si no se encuentra un TbTipo con el nombre especificado
				    System.out.println("No se encontró un tipo de usuario con el nombre especificado.");
				}
				 
				System.out.println("Usuario actualizado");
				System.out.println(); 
			}else {
				System.out.println("Usuario no encontrado");
				System.out.println(); 
			}break;
			
			
case 4:
			
			System.out.println("Digite el codigo del usuario a eliminar");
			
			usu=new TbUsuario();
			usu=entity.find(TbUsuario.class, scanner.nextLong());
			
			if (usu!=null) {
				System.out.println(usu); 
				entity.getTransaction().begin();
				entity.remove(usu); 
				entity.getTransaction().commit();
				
				System.out.println("Usuario eliminado");
				System.out.println(); 
			}else {
				System.out.println("Usuario no encontrado...");
				System.out.println(); 
			}break;
				

				case 5:entity.close();Utiles.shutdown();
						break; 
			
		} */
		 
		 
		Query query=em.createNativeQuery("{call logueo(?,?)}",TbUsuario.class);
		query.setParameter(1, "Admin");
		query.setParameter(2, "super"); 
		
		try {
		    TbUsuario usut = (TbUsuario) query.getSingleResult();
		    System.out.println("Bienvenido " + usut.getNomUsua());
		    System.out.println("Tus datos son: " + usut);
		} catch (NoResultException e) {
		    System.out.println("Usuario no existe");
		}  System.out.println("-------------");
		
		}
		 
	
	
	
	
	
	
	
	
	
	
	
	}
	 
	
	
 
 







