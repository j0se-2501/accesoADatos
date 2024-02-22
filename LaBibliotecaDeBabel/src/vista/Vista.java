package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.ImageIcon;

import controlador.Controlador;

public class Vista extends JFrame {
	
	int estadoVentana=0;
	
	//Elementos pantalla inicial
	public JPanel pantallaInicial = new JPanel();
	public JPanel panelTitulo = new JPanel();
    public JPanel panelBotones = new JPanel();
    public JLabel labelTitulo = new JLabel("La Biblioteca de Babel");
    public JLabel labelImagen = new JLabel(new ImageIcon("img/inicio.jpg")); // Cambia la ruta por la de tu imagen
    public JButton botonNuevaPartida = new JButton("Nueva Partida");
    public JButton botonContinuar = new JButton("Continuar");
	
	
	//Elementos introduccion
    public JPanel introduccion = new JPanel();
    public JLabel textoLabel = new JLabel("");
	public JPanel panelTexto = new JPanel();
	public Timer timer;
	public String rutaArchivoMusica;
	public ReproductorMusica reproductorMusica;
    public int index = 0;
    public String textoCompleto = "<html>El universo (que otros llaman la Biblioteca) se compone de mil veinticuatro hexágonos.<br><br><br><br>Desde cualquier hexágono se ven los treinta y dos pisos inferiores y superiores.<br><br><br><br>A cuatro de los muros de cada hexágono corresponden cinco anaqueles.<br><br><br><br>Cada anaquel encierra treinta y dos libros de formato uniforme.<br><br><br><br>Cada libro lo conforman doscientos ochenta caracteres de naturaleza informe y caótica.<br><br><br><br>Como todos los hombres de la Biblioteca, he viajado en mi juventud.<br><br><br><br>Tú que aún eres joven, ¿podrías ayudarme? Trae a este pobre viejo los libros que añora.</html>";
    public JButton botonAvanzar= new JButton("Comenzar");
    
    
    //Elementos interfaz
    public JPanel pantallaJuego = new JPanel();
    public JPanel panelBotonesArriba = new JPanel(new GridLayout(1, 4));
    public JPanel panelBotonesAbajo = new JPanel(new GridLayout(1, 4));
    public JPanel panelImagen = new JPanel(new BorderLayout());
    public JButton boton1 = new JButton("Buscador");
    public JButton boton2 = new JButton("Compendio");
    public JButton boton3 = new JButton("Volver");
    
    public JButton boton5 = new JButton("Editar");
    public JButton boton6 = new JButton("Quemar");
    public JButton boton7 = new JButton("Añadir al Compendio");
   
    public JLabel labelTexto = new JLabel("1-1");
    public JPanel panelInterfazJuego = new JPanel();;
    public JLabel labelPlantaHex = new JLabel();
    public JButton botonSubirPlanta = new JButton("Subir Planta");
    public JButton botonBajarPlanta = new JButton("Bajar Planta");
    public JButton botonAnteriorHex = new JButton("Anterior Hex.");
    public JButton botonSiguienteHex = new JButton("Siguiente Hex.");
    public JButton botonMuro1 = new JButton("Muro 1");
    public JButton botonMuro2 = new JButton("Muro 2");
    public JButton botonMuro3 = new JButton("Muro 3");
    public JButton botonMuro4 = new JButton("Muro 4");
    
    public JButton botonAnaquel1 = new JButton("Anaquel 1");
    public JButton botonAnaquel2 = new JButton("Anaquel 2");
    public JButton botonAnaquel3 = new JButton("Anaquel 3");
    public JButton botonAnaquel4 = new JButton("Anaquel 4");
    public JButton botonAnaquel5 = new JButton("Anaquel 5");
    
    public JLabel ayudaLibro = new JLabel();;
    public JButton buscarLibro = new JButton("Buscar");
    public JTextField idLibroBuscado = new JTextField();;
    public JTextArea textoLibroBuscado = new JTextArea();;
    
public void configurarIntroduccion() {
    	
    	this.getContentPane().removeAll();
    	pantallaInicial.setVisible(false);
    	introduccion.setVisible(true);
        // Le damos a la lamina una distribución de tipo BorderLayout.
        introduccion.setLayout(new BorderLayout());
        introduccion.setBackground(Color.black);

        // Creamos un panel interno para el texto con margen
        panelTexto = new JPanel(new BorderLayout());
        panelTexto.setBackground(Color.black);
        panelTexto.setBorder(BorderFactory.createEmptyBorder(70, 60, 0, 20)); // Ajusta el margen según tus necesidades

        textoLabel = new JLabel("");
        textoLabel.setForeground(Color.white);
        textoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Añadimos el JLabel al panel interno
        panelTexto.add(textoLabel, BorderLayout.NORTH);
        botonAvanzar.setVisible(false);
        
        botonAvanzar.setPreferredSize(new Dimension(100, 50));
        
        botonAvanzar.setBackground(Color.black);
        botonAvanzar.setForeground(Color.white);
        botonAvanzar.setFont(new Font("Arial", Font.PLAIN, 16));
        botonAvanzar.setBorder(BorderFactory.createEmptyBorder(0, 200, 00, 200));
        introduccion.add(botonAvanzar, BorderLayout.SOUTH);
        
        // Añadimos el panel interno al panel principal en el norte
        introduccion.add(panelTexto, BorderLayout.NORTH);

        // Iniciar el temporizador
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < textoCompleto.length()) {
                    textoLabel.setText(textoCompleto.substring(0, index++));
                } else {
                    timer.stop();
                    botonAvanzar.setVisible(true);
                 }
            }
        });
        
        rutaArchivoMusica = "sfx/sanctuary.wav"; // Cambia la ruta por la de tu archivo de audio
        reproductorMusica = new ReproductorMusica(rutaArchivoMusica);
        reproductorMusica.start(); // Iniciar el hilo del reproductor de música

        timer.start(); // Iniciar el temporizador al agregar el JLabel al panel
        getContentPane().add(introduccion);
    }

    

    private void configurarPantallaInicial() {
        this.getContentPane().removeAll();
        pantallaInicial.setVisible(true);

        pantallaInicial.setLayout(new BorderLayout());
        pantallaInicial.setBackground(Color.white);

        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTitulo.setBackground(Color.white);
        labelTitulo.setFont(new Font("Times New Roman", Font.BOLD, 50)); // Cambia la fuente y el tamaño según tus preferencias
        panelTitulo.add(labelTitulo);
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0)); // Ajusta el margen superior

        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20)); // Añade margen entre los botones
        panelBotones.setBackground(Color.white); // Cambia el color de fondo de los botones
        botonNuevaPartida.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Cambia la fuente y el tamaño de los botones
        botonContinuar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        botonNuevaPartida.setBackground(Color.black); // Cambia el color de fondo de los botones
        botonContinuar.setBackground(Color.black);
        botonNuevaPartida.setForeground(Color.white); // Cambia el color del texto de los botones
        botonContinuar.setForeground(Color.white);
        botonNuevaPartida.setPreferredSize(new Dimension(200, 50)); // Cambia el tamaño de los botones
        botonContinuar.setPreferredSize(new Dimension(200, 50));
        panelBotones.add(botonNuevaPartida);
        panelBotones.add(botonContinuar);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 0, 50, 0)); // Ajusta el margen inferior
        botonNuevaPartida.setFocusPainted(false);
        botonContinuar.setFocusPainted(false);
        pantallaInicial.add(panelTitulo, BorderLayout.NORTH);
        pantallaInicial.add(labelImagen, BorderLayout.CENTER);
        pantallaInicial.add(panelBotones, BorderLayout.SOUTH);
        File comprobarSave = new File("./babel.xml");
        if (!comprobarSave.exists()) botonContinuar.setEnabled(false);
        
        add(pantallaInicial);
    }
    
    public void configurarPantallaJuego() {
        // Eliminar todos los componentes del contenedor principal
        this.getContentPane().removeAll();
        panelInterfazJuego.removeAll();
        
        // Establecer la visibilidad del panel de juego
        pantallaJuego.setVisible(true);
        
        // Configurar el diseño del panel de juego
        pantallaJuego.setLayout(new BorderLayout());

        // Panel para los botones arriba
        panelBotonesArriba = new JPanel(new GridLayout(1, 3));
        panelBotonesArriba.add(boton1);
        panelBotonesArriba.add(boton2);
        panelBotonesArriba.add(boton3);
        
        pantallaJuego.add(panelBotonesArriba, BorderLayout.NORTH);

        // Panel para los botones abajo
        panelBotonesAbajo = new JPanel(new GridLayout(1, 3)); // Cambiado a 3 botones
        panelBotonesAbajo.setBackground(Color.BLACK); // Establecer el color de fondo
        panelBotonesAbajo.add(boton5);
        panelBotonesAbajo.add(boton6);
        panelBotonesAbajo.add(boton7);
        pantallaJuego.add(panelBotonesAbajo, BorderLayout.SOUTH);

        // Establecer el tamaño de los botones y el color de fondo
        Dimension buttonSize = new Dimension(150, 60); // Tamaño personalizado
        boton1.setPreferredSize(buttonSize);
        boton2.setPreferredSize(buttonSize);
        boton3.setPreferredSize(buttonSize);
        
        boton5.setPreferredSize(buttonSize);
        boton6.setPreferredSize(buttonSize);
        boton7.setPreferredSize(buttonSize);
        boton1.setFocusPainted(false);
        boton2.setFocusPainted(false);
        boton3.setFocusPainted(false);
        
        boton5.setFocusPainted(false);
        boton6.setFocusPainted(false);
        boton7.setFocusPainted(false);
        boton1.setBackground(Color.BLACK);
        boton2.setBackground(Color.BLACK);
        boton3.setBackground(Color.BLACK);
        
        boton5.setBackground(Color.BLACK);
        boton6.setBackground(Color.BLACK);
        boton7.setBackground(Color.BLACK);

        // Establecer el color del texto
        Color textColor = Color.WHITE;
        boton1.setForeground(textColor);
        boton2.setForeground(textColor);
        boton3.setForeground(textColor);
        
        boton5.setForeground(textColor);
        boton6.setForeground(textColor);
        boton7.setForeground(textColor);
        
     // Panel para la nueva interfaz de juego
        
        panelInterfazJuego.setLayout(null);
        panelInterfazJuego.setBackground(Color.black); // Establecer el color de fondo
        
        if (estadoVentana==0)configurarPantallaHexagono();
    

        // Agregar el panel de interfaz de juego al panel de juego
        pantallaJuego.add(panelInterfazJuego, BorderLayout.CENTER);

        // Agregar el panel de juego al contenedor principal
        add(pantallaJuego);
    }

    public void configurarPantallaHexagono() {
    	
    	panelInterfazJuego.removeAll();
    	boton5.setEnabled(false);
        boton6.setEnabled(false);
        boton7.setEnabled(false);
    	
     // Panel para la JLabel central
        labelPlantaHex = new JLabel("1-1");
        labelPlantaHex.setBounds(380, 180, 180, 180);
        labelPlantaHex.setForeground(Color.WHITE); // Establecer el color de la fuente
        labelPlantaHex.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto horizontalmente
        labelPlantaHex.setVerticalAlignment(JLabel.CENTER); // Centrar el texto verticalmente
        labelPlantaHex.setPreferredSize(new Dimension(200, 50)); // Establecer el tamaño
        labelPlantaHex.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // Establecer el borde con color blanco
        labelPlantaHex.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir margen
        // Crear una nueva fuente con un tamaño más grande
        Font fuente = new Font(labelPlantaHex.getFont().getName(), Font.BOLD, 30); // Por ejemplo, tamaño 30
        // Establecer la nueva fuente para el JLabel
        labelPlantaHex.setFont(fuente);
        panelInterfazJuego.add(labelPlantaHex, BorderLayout.CENTER);

     // Configurar los botones
        
        botonSubirPlanta.setBounds(380, 50, 180, 60);
        botonSubirPlanta.setBackground(Color.BLACK); // Establecer el color de fondo negro
        botonSubirPlanta.setForeground(Color.WHITE); // Establecer el color del texto blanco

        
        botonBajarPlanta.setBounds(380, 430, 180, 60);
        botonBajarPlanta.setBackground(Color.BLACK); // Establecer el color de fondo negro
        botonBajarPlanta.setForeground(Color.WHITE); // Establecer el color del texto blanco

        
        botonAnteriorHex.setBounds(80, 240, 180, 60);
        botonAnteriorHex.setBackground(Color.BLACK); // Establecer el color de fondo negro
        botonAnteriorHex.setForeground(Color.WHITE); // Establecer el color del texto blanco

        
        botonSiguienteHex.setBounds(680, 240, 180, 60);
        botonSiguienteHex.setBackground(Color.BLACK); // Establecer el color de fondo negro
        botonSiguienteHex.setForeground(Color.WHITE); // Establecer el color del texto blanco
        
     // Crear una nueva fuente con un tamaño más grande para los botones de los muros
        Font fuenteBotonesMuro = new Font("Arial", Font.BOLD, 16);

        // Botones para los muros en las esquinas libres
        
        botonMuro1.setBounds(110, 50, 120, 120); // Forma cuadrada
        botonMuro1.setBackground(Color.DARK_GRAY); // Fondo gris oscuro
        botonMuro1.setForeground(Color.WHITE); // Texto blanco
        botonMuro1.setFont(fuenteBotonesMuro); // Fuente más grande

        botonMuro2.setBounds(710, 50, 120, 120); // Forma cuadrada
        botonMuro2.setBackground(Color.DARK_GRAY); // Fondo gris oscuro
        botonMuro2.setForeground(Color.WHITE); // Texto blanco
        botonMuro2.setFont(fuenteBotonesMuro); // Fuente más grande

        botonMuro3.setBounds(110, 370, 120, 120); // Forma cuadrada
        botonMuro3.setBackground(Color.DARK_GRAY); // Fondo gris oscuro
        botonMuro3.setForeground(Color.WHITE); // Texto blanco
        botonMuro3.setFont(fuenteBotonesMuro); // Fuente más grande

        botonMuro4.setBounds(710, 370, 120, 120); // Forma cuadrada
        botonMuro4.setBackground(Color.DARK_GRAY); // Fondo gris oscuro
        botonMuro4.setForeground(Color.WHITE); // Texto blanco
        botonMuro4.setFont(fuenteBotonesMuro); // Fuente más grande

        // Agregar los botones de los muros al panelInterfazJuego
        panelInterfazJuego.add(botonMuro1);
        panelInterfazJuego.add(botonMuro2);
        panelInterfazJuego.add(botonMuro3);
        panelInterfazJuego.add(botonMuro4);


        // Agregar los botones al panelInterfazJuego
        panelInterfazJuego.add(botonSubirPlanta);
        panelInterfazJuego.add(botonBajarPlanta);
        panelInterfazJuego.add(botonAnteriorHex);
        panelInterfazJuego.add(botonSiguienteHex);
    }
    
    public void configurarPantallaAnaqueles(int numeroMuro) {
        panelInterfazJuego.removeAll();
        
        botonAnaquel1.setBounds(35, 60, 160, 400);
        botonAnaquel2.setBounds(215, 60, 160, 400);
        botonAnaquel3.setBounds(395, 60, 160, 400);
        botonAnaquel4.setBounds(575, 60, 160, 400);
        botonAnaquel5.setBounds(755, 60, 160, 400);

        // Establecer el estilo para los botones de muro y anaquel
        Font fuente = new Font("Arial", Font.BOLD, 20); // Fuente y tamaño
        Color colorTexto = Color.WHITE; // Color del texto
        Color colorFondo = new Color(50, 50, 50); // Color de fondo (gris oscuro)
        
        // Aplicar el estilo a los botones de muro
        JButton[] botonesAnaquel = { botonAnaquel1, botonAnaquel2, botonAnaquel3, botonAnaquel4, botonAnaquel5 };
        for (JButton boton : botonesAnaquel) {
            boton.setFont(fuente);
            boton.setForeground(colorTexto);
            boton.setBackground(colorFondo);
            boton.setFocusPainted(false);
            //boton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen
            panelInterfazJuego.add(boton);
        }
        
        
        
        // Revalidar el panel para actualizar la interfaz
        panelInterfazJuego.revalidate();
        panelInterfazJuego.repaint();
    }
    
    public void configurarPantallaLibros(int numeroAnaquel) {
    	boton5.setEnabled(true);
        boton6.setEnabled(true);
        boton7.setEnabled(true);
        panelInterfazJuego.removeAll();
        
        Font fuente = new Font(labelPlantaHex.getFont().getName(), Font.BOLD, 30); // Por ejemplo, tamaño 30
        // Establecer la nueva fuente para el JLabel
        ayudaLibro.setFont(fuente);
        /*
         * public JLabel ayudaLibro;
    	public JButton buscarLibro;
    	public JTextField idLibroBuscado;
    	public JTextArea textoLibroBuscado;
    	*/
        
        ayudaLibro.setText("ID libro (1-32): ");
        ayudaLibro.setForeground(Color.WHITE);
        ayudaLibro.setBounds(248, -55, 500, 200);
        panelInterfazJuego.add(ayudaLibro);
        
        idLibroBuscado = new JTextField();
        idLibroBuscado.setBounds(468, 25, 50, 40); 
        idLibroBuscado.setFont(fuente);
        panelInterfazJuego.add(idLibroBuscado);
        
       
        buscarLibro.setBounds(548, 25, 150, 40);
        buscarLibro.setBackground(Color.DARK_GRAY); // Fondo gris oscuro
        buscarLibro.setForeground(Color.WHITE); // Texto blanco
        buscarLibro.setFocusPainted(false);
        buscarLibro.setFont(fuente);
        panelInterfazJuego.add(buscarLibro);
        
        textoLibroBuscado = new JTextArea();
        Font fuente2 = new Font(labelPlantaHex.getFont().getName(), Font.BOLD, 30); // Por ejemplo, tamaño 30
        textoLibroBuscado.setFont(fuente2);
        textoLibroBuscado.setBounds(222, 100, 500, 400);
        textoLibroBuscado.setLineWrap(true);
        panelInterfazJuego.add(textoLibroBuscado);

        // Revalidar el panel para actualizar la interfaz
        panelInterfazJuego.revalidate();
        panelInterfazJuego.repaint();
    }


    
	private Controlador controlador;
	
	private void ejecutar() {
		controlador = new Controlador(this);
		controlador.escucharEventos();
	}
	
	public Vista() {
        
        // Le damos un tamaño a la ventana
        this.setSize(960, 720);
         
        // Agregamos un tículo
        this.setTitle("Biblioteca de Babel");
        
        this.estadoVentana=0;
          
        // Lo centramos en pantalla
        this.setLocationRelativeTo(null);
          
        /* Le decimos que no se puede redimensionar*/
        this.setResizable(false);
          
        // Le decimos que al cerrar la ventana, acabe el programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        // Agregamos una lámina a la ventana
        this.getContentPane().add(pantallaInicial);
         
        // llamamos al método que configura la lamina fondo
        // y la lamina de los botones
        configurarPantallaInicial();
        //configurarLaminaBotones();
        ejecutar();
    }    

}
