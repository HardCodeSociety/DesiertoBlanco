package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;


import aplicacion.*;


public class DesiertoBlancoGUI extends JFrame{
	
	private Desierto desierto=null;
	private JMenuBar barMenu;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem importar;
	private JMenuItem exportar;
	private JMenuItem salir;
	private JMenuItem nuevo;
	private JMenu archivo;
	
	private JPanel botones;
	private JScrollPane contenedor;
	private JButton botonMoverTodos;
	private JButton botonMoverUno;
	private JCheckBox checkAPrisa;
	
	private JTextField textNumBuscador;
	
	private JLabel etiquetaTumba;
	private FotoDesierto foto;

	private JFileChooser escoger;
	
	
	public DesiertoBlancoGUI() {
		super("DESIERTO BLANCO");
		try {
			desierto=Desierto.demeDesierto();    	
			desierto.algunosElementos();
			elementos();
			acciones();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void elementos() throws Exception {
		
		foto= new FotoDesierto();
		getContentPane().setLayout(new BorderLayout());
		
		contenedor = new JScrollPane();
		
		foto=new FotoDesierto();
		
		contenedor.getViewport().add(foto);
		
		botones=new JPanel(new GridLayout(1,3));
		checkAPrisa=new JCheckBox("Aprisa");
		botonMoverTodos=new JButton("Mover todos");
		JPanel mini=new JPanel(new FlowLayout());
		botonMoverUno=new JButton("Mover uno");
		textNumBuscador= new JTextField("  1");
		mini.add(botonMoverUno);
		mini.add(textNumBuscador);
		
		botones.add(checkAPrisa);
		botones.add(botonMoverTodos);
		botones.add(mini);
		
		getContentPane().add(contenedor,BorderLayout.CENTER);
		getContentPane().add(botones,BorderLayout.SOUTH);
		
		elementosMenu();
		pack();
		setSize(Desierto.MAXIMO+100,Desierto.MAXIMO+135);
		setResizable(false);
	}
	
	
	private void acciones(){
		ActionListener oyenteBotonMoverTodos=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				moverTodos();
			}	
		};	
		botonMoverTodos.addActionListener(oyenteBotonMoverTodos);
		
		ActionListener oyenteBotonMoverUno=new ActionListener(){
			public void actionPerformed(ActionEvent e){
				moverUno();
			}	
		};	
		botonMoverUno.addActionListener(oyenteBotonMoverUno);
		
		WindowListener w = new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				salir();
			}
		};  
		this.addWindowListener(w);
		nuevo.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					reiniciar();
				}
			}
		);
		salir.addActionListener (
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				}
			);
		guardar.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					guardar();
				}
			}
		);
		abrir.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					abrir();					
				}
			}
		);
	}
	
	public void reiniciar(){
		foto.reiniciar();
		
	}
	public void guardar(){
		File archivo;
		int i=escoger.showSaveDialog(this);
		if (i == JFileChooser.APPROVE_OPTION){
        	archivo = escoger.getSelectedFile();
			int caracteres=archivo.getName.length()
			if(archivo.getName().substring())
			try{
				DesiertoArchivos.guarde(archivo,desierto);
			}catch(DesiertoExcepcion e){}
		}
	}
	public void abrir(){
		File archivo;
		int i=escoger.showOpenDialog(this);
		if (i==JFileChooser.APPROVE_OPTION){
			archivo = escoger.getSelectedFile();
			try{
				desierto.cambieDesierto(DesiertoArchivos.abra(archivo));
			}catch(IOException e){}
			catch(ClassNotFoundException e){}
		}
		actualice();
	}
	private void elementosMenu(){
		nuevo =  new JMenuItem("Nuevo");
		barMenu= new JMenuBar();
		archivo= new JMenu("Archivo");
		abrir = new JMenuItem("Abrir");
		guardar = new JMenuItem("Salvar como");
		importar = new JMenuItem("Importar");
		exportar = new JMenuItem("Exportar");
		salir = new JMenuItem("Salir");
		barMenu.add(archivo);
		archivo.add(nuevo);
		archivo.addSeparator();
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.addSeparator();
		archivo.add(importar);
		archivo.add(exportar);
		archivo.addSeparator();
		archivo.add(salir);
		escoger=new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.DAT", "dat");
		escoger.setFileFilter(filtro);
		this.setJMenuBar(barMenu);	
	}	
	
	
	private void moverTodos(){
		try{
			int veces=(checkAPrisa.isSelected()?100:1);
			for (int i=0;i<veces;i++){
				desierto.seMueven();
				actualice();
			}
		}catch(Exception e){
		}	   
	}
	
	
	private void moverUno(){
		try {
			int nb = Integer.parseInt(textNumBuscador.getText().trim());
			if (nb>=1 && nb<=desierto.numeroElementos()){
				int veces=(checkAPrisa.isSelected()?100:1);
				for (int i=0;i<veces;i++){
					desierto.seMueve(nb);
					actualice();
				}
			}else{
				JOptionPane.showMessageDialog(this,"Error");
			}                
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Error");
			
		}
	}    	
	
	private void actualice(){
		foto.actualice();
	}
	
	
	
	private void salir(){
		dispose();
		System.exit(0);
	}	
	
	
	
	public static void main(String[] args) {
		DesiertoBlancoGUI gui=new DesiertoBlancoGUI();
		gui.setVisible(true);
	}   
	//Clase FotoDesierto
	
	
	class FotoDesierto extends JComponent {
		int x,y;
		Desierto desierto = Desierto.demeDesierto();
		
		private static final int MAX=Desierto.MAXIMO;
		
		private FotoDesierto() {
		}

		public void actualice(){
			desierto=Desierto.demeDesierto();
			repaint();
		}
		public void reiniciar(){
			desierto.reiniciar();
			actualice();
		}
		
		public void paintComponent(Graphics g){
			g.setFont(new Font("TimesRoman", Font.PLAIN, 8)); 
			
			for (int i=1; i<=desierto.numeroElementos(); i++) {
				
				Elemento e=desierto.demeElemento(i);
				//System.out.println(e.getPosY());
				//System.out.println(e.getPosX());
				int x=e.getPosX();
				int y=MAX-e.getPosY();	
				
				g.setColor(e.getColor()); 
				g.drawString(e.mensaje(),x+20,y+10);   
				
				if (! e.esHumano()){
					g.fillOval(x+20,y+0,20,20);
				} else {
					humano(g,e,x,y);
				}
				
			}
			super.paintComponent(g);
		}
		
		
		public void humano(Graphics g, Elemento e,int x, int y){
			int pos;
			g.setColor(Color.PINK);
			g.fillOval(x+10,y+0,10,10);/*cabeza*/
			g.setColor(e.getColor()); 
			g.drawLine(x+10+5,y+10,x+10+5,y+10+20);
			
			pos=(int)(Math.random()*3);
			
			if (pos==0){
				g.drawLine(x+10+5,y+10+5,x+10+15,y+10);/*brazo izq arriba*/
			} else if (pos==1){
				g.drawLine(x+10+5,y+10+5,x+10+15,y+10+5);/*brazo izq al frente*/
			} else {
				g.drawLine(x+10+5,y+10+5,x+10+15,y+10+10);/*brazo izq abajo*/
			}
			
			pos=(int)(Math.random()*3);
			if (pos==0){
				g.drawLine(x+10+5,y+10+5,x+5,y+10);/*brazo der arriba*/
			} else if (pos==1){
				g.drawLine(x+10+5,y+10+5,x+5,y+10+5);/*brazo der al frente*/
			} else{
				g.drawLine(x+10+5,y+10+5,x+5,y+10+10);/*brazo der abajo*/
			}
			
			g.drawLine(x+10+5,(y+15)+10+5,x+10+15,(y+15)+10+15);/*pierna izq abajo*/
			g.drawLine(x+10+5,(y+15)+10+5,x+5,(y+15)+10+15);/*pierna der abajo*/
			
			pos=(int)(Math.random()*3);
			if (pos==0){
				g.drawLine(x+5,(y+15)+10+15,x+5+10,(y+15)+10+15);/*pierna der arriba*/
			} else if (pos==1){
				g.drawLine(x+5,(y+15)+10+15,x+5-10,(y+15)+10+15+5);/*pierna der al frente*/
			} else{
				g.drawLine(x+5,(y+15)+10+15,x+5,(y+15)+10+15+10);/*pierna der abajo*/
			}
			
			pos=(int)(Math.random()*3);
			if (pos==0){
				g.drawLine(x+10+15,(y+15)+10+15,x+10+15-10,(y+15)+10+15);/*pierna izq arriba*/
			} else if (pos==1){
				g.drawLine(x+10+15,(y+15)+10+15,x+10+15+10,(y+15)+10+15+5);/*pierna izq al frente*/
			}else {
				g.drawLine(x+10+15,(y+15)+10+15,x+10+15,(y+15)+10+15+10);/*piernaizqabajo*/
			}
		}
	}
}





