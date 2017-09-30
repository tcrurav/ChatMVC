/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmvcservidor;

import controlador.ControladorCliente;
import modelo.ModeloCliente;
import vista.IVista;
import vista.VistaJFrame;

/**
 *
 * @author Tiburcio
 */
public class ChatMVCServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IVista vista = new VistaJFrame();
        ModeloCliente modelo = new ModeloCliente();
        
        ControladorCliente controlador = new ControladorCliente(vista, modelo);
        
        vista.setControlador(controlador);
        modelo.setControlador(controlador);
        
        controlador.arrancar();
    }
    
}
