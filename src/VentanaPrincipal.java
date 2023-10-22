import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
    private JPanel contentPane;
    private JPanel panelDerecho;
    private JTable pacientesTable;
    private JButton botonSeleccionado = null; // Mantener un seguimiento del botón seleccionado
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal frame = new VentanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
     
    }

    public VentanaPrincipal() {
    	
    	
    	
    	
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza la ventana a pantalla completa
        setLayout(new BorderLayout());

        // Crear un JScrollPane para la barra lateral
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.WEST);

        // Crear un JPanel para la barra lateral con GridLayout
        JPanel barraLateral = new JPanel(new GridLayout(0, 1)); // Un botón por fila
        scrollPane.setViewportView(barraLateral);

        // Crear botón "Deseleccionar" con el mismo tamaño que los otros botones
        JButton deseleccionarBoton = new JButton("Deseleccionar");
        deseleccionarBoton.setPreferredSize(new Dimension(100, 100)); // Tamaño cuadrado
        deseleccionarBoton.setBorder(BorderFactory.createEmptyBorder());
        deseleccionarBoton.setContentAreaFilled(true);

        deseleccionarBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deseleccionarBoton();
            }
        });

        // Agregar el botón "Deseleccionar" al primer botón de los 10 botones existentes
        JButton primerBoton = new JButton("Botón 1");
        primerBoton.setPreferredSize(new Dimension(100, 100)); // Tamaño cuadrado
        primerBoton.setBorder(BorderFactory.createEmptyBorder());
        primerBoton.setContentAreaFilled(true);
        
        
     // Ruta a la imagen que deseas usar
        String rutaImagen = "C:\\Users\\Asus\\Downloads\\logo.jpeg"; // Reemplaza con la ruta de tu imagen

        // Carga la imagen usando ImageIcon
        ImageIcon icono = new ImageIcon(rutaImagen);

        // Crea el botón "Deseleccionar" y establece el icono
        JButton deseleccionarbtn = new JButton("Deseleccionar", icono);

        // Establece el tamaño del botón
        deseleccionarBoton.setPreferredSize(new Dimension(100, 100));
        

        primerBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarBoton(primerBoton);
            }
        });

        // Agregar los botones al panel
        barraLateral.add(deseleccionarBoton);
        barraLateral.add(primerBoton);

        // Crear 9 botones adicionales cuadrados en la barra lateral con colores de fondo
        for (int i = 2; i <= 10; i++) {
            JButton boton = new JButton("Botón " + i);
            boton.setPreferredSize(new Dimension(100, 100)); // Tamaño cuadrado
            boton.setBorder(BorderFactory.createEmptyBorder());
            boton.setContentAreaFilled(true);

            // Asignar un color de fondo diferente a cada botón
            switch (i) {
                case 2:
                    boton.setBackground(Color.GREEN);
                    break;
                case 3:
                    boton.setBackground(Color.BLUE);
                    break;
                case 4:
                    boton.setBackground(Color.YELLOW);
                    break;
                case 5:
                    boton.setBackground(Color.ORANGE);
                    break;
                case 6:
                    boton.setBackground(Color.CYAN);
                    break;
                case 7:
                    boton.setBackground(Color.PINK);
                    break;
                case 8:
                    boton.setBackground(Color.MAGENTA);
                    break;
                case 9:
                    boton.setBackground(Color.LIGHT_GRAY);
                    break;
                case 10:
                    boton.setBackground(Color.DARK_GRAY);
                    break;
            }

            barraLateral.add(boton);

            final int botonIndex = i;
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    seleccionarBoton(boton);
                }
            });
        }

        // Panel derecho para mostrar contenido
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new BorderLayout());
        add(panelDerecho, BorderLayout.CENTER);

        // Inicializar la tabla de pacientes
        tableModel = new DefaultTableModel();
        pacientesTable = new JTable(tableModel);
        tableModel.addColumn("Nombre");
        tableModel.addColumn("DNI");
        tableModel.addColumn("Última Consulta");

        // Formulario predeterminado
        mostrarTextoInteractivo("Selecciona un botón para ver el contenido.");

        // Crear botón para añadir pacientes
        JButton agregarPacienteButton = new JButton("Agregar Paciente");
        agregarPacienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPaciente();
            }
        });

        panelDerecho.add(new JScrollPane(pacientesTable), BorderLayout.CENTER);
        panelDerecho.add(agregarPacienteButton, BorderLayout.SOUTH);
    }

    private void mostrarTextoInteractivo(String texto) {
        panelDerecho.removeAll();
        JTextArea textArea = new JTextArea(texto);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setCaretPosition(0);
        textArea.setEditable(false);
        panelDerecho.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panelDerecho.revalidate();
        panelDerecho.repaint();
    }

    private void seleccionarBoton(JButton boton) {
        if (botonSeleccionado != null) {
            // Deseleccionar el botón previamente seleccionado
            botonSeleccionado.setBorder(BorderFactory.createEmptyBorder());
        }
        botonSeleccionado = boton;
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Resaltar el botón seleccionado
        if (boton.getText().equals("Botón 1")) {
            mostrarPacientesDesdeDB();
        } else {
            mostrarTextoInteractivo("Has presionado " + boton.getText());
        }
    }

    private void deseleccionarBoton() {
        if (botonSeleccionado != null) {
            botonSeleccionado.setBorder(BorderFactory.createEmptyBorder());
            botonSeleccionado = null;
            mostrarTextoInteractivo("Botón deseleccionado.");
        }
    }

    private void mostrarPacientesDesdeDB() {
        // Simulación de datos de pacientes (reemplaza esto con el acceso a tu base de datos)
        Object[][] data = {
            {"Paciente 1", "DNI 1", "Consulta 1"},
            {"Paciente 2", "DNI 2", "Consulta 2"},
            {"Paciente 3", "DNI 3", "Consulta 3"},
            // Agrega más filas de pacientes aquí
        };

        tableModel.setDataVector(data, new Object[]{"Nombre", "DNI", "Última Consulta"});

        panelDerecho.removeAll();
        panelDerecho.add(new JScrollPane(pacientesTable), BorderLayout.CENTER);
        panelDerecho.revalidate();
        panelDerecho.repaint();
    }

    private void agregarPaciente() {
        // Aquí deberías escribir el código para agregar un nuevo paciente a la base de datos
        // y luego actualizar la tabla de pacientes para reflejar el nuevo paciente.

        // Después de agregar el paciente, puedes volver a mostrar la tabla actualizada.
        mostrarPacientesDesdeDB();
    }
}
