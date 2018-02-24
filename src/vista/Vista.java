package vista;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author MANUEL MORENO DELGADO 2ºDAM
 */
public class Vista extends JFrame {
    BorderLayout miBorderLayout;
    JPanel panelInferior, panelCentral, panelSuperior, pestanaMod, pestanaPrincipal;
    JButton close;
    CardLayout tarjetas;
    JList lista;
    JLabel nombreText,apellidoText,dniText,numeroText,cant_numText,fecha_modText;
    private JComboBox dniS;
    private JTextField numeroTextField;
    private JLabel textoDetalles;
    private JList listaPerfil;

    public Vista() {
        initDisplay();
        initComponents();
    }

    public JLabel getTextoDetalles() {
        return textoDetalles;
    }

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public CardLayout getTarjetas() {
        return tarjetas;
    }

    public JComboBox getDniS() {
        return dniS;
    }

    public JTextField getNumeroTextField() {
        return numeroTextField;
    }

    public JLabel getNombreText() {
        return nombreText;
    }

    public JLabel getApellidoText() {
        return apellidoText;
    }

    public JLabel getDniText() {
        return dniText;
    }

    public JLabel getNumeroText() {
        return numeroText;
    }

    public JLabel getCant_numText() {
        return cant_numText;
    }

    public JLabel getFecha_modText() {
        return fecha_modText;
    }

    public JList getLista() {
        return lista;
    }

    public JList getListaPerfil() {
        return listaPerfil;
    }
    
    public JFrame getFrame(){
        return this;
    }

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public JButton getClose() {
        return close;
    }

    private void initDisplay() {
        setLayout(new BorderLayout());
        this.setResizable(false);
        this.setUndecorated(true);
    }

    private void initComponents() {
        panelInferior = new JPanel();
        panelCentral = new JPanel();
        panelSuperior = new JPanel();
        panelInferior.setBackground(Color.yellow);
        panelCentral.setBackground(Color.red);
        panelSuperior.setBackground(new Color(66, 66, 66));
        panelSuperior.setPreferredSize(new Dimension(600, 30));
        panelInferior.setPreferredSize(new Dimension(600, 40));

        this.add(panelInferior, SOUTH);
        this.add(panelCentral, CENTER);
        this.add(panelSuperior, NORTH);

        setActionBar();
        setPrincipal();
        setModificar();
        setVentanas();
        setBackNextBar();
    }

    private void setActionBar() {
        panelSuperior.setLayout(new BorderLayout());
        close = new JButton("X");
        close.setBorder(new EmptyBorder(close.getInsets()));
        close.setContentAreaFilled(false);
        close.setForeground(Color.white);
        close.setFocusable(false);
        panelSuperior.add(close, EAST);
        JLabel title = new JLabel("    DATOS RELATIVOS A NUMEROS");
        title.setForeground(Color.white);
        panelSuperior.add(title, WEST);
    }

    private void setModificar() {
        pestanaMod = new JPanel();
        pestanaMod.setLayout(new BorderLayout());
        
        JLabel panelNumeros = new JLabel();
        JPanel panelCampos = new JPanel(null);
        panelCampos.setBackground(new Color(211,211,211));
        panelNumeros.setPreferredSize(new Dimension(229, panelCentral.getHeight()));
        
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/img/background.jpg"));
        ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(371, 371, java.awt.Image.SCALE_SMOOTH));
        panelNumeros.setIcon(iconoEscala);
       
        panelNumeros.setOpaque(true);
        
        pestanaMod.setLayout(new BorderLayout());
        pestanaMod.add(panelNumeros, WEST);
        pestanaMod.add(panelCampos);
        
        JLabel dniSTag = new JLabel("DNI :");
        dniSTag.setBounds(50, 50, 50, 20);
        panelCampos.add(dniSTag);
        dniS = new JComboBox();
        dniS.setBounds(100, 50, 200, 20);
        panelCampos.add(dniS);
        numeroTextField = new JTextField("Numero");
        numeroTextField.setBounds(100, 100, 200, 20);
        numeroTextField.setForeground(Color.lightGray);
        panelCampos.add(numeroTextField);
    }

    private void setPrincipal() {
        pestanaPrincipal = new JPanel();
        JPanel panelNumeros = new JPanel();
        JPanel panelCampos = new JPanel(new FlowLayout());
        panelCampos.setBorder(new EmptyBorder(35,0, 0, 0));
        panelCampos.setBackground(new Color(211,211,211));
        panelNumeros.setPreferredSize(new Dimension(229, panelCentral.getHeight()));
        panelNumeros.setLayout(new FlowLayout());
        panelNumeros.setBackground(new Color(255, 182, 0));
        pestanaPrincipal.setLayout(new BorderLayout());
        pestanaPrincipal.add(panelNumeros, WEST);
        pestanaPrincipal.add(panelCampos);
        
        JLabel nombre = new JLabel("Nombre:");
        nombre.setPreferredSize(new Dimension(110,20));
        JLabel apellido = new JLabel("Apellido:");
        apellido.setPreferredSize(new Dimension(110,20));
        JLabel dni = new JLabel("DNI:");
        dni.setPreferredSize(new Dimension(110,20));
        JLabel numero = new JLabel("Numero:");
        numero.setPreferredSize(new Dimension(110,20));
        JLabel cant_num = new JLabel("Cantidad numeros:");
        cant_num.setPreferredSize(new Dimension(110,20));
        JLabel fecha_mod = new JLabel("Ultima fecha:");
        fecha_mod.setPreferredSize(new Dimension(110,20));
        
        nombreText = new JLabel();
        labelStyler(nombreText);
        apellidoText = new JLabel();
        labelStyler(apellidoText);
        dniText = new JLabel();
        labelStyler(dniText);
        numeroText = new JLabel();
        labelStyler(numeroText);
        cant_numText = new JLabel();
        labelStyler(cant_numText);
        fecha_modText = new JLabel();
        labelStyler(fecha_modText);
        
        panelCampos.add(nombre);
        panelCampos.add(nombreText);
        panelCampos.add(apellido);
        panelCampos.add(apellidoText);
        panelCampos.add(dni);
        panelCampos.add(dniText);
        panelCampos.add(numero);
        panelCampos.add(numeroText);
        panelCampos.add(cant_num);
        panelCampos.add(cant_numText);
        panelCampos.add(fecha_mod);
        panelCampos.add(fecha_modText);

        panelNumeros.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 35));
        lista = new JList();
        lista.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 40));
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setPreferredSize(new Dimension(170,230));
        scroll.setBorder(null);
        panelNumeros.add(scroll, CENTER);
    }
    
    private void labelStyler(JLabel label){
        label.setPreferredSize(new Dimension(240,20));
        label.setBackground(Color.white);
        label.setOpaque(true);
    }

    private void setVentanas() {
        tarjetas = new CardLayout();
        panelCentral.setLayout(tarjetas);
        panelCentral.add(pestanaMod, "Modificar");
        panelCentral.add(pestanaPrincipal, "Inicio");
        tarjetas.show(panelCentral, "Inicio");
    }

    private void setBackNextBar() {
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 3));
        panelInferior.setBackground(new Color(0, 188, 212));
    }
}
