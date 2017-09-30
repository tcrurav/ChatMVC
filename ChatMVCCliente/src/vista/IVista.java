/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;

/**
 *
 * @author Tiburcio
 */
public interface IVista {
    final String ENVIAR = "ENVIAR";
    
    public void habilitarEnviar();
    public void deshabilitarEnviar();
    public void agnadirMensajeATrasiego(String mensaje);
    public void borrarTextoAEnviar();
    public void setControlador(ControladorCliente controlador);
    public void hacerVisible();
    public void inicializar();
    public String getMensajeAEnviar();
}
