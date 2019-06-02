/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.logica;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author aasanchez
 */
public class ManejoDeImagenes {


    public ManejoDeImagenes() {
        
    }

    public ImageIcon mostrarFotoEnIcon(boolean nuevo, double height, double width) {
        if (nuevo) {
            return ajustarImagen("src/recursos/imagenes/perfilDefault.png", height, width);
        } else {
            return ajustarImagen("src/recursos/imagenes/usuarioPerfil.png", height, width);
        }
    }

    public boolean guardarFotoEnElSistema(String archivoOrigen) {
        String archivoDestino = "src/recursos/imagenes/usuarioPerfil.png";
        return copiarImagenes(archivoOrigen, archivoDestino);
    }
    
    private static boolean copiarImagenes(String archivoOrigen,String archivoDestino) {
        try {
            File origen = new File(archivoOrigen);
            File destino = new File(archivoDestino);
            FileInputStream in = new FileInputStream(origen);
            FileOutputStream out = new FileOutputStream(destino);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private ImageIcon ajustarImagen(String rutaFoto, double height, double width) {
        ImageIcon fotoOriginal = new ImageIcon(rutaFoto);
        Icon fotoNueva = new ImageIcon(fotoOriginal.getImage().getScaledInstance((int) width, (int) height, Image.SCALE_DEFAULT));
        return (ImageIcon) fotoNueva;

    }

    public byte[] fotoDelUsuarioEnByteArray() {
        File foto = new File("src/recursos/imagenes/usuarioPerfil.png");
        try {
            byte[] imagenEnByteArray;
            BufferedImage imagenOriginal = ImageIO.read(foto);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(imagenOriginal, "png", baos);
            baos.flush();
            baos.close();
            imagenEnByteArray = baos.toByteArray();
            return imagenEnByteArray;
        } catch (IOException e) {
            return new byte[0];
        }
    }

    public static void guardarFotoDelUsuario(byte[] foto) {
        try {            
            if (foto.length<=0 || foto==null) {
                copiarImagenes("src/recursos/imagenes/perfilDefault.png", "src/recursos/imagenes/usuarioPerfil.png");
            } else {
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(foto));
                ImageIO.write(img, "png", new File("src/recursos/imagenes/usuarioPerfil.png"));
            }            
        } catch (IOException ex) {
            Logger.getLogger(ManejoDeImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
