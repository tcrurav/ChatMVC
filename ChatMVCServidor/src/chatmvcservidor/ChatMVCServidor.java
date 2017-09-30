/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmvcservidor;

import controlador.ControladorServidor;
import modelo.ModeloServidor;
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
        ModeloServidor modelo = new ModeloServidor();
        
        ControladorServidor controlador = new ControladorServidor(vista, modelo);
        
        vista.setControlador(controlador);
        modelo.setControlador(controlador);
        
        controlador.arrancar();
    }
    
}
