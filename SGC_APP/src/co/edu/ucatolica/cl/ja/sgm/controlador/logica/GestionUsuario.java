/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.logica;

import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.UsuarioJpaController;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.IllegalOrphanException;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.NonexistentEntityException;
import co.edu.ucatolica.cl.ja.sgm.modelo.Historial;
import co.edu.ucatolica.cl.ja.sgm.modelo.Pista;
import co.edu.ucatolica.cl.ja.sgm.modelo.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author sala3
 */
public class GestionUsuario {
    
    private final UsuarioJpaController usuarioJpaController;
    private Usuario usuario;
    
    public GestionUsuario() {
        this.usuarioJpaController = new UsuarioJpaController();
        this.usuario = null;
        
    }
    
    public boolean existeUsuario(String usuario) {
        this.usuario = usuarioJpaController.findUsuario(usuario);
        return this.usuario != null;
    }
    
    public boolean registrarUsuario(byte[] foto, String nombre, String nickName, String correo, String membresia, String contrasenia) {
        try {
            usuario = new Usuario(nickName, contrasenia, correo, membresiaToBoolean(membresia), nombre);
            usuario.setFoto(foto);
            usuarioJpaController.create(usuario);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean eliminarUsuario(String nickName) {
        try {
            usuarioJpaController.destroy(nickName);
            return true;
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            Logger.getLogger(GestionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean validarInicioDeSecion(String usuario, String password) {
        this.usuario = usuarioJpaController.findUsuario(usuario);
        if (this.usuario != null) {
            if (this.usuario.getPassword().equals(password)) {
                ManejoDeImagenes.guardarFotoDelUsuario(this.usuario.getFoto());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public String[] obtenerDatosDelUsuario() {
        String[] datosUsuario = new String[4];
        if (usuario != null) {
            datosUsuario[0] = usuario.getNickname();
            datosUsuario[1] = usuario.getNombre();
            datosUsuario[2] = membresiaToString(usuario.getTipoMembresia());
            datosUsuario[3] = usuario.getCorreoElectronico();
        } else {
            datosUsuario[0] = "";
            datosUsuario[1] = "";
            datosUsuario[2] = "";
            datosUsuario[3] = "";
        }
        return datosUsuario;
    }
    
    private String membresiaToString(boolean tipoMembresia) {
        if (tipoMembresia) {
            return "Premium";
        } else {
            return "Básica";
        }
    }
    
    private boolean membresiaToBoolean(String tipoMembresia) {
        if (tipoMembresia.equals("Premium")) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean modificarCambiosUsuario(String nombre, String correo) {
        try {
            usuario.setNombre(nombre);
            usuario.setCorreoElectronico(correo);
            usuarioJpaController.edit(usuario);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GestionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(GestionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }    
    
    public DefaultListModel obtenerListasDelUsuario() {
        DefaultListModel listasDeReproduccion = new DefaultListModel();
        if (usuario == null) {
            return listasDeReproduccion;
        } else {
            for (int i = 0; i < usuario.getListaList().size(); i++) {
                listasDeReproduccion.addElement(usuario.getListaList().get(i).getIdLista() + "-" + usuario.getListaList().get(i).getNombreLista() + " = " + usuario.getListaList().get(i).getDuracionTotal());
            }
            return listasDeReproduccion;
        }        
    }
    
    public int obtenerIdListaDelUsuario(String descripcionDeLaLista) {
        String[] campos = descripcionDeLaLista.split("-");
        try {
            return Integer.parseInt(campos[0]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public DefaultListModel obtenerHistorialDelUsuario() {
        DefaultListModel cancionesDelhistorial = new DefaultListModel();
        for (int i = 0; i < usuario.getHistorialList().size(); i++) {
            Historial historial = usuario.getHistorialList().get(i);
            cancionesDelhistorial.addElement(historial.getIdHistorial() + " creada: " + historial.getFechaCreacion().toString() + " modificada: " + historial.getFechaModificacion().toString());
            List<Pista> pistasDelHistorial = historial.getPistaList();
            for (int j = 0; j < pistasDelHistorial.size(); j++) {
                cancionesDelhistorial.addElement(pistasDelHistorial.get(j).getNombre() + " - " + pistasDelHistorial.get(j).getArtistaIdArtista().getNombre() + " - " + pistasDelHistorial.get(j).getAlbumIdAlbum().getNombreDelAlbum());
            }
        }
        return cancionesDelhistorial;
    }
    
}
