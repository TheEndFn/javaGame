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
        
        
        JPanel painelEsquerdo = new JPanel();                                           //Cria mais um painel
        painelEsquerdo.setBorder(BorderFactory.createTitledBorder("História"));         
        painelEsquerdo.add(new JLabel("Imagem Aqui!"));
        
        painelOpcoes = new JPanel();
        painelOpcoes.setBorder(BorderFactory.createTitledBorder("Opções"));
        painelOpcoes.add(new JButton("Aceitar"));
        painelOpcoes.add(new JButton("Recusar"));
            
        painelSuperior.add(painelEsquerdo);
        painelSuperior.add(painelOpcoes);
        
        JPanel painelInferior = new JPanel();
        painelInferior.setBorder(BorderFactory.createTitledBorder("Descrição"));
        painelInferior.setLayout(new BorderLayout());
        
        descricao = new JTextArea();
        descricao.setEditable(false);   // Nao permite o usuário alterar o conteúdo
        painelInferior.add(new JScrollPane(descricao), BorderLayout.CENTER);    // Adiciona  um JScrollPane ao painel infeiror para melhor observação do texto
        
        
        nomeJogador = JOptionPane.showInputDialog(this, "Digite o nome do seu personagem:");    // Cria uma painel interativo onde o jogador poderá por o nome de seu personagem
        if (nomeJogador == null || nomeJogador.trim().isEmpty());                               // Caso o valor seja "null", será colocado o nome "Aventureiro ao persongem" 
            nomeJogador = "Aventureiro";                                                         
        
        descricao.setText("Você é " + nomeJogador + ", um jovem aventureiro que chega à Torre Sombria, onde o mago corrompido guarda um artefato poderoso. Na entrada, um senhor "
                + "lhe oferece informações sobre a história da Torre Sombria. \n Você aceita receber a informação ou deseja prosseguir sem ela? "); // Define o texto no JTextArea
        
        add(painelSuperior, BorderLayout.NORTH);
        add(painelInferior, BorderLayout.CENTER);
        
        
        // Primeira decisão
        atualizarOpcoes(
            new String[]{"Aceitar", "Recusar"},
            new Runnable[]{
                () -> {
                    // Jogador aceitou
                    descricao.setText("Você aceitou a missão! Agora deve escolher como viajar até a torre.");
                    atualizarOpcoes(
                        new String[]{"Ir pela floresta", "Ir pela estrada"},
                        new Runnable[]{
                            () -> descricao.setText("Você entrou na floresta escura..."),
                            () -> descricao.setText("Você segue pela estrada iluminada...")
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
