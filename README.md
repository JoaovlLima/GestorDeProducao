Sistema de Gestão de Produção Industrial
     O sistema visa gerenciar e monitorar o processo de produção em uma linha de montagem industrial, proporcionando controle completo sobre o fluxo de materiais, eficiência produtiva e alocação de recursos. Ele ajudará a garantir que todas as etapas do processo produtivo sejam seguidas corretamente, com um foco em maximizar o uso eficiente de máquinas e operadores, além de gerar relatórios de desempenho.

<br><br><br>

<p align="center"> <img src="/src/logo.png" alt="logo" width=250px> </p> <p align="center"> <img src="https://img.shields.io/badge/API-PRODUZINDO-red?style=for-the-badge" alt="backend" /> <img src="https://img.shields.io/badge/Documentação-FEITA-blue?style=for-the-badge" alt="documentação" /> <img src="https://img.shields.io/badge/Protótipos-FEITO-blue?style=for-the-badge" alt="mobile" /> <img src="https://img.shields.io/badge/Frontend-PRODUZINDO-red?style=for-the-badge" alt="site" /> </p> <hr> <br><br><br><br> <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Gestão+de+Produção+Industrial" alt="Typing SVG" />

Apresentação do Projeto: Sistema de Gestão de Produção Industrial
Visão Geral do Projeto
Objetivo: O sistema permitirá o controle completo da produção em uma linha de montagem, desde o cadastro de máquinas, operadores e produtos, até o monitoramento em tempo real de cada etapa do processo produtivo. Usaremos tecnologias modernas como Java, MongoDB e integrações com sensores industriais, visando uma solução robusta, escalável e eficiente.

Por que este Projeto? Este sistema foi idealizado para otimizar a eficiência operacional em indústrias de manufatura e transformação. Ele oferece visibilidade detalhada de todo o processo produtivo, permitindo ajustes em tempo real para evitar gargalos e melhorar a produtividade. O foco é fornecer uma solução que atenda desde pequenas indústrias até grandes corporações, garantindo uma operação produtiva eficiente e transparente.

<br><br><br><br><br> <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=100

Escopo do Sistema
1. Cadastro de Máquinas, Operadores e Produtos:

Máquinas: O sistema permitirá o cadastro de cada máquina ou equipamento utilizado no processo produtivo. Para cada máquina, serão armazenadas informações como:

Tipo de máquina.
Capacidade de produção.
Estado atual (ativa, em manutenção, ociosa).
Histórico de uso e manutenções.
Operadores: Cadastro de operadores que trabalham na linha de produção, com informações sobre:

Turnos.
Habilidades (quais máquinas o operador pode manusear).
Histórico de produtividade.
Produtos: Cadastro de produtos ou componentes que serão fabricados, com os seguintes dados:

Nome do produto.
Especificações técnicas.
Quantidade de materiais necessários.
Tempo estimado de produção por unidade.
2. Controle de Fluxo de Produção e Etapas do Processo Produtivo:

Etapas do Processo: Cada produto terá um fluxo de produção definido por etapas. O sistema permitirá a definição dessas etapas, associando máquinas e operadores específicos a cada uma.

Exemplo de Etapas: Corte, montagem, pintura, embalagem.

Monitoramento: O sistema acompanhará o andamento do processo de produção em cada etapa, registrando:

Tempo gasto.
Status das máquinas e operadores (em operação, ocioso, em manutenção).
3. Geração de Relatórios de Eficiência, Uso de Máquinas e Paradas de Produção:

Relatório de Eficiência Produtiva: O sistema gerará relatórios para medir o desempenho das linhas de produção, incluindo:

Quantidade de produtos fabricados.
Taxa de aproveitamento dos materiais e desperdício.
Relatório de Uso de Máquinas: Detalhes sobre o uso das máquinas, como:

Horas de operação.
Tempo ocioso ou de manutenção.
Eficiência de produção por máquina.
Relatório de Paradas de Produção: Inclui:

Duração e causa das paradas.
Ações corretivas.
Relatórios Personalizados: O sistema permitirá a geração de relatórios por período, por produto, linha de produção ou operador.

4. Interface Gráfica para Gerenciar a Linha de Produção e Alocar Operadores:

Painel de Controle: A interface gráfica oferecerá um painel onde o gestor da produção poderá visualizar o status atual de todas as linhas de produção em tempo real, incluindo:

Status de máquinas e operadores.
Visualização das etapas de produção.
Alocação de Operadores: A interface permitirá a alocação manual ou automática de operadores para diferentes máquinas ou etapas do processo, com base em suas habilidades e disponibilidade.

Visualização do Fluxo de Produção: Será possível acompanhar o progresso do produto desde a primeira etapa até a finalização, facilitando a detecção de gargalos.

Objetivos SMART
Específicos:

Criar o sistema de cadastro de máquinas, operadores e produtos até a segunda semana.
Implementar o monitoramento das etapas de produção até a quarta semana.
Desenvolver relatórios personalizados de produção até a sexta semana.
Mensuráveis:

Gerar relatórios de eficiência com precisão mínima de 90%.
Obter a produção de 100 produtos diários com 95% de máquinas em operação.
Relevantes:

Garantir que o sistema seja escalável e possa ser integrado com sensores IoT no futuro.
Facilitar a utilização da plataforma para gestores e operadores de chão de fábrica.


<br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Análises de Risco" alt="Typing SVG" /></a>

## Análise de Riscos

### 1. Riscos Técnicos

| **Risco**                                          | **Impacto** | **Probabilidade**  | **Mitigação**                                                              |
| ---------------------------------------------------| ----------- | ------------------ | -------------------------------------------------------------------------- |
| **Desempenho do MongoDB com grandes volumes**       | Alto        | Média              | Otimização de queries e testes de estresse.                                |
| **Incompatibilidade entre versões de bibliotecas**  | Médio       | Baixa              | Gerenciamento de dependências com Maven/Gradle.                            |
| **Integração futura com IoT**                       | Alto        | Média              | Arquitetura modular e uso de APIs padrão.                                  |
| **Falta de experiência com MongoDB**                | Médio       | Média              | Treinamento da equipe em NoSQL e boas práticas.                            |

### 2. Riscos de Gerenciamento

| **Risco**                                          | **Impacto** | **Probabilidade**  | **Mitigação**                                                              |
| ---------------------------------------------------| ----------- | ------------------ | -------------------------------------------------------------------------- |
| **Atrasos no cronograma**                          | Alto        | Alta               | Monitoramento regular e priorização de funcionalidades.                    |
| **Falta de comunicação clara na equipe**           | Médio       | Média              | Reuniões diárias e uso de ferramentas de gestão.                           |
| **Mudanças nos requisitos**                        | Alto        | Alta               | Controle formal de mudanças e atualização do cronograma.                   |

### 3. Riscos Operacionais

| **Risco**                                          | **Impacto** | **Probabilidade**  | **Mitigação**                                                              |
| ---------------------------------------------------| ----------- | ------------------ | -------------------------------------------------------------------------- |
| **Interrupções na produção durante a implantação**  | Alto        | Média              | Implantação em fases e treinamento antecipado.                             |
| **Resistência ao novo sistema**                    | Médio       | Alta               | Treinamentos e suporte contínuo aos operadores.                            |
| **Erros operacionais devido à complexidade da UI**  | Médio       | Média              | Desenvolvimento focado em usabilidade e testes de UX.                      |

### 4. Riscos de Segurança

| **Risco**                                          | **Impacto** | **Probabilidade**  | **Mitigação**                                                              |
| ---------------------------------------------------| ----------- | ------------------ | -------------------------------------------------------------------------- |
| **Falhas de segurança nos dados de produção**       | Alto        | Média              | Criptografia, controle de acesso e auditorias.                             |
| **Perda de dados no MongoDB**                      | Alto        | Baixa              | Backups regulares e plano de recuperação de desastres.                     |
| **Ataques cibernéticos**                           | Alto        | Baixa              | Autenticação forte, criptografia e testes de segurança.                    |

### 5. Riscos Financeiros

| **Risco**                                          | **Impacto** | **Probabilidade**  | **Mitigação**                                                              |
| ---------------------------------------------------| ----------- | ------------------ | -------------------------------------------------------------------------- |
| **Aumento de custos de desenvolvimento**           | Médio       | Alta               | Gestão rigorosa de escopo e orçamento.                                     |
| **Investimento em tecnologias sem valor imediato**  | Médio       | Média              | Foco em funcionalidades críticas e análise de retorno.                     |

### 6. Riscos Legais

| **Risco**                                          | **Impacto** | **Probabilidade**  | **Mitigação**                                                              |
| ---------------------------------------------------| ----------- | ------------------ | -------------------------------------------------------------------------- |
| **Não conformidade com regulamentos**              | Alto        | Baixa              | Revisão periódica de conformidade com normas (LGPD).                       |
| **Penalidades por falhas de compliance**           | Alto        | Baixa              | Auditorias de conformidade e correções rápidas.                            |

<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Recursos" alt="Typing SVG"/></a>


**Tecnologias:**
- **Java** (Front / back)
- **MongoDB** (Banco de Dados)
- **Git/GitHub** (Controle de Versão)

**Ferramentas de Gestão:**
- Slack para comunicação interna
- Figma para design de interfaces
- Mermaid para montagem dos diagramas

<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Diagrama de Classe" alt="Typing SVG" /></a>

```mermaid
classDiagram
    class Adm{
        +int id
        +string nome
        +string senha
    }
    class Operador {
    +int Re
    +string nome
    +enum turno
    +string senha
    +List<Maquina> maquinasOperadas  // Máquinas que ele já operou
    +double produtividadeMedia  // Produtividade média do operador
    +get()
    +post()
    +put()
    +delete()
}

    class Maquina {
    +int id
    +int linha
    +string tipo
    +double capacidadePorMin
    +enum estado 
    +int idProduto
    +string historicoManutencao 
    +get()
    +post()
    +put()
    +delete()
}

    class Produto {
        +int id
        +string nome
        +double tempoProduzirKg
        +int quantidadeMaterias
        +get()
        +post()
        +put()
        +delete()
    }

    class Producao {
    +int id
    +int idMaquina 
    +double quantidadeProd
    +double tempoProd
    +int ReOperador
    +date data
    +enum status   // Adiciona status de produção
    +double eficiencia  // Calcula a eficiência da produção
    +get()
    +post()
}

    class Manutencao {
    +int id
    +int idMaquina
    +string descricaoProblema
    +string acaoCorretiva
    +date dataManutencao
    +int idOperadorResponsavel
    +get()
    +post()
    +put()
}
    class Turno {
    +int id
    +enum periodo
    +int ReOperador
    +int idMaquina
    +date inicioTurno
    +date fimTurno
    +get()
    +post()
}

    Operador "1" -- "0..*" Producao : "cria"
    Adm "1" -- "0..*" Operador : "cria"
    Adm "1" -- "0..*" Maquina : "cria"
    Adm "1" -- "0..*" Produto : "cria"
    Producao "1" -- "0..*" Operador : "possui"
    Producao "1" -- "0..*" Maquina : "possui"
    Maquina "1" -- "0..*" Produto : "possui"
```
<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Diagrama de Uso" alt="Typing SVG" /></a>
```mermaid
flowchart TD
    L[Tela de Login] -->|Fazer Login| A(Acessar Sistema de Produção)
    
    %% Verificação de tipo de usuário (Admin ou Operador Comum)
    A -->|Verificar Permissão| P{Usuário é Admin?}
    
    %% Permissões exclusivas do Admin
    P -->|Sim| B(Cadastro de Máquinas)
    P -->|Sim| C(Cadastro de Operadores)
    P -->|Sim| D(Cadastro de Produtos)
    
    B -->|Adicionar Detalhes| B1(Tipo, Capacidade, Estado, Histórico de Manutenção)
    C -->|Adicionar Informações| C1(Turno, Habilidades, Histórico de Produtividade)
    D -->|Especificar Produto| D1(Nome, Especificações, Materiais, Tempo de Produção)
    
    %% Funções acessíveis a todos os usuários
    P -->|Não| E(Etapas do Processo)
    E -->|Associar Máquinas e Operadores| E1(Definir Corte, Montagem, Pintura, Embalagem)
    
    A -->|Monitorar Processo Produtivo| F(Monitoramento em Tempo Real)
    F -->|Registrar Tempo| F1(Tempo Gasto em Cada Etapa)
    F -->|Visualizar Status| F2(Status de Máquinas e Operadores)
    
    A -->|Gerar Relatórios| G(Geração de Relatórios)
    G -->|Relatório de Eficiência| G1(Eficiência Produtiva, Aproveitamento, Desperdício)
    G -->|Relatório de Uso de Máquinas| G2(Horas de Operação, Tempo Ocioso, Eficiência)
    G -->|Relatório de Paradas| G3(Causas, Duração, Ações Tomadas)
    
    A -->|Gerenciar Linha de Produção| H(Interface Gráfica)
    H -->|Visualizar Status| H1(Status das Máquinas e Operadores)
    H -->|Alocar Operadores| H2(Alocação Manual ou Automática)
    H -->|Ajustar Alocação| H3(Ajuste em Tempo Real)
    H -->|Visualizar Fluxo de Produção| H4(Visualização Gráfica do Fluxo de Produção)


````
<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Diagrama de Fluxo" alt="Typing SVG" /></a>
````mermaid
flowchart TD
    A[Tela de Login] -->|Fazer Login| B{Usuário Autenticado?}
    B -- Sim --> C[Acessar Sistema de Produção]
    B -- Não --> D[Mostrar Mensagem de Erro]
    
    C --> E{Escolher Ação}
    E -->|Cadastrar Máquina| F[Cadastrar Máquinas]
    E -->|Cadastrar Operador| G[Cadastrar Operadores]
    E -->|Cadastrar Produto| H[Cadastrar Produtos]
    E -->|Definir Etapas| I[Definir Etapas do Processo]
    E -->|Monitorar Produção| J[Monitorar Processo Produtivo]
    E -->|Gerar Relatórios| K[Gerar Relatórios]
    E -->|Gerenciar Linha de Produção| L[Gerenciar Linha de Produção]

    F --> M[Adicionar Detalhes da Máquina]
    G --> N[Adicionar Informações do Operador]
    H --> O[Especificar Produto]
    I --> P[Associar Máquinas e Operadores]
    
    J --> Q[Registrar Tempo em Cada Etapa]
    J --> R[Visualizar Status de Máquinas e Operadores]
    
    K --> S{Selecionar Tipo de Relatório}
    S -->|Eficiência Produtiva| T[Gerar Relatório de Eficiência]
    S -->|Uso de Máquinas| U[Gerar Relatório de Uso]
    S -->|Paradas| V[Gerar Relatório de Paradas]
    
    L --> W[Visualizar Status das Linhas de Produção]
    L --> X[Alocar Operadores]
    L --> Y[Ajustar Alocação em Tempo Real]
    L --> Z[Visualizar Fluxo de Produção]

````
<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Identidade Visual" alt="Typing SVG" /></a>

<p align="left">



* ### Modelagem de Diagramas:
    - [Mermaid](https://mermaid.live/edit#pako:eNpVjs1qw0AMhF9F6NRC_AI-FBq7zSXQQnPz5iBs2bvE-8NaSwi2373r-NLqJM18M2jG1neMJfajv7eaosClVg7yvDeVjmYSS9MViuJtObGA9Y4fCxxfTh4m7UMwbnjd-eMGQTWfN4xBtHG3dbeqZ_7L8QJ1c6YgPlz_Ope7X-CjMd861_93dOSc-mx6KnsqWopQUXwieEDL0ZLp8vvzpigUzZYVlnntuKc0ikLl1oxSEv_zcC2WEhMfMPo0aMyd45SvFDoSrg0NkeyOrL_WfFuF)

* ### IA's Usadas:
    - [ChatGPT 3.5](https://chat.openai.com/)
    - [Bing - Image Creator](https://www.bing.com/images/create)
 
* ### UX/UI:
  - [Figma](https://www.figma.com/)
  
* ### Outros:
  - [YouTube](https://www.youtube.com/)
  - [Documentação](https://github.com/shyoutarou/README-Model/blob/master/README.md)
  - [Badges](https://dev.to/)
<br><br><br><br><br>
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Desenvolvedores do Projeto" alt="Typing SVG" /></a>

<div align=center>
  <table style="width: 100%">
    <tbody>
      <tr align=center>
        <th><strong> João Victor de Lima </br> JoaovlLima </strong></th>
      </tr>
      <tr align=center>
        <td>
          <a href="https://github.com/JoaovlLima">
            <img width="250" height="250" style="border-radius: 50%;" src="https://avatars.githubusercontent.com/JoaovlLima">
          </a>
        </td>
      </tr>
    </tbody>

  </table>
</div>
