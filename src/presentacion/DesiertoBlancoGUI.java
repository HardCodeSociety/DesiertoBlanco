package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;


import aplicacion.*;


public class DesiertoBlancoGUI extends JFrame{
	
	private Desierto desierto=null;
	
	private JPanel botones;
	private JScrollPane contenedor;
	private JButton botonMoverTodos;
	private JButton botonMoverUno;
	private JCheckBox checkAPrisa;
	
	private JTextField textNumBuscador;
	
	private JLabel etiquetaTumba;
	private FotoDesierto foto;
	
	
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
		
		public void paintComponent(Graphics g){
			g.setFont(new Font("TimesRoman", Font.PLAIN, 8)); 
			
			for (int i=1; i<=desierto.numeroElementos(); i++) {
				
				Elemento e=desierto.demeElemento(i);
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





