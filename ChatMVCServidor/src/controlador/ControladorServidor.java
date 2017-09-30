/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloServidor;
import vista.IVista;

/**
 *
 * @author Tiburcio
 */
public class ControladorServidor implements ActionListener {
    IVista vista;
    ModeloServidor modelo;

    public ControladorServidor(IVista vista, ModeloServidor modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void arrancar(){
        vista.hacerVisible();
        vista.inicializar();
        vista.agnadirMensajeATrasiego("abriendo el puerto...");
        modelo.abrirPuerto();
        vista.agnadirMensajeATrasiego("Esperando al cliente...");
        modelo.esperarAlCliente();
        modelo.crearFlujos();
        modelo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case IVista.ENVIAR:
                vista.agnadirMensajeATrasiego("Enviando mensaje al cliente...");
                modelo.enviarMensaje(vista.getMensajeAEnviar());
                vista.agnadirMensajeATrasiego("Mensaje enviado.");
                vista.borrarTextoAEnviar();
                break;
        }
    }
    
    public void agnadirMensajeATrasiego(String mensaje){
        vista.agnadirMensajeATrasiego(mensaje);
    }
}
