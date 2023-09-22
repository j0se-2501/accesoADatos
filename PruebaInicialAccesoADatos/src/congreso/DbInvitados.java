package congreso;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;
import java.sql.Date;

public class DbInvitados {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/congresos";
    private static final String USER = "admin";
    private static final String PASS = "1234";
    private static final Scanner sc = new Scanner(System.in);

    public static void getInvitadosFromDatabase() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        ArrayList<Invitado> invitados = new ArrayList<>();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql = "SELECT * FROM alumnos";
            rs = stmt.executeQuery(sql);
            

            while (rs.next()) {
                
            	String dni = rs.getString("dni");
                String apellidos = rs.getString("apellidos");
                String nombre = rs.getString("nombre");
                String centroAcademico = rs.getString("centro_academico");
                int edad = rs.getInt("edad");
                
                Invitado invitado = new Invitado(dni, apellidos, nombre, centroAcademico, edad);
                invitados.add(invitado);
            	}
            	
            	int opcion = -1;
            
				do {
				opcion = menuInvitados();
				switch (opcion) {
				case 0: System.out.println("Hasta pronto!");
				break;
				case 1: consultarInvitado(invitados);
				 break;
				case 2: listarInvitados(invitados);
				 break;
				case 3:Invitado nuevoInvitado = nuevoInvitado(invitados, conn, stmt, rs);
							invitados.add(nuevoInvitado);
				break;
				
				case 4: modificarInvitado(invitados, conn, stmt, rs);
				break;
				
				case 6: eliminarInvitado(invitados, conn, stmt, rs);
				break;
				
				default: System.out.println("Por favor, introduzca una opcion correcta.");
						 
				}
        
				}while(opcion!=0);
			
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            
            if (conn != null) {
                conn.close();
            }
        }

    }
    
    public static int menuInvitados() {
    	boolean invalidInput;
    	do {
    		
    	invalidInput = false;
    	int opcion=-1;
    	
    	System.out.println("\nQue desea hacer?"
    			+ "\n1. Consultar datos personales de un invitado."
    			+ "\n2. Listar todos los invitados.");
    	System.out.println("3. Dar de alta a un invitado"
    			+ "\n4. Modificar datos de un invitado.");
    	System.out.println("6. Eliminar a un invitado del sistema.");
    	System.out.println("\n0. Salir");
    	
    	
    	try {
			opcion = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Debe introducir un numero.");
			invalidInput=true;
			sc.nextLine();
		} 
    	
    	return opcion;
    	
		
    	}while(invalidInput);
    }
    
    public static void listarInvitados(ArrayList<Invitado> invitados) {
        for (Invitado invitado : invitados) {
            System.out.println(invitado.toString());
        }     
    }
    
    public static void consultarInvitado(ArrayList<Invitado> invitados) {
        
        System.out.print("Ingrese el dni del invitado: ");
        String dni;
        int flag = 0;
		try {
			dni = sc.nextLine();
		
			for (Invitado invitado : invitados) {
            if (invitado.getDni() == dni) {
            	System.out.println(invitado.toString());
            	flag=1;
            	}
       
			}
			
			if (flag==0) System.out.println("El dni del invitado no se encuentra en la base de datos.");
		
		} catch (InputMismatchException e) {
			
			System.out.println("Debe introducir un dni correctamente.");
		}
        
    }
    
    public static Invitado nuevoInvitado(ArrayList<Invitado> invitados, 
    		Connection conn,
    		Statement stmt,
    		ResultSet rs) {
        
        System.out.println("Ingresar los datos del nuevo invitado:");

        System.out.println("DNI: ");
        String dni = sc.nextLine();
        
        System.out.println("Apellidos: ");
        String apellidos = sc.nextLine();
        
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Centro Academico: ");
        String centroAcademico = sc.nextLine();

        System.out.println("Edad: ");
        int edad = sc.nextInt();

        // Crear un nuevo objeto Alumno con los datos ingresados
        Invitado nuevoInvitado = new Invitado(dni, apellidos, nombre, centroAcademico, edad);
        
        String sql = "INSERT INTO invitados (dni, apellidos, nombre, centro_academico, edad)\r\n"
        		+ "VALUES ("+dni+", "+apellidos+", '"+nombre+"', '"+centroAcademico+"', '"+apellidos+"', '"+edad+"');";
        try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return nuevoInvitado;
    }
    
    public static void modificarInvitado(ArrayList<Invitado> invitados, 
    		Connection conn,
    		Statement stmt,
    		ResultSet rs) {
  
        System.out.println("Ingrese el dni del invitado cuyos datos desea modificar: ");
        String dni = sc.nextLine();

        Invitado invitado = null;

        for (Invitado a : invitados) {
            if (a.getDni() == dni) {
                invitado = a;
                break;
            }
        }

        if (invitado == null) {
            System.out.println("No se encontró ningún invitado con el dni especificado.");
            return;
        }

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú de modificación de datos del invitado:");
            System.out.println("1. DNI");
            System.out.println("2. Apellidos");
            System.out.println("3. Nombre");
            System.out.println("4. Centro Academico");
            System.out.println("5. Edad");
            
            System.out.println("\n0. Salir");

            System.out.println("Ingrese la opción deseada: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Nuevo DNI: ");
                    String dni2 = sc.nextLine();
                    invitado.setDni(dni2);
                    break;
                case 2:
                    System.out.println("Nuevos apellidos: ");
                    String apellidos = sc.nextLine();
                    invitado.setApellidos(apellidos);
                    break;
                case 3:
                    System.out.println("Nuevo nombre: ");
                    String nombre = sc.nextLine();
                    invitado.setNombre(nombre);
                    break;
                case 4:
                    System.out.println("Nuevo centro academico: ");
                    String centroAcademico = sc.nextLine();
                    invitado.setCentroAcademico(centroAcademico);
                    break;
                case 5:
                    System.out.println("Nueva edad: ");
                    int edad = sc.nextInt();
                    invitado.setEdad(edad);
                    break;
                
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        
        
        
        /*HASTA AQUÍ SORAYA
         * 
         * 
         * 
         * NO ME DIO TIEMPO A MODIFICAR MÁS EL CÓDIGO
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * SALU2*/
        
        
        String sql = "UPDATE invitados SET dni = "+invitado.getDni()+", nombre = '"+invitado.getNombre()+"', apellidos = '"+invitado.getApellidos()+"', "
        		+ "centro_academico = '"+invitado.getCentroAcademico()+"', edad = '"+invitado.getEdad()+"'"
        		+ "WHERE dni = '"+invitado.getDni()+"'\r\n";
        try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Modificación de datos del invitado finalizada.");
    }

    public static void eliminarInvitado(ArrayList<Invitado> invitados, Connection conn, Statement stmt, ResultSet rs) {
        
        System.out.print("Ingrese el código del invitado a eliminar: ");
        String dni = sc.nextLine();

        Invitado invitado = null;

        for (Invitado a : invitados) {
            if (a.getDni() == dni) {
                invitado = a;
                break;
            }
        }

        if (invitado == null) {
            System.out.println("No se encontró ningún invitado con el DNI especificado.");
            return;
        }

        System.out.println("\nDatos del invitado a eliminar:");
        System.out.println(invitado.toString());

        System.out.println("\n¿Está seguro de eliminar al invitado? (S/N): ");
        String confirmacion = sc.next();

        if (confirmacion.equalsIgnoreCase("S")) {
            System.out.println("¿Está completamente seguro? (S/N): ");
            confirmacion = sc.next();

            if (confirmacion.equalsIgnoreCase("S")) {
                invitados.remove(invitado);
                String sql = "DELETE FROM invitados WHERE dni = '"+invitado.getDni()+"'\r\n";
                try {
        			stmt.executeUpdate(sql);
        		} catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
                System.out.println("Invitado eliminado correctamente.");
            } else {
                System.out.println("No se ha eliminado al invitado.");
            }
        } else {
            System.out.println("No se ha eliminado al invitado.");
        }
    }
}


