package Game;

import javax.swing.*;
import java.awt.*;

public class TelaGame extends JFrame {
    
    private JTextArea descricao;        // JTextArea é salvo com uma variável
    private String nomeJogador = "";    // Define a String como uma variável vazia (nomeJogador = "(Sem valor)")
    private JPanel painelOpcoes;        // JPanel definido com uma  variável
    
    public TelaGame(){
        
        // Cria e configura a inicialização do JFrame
        
        setTitle("Tela do Jogo");                               // Coloca Título
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // Finaliza o programa ao clicar no "X"
        setSize(1200,800);                                      // Define o tamanho da tela ao iniciar o programa        
        setLocationRelativeTo(null);                            // Inicia o JFrame centralizado no munitor
        setResizable(true);                                     // Permite que eu redimencione a minha tela
        setLayout(new BorderLayout());                          // Defini o JFrame com um BorderLayout
        
        
        JPanel painelSuperior = new JPanel(new GridLayout(1, 2)); // Cria um painel
        
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/imagens/Telainicial76.jpg"));
        Image backgroundImage = backgroundIcon.getImage();        
        
        JPanel painelEsquerdo = new JPanel() {  //Cria mais um painel
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };      
        
        painelOpcoes = new JPanel();
        painelOpcoes.setBorder(BorderFactory.createTitledBorder("Opções"));
        painelOpcoes.add(new JButton("ACEITAR"));
        painelOpcoes.add(new JButton("RECUSAR"));
            
        painelSuperior.add(painelEsquerdo);
        painelSuperior.add(painelOpcoes);
        
        JPanel painelInferior = new JPanel();
        painelInferior.setBorder(BorderFactory.createTitledBorder("Descrição"));
        painelInferior.setLayout(new BorderLayout());
        
        descricao = new JTextArea();
        descricao.setEditable(false);   // Nao permite o usuário alterar o conteúdo
        painelInferior.add(new JScrollPane(descricao), BorderLayout.CENTER);    // Adiciona  um JScrollPane ao painel infeiror para melhor observação do texto
        
        
        nomeJogador = JOptionPane.showInputDialog(this, "Digite o nome do seu personagem:");   // Cria uma painel interativo onde o jogador poderá por o nome de seu personagem
        if (nomeJogador == null || nomeJogador.trim().isEmpty()){                               // Caso o valor seja "null", será colocado o nome "Aventureiro ao persongem" 
            nomeJogador = "Aventureiro";                                                         
        }
        
        descricao.setText("Você é " + nomeJogador + ", um jovem aventureiro que chega à Torre Sombria, onde o mago corrompido guarda um artefato poderoso. Na entrada, um senhor "
                + "lhe oferece informações sobre a história da Torre Sombria. \n Você aceita receber a informação ou deseja prosseguir sem ela? "); // Define o texto no JTextArea
        
        // Cria um SplitPane para dividir a tela
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, painelSuperior, painelInferior);
        splitPane.setResizeWeight(0.7); // 70% espaço para o painel superior, 30% para o inferior
        splitPane.setDividerSize(5);   // tamanho da linha divisória
        splitPane.setOneTouchExpandable(true); // permite expandir/recolher
        
        add(splitPane, BorderLayout.CENTER);
        
        // Primeira decisão
        atualizarOpcoes(
            new String[]{"ACEITAR", "RECUSAR"},
            new Runnable[]{
                () -> {
                    // Jogador aceitou
                    descricao.setText("  ==Você aceitou a missão e ele dá uma breve explicação sobre os acontecimentos da Torre e sobre o Artefato==  "
                            + " \n \n Á uma lenda antiga que vem sendo passada de geração   a geração, de um artefato cujo poder que pode causar a ERA DA "
                            + "ESCURIDÃO, mas segundo a lenda o 10º portador do artefato terá poder suficiente para \n"
                            + " destruir o artefato gerando a paz no mundo ou usar ele para destrui-lo colocando o mundo em uma eterna de escuridão. \n \n"
                            + "O viajante fala que já tentou adentrar a Torre, mas nela há uma presença maligna, cuja aura negra amedronta os viajantes, mas o "
                            + "senhor lhe oferece ajuda para enfrentar a escuridão da Torre.");
                    atualizarOpcoes(
                        new String[]{"ACEITAR AJUDA", "RECUSAR AJUDA"},
                        new Runnable[]{
                            () -> {
                                descricao.setText("O senhor te ensina magia básica para que você possa enfrentar os perigos da Torre. \n \n \n "
                                        + " == Primeiro Desafio: O Esqueleto ==  \n \n "
                                        + " Ao entrar na Torre um esqueleto se levanta, pega uma espada afiada que estava escondida e corre em sua direção. Você o atinge com a magia que o senhor havia te ensinado anteriormente, derrotando o esqueleto. \n \n"
                                        + " == Segundo Desafio: As Portas =="
                                        + " ");
                                atualizarOpcoes(
                                    new String[]{"PORTA DIREITA", "PORTA ESQUERDA"},
                                    new Runnable[]{
                                     () -> descricao.setText(""),
                                     () -> descricao.setText("")
                                    }
                                );
                            },
                            () -> descricao.setText("Você perde a oportunidade de aprender magia básica e vai para a Torre sozinho.")
                        }
                    );
                },
                () -> {
                    // Jogador recusou
                    descricao.setText("Você recusou a missão e voltou para casa.");
                    atualizarOpcoes(
                        new String[]{"Dormir", "Refletir"},
                        new Runnable[]{
                            () -> descricao.setText("Você dormiu e sonhou com a aventura perdida."),
                            () -> descricao.setText("Você refletiu e se arrependeu da recusa...")
                        }
                    );
                }
            }
        );

        
        
        setVisible(true);     
        
    }   
    
    private void atualizarOpcoes(String[] textosBotoes, Runnable[] acoes) { // Criando um Método.
        painelOpcoes.removeAll();                                           // Remove o contéudo do painelOpcoes
        
        for(int i = 0; i < textosBotoes.length; i++){       // Cria um laço for 
            JButton botao = new JButton(textosBotoes[i]);
            Runnable acao = acoes[i];
            botao.addActionListener(e -> acao.run());
            painelOpcoes.add(botao);
        } 
          
        painelOpcoes.revalidate();
        painelOpcoes.repaint();
        
    }
    
}