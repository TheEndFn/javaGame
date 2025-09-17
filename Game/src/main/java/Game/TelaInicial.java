package Game; 

import javax.swing.*; // Importando os metodos do javax.Swing
import java.awt.*;    // importando os medotos do java.awt

public class TelaInicial extends JFrame { 

    public TelaInicial() {
        // Configurações para a inicialização da janela
        setTitle("Tela Inicial");                       // Define o titulo do JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a forma de fechamento do Programa
        setSize(1200, 720);                             // Define a dimensão do JFrame ao ser executado
        setLocationRelativeTo(null);                    // Define a localização que o JFrame será iniciado no centro da tela
        setResizable(true);                             // Define que a tela pode ser redimensionada

        
        // Carregar imagem de fundo (a partir de src/imagens/)
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/imagens/Telainicial76.jpg"));
        Image backgroundImage = backgroundIcon.getImage();

        // Painel com imagem de fundo
        JPanel painel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Painel para os botões
        JPanel painelBotoes = new JPanel();                                     // Cria um novo painel com o nome de painelBotoes
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 500));     // Define o painel como um FlowLayout no centro com um distanciamento de 50px e um alinhamento vertical de 500px
        painelBotoes.setOpaque(false);                                          // Faz o painel ser transparênte

        // Criando os Botões
        JButton btnIniciar = new JButton("Iniciar"); 
        JButton btnSair = new JButton("Sair");
        
        // Adiciona os botões ao painelBotoes
        painelBotoes.add(btnIniciar); 
        painelBotoes.add(btnSair);
        
        //Adiciona o painelBotoes ao primeiro painel criado
        painel.add(painelBotoes, BorderLayout.CENTER);

        // Ação do btnIniciar
        btnIniciar.addActionListener(e -> {
            new TelaGame(); // Inica o JFrame da TelaGame
            dispose();      // Feja o JFrame da TelaInicial
        });

        // Ação do btnSair
        btnSair.addActionListener(e -> {
            System.exit(0); // Fecha o JFrame
        });

        
        add(painel); // Adiciona o painel ao JFrame da TelaInicial

        setVisible(true); // Torna o JFrame visível
    }

}