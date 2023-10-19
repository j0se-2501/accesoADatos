package trabajo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void NumJugadores(ArrayList<Videojuego> arrayListVideojuego) {
		System.out.println("Introduzca el mes del que quiera saber los jugadores: ");
		
				String mes = sc.nextLine().toLowerCase();
				int totalMes = 0;
				DecimalFormat df = new DecimalFormat("0.00");
				
				switch(mes) {
				case "1":
				case "enero":
					
					for (Videojuego juego2 : arrayListVideojuego) {
						
						totalMes += juego2.getJugadores().getEnero();
						
					}
						for (Videojuego juego : arrayListVideojuego) {
							
						double porcentaje = (double) juego.getJugadores().getEnero() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
							
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Enero: "+juego.getJugadores().getEnero()+", Porcentaje en el mes: "+porcentajeFormateado+"%, Total del anno: "+juego.getJugadores().getTotal());
					}
			        
			        break;
				case "2":
			    case "febrero":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getFebrero();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getFebrero() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Febrero: "+juego.getJugadores().getFebrero()+", Porcentaje en el mes: "+porcentajeFormateado+"%, Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "3":
			    case "marzo":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getMarzo();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getMarzo() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Marzo: "+juego.getJugadores().getMarzo()+", Porcentaje en el mes: "+porcentajeFormateado+"%, Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "4":
			    case "abril":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getAbril();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getAbril() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Abril: "+juego.getJugadores().getAbril()+", Porcentaje en el mes: "+porcentajeFormateado+", Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "5":
			    case "mayo":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getMayo();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getMayo() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Mayo: "+juego.getJugadores().getMayo()+", Porcentaje en el mes: "+porcentajeFormateado+", Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "6":
			    case "junio":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getJunio();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getJunio() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Junio: "+juego.getJugadores().getJunio()+", Porcentaje en el mes: "+porcentajeFormateado+", Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "7":
			    case "julio":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getJulio();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getJulio() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Julio: "+juego.getJugadores().getJulio()+", Porcentaje en el mes: "+porcentajeFormateado+", Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "8":
			    case "agosto":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getAgosto();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getAgosto() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Agosto: "+juego.getJugadores().getAgosto()+", Porcentaje en el mes: "+porcentajeFormateado+", Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "9":
			    case "septiembre":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getSeptiembre();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getSeptiembre() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Septiembre: "+juego.getJugadores().getSeptiembre()+", Porcentaje en el mes: "+porcentajeFormateado+", Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "10":
			    case "octubre":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getOctubre();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getOctubre() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Octubre: "+juego.getJugadores().getOctubre()+", Porcentaje en el mes: "+porcentajeFormateado+", Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "11":
			    case "noviembre":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getNoviembre();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getNoviembre() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Noviembre: "+juego.getJugadores().getNoviembre()+", Porcentaje en el mes: "+porcentajeFormateado+", Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    case "12":
			    case "diciembre":
			    	for (Videojuego juego2 : arrayListVideojuego) {
			    	    totalMes += juego2.getJugadores().getDiciembre();
			    	}
			    	for (Videojuego juego : arrayListVideojuego) {
			    		double porcentaje = (double) juego.getJugadores().getDiciembre() / totalMes * 100;
						
						String porcentajeFormateado = df.format(porcentaje);
						System.out.println("ID: "+juego.getID()+", "+juego.getTitulo()+", Diciembre: "+juego.getJugadores().getDiciembre()+", Porcentaje en el mes: "+porcentajeFormateado+", Total del anno: "+juego.getJugadores().getTotal());
					}
			        break;
			    default:
			        System.out.println("Mes no valido");
		    	}
				
				
	}
	
	public static Videojuego editarVideojuego(ArrayList<Videojuego> arrayListVideojuego) {
		System.out.println("Introduzca ID del videojuego que quiera editar: ");
		int id = sc.nextInt();
		for (Videojuego videojuego : arrayListVideojuego) {
			if (videojuego.getID()==id) {
				
				System.out.println("Elija el atributo que desee editar:\n\n"
						+ "1. Titulo\n"
						+ "2. Desarrollador\n"
						+ "3. Director\n"
						+ "4. Productor\n"
						+ "5. Genero\n"
						+ "6. Subgenero\n"
						+ "7. Pegi\n"
						+ "8. Anno\n"
						+ "9. Plataforma\n"
						+ "10. Jugadores");
				
				int opcion = sc.nextInt();

		        switch (opcion) {
		            case 1:
		                System.out.println("Introduzca el nuevo título:");
		                sc.nextLine(); // Limpiar el buffer del scanner antes de leer la línea
		                String nuevoTitulo = sc.nextLine();
		                videojuego.setTitulo(nuevoTitulo);
		                break;
		            case 2:
		                System.out.println("Introduzca el nuevo desarrollador:");
		                sc.nextLine();
		                String nuevoDesarrollador = sc.nextLine();
		                videojuego.setDesarrollador(nuevoDesarrollador);
		                break;
		            case 3:
		                System.out.println("Introduzca el nuevo director:");
		                sc.nextLine();
		                String nuevoDirector = sc.nextLine();
		                videojuego.setDirector(nuevoDirector);
		                break;
		            case 4:
		                System.out.println("Introduzca el nuevo productor:");
		                sc.nextLine();
		                String nuevoProductor = sc.nextLine();
		                videojuego.setProductor(nuevoProductor);
		                break;
		            case 5:
		                System.out.println("Introduzca el nuevo género:");
		                sc.nextLine();
		                String nuevoGenero = sc.nextLine();
		                Genero genero = Genero.valueOf(nuevoGenero);
		                videojuego.setGenero(genero);
		                break;
		            case 6:
		                System.out.println("Introduzca el nuevo subgénero:");
		                sc.nextLine();
		                String nuevoSubgenero = sc.nextLine();
		                Subgenero subgenero = Subgenero.valueOf(nuevoSubgenero);
		                videojuego.setSubgenero(subgenero);
		                break;
		            case 7:
		                System.out.println("Introduzca el nuevo PEGI:");
		                int nuevoPegi = sc.nextInt();
		                videojuego.setPegi(nuevoPegi);
		                break;
		            case 8:
		                System.out.println("Introduzca el nuevo año:");
		                int nuevoAnno = sc.nextInt();
		                videojuego.setAnno(nuevoAnno);
		                break;
		            case 9:
		                System.out.println("Introduzca la nueva plataforma (separadas por comas si son varias):");
		                sc.nextLine();
		                String nuevaPlataforma = sc.nextLine();
		                videojuego.setPlataforma(nuevaPlataforma);
		                break;
		            case 10:
		                Jugadores nuevosJugadores = new Jugadores();
		                int jugadores=0;
		                for (int i = 0; i < 12; i++) {
		                    System.out.print("Introduzca la cantidad de jugadores para el mes " + (i + 1) + ": ");
		                    jugadores=sc.nextInt();
		                    switch (i) {
		                            case 0:
		                            	nuevosJugadores.setEnero(jugadores);
		                                break;
		                            case 1:
		                            	nuevosJugadores.setFebrero(jugadores);
		                                break;
		                            case 2:
		                            	nuevosJugadores.setMarzo(jugadores);
		                                break;
		                            case 3:
		                            	nuevosJugadores.setAbril(jugadores);
		                                break;
		                            case 4:
		                            	nuevosJugadores.setMayo(jugadores);
		                                break;
		                            case 5:
		                            	nuevosJugadores.setJunio(jugadores);
		                                break;
		                            case 6:
		                            	nuevosJugadores.setJulio(jugadores);
		                                break;
		                            case 7:
		                            	nuevosJugadores.setAgosto(jugadores);
		                                break;
		                            case 8:
		                            	nuevosJugadores.setSeptiembre(jugadores);
		                                break;
		                            case 9:
		                            	nuevosJugadores.setOctubre(jugadores);
		                                break;
		                            case 10:
		                            	nuevosJugadores.setNoviembre(jugadores);
		                                break;
		                            case 11:
		                            	nuevosJugadores.setDiciembre(jugadores);
		                                break;
		                            default:
		                                System.out.println("Mes no válido");
		                                break;
		                        }
		                    }
		                    
		                
		                videojuego.setJugadores(nuevosJugadores);
		                break;
		            default:
		                System.out.println("Opción no válida");
		        }
		        
		        System.out.println("Datos del videojuego actualizados:\n"
		        		+ ""+videojuego.toString());
		        
		        for (Videojuego juego : arrayListVideojuego) {
					if (juego.getID()==id) juego = videojuego;
				}
		        
		        return videojuego;
				
			}
		}
		return null;
		
		
        
	}

}
