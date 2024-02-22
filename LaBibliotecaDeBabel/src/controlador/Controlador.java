package controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;


import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

import principal.Principal;
import vista.ReproductorMusica;
import vista.Vista;

public class Controlador implements ActionListener{
	
	Vista vista;
	int planta=1;
	int hexagono=1;
	int muro=1;
	int anaquel=1;
	int libro=1;
	String idBusqueda;
	Marshalling marshalling;
	Libro libroMarshalling;
	ArrayList<Libro> compendio = new ArrayList<Libro>();
	String palabra;
	String[] palabrasClave1 = {"fuego", "agua", "aire", "tierra"};
	String[] palabrasClave2 = {"hijo", "padre", "abuelo"};
	String[] palabrasClave3 = {"luna", "estrella"};
	String[] palabrasClave4 = {"libro"};
	String estadoClave1 = "FALTA";
	String estadoClave2 = "FALTA";
	String estadoClave3 = "FALTA";
	String estadoClave4 = "FALTA";

	
	public Controlador(Vista vista) {
		this.vista=vista;
		this.planta=1;
		this.hexagono=1;
		this.muro=1;
		this.anaquel=1;
		this.libro=1;
		this.marshalling=new Marshalling();
	}
	
	public void escucharEventos() {
	    vista.botonNuevaPartida.addActionListener(this);
	    vista.botonContinuar.addActionListener(this);
	    vista.botonAvanzar.addActionListener(this);
	    vista.botonSubirPlanta.addActionListener(this);
	    vista.botonBajarPlanta.addActionListener(this);
	    vista.botonSiguienteHex.addActionListener(this);
	    vista.botonAnteriorHex.addActionListener(this);
	    vista.botonMuro1.addActionListener(this);
	    vista.botonMuro2.addActionListener(this);
	    vista.botonMuro3.addActionListener(this);
	    vista.botonMuro4.addActionListener(this);
	    vista.botonAnaquel1.addActionListener(this);
	    vista.botonAnaquel2.addActionListener(this);
	    vista.botonAnaquel3.addActionListener(this);
	    vista.botonAnaquel4.addActionListener(this);
	    vista.botonAnaquel5.addActionListener(this);
	    vista.buscarLibro.addActionListener(this);
	    vista.boton1.addActionListener(this);
	    vista.boton2.addActionListener(this);
	    vista.boton3.addActionListener(this);
	   
	    vista.boton5.addActionListener(this);
	    vista.boton6.addActionListener(this);
	    vista.boton7.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(vista.botonNuevaPartida)) {
	    	marshalling.biblioteca = new Biblioteca(1024);
			try {
				marshalling.marshal(marshalling.biblioteca);
			} catch (JAXBException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        vista.getContentPane().removeAll();
	        vista.configurarIntroduccion();
	        vista.getContentPane().validate();
	        vista.repaint();
	    }
	    if (e.getSource().equals(vista.botonContinuar)) {
	    	try {
				marshalling.biblioteca = marshalling.unmarshal();
			} catch (JAXBException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	vista.rutaArchivoMusica = "sfx/sanctuary.wav"; // Cambia la ruta por la de tu archivo de audio
	    	vista.reproductorMusica = new ReproductorMusica(vista.rutaArchivoMusica);
	    	vista.reproductorMusica.start(); // Iniciar el hilo del reproductor de música
	    	vista.getContentPane().removeAll();
	        vista.configurarPantallaJuego();
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonAvanzar)) {
	    	vista.getContentPane().removeAll();
	        vista.configurarPantallaJuego();
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonSubirPlanta)) {
	        planta++;
	        if (planta == 33) planta = 1;
	        vista.labelPlantaHex.setText(cambiarNumeroHexagono(planta, hexagono));
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonBajarPlanta)) {
	        planta--;
	        if (planta == 0) planta = 32;
	        vista.labelPlantaHex.setText(cambiarNumeroHexagono(planta, hexagono));
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonSiguienteHex)) {
	        hexagono++;
	        if (hexagono == 33) hexagono = 1;
	        vista.labelPlantaHex.setText(cambiarNumeroHexagono(planta, hexagono));
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonAnteriorHex)) {
	        hexagono--;
	        if (hexagono == 0) hexagono = 32;
	        vista.labelPlantaHex.setText(cambiarNumeroHexagono(planta, hexagono));
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonMuro1)) {
	        muro = 1;
	        vista.configurarPantallaAnaqueles(muro);
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonMuro2)) {
	        muro = 2;
	        vista.configurarPantallaAnaqueles(muro);
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonMuro3)) {
	        muro = 3;
	        vista.configurarPantallaAnaqueles(muro);
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonMuro4)) {
	        muro = 4;
	        vista.configurarPantallaAnaqueles(muro);
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonAnaquel1)) {
	        anaquel = 1;
	        vista.configurarPantallaLibros(anaquel);
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonAnaquel2)) {
	    	anaquel = 2;
	    	vista.configurarPantallaLibros(anaquel);
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonAnaquel3)) {
	    	anaquel = 3;
	    	vista.configurarPantallaLibros(anaquel);
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonAnaquel4)) {
	    	anaquel = 4;
	    	vista.configurarPantallaLibros(anaquel);
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.botonAnaquel5)) {
	    	anaquel = 5;
	    	vista.configurarPantallaLibros(anaquel);
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    if (e.getSource().equals(vista.buscarLibro)) {
	    	
	    	
	    	try {
	    	try {
	    	libro = Integer.parseInt(vista.idLibroBuscado.getText());
	    	}catch(NumberFormatException e2) {
	    		libro=0;
	    	}
	    	if (libro>0&&libro<33) {
	    		
	    		idBusqueda=planta+"-"+hexagono+"-"+muro+"-"+anaquel+"-"+libro;
	    		
	    		
					vista.textoLibroBuscado.setText(marshalling.consultaXpathPorId(idBusqueda));
				
		       
	    		
	    	} else {
	    		libro=0;
	    		vista.idLibroBuscado.setText("");
	    		vista.textoLibroBuscado.setText("ID incorrecta.");
	    	}
	    	
	    	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    }
	    
	    if (e.getSource().equals(vista.boton3)) {
	    	vista.panelInterfazJuego.removeAll();
	        vista.configurarPantallaHexagono();
	    	vista.labelPlantaHex.setText(cambiarNumeroHexagono(planta, hexagono));
	    	libro=0;
	    	muro=0;
	    	anaquel=0;
	        vista.getContentPane().validate();
	        vista.getContentPane().repaint();
	    }
	    
	    if (e.getSource().equals(vista.boton1)) {
	    	
	    	
	    	palabra = JOptionPane.showInputDialog(null, "Inserte una palabra", "Buscador", JOptionPane.PLAIN_MESSAGE);
	    	if (!palabra.isEmpty()) {
	    	try {
				 JOptionPane.showMessageDialog(null, marshalling.consultaXpathPorPalabra(palabra), "ID del libro", JOptionPane.PLAIN_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	}
	    	
	    }
	    
	    if(e.getSource().equals(vista.boton5)) {
	    	int selected = JOptionPane.showConfirmDialog(null, "¿Desea alterar el universo?", 
	    			  	           "Editar libro", JOptionPane.YES_NO_OPTION,
	    			  	           JOptionPane.PLAIN_MESSAGE);
	    			 	if (selected == JOptionPane.YES_OPTION) {
	    			 		if (libro>0&&libro<33) {
	    			    		
	    			    		idBusqueda=planta+"-"+hexagono+"-"+muro+"-"+anaquel+"-"+libro;
	    			    		libroMarshalling = marshalling.biblioteca.buscarLibroPorId(idBusqueda);
	    			    		libroMarshalling.setTexto(vista.textoLibroBuscado.getText());
	    			    		try {
									marshalling.marshal(marshalling.biblioteca);
								} catch (JAXBException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
	    						JOptionPane.showMessageDialog(null, "Libro reescrito", "Editar libro", JOptionPane.PLAIN_MESSAGE);	
	    			    	} else {
	    			    		libro=0;
	    			    		vista.idLibroBuscado.setText("");
	    			    		vista.textoLibroBuscado.setText("ID incorrecta.");
	    			    		JOptionPane.showMessageDialog(null, "ID Incorrecta", "Editar libro", JOptionPane.PLAIN_MESSAGE);	
	    			    	}
	    			 		
	    			 	}
	    			 		
	    			 	
	    }
	    if(e.getSource().equals(vista.boton6)) {
	    	int selected = JOptionPane.showConfirmDialog(null, "¿Desea quemar este libro?", 
		  	           "Quemar libro", JOptionPane.YES_NO_OPTION,
		  	           JOptionPane.PLAIN_MESSAGE);
		 	if (selected == JOptionPane.YES_OPTION) {
		 		if (libro>0&&libro<33) {
		    		
		    		idBusqueda=planta+"-"+hexagono+"-"+muro+"-"+anaquel+"-"+libro;
		    		marshalling.biblioteca.eliminarLibroPorId(idBusqueda);
		    		
		    		try {
						marshalling.marshal(marshalling.biblioteca);
					} catch (JAXBException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Solo quedan las cenizas.", "Quemar libro", JOptionPane.PLAIN_MESSAGE);
					vista.textoLibroBuscado.setText("...");
		    	} else {
		    		libro=0;
		    		vista.idLibroBuscado.setText("");
		    		vista.textoLibroBuscado.setText("ID incorrecta.");
		    		JOptionPane.showMessageDialog(null, "ID Incorrecta", "Editar libro", JOptionPane.PLAIN_MESSAGE);	
		    	}
		 		
		 	}
	    }
	    if(e.getSource().equals(vista.boton7)) {
	    	
	    	if (libro>0&&libro<33) {
	    		
	    		idBusqueda=planta+"-"+hexagono+"-"+muro+"-"+anaquel+"-"+libro;
	    	libroMarshalling = marshalling.biblioteca.buscarLibroPorId(idBusqueda);
	    	
	    	if (!compendio.contains(libroMarshalling)) {
	    		compendio.add(libroMarshalling);
		    	JOptionPane.showMessageDialog(null, "Libro recogido.", "Recoger libro", JOptionPane.PLAIN_MESSAGE);
	    	} else JOptionPane.showMessageDialog(null, "El libro ya se encuentra en el compendio.", "Recoger libro", JOptionPane.PLAIN_MESSAGE);
	    	} else JOptionPane.showMessageDialog(null, "Seleccione primero un libro.", "Recoger libro", JOptionPane.PLAIN_MESSAGE);
	    }
	    
	    if(e.getSource().equals(vista.boton2)) {
	    	
	    	for (Libro libro : compendio) {
	    		for (int i=0; i<4; i++) {
	    			if (libro.getTexto().contains(palabrasClave1[i])) {
	    				estadoClave1="CONSEGUIDO";
	    				
	    			}
	    		}
	    		for (int i=0; i<3; i++) {
	    			if (libro.getTexto().contains(palabrasClave2[i])) {
	    				estadoClave2="CONSEGUIDO";
	    				
	    			}
	    		}
	    		for (int i=0; i<2; i++) {
	    			if (libro.getTexto().contains(palabrasClave3[i])) {
	    				estadoClave3="CONSEGUIDO";
	    				
	    			}
	    		}
	    		if (libro.getTexto().contains(palabrasClave4[0])) {
	    				estadoClave4="CONSEGUIDO";
	    				
	    			}
	    		
	    		
	    	}
	    	
	    	if (estadoClave1.equals("CONSEGUIDO")&&estadoClave2.equals("CONSEGUIDO")
	    			&&estadoClave3.equals("CONSEGUIDO")&&estadoClave4.equals("CONSEGUIDO")) {
	    		
	    		int opcionSeleccionada= JOptionPane.showOptionDialog(null,
	    				"\n·Encuentra un libro que contenga la palabra 'fuego', 'agua', 'aire' o 'tierra': "+estadoClave1+"."
	    		    			+ "\n\n\n·Encuentra un libro que contenga la palabra 'hijo', 'padre' o 'abuelo': "+estadoClave2+"."
	    		    			+ "\n\n\n·Encuentra un libro que contenga la palabra 'luna' o 'estrella': "+estadoClave3+"."
	    		    			+ "\n\n\n·Encuentra un libro que contenga la palabra 'libro: "+estadoClave4+".\n\n\n",
	                    "Compendio",
	                    JOptionPane.YES_NO_OPTION,
	                    JOptionPane.QUESTION_MESSAGE,
	                    null,
	                    new String[]{"Volver con el bibliotecario", "Cancelar"},
	                    // El botón por defecto es el primero
	                    "Cancelar");

	            // Verificar la opción seleccionada
	            if (opcionSeleccionada == JOptionPane.YES_OPTION) {
	            	
	            	File htmlFile = new File("xslt-results.html");
                    try {
						Desktop.getDesktop().browse(htmlFile.toURI());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    System.out.println(htmlFile);
	            	
	            	/*StringBuilder xmlBuilder = new StringBuilder();
	            	xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
	            	xmlBuilder.append("<?xml-stylesheet type=\"text/xsl\" href=\"transformacion.xsl\"?>\n");
	            	xmlBuilder.append("<compendio>\n");
	            	for (Libro libro : compendio) {
	            	    xmlBuilder.append("<libro id=\"" + libro.getId() + "\">");
	            	    xmlBuilder.append(libro.getTexto());
	            	    xmlBuilder.append("</libro>\n");
	            	}
	            	xmlBuilder.append("</compendio>");

	            	String xml= xmlBuilder.toString();

	            	String rutaArchivo = "compendio.xml";

	            	// Escribir el contenido XML en un archivo
	            	try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
	            	    writer.write(xml);
	            	    System.out.println("Archivo XML creado exitosamente.");
	            	} catch (IOException e7) {
	            	    System.err.println("Error al escribir el archivo XML: " + e7.getMessage());
	            	}

	                try {
	                	
	                	
	                		InputStream xslInputStream = Principal.class.getResourceAsStream("transformacion.xsl");
	                		Source xslSource = new StreamSource(xslInputStream);
	                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	                        Transformer transformer = transformerFactory.newTransformer(xslSource);

	                        Source xmlSource = new StreamSource(new StringReader(xml));
	                        StringWriter htmlWriter = new StringWriter();
	                        transformer.transform(xmlSource, new StreamResult(htmlWriter));

	                        String html = htmlWriter.toString();
	                        
	                    try (PrintWriter out = new PrintWriter("output.html")) {
	                        out.println(html);
	                    } catch (FileNotFoundException e5) {
							// TODO Auto-generated catch block
							e5.printStackTrace();
						}

	                    // Abrir el HTML en un navegador web
	                    //File htmlFile = new File("output.html");
	                    //Desktop.getDesktop().browse(htmlFile.toURI());
	                    //System.out.println(html);
	                } catch (TransformerException e4) {
	                    e4.printStackTrace();
	                }/* catch (IOException e6) {
						// TODO Auto-generated catch block
						e6.printStackTrace();
					}*/
	                
	            } else {
	                // Realizar la acción cuando se selecciona "Cancelar" o se cierra el JOptionPane
	                System.out.println("Se ha cancelado la operación");
	            }
	    		
	    	} else {
	    	
	    	JOptionPane.showMessageDialog(null, "\n·Encuentra un libro que contenga la palabra 'fuego', 'agua', 'aire' o 'tierra': "+estadoClave1+"."
	    			+ "\n\n\n·Encuentra un libro que contenga la palabra 'hijo', 'padre' o 'abuelo': "+estadoClave2+"."
	    			+ "\n\n\n·Encuentra un libro que contenga la palabra 'luna' o 'estrella': "+estadoClave3+"."
	    			+ "\n\n\n·Encuentra un libro que contenga la palabra 'libro: "+estadoClave4+".\n\n\n", "Compendio", JOptionPane.PLAIN_MESSAGE);
	    		}
	      }
	    
	}

	public String cambiarNumeroHexagono(int planta, int hexagono) {
	    return planta + "-" + hexagono;
	}


}
