package trabajo;

import java.util.Scanner;

public class MetodosJugadores {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void NumJugadores(Videojuego videojuego) {
		
		
		
		System.out.println("De que mes desea consultar los espectadores?");
		String mes = sc.next().toLowerCase();
		int jugadoresMes=0;
		
		try {
		
		switch(mes) {
		case "enero":
	        jugadoresMes = videojuego.getJugadores().getEnero();
	        break;
	    case "febrero":
	        jugadoresMes = videojuego.getJugadores().getFebrero();
	        break;
	    case "marzo":
	        jugadoresMes = videojuego.getJugadores().getMarzo();
	        break;
	    case "abril":
	        jugadoresMes = videojuego.getJugadores().getAbril();
	        break;
	    case "mayo":
	        jugadoresMes = videojuego.getJugadores().getMayo();
	        break;
	    case "junio":
	        jugadoresMes = videojuego.getJugadores().getJunio();
	        break;
	    case "julio":
	        jugadoresMes = videojuego.getJugadores().getJulio();
	        break;
	    case "agosto":
	        jugadoresMes = videojuego.getJugadores().getAgosto();
	        break;
	    case "septiembre":
	        jugadoresMes = videojuego.getJugadores().getSeptiembre();
	        break;
	    case "octubre":
	        jugadoresMes = videojuego.getJugadores().getOctubre();
	        break;
	    case "noviembre":
	        jugadoresMes = videojuego.getJugadores().getNoviembre();
	        break;
	    case "diciembre":
	        jugadoresMes = videojuego.getJugadores().getDiciembre();
	        break;
	    default:
	        System.out.println("Mes no valido");
    	}
		
		}catch(Exception e) {
			System.out.println("Por favor, introduzca un mes correcto.");
		}
		
		int total = videojuego.getJugadores().getEnero() +
                videojuego.getJugadores().getFebrero() +
                videojuego.getJugadores().getMarzo() +
                videojuego.getJugadores().getAbril() +
                videojuego.getJugadores().getMayo() +
                videojuego.getJugadores().getJunio() +
                videojuego.getJugadores().getJulio() +
                videojuego.getJugadores().getAgosto() +
                videojuego.getJugadores().getSeptiembre() +
                videojuego.getJugadores().getOctubre() +
                videojuego.getJugadores().getNoviembre() +
                videojuego.getJugadores().getDiciembre();
		
		int media = total/12;
		
		System.out.println(videojuego.getTitulo()+": jugadores en " + mes + ": " + jugadoresMes + "; total de jugadores: " + total + "; media anual: " + media + ".");
	}

}
