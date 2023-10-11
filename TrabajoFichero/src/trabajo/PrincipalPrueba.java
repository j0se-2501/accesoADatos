package trabajo;

import trabajo.Videojuego;

public class PrincipalPrueba {

	public static void main(String[] args) {
		
		int[] jugadores = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
	
		Videojuego juego1 = new Videojuego("Red Dead", "RockStar", "Director", "Productor", genero.accion,
											subgenero.shooter, 18, 2010, "PS3", jugadores);
		Videojuego juego2 = new Videojuego("Mario", "RockStar", "Director", "Productor", genero.accion,
				subgenero.shooter, 18, 2010, "PS3", jugadores);
		Videojuego juego3 = new Videojuego("Sonic", "RockStar", "Director", "Productor", genero.accion,
				subgenero.shooter, 18, 2010, "PS3", jugadores);
		
		System.out.println(juego1.toString());
		System.out.println(juego2.toString());
		System.out.println(juego3.toString());

	}

}
