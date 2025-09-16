O projeto de um jogo de aventura em texto está estruturado em três arquivos Java principais, cada um com uma função distinta:

GameMain.java: A classe principal que inicia a aplicação.
TelaInicial.java: Cria a janela de entrada do jogo com os botões "Iniciar" e "Sair" e uma imagem de fundo.
TelaGame.java: A janela principal do jogo, onde a história é narrada e as opções de escolha são apresentadas.
Explicação Detalhada de Cada Arquivo
1. GameMain.java

Este é o ponto de entrada do programa. Ele contém o método main, que é o primeiro a ser executado.

package Game;: Declara que a classe pertence ao pacote Game.
import javax.swing.SwingUtilities;: Importa a classe SwingUtilities, usada para garantir que a interface gráfica (GUI) seja criada na Event Dispatch Thread (EDT). Essa é uma prática recomendada para evitar problemas de concorrência e melhorar a performance no Swing.
SwingUtilities.invokeLater(() -> new TelaInicial());: Este comando agenda a criação e a exibição da TelaInicial para ser executada na EDT. Isso garante que a janela inicial do jogo seja exibida de forma segura e correta.
2. TelaInicial.java

Esta classe é responsável por criar a primeira tela que o jogador vê.

public class TelaInicial extends JFrame: Declara a classe TelaInicial como uma extensão de JFrame, o que significa que ela é uma janela.
Configurações da Janela: Define o título ("Tela Inicial"), o tamanho (1200x800), a operação de fechamento (JFrame.EXIT_ON_CLOSE) e a posição (centralizada na tela).
Imagem de Fundo: Carrega uma imagem (Telainicial76.jpg) do diretório src/main/resources/imagens/ e a desenha como fundo do painel principal usando o método paintComponent.
Botões: Cria um painel (painelBotoes) para organizar os botões "Iniciar" e "Sair" e os adiciona à janela.
Ações dos Botões:
Botão "Iniciar": Quando clicado, cria uma nova instância de TelaGame (abrindo a próxima tela) e fecha a TelaInicial (dispose()).
Botão "Sair": Quando clicado, encerra o programa (System.exit(0)).
3. TelaGame.java

Esta classe é a principal tela do jogo, onde a história interativa acontece.

public class TelaGame extends JFrame: Assim como a TelaInicial, esta classe também é uma janela.
Componentes da Interface:
JTextArea descricao: Uma área de texto não editável para exibir a narrativa do jogo.
JPanel painelOpcoes: Um painel para conter os botões de opção que o jogador pode clicar.
String nomeJogador: Uma variável para armazenar o nome que o jogador digita.
Lógica do Jogo:
Um JOptionPane.showInputDialog é usado para pedir ao jogador que digite o nome do personagem. Se o nome for deixado em branco, o valor padrão é "Aventureiro".
O texto inicial da história é definido no JTextArea.
O método atualizarOpcoes é crucial: ele limpa o painel de opções e cria novos botões com base nas escolhas disponíveis.
O código usa lambdas (->) e objetos Runnable para definir as ações de cada botão. Por exemplo, o primeiro conjunto de botões ("Aceitar" e "Recusar") tem ações que, quando ativadas, mudam o texto da história e chamam o atualizarOpcoes novamente com novas escolhas ("Ir pela floresta", "Ir pela estrada", etc.).

