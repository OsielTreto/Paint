/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.scene.paint.Color.color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author OSIEL
 */
public class Paint extends JFrame implements ActionListener {

    JMenuBar menu;
    JMenu archivo;
    JMenuItem abrir, guardar, salir;
    Color color;

    JTable barra = new JTable();
    JLabel herra = new JLabel("Herramientas");
    JLabel form = new JLabel("Formas");
    JLabel colores = new JLabel("Colores");

    JButton lapiz = new JButton();
    JButton rellenar = new JButton();
    JButton borrador = new JButton();
    JButton selectorColor = new JButton();
    JButton gotero = new JButton();

    JButton circulo = new JButton();
    JButton rectangulo = new JButton();
    JButton pentagono = new JButton();
    JButton triangulo = new JButton();
    JButton estrella = new JButton();

    public Paint() {
        menu = new JMenuBar();
        setJMenuBar(menu);
        archivo = new JMenu("Archivo");
        menu.add(archivo);
        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        salir = new JMenuItem("Salir");
        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(salir);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        setTitle("Paint");
        setSize(1280, 720);
        setLayout(null);
        Container contenedor = getContentPane();
        contenedor.setBackground(new Color(38, 38, 38));
        barra.setBounds(0, 0, 1920, 100);
        barra.setBackground(Color.WHITE);

        herra.setBounds(25, 70, 80, 40);
        form.setBounds(220, 70, 80, 40);
        colores.setBounds(390, 70, 80, 40);

        lapiz.setBounds(30, 10, 30, 30);
        rellenar.setBounds(70, 10, 30, 30);
        borrador.setBounds(30, 50, 30, 30);
        gotero.setBounds(70, 50, 30, 30);
        selectorColor.setBounds(380, 10, 60, 60);

        circulo.setBounds(120, 10, 40, 40);
        rectangulo.setBounds(170, 10, 40, 40);
        pentagono.setBounds(220, 10, 40, 40);
        triangulo.setBounds(270, 10, 40, 40);
        estrella.setBounds(320, 10, 40, 40);

        circulo.setIcon(new ImageIcon(getClass().getResource("/iconos/circulo.png")));
        rectangulo.setIcon(new ImageIcon(getClass().getResource("/iconos/rectangulo.png")));
        pentagono.setIcon(new ImageIcon(getClass().getResource("/iconos/pentagono.png")));
        triangulo.setIcon(new ImageIcon(getClass().getResource("/iconos/triangulo.png")));
        estrella.setIcon(new ImageIcon(getClass().getResource("/iconos/estrella.png")));

        lapiz.setIcon(new ImageIcon(getClass().getResource("/iconos/lapiz.png")));
        rellenar.setIcon(new ImageIcon(getClass().getResource("/iconos/bote.png")));
        borrador.setIcon(new ImageIcon(getClass().getResource("/iconos/borra.png")));
        gotero.setIcon(new ImageIcon(getClass().getResource("/iconos/gotero.png")));
        selectorColor.setIcon(new ImageIcon(getClass().getResource("/iconos/selector.png")));

        selectorColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JColorChooser Selectorcolor = new JColorChooser();
                color = Selectorcolor.showDialog(null, "Seleccione un Color", Color.BLUE);
            }
        });

        add(circulo);
        add(rectangulo);
        add(pentagono);
        add(triangulo);
        add(estrella);
        add(selectorColor);
        add(lapiz);
        add(rellenar);
        add(borrador);
        add(gotero);
        add(herra);
        add(form);
        add(colores);
        add(barra);
    }

    public static void main(String[] args) {
        Paint obj = new Paint();
        JanelaComandos JanelaComandos = new JanelaComandos();

        JanelaComandos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JanelaComandos.setSize(1280, 720);
        JanelaComandos.setVisible(true);
        JanelaComandos.setLocationRelativeTo(null);

        //obj.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}

class JanelaComandos extends JFrame {

    JMenuBar menu;
    JMenu archivo;
    JMenuItem abrir, guardar, salir;
    // Barra de Ferramenta com os botões necessários
    private JToolBar barra = new JToolBar();

    private JButton rectangulo = new JButton();
    private JButton circulo = new JButton();
    private JButton triangulo = new JButton();
    private JButton pentagono = new JButton();
    private JButton estrella = new JButton();
    private JButton recta = new JButton("Linea");
    private JButton selectorColor = new JButton();
    private JButton pincel = new JButton();
    JButton fondo = new JButton();

    private Gerador_Desenho Panel_Desenho = new Gerador_Desenho();
    private Color Cor_da_Figura = Color.RED;
    private Color Ultima_Cor = Color.RED;
    private JLabel Status = new JLabel("  Forma activa: Rectangulo");

    public JanelaComandos() {

        super("Paint 1.0");
        menu = new JMenuBar();
        setJMenuBar(menu);
        archivo = new JMenu("Archivo");
        menu.add(archivo);
        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        salir = new JMenuItem("Salir");
        //archivo.add(abrir);
        //archivo.add(guardar);
        archivo.add(salir);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        // Adicionando os componentes
        circulo.setIcon(new ImageIcon(getClass().getResource("/iconos/circulo.png")));
        rectangulo.setIcon(new ImageIcon(getClass().getResource("/iconos/rectangulo.png")));
        pentagono.setIcon(new ImageIcon(getClass().getResource("/iconos/pentagono.png")));
        triangulo.setIcon(new ImageIcon(getClass().getResource("/iconos/triangulo.png")));
        estrella.setIcon(new ImageIcon(getClass().getResource("/iconos/estrella.png")));
        selectorColor.setIcon(new ImageIcon(getClass().getResource("/iconos/selector.png")));
        pincel.setIcon(new ImageIcon(getClass().getResource("/iconos/lapiz.png")));
        fondo.setIcon(new ImageIcon(getClass().getResource("/iconos/bote.png")));

        barra.add(pincel);
        //barra.add(fondo);
        barra.add(rectangulo);
        barra.add(circulo);
        barra.add(triangulo);
        barra.add(pentagono);
        barra.add(estrella);
        barra.add(recta);
        barra.add(selectorColor);

        barra.setBackground(new Color(38, 38, 38));
        Status.setForeground(new Color(38, 38, 38));

        add(barra, BorderLayout.NORTH);
        add(Panel_Desenho, BorderLayout.CENTER);
        add(Status, BorderLayout.SOUTH);

        Eventos_Desenhando Eventos = new Eventos_Desenhando();
        pincel.addActionListener(Eventos);
        fondo.addActionListener(Eventos);
        rectangulo.addActionListener(Eventos);
        circulo.addActionListener(Eventos);
        triangulo.addActionListener(Eventos);
        pentagono.addActionListener(Eventos);
        estrella.addActionListener(Eventos);
        recta.addActionListener(Eventos);
        selectorColor.addActionListener(Eventos);

    }

    private class Eventos_Desenhando implements ActionListener {

        /* A variável Forma determinará qual figura deverá ser desenhada,
         se seu valor for 0 será desenhado um Retângulo, caso for 1
         um Círculo, 2 será uma reta*/
        int Forma = 0;

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == rectangulo) {
                Forma = 0;
                Status.setText("  Forma activa: Rectangulo");
                repaint();
            }

            if (event.getSource() == circulo) {
                Forma = 1;
                Status.setText("  Forma activa: Circulo");
                repaint();
            }
            if (event.getSource() == triangulo) {
                Forma = 2;
                Status.setText("  Forma activa: Triangulo");
                repaint();
            }
            if (event.getSource() == pentagono) {
                Forma = 3;
                Status.setText("  Forma activa: Pentagono");
                repaint();
            }
            if (event.getSource() == estrella) {
                Forma = 4;
                Status.setText("  Forma activa: Estrella");
                repaint();
            }
            if (event.getSource() == recta) {
                Forma = 5;
                Status.setText("  Forma activa: Linea");
                repaint();
            }
            if (event.getSource() == pincel) {
                Forma = 6;
                Status.setText("  Forma activa: Lapiz");
                repaint();
            }
            if (event.getSource() == fondo) {
                Cor_da_Figura = JColorChooser.showDialog(JanelaComandos.this,
                        "Editando color del fondo", Cor_da_Figura);
                if (Cor_da_Figura != null) {
                    Ultima_Cor = Cor_da_Figura;
                }
            }
                        Panel_Desenho.setBackground(Ultima_Cor);


            // Criando uma Caixa de Cor para mudar a cor da linha
            if (event.getSource() == selectorColor) {
                Cor_da_Figura = JColorChooser.showDialog(JanelaComandos.this,
                        "Editando color de figura", Cor_da_Figura);
                if (Cor_da_Figura != null) {
                    Ultima_Cor = Cor_da_Figura;
                }
            }
            // Enviando a Forma a ser desenhada e a cor da linha
            Panel_Desenho.setForma(Forma, Ultima_Cor);

        }
    }
}

class Gerador_Desenho extends JPanel implements MouseListener, MouseMotionListener {

    Dimension Dimensao = Toolkit.getDefaultToolkit().getScreenSize();

    // Criando local onde ficará armazenadas as imagens.
    private BufferedImage Buffered_da_Imagem = new BufferedImage((int) Dimensao.getWidth(),
            (int) Dimensao.getHeight(), BufferedImage.TYPE_INT_RGB);

    private BufferedImage Buffered_da_Reta = new BufferedImage((int) Dimensao.getWidth(),
            (int) Dimensao.getHeight(), BufferedImage.TYPE_INT_RGB);

    private int valor;
    private Color Ultima_Cor;
    private int x;
    private int y;

    public Gerador_Desenho() {

        Graphics g_Imagem = Buffered_da_Imagem.createGraphics();
        g_Imagem.setColor(Color.WHITE);
        g_Imagem.fillRect(0, 0, Buffered_da_Imagem.getWidth(), Buffered_da_Imagem.getHeight());
        g_Imagem.dispose();

        Graphics g_Reta = Buffered_da_Reta.createGraphics();
        g_Reta.setColor(Color.WHITE);
        g_Reta.fillRect(0, 0, Buffered_da_Reta.getWidth(), Buffered_da_Reta.getHeight());
        g_Reta.dispose();

        if (Ultima_Cor == null) {
            Ultima_Cor = Color.RED;
        }

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Buffered_da_Imagem.getWidth(), Buffered_da_Imagem.getHeight());
        g.drawImage(Buffered_da_Reta, 0, 0, null);

        g.dispose();
    }

    public void setForma(int newValor, Color newCor) {
        valor = newValor;
        Ultima_Cor = newCor;
    }

    public void paint_retangulo(int x2, int y2) {

        Graphics2D g_retangulo = Buffered_da_Reta.createGraphics();
        g_retangulo.drawImage(Buffered_da_Imagem, 0, 0, null);
        g_retangulo.setColor(Ultima_Cor);

        g_retangulo.setStroke(new BasicStroke(2.0f));

        if (x2 > x && y2 > y) {
            g_retangulo.drawRect(x, y, x2 - x, y2 - y);
        }
        if (x2 > x && y > y2) {
            g_retangulo.drawRect(x, y2, x2 - x, y - y2);
        }
        if (x > x2 && y > y2) {
            g_retangulo.drawRect(x2, y2, x - x2, y - y2);
        }
        if (x > x2 && y2 > y) {
            g_retangulo.drawRect(x2, y, x - x2, y2 - y);
        }

        g_retangulo.dispose();
    }

    public void paint_Circulo(int x2, int y2) {

        Graphics2D g_Circulo = Buffered_da_Reta.createGraphics();
        g_Circulo.drawImage(Buffered_da_Imagem, 0, 0, null);
        g_Circulo.setColor(Ultima_Cor);

        g_Circulo.setStroke(new BasicStroke(2.0f));

        if (x2 > x && y2 > y) {
            g_Circulo.drawOval(x, y, x2 - x, y2 - y);
        }
        if (x2 > x && y > y2) {
            g_Circulo.drawOval(x, y2, x2 - x, y - y2);
        }
        if (x > x2 && y > y2) {
            g_Circulo.drawOval(x2, y2, x - x2, y - y2);
        }
        if (x > x2 && y2 > y) {
            g_Circulo.drawOval(x2, y, x - x2, y2 - y);
        }

        g_Circulo.dispose();
    }

    public void paint_Reta(int x2, int y2) {

        Graphics2D g_Reta = Buffered_da_Reta.createGraphics();
        g_Reta.drawImage(Buffered_da_Imagem, 0, 0, null);
        // Definindo a Cor da linha
        g_Reta.setColor(Ultima_Cor);

        // Definindo a espessura da linha
        g_Reta.setStroke(new BasicStroke(2.0f));

        // Desenhando a linha
        g_Reta.drawLine(x, y, x2, y2);

        // Atualizando a tela
        g_Reta.dispose();
    }

    // Capturando os Eventos com o mouse
    public void mousePressed(MouseEvent e) {

        // Obtendo as coordenadas do mouse
        x = e.getX();
        y = e.getY();

        // Chamando o método Forma
        Forma(e.getX(), e.getY());

        repaint();
    }

    public void mouseReleased(MouseEvent e) {

        Forma(e.getX(), e.getY());

        Graphics g_Imagem = Buffered_da_Imagem.createGraphics();
        g_Imagem.drawImage(Buffered_da_Reta, 0, 0, null);
        g_Imagem.dispose();

        repaint();
    }

    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        Forma(e.getX(), e.getY());

        repaint(); // Atualiza a imagem do Jpanel   
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

        Forma(e.getX(), e.getY());

        repaint();
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void Forma(int x, int y) {

        if (valor == 0) {
            paint_retangulo(x, y);
        }
        if (valor == 1) {
            paint_Circulo(x, y);
        }
        if (valor == 2) {
            paint_Triangulo(x, y);
        }
        if (valor == 3) {
            paint_Pentagono(x, y);
        }
        if (valor == 4) {
            paint_Estrella(x, y);
        }
        if (valor == 5) {
            paint_Reta(x, y);
        }
        if (valor == 6) {
            paint_pincel(x, y);
        }
        if (valor == 7) {
            paint_fondo();
        }

    }

    @SuppressWarnings("empty-statement")
    private void paint_Triangulo(int x2, int y2) {
        Graphics2D g_triangulo = Buffered_da_Reta.createGraphics();
        g_triangulo.drawImage(Buffered_da_Imagem, 0, 0, null);
        g_triangulo.setColor(Ultima_Cor);

        g_triangulo.setStroke(new BasicStroke(2.0f));
        try {
            if (x2 > x && y2 > y) {
                int[] coordenadasX = {x, (x + x2) / 2, x2};
                int[] coordenadasY = {y2, y, y2};

                g_triangulo.drawPolygon(coordenadasX, coordenadasY, 3);

            }

            if (x2 > x && y > y2) {
                int[] coordenadasX = {x, (x + x2) / 2, x2};
                int[] coordenadasY = {y, y2, y};

                g_triangulo.drawPolygon(coordenadasX, coordenadasY, 3);
            }
            if (x > x2 && y > y2) {
                int[] coordenadasX = {x2, (x + x2) / 2, x};
                int[] coordenadasY = {y, y2, y};

                g_triangulo.drawPolygon(coordenadasX, coordenadasY, 3);
            }
            if (x > x2 && y2 > y) {
                int[] coordenadasX = {x, (x + x2) / 2, x2};
                int[] coordenadasY = {y2, y, y2};

                g_triangulo.drawPolygon(coordenadasX, coordenadasY, 3);
            }

            g_triangulo.dispose();
        } catch (Exception a) {

        }
    }

    private void paint_Pentagono(int x2, int y2) {
        Graphics2D g_pentagono = Buffered_da_Reta.createGraphics();
        g_pentagono.drawImage(Buffered_da_Imagem, 0, 0, null);
        g_pentagono.setColor(Ultima_Cor);

        g_pentagono.setStroke(new BasicStroke(2.0f));
        try {
            if (x2 > x && y2 > y) {
                int parteX = ((x + x2) / 3);
                int parteY = ((y + y2) / 5);

                int[] coordenadasX = {x, (x + x2) / 2, x2, (x + x2) - ((x + x2) / 3), ((x + x2) / 3)};
                int[] coordenadasY = {((y + y2) / 5) + ((y + y2) / 5), y, ((y + y2) / 5) + ((y + y2) / 5), y2, y2};

                g_pentagono.drawPolygon(coordenadasX, coordenadasY, 5);

            }

            if (x2 > x && y > y2) {
                int[] coordenadasX = {x, (x + x2) / 2, x2};
                int[] coordenadasY = {y, y2, y};

                g_pentagono.drawPolygon(coordenadasX, coordenadasY, 5);
            }
            if (x > x2 && y > y2) {
                int[] coordenadasX = {x2, (x + x2) / 2, x};
                int[] coordenadasY = {y, y2, y};

                g_pentagono.drawPolygon(coordenadasX, coordenadasY, 5);
            }
            if (x > x2 && y2 > y) {
                int[] coordenadasX = {x, (x + x2) / 2, x2};
                int[] coordenadasY = {y2, y, y2};

                g_pentagono.drawPolygon(coordenadasX, coordenadasY, 5);
            }

            g_pentagono.dispose();
        } catch (Exception a) {

        }
    }

    public void paint_Estrella(int x2, int y2) {

        Graphics2D g_estrella = Buffered_da_Reta.createGraphics();
        g_estrella.drawImage(Buffered_da_Imagem, 0, 0, null);
        g_estrella.setColor(Ultima_Cor);

        g_estrella.setStroke(new BasicStroke(2.0f));
        int a1 = x2 - x;
        int p1 = x - a1;

        int b1 = y2 - y;

        int p2 = p1 - b1;
        int p3 = x2 - p1;
        int p4 = p3 + y2;
        int p5 = p4 + b1;
        int p6 = b1 / 2;
        int p8 = p3 / 4;
        int p9 = p1 - p8;
        int p10 = p3 / 2;
        int p11 = p4 + p10;
        int p7 = p2 + p6;
        int p12 = x - p7;
        int p13 = p12 + x;
        int p14 = p8 + x2;
        int p15 = x - p2;
        int p16 = x + p15;
        int posx[] = {x2, x, p1, p2, p9, p7, x, p13, p14, p16};
        int posy[] = {y2, y, y2, y2, p4, p5, p11, p5, p4, y2};

        if (x2 > x && y2 > y) {
            g_estrella.drawPolygon(posx, posy, 10);
        }
        if (x2 > x && y > y2) {
            g_estrella.drawPolygon(posx, posy, 10);
        }
        if (x > x2 && y > y2) {
            g_estrella.drawPolygon(posx, posy, 10);
        }
        if (x > x2 && y2 > y) {
            g_estrella.drawPolygon(posx, posy, 10);
        }

        g_estrella.dispose();
    }

    public void paint_pincel(int x2, int y2) {
        Graphics2D g_pincel = Buffered_da_Reta.createGraphics();
        g_pincel.drawImage(Buffered_da_Imagem, 0, 0, null);
        g_pincel.setColor(Ultima_Cor);

        g_pincel.setStroke(new BasicStroke(2.0f));

        g_pincel.drawLine(x, y, x2, y2);
        g_pincel.dispose();
    }

    public void paint_fondo() {

    }

}
