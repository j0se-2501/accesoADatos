package trabajo;

public class Videojuego {

private String titulo;
private String desarrollador;
private String director;
private String productor;
private genero genero;
private subgenero subgenero; //Es nodo nieto de genero
private int pegi;
private int anno;
private plataforma[] plataforma;
private int[] jugadores = new int[12]; //un mes por casilla del array

}



enum plataforma{

	play5, play4, play3, play2, play1, pc, xbox, xbox360, xboxOne, xboxX, xboxS, NintendoSwitch

}

//generos y subgeneros: https://en.wikipedia.org/wiki/List_of_video_game_genres

enum genero{

	accion, accionAventura, aventura, puzzle, rol, simulacion, estrategia, deportes

}

enum subgenero{

	plataformas, shooter, lucha, beatEmUp, sigilo, survival, ritmo, battleRoyale, //para accion
	survivalHorror, metroidVania, //para accion-aventura
	aventuraGrafica, visualNovel, //para aventura
	actionRPG, JRPG, rolOccidental, MMORPG, roguelike, tacticalRPG, dungeonCrawler, //para rol
	construccion, vida, vehiculos, //para simulacion
	guerra, MOBA, realTimeStrategy, turnBasedStrategy, //para estrategia
	carreras, tenis, futbol, baloncesto, golf //para deportes

}
