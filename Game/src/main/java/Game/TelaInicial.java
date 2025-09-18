package Game; 

import javax.swing.*; 
import java.awt.*;    

public class TelaInicial extends JFrame { 

    public TelaInicial() {   // Método construtor
        
        // Configurações para a inicialização do JFrame (TelaInicial)
        setTitle("Tela Inicial");                                       // Define o titulo do JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 // Faz o programa ser finalizado ao fechar o JFrame
        setSize(1280, 720);                                             // Define a dimensão do JFrame ao ser executado
        setLocationRelativeTo(null);                                    // Define a localização que o JFrame será iniciado no centro da tela
        setResizable(true);                                             // Define que a tela pode ser redimensionada

        
        ImageIcon telaDeFundo0 = new ImageIcon(getClass().getResource("/imagens/Telainicial76.jpg"));   // Armazena a imagem em um objeto usando a classe ImageIcon so Swing   
        Image telaDeFundo1 = telaDeFundo0.getImage();                                                   // Trasporta a imagem salva em telaDeFundo para  para telaDeFundo1 que usa a classe Image da biblioteca AWT.

        // Painel com imagem de fundo
        JPanel painel = new JPanel(new BorderLayout()) {
            @Override                                                             // Define que houve uma forma de polimorfismo
            protected void paintComponent(Graphics g) {                           // Criando um método que permite que eu mexa com a tela de fundo do JPanel e Referência o objeto "Graphics g" ao método
                super.paintComponent(g);                                          // Garante que o JPanel estará limpo de qualquer lixo gráfico.
                g.drawImage(telaDeFundo1, 0, 0, getWidth(), getHeight(), this);   // Usa o metódo "g.drawImage" para definir o comportamento da nossa imagem no JPanel
            }
        };

        // Painel para os botões
        JPanel painelBotoes = new JPanel();                                     // Cria um novo painel com o nome de painelBotoes
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 500));     // Define o painel como um FlowLayout no centro com um distanciamento de 50 e um alinhamento vertical de 500
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
            dispose();      // Feja a TelaInicial
        });

        // Ação do btnSair
        btnSair.addActionListener(e -> {
            System.exit(0); // Fecha o JFrame
        });

        
        add(painel); // Adiciona o painel ao JFrame da TelaInicial

        setVisible(true); // Torna o JFrame visível
    }

}