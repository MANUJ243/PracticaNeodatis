package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Negocio;
import org.neodatis.odb.ODBFactory;
import vista.Vista;

/**
 * @author MANUEL MORENO DELGADO 2ºDAM
 */
public class controladorVista implements ActionListener, MouseListener, MouseMotionListener, ListSelectionListener, FocusListener {

    Vista vista;
    int xx, xy;
    boolean mod = true;

    public controladorVista(Vista vista) {
        this.vista = vista;
        initListeners();
        Negocio.odb = ODBFactory.open("telefonos.neodatis");
        Negocio.initNeodatis();
        Negocio.odb = ODBFactory.open("telefonos.neodatis");
        vista.getLista().setModel(Negocio.getTelefonosModel());
    }

    private void initListeners() {
        vista.getClose().addMouseListener(this);
        vista.getClose().addActionListener(this);
        vista.getPanelSuperior().addMouseListener(this);
        vista.getPanelSuperior().addMouseMotionListener(this);
        vista.getLista().addListSelectionListener(this);
        vista.getNumeroTextField().addFocusListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getClose()) {
            Negocio.odb.close();
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == vista.getPanelSuperior()) {
            xx = e.getX();
            xy = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == vista.getClose()) {
            vista.getClose().setForeground(Color.red);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == vista.getClose()) {
            vista.getClose().setForeground(Color.white);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource() == vista.getPanelSuperior()) {
            int x = e.getXOnScreen();
            int y = e.getYOnScreen();
            vista.getFrame().setLocation(x - xx, y - xy);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            Negocio.rellenarCampos(vista.getLista().getSelectedValue().toString(), vista.getNombreText(),
                    vista.getApellidoText(), vista.getDniText(), vista.getNumeroText(),
                    vista.getCant_numText(), vista.getFecha_modText());
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == vista.getNumeroTextField()) {
            if (vista.getNumeroTextField().getText().equals("Numero")) {
                vista.getNumeroTextField().setText("");
                vista.getNumeroTextField().setForeground(Color.darkGray);
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == vista.getNumeroTextField()) {
            if (vista.getNumeroTextField().getText().equals("")) {
                vista.getNumeroTextField().setText("Numero");
                vista.getNumeroTextField().setForeground(Color.lightGray);
            }
        }
    }
}
