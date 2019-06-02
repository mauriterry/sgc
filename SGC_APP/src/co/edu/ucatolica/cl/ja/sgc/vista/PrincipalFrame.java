/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgc.vista;

import co.edu.ucatolica.cl.ja.sgm.controlador.logica.GestionMusica;
import co.edu.ucatolica.cl.ja.sgm.controlador.logica.GestionReproductor;
import co.edu.ucatolica.cl.ja.sgm.controlador.logica.GestionUsuario;
import co.edu.ucatolica.cl.ja.sgm.controlador.logica.ManejoDeImagenes;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author sala3
 */
public class PrincipalFrame extends JFrame {

    //relaciones
    private CambiarContraseniaPanel cambiarContraseniaPanel;
    private GestionAlbumPanel gestionAlbumPanel;
    private GestionArtistaPanel gestionArtistaPanel;
    private GestionMusicaListaPanel gestionMusicaListaPanel;
    private GestionPerfilPanel gestionPerfilPanel;
    private GestionPistaPanel gestionPistaPanel;
    private HomePanel homePanel;
    private InicioDeSesionPanel inicioDeSesionPanel;
    private RegistroPanel registroPanel;
    private ReproductorPanel reproductorPanel;
    private VentanaDialog ventanaDialog;

    private final GestionReproductor gestionReproductor;
    private final GestionUsuario gestionUsuario;
    private final GestionMusica gestionMusica;
    private final ManejoDeImagenes manejoDeImagenes;
    //componentes
    //menubar
    private JMenuBar jMenuBarMenuPrincipal;
    //menu archivo
    private JMenu jMenuArchivo;
    //menu items de archivo
    private JMenuItem jMenuItemPerfil;
    private JMenuItem jMenuItemCerrarSesion;
    private JMenuItem jMenuItemSalir;
    private JMenuItem jMenuItemHome;
    //menu Ayuda
    private JMenu jMenuAyuda;
    //menu items de Ayuda
    private JMenuItem jMenuItemVersion;
    private JMenuItem jMenuItemSoporte;

    /**
     * metodo main
     *
     * @param args argumentos del programa
     */
    public static void main(String[] args) {
        PrincipalFrame principal = new PrincipalFrame();
    }

    /**
     * Metodo Constructor
     */
    public PrincipalFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Sistema de Gestion de Musica");
        this.setIconImage(new ImageIcon("src/recursos/imagenes/iconos/sgm.png").getImage());
        this.setResizable(false);
        this.setVisible(false);
        //iniciar ralacion con la logica
        this.manejoDeImagenes = new ManejoDeImagenes();
        this.gestionMusica = new GestionMusica();
        this.gestionReproductor = new GestionReproductor();
        this.gestionUsuario = new GestionUsuario();
        //inicia caracteristicas del Frame
        this.irAInicioDeSesion();
    }

    /**
     * inicia los componentes del frame, en este caso el menu bar y sus botones
     * y sus eventos.
     */
    private void iniciarComponentesDePrincipal() {
        this.setJMenuBar(null);
        this.jMenuBarMenuPrincipal = new JMenuBar();
        this.jMenuArchivo = new JMenu();
        this.jMenuItemPerfil = new JMenuItem();
        this.jMenuItemCerrarSesion = new JMenuItem();
        this.jMenuItemSalir = new JMenuItem();
        this.jMenuItemHome = new JMenuItem();
        this.jMenuAyuda = new JMenu();
        this.jMenuItemVersion = new JMenuItem();
        this.jMenuItemSoporte = new JMenuItem();
        //this.jMenuArchivo.setText("Archivo");
        this.jMenuArchivo.setIcon(new ImageIcon("src/recursos/imagenes/iconos/archivo.png"));
        this.jMenuItemHome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
        this.jMenuItemHome.setText("Home");
        this.jMenuItemHome.setIcon(new ImageIcon("src/recursos/imagenes/iconos/home.png"));
        this.jMenuItemHome.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHomeActionPerformed(evt);
            }
        });
        this.jMenuArchivo.add(jMenuItemHome);
        this.jMenuItemPerfil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        this.jMenuItemPerfil.setText("Perfil");
        this.jMenuItemPerfil.setIcon(new ImageIcon("src/recursos/imagenes/iconos/perfil.png"));
        this.jMenuItemPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPerfilActionPerformed(evt);
            }
        });
        this.jMenuArchivo.add(jMenuItemPerfil);
        this.jMenuItemCerrarSesion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        this.jMenuItemCerrarSesion.setText("Cerrar Sesion");
        this.jMenuItemCerrarSesion.setIcon(new ImageIcon("src/recursos/imagenes/iconos/cerrarSesion.png"));
        this.jMenuItemCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarSesionActionPerformed(evt);
            }
        });
        this.jMenuArchivo.add(jMenuItemCerrarSesion);
        this.jMenuItemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        this.jMenuItemSalir.setText("Salir");
        this.jMenuItemSalir.setIcon(new ImageIcon("src/recursos/imagenes/iconos/salir.png"));
        this.jMenuItemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        this.jMenuArchivo.add(jMenuItemSalir);
        this.jMenuBarMenuPrincipal.add(jMenuArchivo);
        //this.jMenuAyuda.setText("Ayuda");
        this.jMenuAyuda.setIcon(new ImageIcon("src/recursos/imagenes/iconos/ayuda.png"));
        this.jMenuItemVersion.setText("Version");
        this.jMenuItemVersion.setIcon(new ImageIcon("src/recursos/imagenes/iconos/version.png"));
        this.jMenuItemVersion.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVersionActionPerformed(evt);
            }
        });
        this.jMenuAyuda.add(jMenuItemVersion);
        this.jMenuItemSoporte.setText("Soporte");
        this.jMenuItemSoporte.setIcon(new ImageIcon("src/recursos/imagenes/iconos/soporte.png"));
        this.jMenuItemSoporte.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSoporteActionPerformed(evt);
            }
        });
        this.jMenuAyuda.add(jMenuItemSoporte);
        this.jMenuBarMenuPrincipal.add(jMenuAyuda);
        this.setJMenuBar(jMenuBarMenuPrincipal);
    }

    //metodos de eventos del menu bar    
    private void jMenuItemHomeActionPerformed(ActionEvent evt) {
        irAHome();
    }

    private void jMenuItemPerfilActionPerformed(ActionEvent evt) {
        irAGestionPerfil();
    }

    private void jMenuItemSalirActionPerformed(ActionEvent evt) {
        salir();
    }

    private void jMenuItemCerrarSesionActionPerformed(ActionEvent evt) {
        irAInicioDeSesion();
    }

    private void jMenuItemVersionActionPerformed(ActionEvent evt) {
        mostrarVersion();
    }

    private void jMenuItemSoporteActionPerformed(ActionEvent evt) {
        mostrarSoporte();
    }

    //metodos de navegacion
    protected void salir() {
        System.exit(0);
    }

    private void quitarPanelesDelMarco() {
        setVisible(false);
        if (gestionAlbumPanel != null) {
            remove(gestionAlbumPanel);
            gestionAlbumPanel = null;
        }
        if (gestionArtistaPanel != null) {
            remove(gestionArtistaPanel);
            gestionArtistaPanel = null;
        }
        if (gestionMusicaListaPanel != null) {
            remove(gestionMusicaListaPanel);
            gestionMusicaListaPanel = null;
        }
        if (gestionPerfilPanel != null) {
            remove(gestionPerfilPanel);
            gestionPerfilPanel = null;
        }
        if (gestionPistaPanel != null) {
            remove(gestionPistaPanel);
            gestionPistaPanel = null;
        }
        if (homePanel != null) {
            remove(homePanel);
            homePanel = null;
        }
        if (reproductorPanel != null) {
            remove(reproductorPanel);
            reproductorPanel = null;
        }
    }

    private void iniciarMarco() {
        //inicia los componentes del frame
        this.quitarPanelesDelMarco();
        this.iniciarComponentesDePrincipal();
        this.setVisible(true);
    }

    protected void cerrarVentana() {
        ventanaDialog.dispose();
        ventanaDialog = null;
        irAHome();
    }

    private void iniciarVentana() {
        if (ventanaDialog != null) {
            cerrarVentana();
        }
        setVisible(false);
    }

    private void mostrarVersion() {
        JOptionPane.showMessageDialog(this, "Version: 1.0@beta", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarSoporte() {
        JOptionPane.showMessageDialog(this, "Soporte: aasanchez@ucatolica.edu.co", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }

    protected void irAInicioDeSesion() {
        iniciarVentana();
        inicioDeSesionPanel = new InicioDeSesionPanel(this);
        Image imagen = new ImageIcon("src/recursos/imagenes/iconos/inicioDeSesion.png").getImage();
        ventanaDialog = new VentanaDialog(this, inicioDeSesionPanel, "Ventana", false, false, imagen, DO_NOTHING_ON_CLOSE);
    }

    protected void irARegistro() {
        iniciarVentana();
        registroPanel = new RegistroPanel(this);
        Image imagen = new ImageIcon("src/recursos/imagenes/iconos/registro.png").getImage();
        ventanaDialog = new VentanaDialog(this, registroPanel, "Registro", false, false, imagen, DO_NOTHING_ON_CLOSE);
    }
    
    protected void irACambioContrasenia() {
        iniciarVentana();
        this.setVisible(true);
        cambiarContraseniaPanel = new CambiarContraseniaPanel(this);
        Image imagen = new ImageIcon("src/recursos/imagenes/iconos/registro.png").getImage();
        ventanaDialog = new VentanaDialog(this, cambiarContraseniaPanel, "Registro", false, false, imagen, DO_NOTHING_ON_CLOSE);
    }
    
    protected void irAHome() {
        iniciarMarco();
        //agrega el panelinicial
        homePanel = new HomePanel(this);
        homePanel.setVisible(true);
        add(homePanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }

    protected void irAGestionPerfil() {
        iniciarMarco();
        //agrega el panelinicial
        gestionPerfilPanel = new GestionPerfilPanel(this);
        gestionPerfilPanel.setVisible(true);
        add(gestionPerfilPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }

    protected void irAPerfilDesCambioDeContrasenia() {
        cerrarVentana();
        irAGestionPerfil();
    }

    protected void irAGestionMusicaLista() {
        iniciarMarco();
        //agrega el panelinicial
        gestionMusicaListaPanel = new GestionMusicaListaPanel(this);
        gestionMusicaListaPanel.setVisible(true);
        add(gestionMusicaListaPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }

    protected void irAGestionAlbum() {
        iniciarMarco();
        //agrega el panelinicial
        gestionAlbumPanel = new GestionAlbumPanel(this);
        gestionAlbumPanel.setVisible(true);
        add(gestionAlbumPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }

    protected void irAReproductor(int idLista) {
        iniciarMarco();
        //agrega el panelinicial
        reproductorPanel = new ReproductorPanel(this);
        reproductorPanel.cargarCanciones(idLista);
        reproductorPanel.setVisible(true);        
        add(reproductorPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }

    protected void irAGestionPista() {
        iniciarMarco();
        //agrega el panelinicial
        gestionPistaPanel = new GestionPistaPanel(this);
        gestionPistaPanel.setVisible(true);        
        add(gestionPistaPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);}

    protected void irAArtista() {
        iniciarMarco();
        //agrega el panelinicial
        gestionArtistaPanel = new GestionArtistaPanel(this);
        gestionArtistaPanel.setVisible(true);        
        add(gestionArtistaPanel);
        //se ajusta el frame
        pack();
        //centra la aplicacion 
        setLocationRelativeTo(null);
    }   

    //metodos de paso de mensajes.
    //manejo de Imagenes
    protected boolean guardarFotoEnSistema(String rutaFoto) {
        return manejoDeImagenes.guardarFotoEnElSistema(rutaFoto);
    }

    protected ImageIcon mostrarFoto(boolean nuevo, double height, double width) {
        return manejoDeImagenes.mostrarFotoEnIcon(nuevo, height, width);
    }

    //GestionUsuario    
    protected boolean existeUsuario(String usuario) {
        return gestionUsuario.existeUsuario(usuario);
    }

    protected boolean verificarClaveUsuario(String usuario, String password) {
        return gestionUsuario.validarInicioDeSecion(usuario, password);
    }
    
    boolean registrarUsuario(String nombre, String nickName, String correo, String membresia, String contrasenia) {
        byte[] foto = manejoDeImagenes.fotoDelUsuarioEnByteArray();
        return gestionUsuario.registrarUsuario(foto, nombre, nickName, correo, membresia, contrasenia);
    }

    protected String[] obtenerDatosUsuario() {
        return gestionUsuario.obtenerDatosDelUsuario();
    }
    
    protected String obtenerNickName() {
        return gestionUsuario.obtenerDatosDelUsuario()[0];
    }
    
    protected DefaultListModel obtenerListasDelUsuario() {
        return gestionUsuario.obtenerListasDelUsuario();
    }
    
    protected DefaultListModel obtenerHistorialDelUsuario() {
        return gestionUsuario.obtenerHistorialDelUsuario();
    }
    
    protected int idListaDelUsuario(String descripcionDeLaLista) {
        return gestionUsuario.obtenerIdListaDelUsuario(descripcionDeLaLista);
    }

    protected boolean modificarCambiosUsuario(String nombre, String correo) {
        return gestionUsuario.modificarCambiosUsuario(nombre, correo);
    }
    //GestionReproductor
    
    //GestionMusica  
    protected String obtenerArtistasToString() {
        return gestionMusica.artistasToString();
    }

    protected int cantidadDeArtistas() {
        return gestionMusica.cantidadDeArtistas();
    }

    protected String[] obtenerArtistasToStringArray() {
        return gestionMusica.obtenerArtistasToStringArray();
    } 

    protected boolean existeArtista(int id) {
        return gestionMusica.existeArtista(id);
    }
    
    protected boolean existeLista(int id) {
        return gestionMusica.existeLista(id);
    }

    protected boolean crearArtista(int id, String nombre, int edad, String sexo, String nacionalidad) {
        return gestionMusica.crearArtista(id, nombre, edad, sexo, nacionalidad);
    }

    protected boolean crearLista(int id, String nombre) {
        return gestionMusica.crearLista(id, nombre);
    }
        
    protected String[] datosDelArtista(String datosDeBusqueda) {
        return gestionMusica.artistaToStringArray(datosDeBusqueda);
    }
    
    protected String[] datosDeLaLista(String datosDeBusqueda) {
        return gestionMusica.listaToStringArray(datosDeBusqueda);
    }

    protected boolean eliminarArtista(int idArtista) {
        return gestionMusica.eliminarArtista(idArtista);
    }

    protected boolean modificarArtista(int id, String nombre, int edad, String sexo, String nacionalidad) {
         return gestionMusica.modificarArtista(id, nombre, edad, sexo, nacionalidad);
    }

}
