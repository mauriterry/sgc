/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.logica;

import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.AlbumJpaController;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.ArtistaJpaController;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.ListaJpaController;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.PistaJpaController;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.IllegalOrphanException;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.NonexistentEntityException;
import co.edu.ucatolica.cl.ja.sgm.modelo.Artista;
import co.edu.ucatolica.cl.ja.sgm.modelo.Lista;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sala3
 */
public class GestionMusica {

    private final ArtistaJpaController artistaJpaController;
    private final AlbumJpaController albumJpaController;
    private final PistaJpaController pistaJpaController;
    private final ListaJpaController listaJpaController;

    public GestionMusica() {
        this.artistaJpaController = new ArtistaJpaController();
        this.albumJpaController = new AlbumJpaController();
        this.pistaJpaController = new PistaJpaController();
        this.listaJpaController = new ListaJpaController();
    }

    public String artistasToString() {
        String artistas = "";
        List<Artista> listaDeArtistas = artistaJpaController.findArtistaEntities();
        for (int i = 0; i < listaDeArtistas.size(); i++) {
            artistas += listaDeArtistas.get(i).getIdArtista() + " " + listaDeArtistas.get(i).getNombre();
        }
        return artistas;
    }

    public int cantidadDeArtistas() {
        return artistaJpaController.findArtistaEntities().size();
    }

    public String[] obtenerArtistasToStringArray() {
        String artistasToString[] = new String[cantidadDeArtistas()];
        List<Artista> listaDeArtistas = artistaJpaController.findArtistaEntities();
        for (int i = 0; i < listaDeArtistas.size(); i++) {
            artistasToString[i] = listaDeArtistas.get(i).getIdArtista() + "-" + listaDeArtistas.get(i).getNombre();
        }
        return artistasToString;
    }

    public boolean existeArtista(int id) {
        Artista artista = artistaJpaController.findArtista(id);
        return artista != null;

    }
    public boolean existeLista(int id) {
        Lista lista = listaJpaController.findLista(id);
        return lista != null;

    }

    public boolean crearArtista(int id, String nombre, int edad, String sexo, String nacionalidad) {
        try {
            Artista artista = new Artista(id, nombre, sexo, edad, nacionalidad);
            artistaJpaController.create(artista);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GestionMusica.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String[] artistaToStringArray(String datosDeBusqueda) {
        int id = obtenerIdDelArtista(datosDeBusqueda);
        Artista artista = artistaJpaController.findArtista(id);
        String[] datosArtista = new String[5];
        datosArtista[0]=artista.getNombre();
        datosArtista[1]=artista.getIdArtista()+"";
        datosArtista[2]=artista.getEdad()+"";
        datosArtista[3]=artista.getSexo();
        datosArtista[4]=artista.getNacionalidad();
        return datosArtista;  
    }

    public boolean eliminarArtista(int idArtista) {
        try {
            artistaJpaController.destroy(idArtista);
            return true;
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            Logger.getLogger(GestionMusica.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private int obtenerIdDelArtista(String datosDeBusqueda) {
        String[] campos = datosDeBusqueda.split("-");
        try{
            return Integer.parseInt(campos[0]);
        }catch (NumberFormatException e){
            return -1;
        }
    }

    public boolean modificarArtista(int id, String nombre, int edad, String sexo, String nacionalidad) {
        try {
            Artista artista = artistaJpaController.findArtista(id);
            artista.setEdad(edad);
            artista.setNacionalidad(nacionalidad);
            artista.setNombre(nombre);
            artista.setSexo(sexo);
            artistaJpaController.edit(artista);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GestionMusica.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(GestionMusica.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean crearLista(int id, String nombre) {
        try {
            Lista lista = new Lista (id, nombre);
            listaJpaController.create(lista);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(GestionMusica.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public String[] listaToStringArray(String datosDeBusqueda) {
        int id = obtenerIdDelArtista(datosDeBusqueda);
        Lista lista = listaJpaController.findLista(id);
        String[] datosLista = new String[2];
        datosLista[0]=lista.getNombreLista();
        datosLista[1]=lista.getIdLista()+"";
        
        return datosLista;  
    }

}
