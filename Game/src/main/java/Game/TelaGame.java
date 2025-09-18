package Game;

import javax.swing.*;
import java.awt.*;

public class TelaGame extends JFrame {
    
    private JTextArea descricao;        // JTextArea é salvo com uma variável
    private String nomeJogador = "";    // Define a String como uma variável vazia (nomeJogador = "(Sem valor)")
    private JPanel painelOpcoes;        // JPanel definido com uma  variável
    
    public TelaGame(){
        
        setTitle("Tela do Jogo");                               
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
        setSize(1280, 720);                                      
        setLocationRelativeTo(null);                            
        setResizable(true);                                     
        setLayout(new BorderLayout());                          
        
        
        JPanel painelSuperior = new JPanel(new GridLayout(1, 2)); // Cria um JPanel com um GridLayout de duas partes "(1,2)"
        
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
        painelOpcoes.setBorder(BorderFactory.createTitledBorder("Opções")); // Cria e define um nome para a borda do meu JPanel
        painelOpcoes.add(new JButton("ACEITAR"));                           // Cria um botão dentro do JPanel
        painelOpcoes.add(new JButton("IGNORAR"));                           // ...
            
        painelSuperior.add(painelEsquerdo);
        painelSuperior.add(painelOpcoes);
        
        JPanel painelInferior = new JPanel();
        painelInferior.setBorder(BorderFactory.createTitledBorder("Descrição"));
        painelInferior.setLayout(new BorderLayout());
        
        descricao = new JTextArea();                                            // Cria um JTextArea
        descricao.setEditable(false);                                           // Não permite o usuário alterar o conteúdo
        painelInferior.add(new JScrollPane(descricao), BorderLayout.CENTER);    // Adiciona  um JScrollPane ao painel infeiror para melhor observação do texto
        
        
        nomeJogador = JOptionPane.showInputDialog(this, "Digite o nome do seu personagem:");   // Cria uma painel interativo onde o jogador poderá por o nome de seu personagem
        if (nomeJogador == null || nomeJogador.trim().isEmpty()){                               // Caso o valor seja "null", será colocado o nome "Dragos" 
            nomeJogador = "Dragos";                                                         
        }
        
        descricao.setText("   == Inicio da Aventura ==  \n \n"
            + "  Você é " + nomeJogador + ", um jovem aventureiro que chega à Torre Sombria onde o mago corrompido guarda um artefato poderoso. Na entrada da Torre, um viajante te oferece informações sobre a Torre Sombria. \n \n"
            + "  Agora é com você. Você aceita as informações ou ignora o viajante ? "); // Define o texto no JTextArea
        
        // Cria um SplitPane para dividir a tela
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, painelSuperior, painelInferior);
        splitPane.setResizeWeight(0.7); // 70% espaço para o painel superior, 30% para o inferior
        splitPane.setDividerSize(5);   // tamanho da linha divisória
        splitPane.setOneTouchExpandable(true); // permite expandir/recolher
        
        add(splitPane, BorderLayout.CENTER);
        
        // Lista de atividade e de possiblididades do jogo. Usamos o método "atualizarOpcoes" para poder fazer essas decisões funcionar. Ele cria novos botões, novas ações para os botões e atualiza o texto do JTextArea.         
        atualizarOpcoes(
            new String[]{"ACEITAR", "IGNORAR"},
            new Runnable[]{
                () -> {
                    // Jogador aceitou
                    descricao.setText("  O Viajante começa a dizer que naquela região existe uma lenda antiga que vem sendo passada de geração em geração. Ela fala que na Torre há um artefato cujo poder pode levar o mundo a uma Nova Era. Segundo a lenda, \n"
                            + "o 10º portador do artefato terá poder suficiente para promover a paz no mundo. Ele também diz que esse artefato, segundo a lenda, está na Torre. \n\n"
                            + "  O viajante fala que já tentou entrar na Torre, mas lá existe uma presença maligna cuja aura negra amedronta as pessoas que passam ali. O Viajante vê em seu olhar a vontade de se aventurar na Torre e oferece ajuda para que \n"
                            + "você possa enfrentar a escuridão da Torre. \n\n"
                            + "  Mais uma vez é a sua vez. Você aceita a ajuda do Viajante ou recusa a proposta dele ?");
                    atualizarOpcoes(
                        new String[]{"ACEITAR AJUDA", "RECUSAR AJUDA"},
                        new Runnable[]{
                            () -> {
                                descricao.setText("  Sem demorar, o Viajante passa um tempo te ensinando magia básica para que você possa enfrentar os perigos da Torre.\n\n"
                                    + "  Depois de ter aprendido a manipular corretamente a magia básica, você se dirige em direção da porta principal da Torre. As portas são pesadas e você faz um esforço até conseguir abri-las um pouco.\n\n\n"
                                    + "   == Primeiro Desafio: O Esqueleto ==  \n\n "
                                    + "  Você entra na Torre e caminha alguns metros até entrar em uma sala escura. Derrepente as porta se fecham e um esqueleto se levanta empunhando uma espada afiada. Ele corre em sua direção fazendo um barulho\n"
                                    + "apavorante, mas você o destroi com a magia que havia acabado de aprender.\n"
                                    + "  As portas que haviam se fechado, novamente se abrem e você continua andando até chegar em uma bifurcação. Ali você encontra duas portas, uma a direita e outra a esquerda.\n\n\n"
                                    + "   == Segundo Desafio: As Portas == \n\n"
                                    + "  A porta da direita é sombria, possui um cheiro ruim e você vê fumaça saindo pelas frestas das portas.\n\n"
                                    + "  A porta da esquerda possui um silencio ensurdecedor e símbolos estranhos.\n\n\n"
                                    + "  Agora você tem que decidir por qual porta você vai seguir em frente. Direita ou esquerda ?\n\n");
                                atualizarOpcoes(
                                    new String[]{"PORTA DIREITA", "PORTA ESQUERDA"},
                                    new Runnable[]{
                                        () -> {
                                            descricao.setText("  Você entra e essa sala é bem maior do que a que você derrotou o esqueleto, mas como anteriormente, as portas se fecham e você fica preso. Você passa alguns minutos tentando sair, até que a sala começa a fazer alguns\n"
                                                    + "sons esquisitos e de uma das paredes surge um golem de pedra enorme que te ataca com muita furia. Você enfrenta o Golem com muita dificuldade, mas consegue derrotá-lo usando a magia. \n\n"
                                                    + "  Dessa vez as portas não se abrem e você usa a magia para empurrar a porta até que consiga passar.\n\n"
                                                    + "  Ao passar pela porta você seque por uma corredor e vê uma escada que leva ao topo da torre. \n\n\n"
                                                    + "   == Terceiro Desafio: O Mago das Sombras ==  \n\n"
                                                    + "  Ao chegar no topo da Torre o Mago da Sombras aparece e uma luta feroz de feitiços começa acontecer. Essa luta supera todas as outras que você já teve, mas com os duelos anteriores você aperfeiçoou sua habilidades e\n"
                                                    + "consegue com muita dificuldade derrotar o Mago por um descuido dele. \n\n\n "
                                                    + "   == Final: O Artefato == \n\n"
                                                    + "  Depois da luta você está com o artefato em suas mãos e precisa fazer uma escolha. \n\n\n"
                                                    + "  1º Escolha: Usar o poder do artefato para promover a paz no mundo, gerando uma Nova Era.\n\n"
                                                    + "  2º Escolha: Destruir o artefato.\n\n\n"
                                                    + "  Agora é a sua ultima decisão. Qual é a sua escolha? Usar ou destuir? \n\n");
                                            atualizarOpcoes(
                                                new String[]{"USAR", "DESTRUIR"},
                                                new Runnable[]{
                                                    () -> {
                                                        descricao.setText("  Confiando no que o Viajante te disse, você usa o artefato e logo sente uma tontura e fraqueza que te faz solta o artefato. De dentro do artefato sai uma fumaça escura e densa que se transforma no viajante por um estante e você\n"
                                                            + "nunca mais é visto. \n\n"
                                                            + "   == Alguns anos depois == \n\n"
                                                            + "  Um jovem Aventureiro passa pela Torre Sombria e demonstra curiosidade. Enquanto ele olha para a Torre, um viajante aparece e explica que essa Torre é especial e pergunta se ele sabe sobre a Lenda da Torre que é passada\n"
                                                            + "de geração em geração naquela região. O jovem olha para a Torre e um espirio aventureiro e de coragem preenche seu coração, enquanto os olhos do viajante brilham com um vermelho sombrio... \n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    },
                                                    () -> {
                                                        descricao.setText("  Após tudo o que viu e o que passou, você percebe que aquele poder não tem nada de bom e decide destruir o artefato. Ao destruir o artefato uma grande explosão é ouvida na torre e ela começa a cair. Você consegue sobreviver\n"
                                                            + "por sorte e ao se levantar você observa que uma fumaça escura e espesa com a forma do viajante se forma entre os escombros da Torre, mas logo em seguida se deforma e some. \n\n"
                                                            + "Nunca mais houve guerras e coisas ruins naquela regiao, pois o artefato maligno que era o causador delas havia sido destruido. \n\n"
                                                            + nomeJogador + ", continua sua aventura pelo mundo e inspira outros aventureiros a enfrentar aquilo que é sombrio, pois tudo é possível para alguém com uma alma pura.\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    }
                                                }
                                            );
                                        },    
                                            
                                        () -> {
                                            descricao.setText("  Você entra e essa sala é cheia de objetos mágicos. Ao tocar em um livro que estava na sala, suas magia se tornam muito mais fortes e você consegue manipular a sua magia com mais facilidade, além de aprender algus\n"
                                                + "feitiços com os livros que estavam ali. \n\n"
                                                + "  Ao terminar tudo que podia fazer ali, você observa que existe uma porta e vai em direção a ela. Ao passar pela porta você seque por uma corredor e vê uma escada que leva ao topo da torre. \n\n\n"
                                                + "   == Terceiro Desafio: O Mago das Sombras ==  \n\n"
                                                + "  Ao chegar no topo da Torre o Mago da Sombras aparece e uma luta feroz de feitiços começa acontecer. Essa luta supera todas as outras que você já teve, mas com o aprimoramento da sala de feitiços você consegue derrotar\n"
                                                + "o Mago das Sombras, com um acerto certeiro em seu peito e em sua cabeça. \n\n\n "
                                                + "   == Final: O Artefato == \n\n"
                                                + "  Depois da luta você está com o artefato em suas mãos e precisa fazer uma escolha. \n\n\n"
                                                + "  1º Escolha: Usar o poder do artefato para promover a paz no mundo, gerando uma Nova Era.\n\n"
                                                + "  2º Escolha: Destruir o artefato.\n\n\n"
                                                + "  Agora é a sua ultima decisão. Qual é a sua escolha? Usar ou destuir? \n\n");
                                            atualizarOpcoes(
                                                new String[]{"USAR", "DESTRUIR"},
                                                new Runnable[]{
                                                    () -> {
                                                        descricao.setText("  Confiando no que o Viajante te disse, você usa o artefato e logo sente uma tontura e fraqueza que te faz solta o artefato. De dentro do artefato sai uma fumaça escura e densa que se transforma no viajante por um estante e você\n"
                                                            + "nunca mais é visto. \n\n"
                                                            + "   == Alguns anos depois == \n\n"
                                                            + "  Um jovem Aventureiro passa pela Torre Sombria e demonstra curiosidade. Enquanto ele olha para a Torre, um viajante aparece e explica que essa Torre é especial e pergunta se ele sabe sobre a Lenda da Torre que é passada\n"
                                                            + "de geração em geração naquela região. O jovem olha para a Torre e um espirio aventureiro e de coragem preenche seu coração, enquanto os olhos do viajante brilham com um vermelho sombrio... \n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    },
                                                    () -> {
                                                        descricao.setText("  Após tudo o que viu e o que passou, você percebe que aquele poder não tem nada de bom e decide destruir o artefato. Ao destruir o artefato uma grande explosão é ouvida na torre e ela começa a cair. Você consegue sobreviver\n"
                                                            + "por sorte e ao se levantar você observa que uma fumaça escura e espesa com a forma do viajante se forma entre os escombros da Torre, mas logo em seguida se deforma e some. \n\n"
                                                            + "Nunca mais houve guerras e coisas ruins naquela regiao, pois o artefato maligno que era o causador delas havia sido destruido. \n\n"
                                                            + nomeJogador + ", continua sua aventura pelo mundo e inspira outros aventureiros a enfrentar aquilo que é sombrio, pois tudo é possível para alguém com uma alma pura.\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    }
                                                }
                                            );
                                        }
                                    }
                                );
                            },
                            () -> {
                                descricao.setText(" O Viajante te avisa novamente sobre os perigos que estão na Torre, mas não te oferece ajuda novamente. \n\n"
                                    + "  O viajante se retira e você vai em direção as portas da Torre. Ao tentar abri-las, você percebe que elas estão trancadas e você não consegue entra. Até que você enxerga um buraco ao lado da torre e entra por ali.\n\n"
                                    + "   == Primeiro Desafio: O Esqueleto ==  \n\n "
                                    + "  Você entra na Torre e caminha alguns metros até entrar em uma sala escura. Derrepente as porta desta sala se fecham e um esqueleto se levanta empunhando uma espada afiada. Ele corre em sua direção fazendo um\n"
                                    + "barulho apavorante. Você entra em despero e tenta correr do esqueleto, mas ele é muito rápido. Você entende que terá que lutar e vê uma espada ao lado da porta. Logo após ter pego a espada, um grande duelo começa e\n"
                                    + "você é ferido levemente no rosto, mas consegue derrotar o esqueleto. \n\n"
                                    + "  As portas que haviam se fechado, novamente se abrem e você continua andando até chegar em uma bifurcação. Ali você encontra duas portas, uma a direita e outra a esquerda.\n\n\n"
                                    + "   == Segundo Desafio: As Portas == \n\n"
                                    + "  A porta da direita é sombria, possui um cheiro ruim e você vê fumaça saindo pelas frestas das portas.\n\n"
                                    + "  A porta da esquerda possui um silencio ensurdecedor e símbolos estranhos.\n\n\n"
                                    + "  Agora você tem que decidir por qual porta você vai seguir em frente. Direita ou esquerda ?\n\n");
                                atualizarOpcoes(
                                    new String[]{"PORTA DIREITA", "PORTA ESQUERDA"},
                                    new Runnable[]{
                                        () -> {
                                            descricao.setText("  Você entra e essa sala é bem maior do que a que você derrotou o esqueleto, mas como anteriormente, as portas se fecham e você fica preso. Você passa alguns minutos tentando sair, até que a sala começa a fazer alguns\n"
                                                + "sons esquisitos e de uma das paredes surge um golem de pedra enorme que te ataca com muita furia. Você enfrenta o Golem, mas ele é muito mais forte que você. Nesse instante, você foge pela abertura que\n"
                                                + "o golem deixou na parede, correndo por alguns corredores até conseguir despistar o golem.\n\n"
                                                + "  Você caminha e parece que está voltando para o lugar onde o Golem estava, mas esse corredor te leva às escadas que vão ao topo da Torre. \n\n"
                                                + "   == Terceiro Desafio: O Mago das Sombras ==  \n\n"
                                                + "  Ao chegar no topo da Torre o Mago da Sombras aparece e te ataca com toda a força que ele tem. Essa luta supera todas as outras que você já teve, mas por um descuido dele e por sua sagacidade, você consegue tirar o\n"
                                                + "artefato dele. Sem você fazer nada, o artefato solta uma magia que atravessa o coração do mago, matando ele em segundos.\n"
                                                + "\n\n "
                                                + "   == Final: O Artefato == \n\n"
                                                + "  Depois da luta você está com o artefato em suas mãos e precisa fazer uma escolha. \n\n\n"
                                                + "  1º Escolha: Usar o poder do artefato para promover a paz no mundo, gerando uma Nova Era.\n\n"
                                                + "  2º Escolha: Destruir o artefato.\n\n\n"
                                                + "  Agora é a sua ultima decisão. Qual é a sua escolha? Usar ou destuir? \n\n");
                                            atualizarOpcoes(
                                                new String[]{"USAR", "DESTRUIR"},
                                                new Runnable[]{
                                                    () -> {
                                                        descricao.setText("  Confiando no que o Viajante te disse, você usa o artefato e logo sente uma tontura e fraqueza que te faz solta o artefato. De dentro do artefato sai uma fumaça escura e densa que se transforma no viajante por um estante\n"
                                                            + "e você nunca mais é visto. \n\n"
                                                            + "   == Alguns anos depois == \n\n"
                                                            + "  Um jovem Aventureiro passa pela Torre Sombria e demonstra curiosidade. Enquanto ele olha para a Torre, um viajante aparece e explica que essa Torre é especial e pergunta se ele sabe sobre a Lenda da Torre que é passada\n"
                                                            + "de geração em geração naquela região. O jovem olha para a Torre e um espirio aventureiro e de coragem preenche seu coração, enquanto os olhos do viajante brilham com um vermelho sombrio... \n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    },
                                                    () -> {
                                                        descricao.setText("  Após tudo o que viu e o que passou, você percebe que aquele poder não tem nada de bom e decide destruir o artefato. Ao destruir o artefato uma grande explosão é ouvida na torre e ela começa a cair. Você consegue sobreviver\n"
                                                            + "por sorte e ao se levantar você observa que uma fumaça escura e espesa com a forma do viajante se forma entre os escombros da Torre, mas logo em seguida se deforma e some. \n\n"
                                                            + "Nunca mais houve guerras e coisas ruins naquela regiao, pois o artefato maligno que era o causador delas havia sido destruido. \n\n\n"
                                                            + nomeJogador + ", continua sua aventura pelo mundo e inspira outros aventureiros a enfrentar aquilo que é sombrio, pois tudo é possível para alguém com uma alma pura.\n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    }
                                                }
                                            );
                                        },    
                                            
                                        () -> {
                                            descricao.setText("  Você entra e essa sala é cheia de objetos mágicos. Você começa a olhar alguns livros que estão ali e encontra um pergaminhi antigo. Esse pergaminho ensina como alguém que não possui magia pode aprender habilidades\n"
                                                + "de furtividade. Mais do que depresa, você começa a estudar e aprende com maestria aquela arte.\n\n"
                                                + "  Ao terminar tudo que podia fazer ali, você observa que existe uma porta e vai em direção a ela. Ao passar pela porta você seque por uma corredor e vê uma escada que leva ao topo da torre. \n\n\n"
                                                + "   == Terceiro Desafio: O Mago das Sombras ==  \n\n"
                                                + "  Ao chegar no topo da Torre o Mago da Sombras aparece e te ataca com toda a força que ele tem. Essa luta supera todas as outras que você já teve, mas por um descuido dele e por sua sagacidade, você consegue tirar o\n"
                                                + "artefato dele. Sem você fazer nada, o artefato solta uma magia que atravessa o coração do mago, matando ele em segundos.\n\n"
                                                + "   == Final: O Artefato == \n\n"
                                                + "  Depois da luta você está com o artefato em suas mãos e precisa fazer uma escolha. \n\n\n"
                                                + "  1º Escolha: Usar o poder do artefato para promover a paz no mundo, gerando uma Nova Era.\n\n"
                                                + "  2º Escolha: Destruir o artefato.\n\n\n"
                                                + "  Agora é a sua ultima decisão. Qual é a sua escolha? Usar ou destuir? \n\n");
                                            atualizarOpcoes(
                                                new String[]{"USAR", "DESTRUIR"},
                                                new Runnable[]{
                                                    () -> {
                                                        descricao.setText("  Confiando no que o Viajante te disse, você usa o artefato e logo sente uma tontura e fraqueza que te faz solta o artefato. De dentro do artefato sai uma fumaça escura e densa que se transforma no viajante por um\n"
                                                            + "estante e você nunca mais é visto. \n\n"
                                                            + "   == Alguns anos depois == \n\n"
                                                            + "  Um jovem Aventureiro passa pela Torre Sombria e demonstra curiosidade. Enquanto ele olha para a Torre, um viajante aparece e explica que essa Torre é especial e pergunta se ele sabe sobre a Lenda da Torre que é passada\n"
                                                            + "de geração em geração naquela região. O jovem olha para a Torre e um espirio aventureiro e de coragem preenche seu coração, enquanto os olhos do viajante brilham com um vermelho sombrio... \n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    },
                                                    () -> {
                                                        descricao.setText("  Após tudo o que viu e o que passou, você percebe que aquele poder não tem nada de bom e decide destruir o artefato. Ao destruir o artefato uma grande explosão é ouvida na torre e ela começa a cair. Você consegue sobreviver\n"
                                                            + "por sorte e ao se levantar você observa que uma fumaça escura e espesa com a forma do viajante se forma entre os escombros da Torre, mas logo em seguida se deforma e some.\n\n"
                                                            + "Nunca mais houve guerras e coisas ruins naquela regiao, pois o artefato maligno que era o causador delas havia sido destruido. \n\n\n"
                                                            + nomeJogador + ", continua sua aventura pelo mundo e inspira outros aventureiros a enfrentar aquilo que é sombrio, pois tudo é possível para alguém com uma alma pura.\n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    }
                                                }
                                            );
                                        }
                                    }
                                );
                            }
                        }
                    );
                },
                () -> {
                    // Jogador recusou
                    descricao.setText("  O Viajante apenas te conta que essa Torre é especial e pode dar grandes poderes para quem conseguir pegar o artefado do mago que está na Torre. Ele tambem fala que já tentou entrar na Torre, mas lá existe uma presença\n"
                            + "maligna cuja aura negra amedronta as pessoas que passam ali. O Viajante vê em seu olhar a vontade de se aventurar na Torre e oferece ajuda para que você possa enfrentar a escuridão da Torre. \n\n"
                            + "  Mais uma vez é a sua vez. Você aceita a ajuda do Viajante ou recusa a proposta dele ?");
                    atualizarOpcoes(
                        new String[]{"ACEITAR AJUDA", "RECUSAR AJUDA"},
                        new Runnable[]{
                            () -> {
                                descricao.setText("  Sem demorar, o Viajante passa um tempo te ensinando magia básica para que você possa enfrentar os perigos da Torre.\n\n"
                                    + "  Depois de ter aprendido a manipular corretamente a magia básica, você se dirige em direção da porta principal da Torre. As portas são pesadas e você faz um esforço até conseguir abri-las um pouco.\n\n\n"
                                    + "   == Primeiro Desafio: O Esqueleto ==  \n\n "
                                    + "  Você entra na Torre e caminha alguns metros até entrar em uma sala escura. Derrepente as porta se fecham e um esqueleto se levanta empunhando uma espada afiada. Ele corre em sua direção fazendo um barulho\n"
                                    + "apavorante, mas você o destroi com a magia que havia acabado de aprender.\n"
                                    + "  As portas que haviam se fechado, novamente se abrem e você continua andando até chegar em uma bifurcação. Ali você encontra duas portas, uma a direita e outra a esquerda.\n\n\n"
                                    + "   == Segundo Desafio: As Portas == \n\n"
                                    + "  A porta da direita é sombria, possui um cheiro ruim e você vê fumaça saindo pelas frestas das portas.\n\n"
                                    + "  A porta da esquerda possui um silencio ensurdecedor e símbolos estranhos.\n\n\n"
                                    + "  Agora você tem que decidir por qual porta você vai seguir em frente. Direita ou esquerda ?\n\n");
                                atualizarOpcoes(
                                    new String[]{"PORTA DIREITA", "PORTA ESQUERDA"},
                                    new Runnable[]{
                                        () -> {
                                            descricao.setText("  Você entra e essa sala é bem maior do que a que você derrotou o esqueleto, mas como anteriormente, as portas se fecham e você fica preso. Você passa alguns minutos tentando sair, até que a sala começa a fazer alguns\n"
                                                    + "sons esquisitos e de uma das paredes surge um golem de pedra enorme que te ataca com muita furia. Você enfrenta o Golem com muita dificuldade, mas consegue derrotá-lo usando a magia. \n\n"
                                                    + "  Dessa vez as portas não se abrem e você usa a magia para empurrar a porta até que consiga passar.\n\n"
                                                    + "  Ao passar pela porta você seque por uma corredor e vê uma escada que leva ao topo da torre. \n\n\n"
                                                    + "   == Terceiro Desafio: O Mago das Sombras ==  \n\n"
                                                    + "  Ao chegar no topo da Torre o Mago da Sombras aparece e uma luta feroz de feitiços começa acontecer. Essa luta supera todas as outras que você já teve, mas com os duelos anteriores você aperfeiçoou sua habilidades e\n"
                                                    + "consegue com muita dificuldade derrotar o Mago por um descuido dele. \n\n\n "
                                                    + "   == Final: O Artefato == \n\n"
                                                    + "  Depois da luta você está com o artefato em suas mãos e precisa fazer uma escolha. \n\n\n"
                                                    + "  1º Escolha: Usar o poder do artefato para promover a paz no mundo, gerando uma Nova Era.\n\n"
                                                    + "  2º Escolha: Destruir o artefato.\n\n\n"
                                                    + "  Agora é a sua ultima decisão. Qual é a sua escolha? Usar ou destuir? \n\n");
                                            atualizarOpcoes(
                                                new String[]{"USAR", "DESTRUIR"},
                                                new Runnable[]{
                                                    () -> {
                                                        descricao.setText("  Confiando no que o Viajante te disse, você usa o artefato e logo sente uma tontura e fraqueza que te faz solta o artefato. De dentro do artefato sai uma fumaça escura e densa que se transforma no viajante por um estante e você\n"
                                                            + "nunca mais é visto. \n\n"
                                                            + "   == Alguns anos depois == \n\n"
                                                            + "  Um jovem Aventureiro passa pela Torre Sombria e demonstra curiosidade. Enquanto ele olha para a Torre, um viajante aparece e explica que essa Torre é especial e pergunta se ele sabe sobre a Lenda da Torre que é passada\n"
                                                            + "de geração em geração naquela região. O jovem olha para a Torre e um espirio aventureiro e de coragem preenche seu coração, enquanto os olhos do viajante brilham com um vermelho sombrio... \n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    },
                                                    () -> {
                                                        descricao.setText("  Após tudo o que viu e o que passou, você percebe que aquele poder não tem nada de bom e decide destruir o artefato. Ao destruir o artefato uma grande explosão é ouvida na torre e ela começa a cair. Você consegue sobreviver\n"
                                                            + "por sorte e ao se levantar você observa que uma fumaça escura e espesa com a forma do viajante se forma entre os escombros da Torre, mas logo em seguida se deforma e some. \n\n"
                                                            + "Nunca mais houve guerras e coisas ruins naquela regiao, pois o artefato maligno que era o causador delas havia sido destruido. \n\n\n"
                                                            + nomeJogador + ", continua sua aventura pelo mundo e inspira outros aventureiros a enfrentar aquilo que é sombrio, pois tudo é possível para alguém com uma alma pura.\n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    }
                                                }
                                            );
                                        },    
                                            
                                        () -> {
                                            descricao.setText("  Você entra e essa sala é cheia de objetos mágicos. Ao tocar em um livro que estava na sala, suas magia se tornam muito mais fortes e você consegue manipular a sua magia com mais facilidade, além de aprender algus\n"
                                                + "feitiços com os livros que estavam ali. \n\n"
                                                + "  Ao terminar tudo que podia fazer ali, você observa que existe uma porta e vai em direção a ela. Ao passar pela porta você seque por uma corredor e vê uma escada que leva ao topo da torre. \n\n\n"
                                                + "   == Terceiro Desafio: O Mago das Sombras ==  \n\n"
                                                + "  Ao chegar no topo da Torre o Mago da Sombras aparece e uma luta feroz de feitiços começa acontecer. Essa luta supera todas as outras que você já teve, mas com o aprimoramento da sala de feitiços você consegue derrotar\n"
                                                + "o Mago das Sombras, com um acerto certeiro em seu peito e em sua cabeça. \n\n\n "
                                                + "   == Final: O Artefato == \n\n"
                                                + "  Depois da luta você está com o artefato em suas mãos e precisa fazer uma escolha. \n\n\n"
                                                + "  1º Escolha: Usar o poder do artefato para promover a paz no mundo, gerando uma Nova Era.\n\n"
                                                + "  2º Escolha: Destruir o artefato.\n\n\n"
                                                + "  Agora é a sua ultima decisão. Qual é a sua escolha? Usar ou destuir? \n\n");
                                            atualizarOpcoes(
                                                new String[]{"USAR", "DESTRUIR"},
                                                new Runnable[]{
                                                    () -> {
                                                        descricao.setText("  Confiando no que o Viajante te disse, você usa o artefato e logo sente uma tontura e fraqueza que te faz solta o artefato. De dentro do artefato sai uma fumaça escura e densa que se transforma no viajante por um estante e você\n"
                                                            + "nunca mais é visto. \n\n"
                                                            + "   == Alguns anos depois == \n\n"
                                                            + "  Um jovem Aventureiro passa pela Torre Sombria e demonstra curiosidade. Enquanto ele olha para a Torre, um viajante aparece e explica que essa Torre é especial e pergunta se ele sabe sobre a Lenda da Torre que é passada\n"
                                                            + "de geração em geração naquela região. O jovem olha para a Torre e um espirio aventureiro e de coragem preenche seu coração, enquanto os olhos do viajante brilham com um vermelho sombrio... \n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    },
                                                    () -> {
                                                        descricao.setText("  Após tudo o que viu e o que passou, você percebe que aquele poder não tem nada de bom e decide destruir o artefato. Ao destruir o artefato uma grande explosão é ouvida na torre e ela começa a cair. Você consegue sobreviver\n"
                                                            + "por sorte e ao se levantar você observa que uma fumaça escura e espesa com a forma do viajante se forma entre os escombros da Torre, mas logo em seguida se deforma e some. \n\n"
                                                            + "Nunca mais houve guerras e coisas ruins naquela regiao, pois o artefato maligno que era o causador delas havia sido destruido. \n\n\n"
                                                            + nomeJogador + ", continua sua aventura pelo mundo e inspira outros aventureiros a enfrentar aquilo que é sombrio, pois tudo é possível para alguém com uma alma pura.\n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    }
                                                }
                                            );
                                        }
                                    }
                                );
                            },
                            () -> {
                                descricao.setText(" O Viajante te avisa novamente sobre os perigos que estão na Torre, mas não te oferece ajuda novamente. \n\n"
                                    + "  O viajante se retira e você vai em direção as portas da Torre. Ao tentar abri-las, você percebe que elas estão trancadas e você não consegue entra. Até que você enxerga um buraco ao lado da torre e entra por ali.\n\n\n"
                                    + "   == Primeiro Desafio: O Esqueleto ==  \n\n "
                                    + "  Você entra na Torre e caminha alguns metros até entrar em uma sala escura. Derrepente as porta desta sala se fecham e um esqueleto se levanta empunhando uma espada afiada. Ele corre em sua direção fazendo um\n"
                                    + "barulho apavorante. Você entra em despero e tenta correr do esqueleto, mas ele é muito rápido. Você entende que terá que lutar e vê uma espada ao lado da porta. Logo após ter pego a espada, um grande duelo começa\n"
                                    + "e você é ferido levemente no rosto, mas consegue derrotar o esqueleto. \n\n"
                                    + "  As portas que haviam se fechado, novamente se abrem e você continua andando até chegar em uma bifurcação. Ali você encontra duas portas, uma a direita e outra a esquerda.\n\n\n"
                                    + "   == Segundo Desafio: As Portas == \n\n"
                                    + "  A porta da direita é sombria, possui um cheiro ruim e você vê fumaça saindo pelas frestas das portas.\n\n"
                                    + "  A porta da esquerda possui um silencio ensurdecedor e símbolos estranhos.\n\n\n"
                                    + "  Agora você tem que decidir por qual porta você vai seguir em frente. Direita ou esquerda ?\n\n");
                                atualizarOpcoes(
                                    new String[]{"PORTA DIREITA", "PORTA ESQUERDA"},
                                    new Runnable[]{
                                        () -> {
                                            descricao.setText("  Você entra e essa sala é bem maior do que a que você derrotou o esqueleto, mas como anteriormente, as portas se fecham e você fica preso. Você passa alguns minutos tentando sair, até que a sala começa a fazer alguns\n"
                                                + "sons esquisitos e de uma das paredes surge um golem de pedra enorme que te ataca com muita furia. Você enfrenta o Golem, mas ele é muito mais forte que você. Nesse instante, você foge pela abertura que o\n"
                                                + "golem deixou na parede, correndo por alguns corredores até conseguir despistar o golem.\n\n"
                                                + "  Você caminha e parece que está voltando para o lugar onde o Golem estava, mas esse corredor te leva às escadas que vão ao topo da Torre. \n\n"
                                                + "   == Terceiro Desafio: O Mago das Sombras ==  \n\n"
                                                + "  Ao chegar no topo da Torre o Mago da Sombras aparece e te ataca com toda a força que ele tem. Essa luta supera todas as outras que você já teve, mas por um descuido dele e por sua sagacidade, você consegue tirar o\n"
                                                + "artefato dele. Sem você fazer nada, o artefato solta uma magia que atravessa o coração do mago, matando ele em segundos.\n"
                                                + "\n\n "
                                                + "   == Final: O Artefato == \n\n"
                                                + "  Depois da luta você está com o artefato em suas mãos e precisa fazer uma escolha. \n\n\n"
                                                + "  1º Escolha: Usar o poder do artefato para promover a paz no mundo, gerando uma Nova Era.\n\n"
                                                + "  2º Escolha: Destruir o artefato.\n\n\n"
                                                + "  Agora é a sua ultima decisão. Qual é a sua escolha? Usar ou destuir? \n\n");
                                            atualizarOpcoes(
                                                new String[]{"USAR", "DESTRUIR"},
                                                new Runnable[]{
                                                    () -> {
                                                        descricao.setText("  Confiando no que o Viajante te disse, você usa o artefato e logo sente uma tontura e fraqueza que te faz solta o artefato. De dentro do artefato sai uma fumaça escura e densa que se transforma no viajante por um estante e você\n"
                                                            + "nunca mais é visto. \n\n"
                                                            + "   == Alguns anos depois == \n\n"
                                                            + "  Um jovem Aventureiro passa pela Torre Sombria e demonstra curiosidade. Enquanto ele olha para a Torre, um viajante aparece e explica que essa Torre é especial e pergunta se ele sabe sobre a Lenda da Torre que é passada\n"
                                                            + "de geração em geração naquela região. O jovem olha para a Torre e um espirio aventureiro e de coragem preenche seu coração, enquanto os olhos do viajante brilham com um vermelho sombrio... \n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    },
                                                    () -> {
                                                        descricao.setText("  Após tudo o que viu e o que passou, você percebe que aquele poder não tem nada de bom e decide destruir o artefato. Ao destruir o artefato uma grande explosão é ouvida na torre e ela começa a cair. Você consegue sobreviver\n"
                                                            + "por sorte e ao se levantar você observa que uma fumaça escura e espesa com a forma do viajante se forma entre os escombros da Torre, mas logo em seguida se deforma e some. \n\n"
                                                            + "Nunca mais houve guerras e coisas ruins naquela regiao, pois o artefato maligno que era o causador delas havia sido destruido. \n\n\n"
                                                            + nomeJogador + ", continua sua aventura pelo mundo e inspira outros aventureiros a enfrentar aquilo que é sombrio, pois tudo é possível para alguém com uma alma pura.\n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    }
                                                }
                                            );
                                        },    
                                            
                                        () -> {
                                            descricao.setText("  Você entra e essa sala é cheia de objetos mágicos. Você começa a olhar alguns livros que estão ali e encontra um pergaminhi antigo. Esse pergaminho ensina como alguém que não possui magia pode aprender habilidades\n"
                                                + "de furtividade. Mais do que depresa, você começa a estudar e aprende com maestria aquela arte.\n\n"
                                                + "  Ao terminar tudo que podia fazer ali, você observa que existe uma porta e vai em direção a ela. Ao passar pela porta você seque por uma corredor e vê uma escada que leva ao topo da torre. \n\n\n"
                                                + "   == Terceiro Desafio: O Mago das Sombras ==  \n\n"
                                                + "  Ao chegar no topo da Torre o Mago da Sombras aparece e te ataca com toda a força que ele tem. Essa luta supera todas as outras que você já teve, mas por um descuido dele e por sua sagacidade, você consegue tirar o\n"
                                                + "artefato dele. Sem você fazer nada, o artefato solta uma magia que atravessa o coração do mago, matando ele em segundos.\n\n"
                                                + "   == Final: O Artefato == \n\n"
                                                + "  Depois da luta você está com o artefato em suas mãos e precisa fazer uma escolha. \n\n\n"
                                                + "  1º Escolha: Usar o poder do artefato para promover a paz no mundo, gerando uma Nova Era.\n\n"
                                                + "  2º Escolha: Destruir o artefato.\n\n\n"
                                                + "  Agora é a sua ultima decisão. Qual é a sua escolha? Usar ou destuir? \n\n");
                                            atualizarOpcoes(
                                                new String[]{"USAR", "DESTRUIR"},
                                                new Runnable[]{
                                                    () -> {
                                                        descricao.setText("  Você lembra do que o viajante te disse e você usa o artefato para ter poder, mas logo sente uma tontura e fraqueza que te faz solta o artefato. De dentro do artefato sai uma fumaça escura e densa que se transforma no viajante\n"
                                                            + "por um estante e você nunca mais é visto. \n\n"
                                                            + "   == Alguns anos depois == \n\n"
                                                            + "  Um jovem Aventureiro passa pela Torre Sombria e demonstra curiosidade. Enquanto ele olha para a Torre, um viajante aparece e explica que essa Torre é especial e pergunta se ele sabe sobre a Lenda da Torre \n"
                                                            + "que é passada de geração em geração naquela região. O jovem olha para a Torre e um espirio aventureiro e de coragem preenche seu coração, enquanto os olhos do viajante brilham com um vermelho sombrio... \n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    },
                                                    () -> {
                                                        descricao.setText("  Após tudo o que viu e o que passou, você percebe que aquele poder não tem nada de bom e decide destruir o artefato. Ao destruir o artefato uma grande explosão é ouvida na torre e ela começa a cair. Você consegue sobreviver\n"
                                                            + "por sorte e ao se levantar você observa que uma fumaça escura e espesa com a forma do viajante se forma entre os escombros da Torre, mas logo em seguida se deforma e some. \n\n"
                                                            + "Nunca mais houve guerras e coisas ruins naquela regiao, pois o artefato maligno que era o causador delas havia sido destruido. \n\n\n"
                                                            + nomeJogador + ", continua sua aventura pelo mundo e inspira outros aventureiros a enfrentar aquilo que é sombrio, pois tudo é possível para alguém com uma alma pura.\n\n\n\n\n"
                                                            + "     == FIM DE JOGO ==");
                                                        atualizarOpcoes(
                                                            new String[]{"MENU", "SAIR"},
                                                            new Runnable [] {
                                                                () -> {new TelaInicial(); dispose();},
                                                                () -> {System.exit(0);}
                                                            }
                                                        );
                                                    }
                                                }
                                            );
                                        }
                                    }
                                );
                            }
                        }
                    );
                }
            }
        );

        
        
        setVisible(true);     
        
    }   
    
    private void atualizarOpcoes(String[] textosBotoes, Runnable[] acoes) { // Criando um Método.
        painelOpcoes.removeAll();                                           // Remove o contéudo do painelOpcoes
        
        for(int i = 0; i < textosBotoes.length; i++){                       // Cria um laço for que conta a quantidade de itens da array textosBotoes
            JButton btn = new JButton(textosBotoes[i]);                     // Cria a quantidade de botões de acordo com a quantidade de itens na array textoBotoes
            Runnable acao = acoes[i];                                       // Adiciona à lista Runnable a quantidade de ações que terão.  
            btn.addActionListener(e -> acao.run());                         // Define a ação que o botão terá"
            painelOpcoes.add(btn);                                          
        } 
          
        painelOpcoes.revalidate(); // Entende que o Painel foi atualizado e reorgania o layout do painel.
        painelOpcoes.repaint();    // Redesenha o painel de acordo com os comandos.
        
    }
    
}