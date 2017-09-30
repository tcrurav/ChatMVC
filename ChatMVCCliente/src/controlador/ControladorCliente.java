/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloCliente;
import vista.IVista;

/**
 *
 * @author Tiburcio
 */
public class ControladorCliente implements ActionListener {
    IVista vista;
    ModeloCliente modelo;

    public ControladorCliente(IVista vista, ModeloCliente modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void arrancar(){
        vista.hacerVisible();
        vista.inicializar();
        vista.agnadirMensajeATrasiego("conectando con el Servidor...");
        modelo.conectarConElServidor();
        vista.agnadirMensajeATrasiego("Conectado al servidor.");
        modelo.crearFlujos();
        modelo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case IVista.ENVIAR:
                vista.agnadirMensajeATrasiego("Enviando mensaje al Servidor...");
                vista.deshabilitarEnviar();
                modelo.enviarMensaje(vista.getMensajeAEnviar());
                vista.habilitarEnviar();
                vista.agnadirMensajeATrasiego("Mensaje enviado.");
                vista.borrarTextoAEnviar();
                break;
        }
    }
    
    public void agnadirMensajeATrasiego(String mensaje){
        vista.agnadirMensajeATrasiego(mensaje);
    }
}
