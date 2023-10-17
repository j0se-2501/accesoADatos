package trabajo;

public class MetodosJugadores {
	
	public void calcularMediaAnual(Videojuego videojuego) {
		
		int media = (videojuego.getJugadores().getEnero() +
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
                videojuego.getJugadores().getDiciembre())
				/12;

		System.out.println("Media del ultimo anno de " + videojuego.getTitulo() + ": "+media);
	}

}
