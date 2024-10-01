Sistema de Gestão de Produção Industrial
     O sistema visa gerenciar e monitorar o processo de produção em uma linha de montagem industrial, proporcionando controle completo sobre o fluxo de materiais, eficiência produtiva e alocação de recursos. Ele ajudará a garantir que todas as etapas do processo produtivo sejam seguidas corretamente, com um foco em maximizar o uso eficiente de máquinas e operadores, além de gerar relatórios de desempenho.

<br><br><br>

<p align="center"> <img src="/src/logo/logo.png" alt="logo" width=250px> </p> <p align="center"> <img src="https://img.shields.io/badge/API-PRODUZINDO-red?style=for-the-badge" alt="backend" /> <img src="https://img.shields.io/badge/Documentação-FEITA-blue?style=for-the-badge" alt="documentação" /> <img src="https://img.shields.io/badge/Protótipos-FEITO-blue?style=for-the-badge" alt="mobile" /> <img src="https://img.shields.io/badge/Frontend-PRODUZINDO-red?style=for-the-badge" alt="site" /> </p> <hr> <br><br><br><br> <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Gestão+de+Produção+Industrial" alt="Typing SVG" />

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

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Cronograma" alt="Typing SVG" /></a>

```mermaid
gantt
    title Cronograma do Projeto de Enquete
    dateFormat  YYYY-MM-DD

    section Semana 1-2: Definição dos Requisitos e Configuração do Ambiente
    Reunião inicial          :a1, 2024-09-10, 3d
    Configuração do ambiente :a2, 2024-09-13, 4d
    Definição das entidades  :a3, 2024-09-17, 3d
    Criação de wireframes    :a4, 2024-09-20, 4d

    section Semana 3-4: Desenvolvimento do Backend e API
    Desenvolvimento da API   :b1, 2024-09-25, 4d
    Rotas CRUD para enquetes :b2, 2024-09-29, 5d
    Testes iniciais do backend :b3, 2024-10-04, 5d

    section Semana 5-6: Desenvolvimento do Frontend
    Criação do frontend      :c1, 2024-10-09, 4d
    Integração com a API     :c2, 2024-10-13, 4d
    Implementação da autenticação :c3, 2024-10-17, 6d

    section Semana 7-8: Testes e Ajustes Finais
    Testes de integração     :d1, 2024-10-23, 4d
    Funcionalidades adicionais :d2, 2024-10-27, 4d
    Testes de desempenho e segurança :d3, 2024-10-31, 6d

    section Semana 9: Finalização e Entrega
    Revisão final e documentação :e1, 2024-11-06, 2d
    Apresentação e entrega    :e2, 2024-11-08, 2d
```
<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Análises de Risco" alt="Typing SVG" /></a>

1. **Atrasos no Desenvolvimento: Riscos de Complexidade e Mudança de Requisitos:** O desenvolvimento de uma plataforma de enquetes interativas envolve várias funcionalidades interdependentes, como o sistema de login/cadastro, criação de enquetes, e funcionalidades de votação. O mal gerenciamento do tempo e a subestimação da complexidade técnica podem resultar em atrasos significativos, especialmente se surgirem mudanças nos requisitos ou dificuldades técnicas inesperadas, como a necessidade de ajustes em bibliotecas externas ou problemas de desempenho em consultas ao banco de dados.
   
   **Mitigação:**
Planejamento Detalhado e Metas Curto-Prazo: Defina claramente os requisitos desde o início, documentando-os de forma detalhada. Crie um cronograma com marcos bem definidos e revisões periódicas.
Gestão de Mudanças: Implemente um processo formal de controle de mudanças, onde qualquer nova solicitação de alteração deve ser discutida e aprovada antes de ser incorporada ao projeto.
Divisão do Desenvolvimento: Divida o desenvolvimento em pequenas entregas incrementais. Cada funcionalidade deve ser desenvolvida, testada e integrada em ciclos curtos.
Buffer para Imprevistos: Alocar tempo extra no cronograma para lidar com problemas técnicos ou mudanças inesperadas.
Ferramentas de Monitoramento: Utilize ferramentas de gestão de projetos, como Jira ou Trello, para acompanhar o progresso e manter o controle das tarefas.

3. **Desafios de Integração: Riscos de Inconsistência e Sincronização Entre Frontend e Backend:** A integração entre o frontend (React/Next.js) e o backend (Node.js) pode enfrentar desafios significativos, especialmente em relação ao fluxo de autenticação e à manipulação das enquetes e votos. A comunicação entre o frontend e as APIs precisa ser sincronizada de maneira eficiente, especialmente na gestão de sessões, autenticação JWT e atualização de dados em tempo real, para garantir uma experiência de usuário fluida.
   
   **Mitigação:**
Padronização de APIs: Garanta que as APIs estejam bem documentadas e sigam padrões consistentes, como o uso de REST ou GraphQL. Isso facilita a integração e a comunicação entre frontend e backend.
Testes Automatizados: Implemente testes automatizados para o frontend e o backend. Testes de integração garantirão que os endpoints da API estejam funcionando corretamente e que a comunicação com o frontend seja sincronizada.
Gestão de Sessões: Utilize um sistema de gestão de sessão robusto, como JWT com renovação automática de tokens, garantindo que a autenticação funcione corretamente e sem problemas de sincronização.
Simulações de Cenários de Uso: Execute simulações de diferentes cenários de interação entre frontend e backend para garantir que a manipulação de enquetes e votos aconteça sem inconsistências.
WebSockets ou SSE (Server-Sent Events): Para atualizações de dados em tempo real, considere usar WebSockets ou SSE, que permitem manter o frontend sincronizado com as atualizações feitas no backend.

3. **Segurança dos Dados: Vulnerabilidades em Autenticação, Proteção de Votos e Privacidade de Usuários:** A segurança dos dados é uma preocupação central em plataformas interativas. Com a funcionalidade de login/cadastro, é fundamental garantir que as senhas dos usuários sejam armazenadas com segurança, que a autenticação seja robusta (ex: usando JWT) e que as enquetes e votos sejam protegidos contra manipulação externa (como múltiplos votos fraudulentos ou ataques de injeção). Além disso, dados pessoais dos usuários, como e-mails, devem ser protegidos contra vazamentos.
   
   **Mitigação:**
Criptografia de Senhas: Armazene as senhas dos usuários utilizando algoritmos de hash seguros, como bcrypt ou Argon2, e implemente políticas de senha forte.
Autenticação Segura (JWT): Use tokens JWT com expiração curta e renovações controladas. Assegure-se de usar HTTPS para a troca segura de tokens e dados sensíveis.
Proteção contra Votos Fraudulentos: Implemente restrições para impedir múltiplos votos por usuário, como limitar um voto por IP, ou usar cookies/sessões junto ao JWT para garantir unicidade. Também é útil usar mecanismos de validação, como captchas, para evitar automação de votos.
Proteção contra Ataques de Injeção: Valide e sanitize todas as entradas de usuários para proteger a aplicação contra SQL injection e XSS. Use bibliotecas e frameworks que oferecem proteção contra essas vulnerabilidades, como o mongoose (MongoDB) e express-validator.
Anonimização de Dados: Para garantir a privacidade dos usuários, anonimize dados sensíveis nas enquetes, limitando o acesso a informações pessoais apenas para o necessário.
Auditoria e Logs: Implemente mecanismos de auditoria e logs para monitorar atividades suspeitas, como tentativas de acesso não autorizado ou votos suspeitos, e responda rapidamente a ameaças.

<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Recursos" alt="Typing SVG"/></a>

**Equipe:**
- 1 Gerente de Projetos
- 3 Desenvolvedores Full-Stack (Node.js, React e Next)
- 2 Designer UI/UX
- 1 Administrador de Banco de Dados
- 1 Especialista em Segurança

**Tecnologias:**
- **Node.js** (Backend)
- **React e Next** (Frontend)
- **MongoDB** (Banco de Dados)
- **JWT** (Autenticação)
- **Git/GitHub** (Controle de Versão)

**Ferramentas de Gestão:**
- Trello para gerenciamento de tarefas
- Slack para comunicação interna
- Figma para design de interfaces
- Mermaid para montagem dos diagramas

<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Diagrama de Classe" alt="Typing SVG" /></a>

```mermaid
classDiagram
    class Usuario {
        +int id
        +string nome
        +string email
        +string senha
        +string cidade
        +string fotoDePerfil
        +post()
        +put()
        +delete()
    }

    class Enquete {
        +int id
        +string título
        +string[] opções
        +string descrição
        +enum categoria
        +string imagem
        +date dataDeCriação
        +int usuarioId
        +get()
        +post()
        +put()
        +delete()
    }

    class Votacao {
        +int id
        +int enqueteId
        +int usuarioId
        +string opçãoVotada
        +date dataQueVotou
        +get()
        +post()
        +put()
        +delete()
    }

    Usuario "1" -- "0..*" Enquete : "cria"
    Enquete "1" -- "0..*" Votacao : "possui"
```
<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Diagrama de Uso" alt="Typing SVG" /></a>
```mermaid
flowchart TD
    U[Usuário] -->|Criar Conta| A(Registrar-se)
    A -->|Fazer Login| B(Fazer Login)
    B -->|Acessar Plataforma| C(Plataforma de Enquetes)
    
    C -->|Criar Enquete| D(Criar Nova Enquete)
    D -->|Adicionar Opções| E(Adicionar Opções à Enquete)
    
    C -->|Votar em Enquete| F(Votar em Enquete Existente)
    F -->|Selecionar Opção| G(Escolher Opção e Confirmar Voto)
    
    C -->|Acompanhar Resultados| H(Visualizar Resultados das Enquetes)
    
    I[Criador da Enquete] -->|Gerenciar Enquetes| J(Gerenciar Enquetes dos Usuários)
    J -->|Editar Enquete| K(Editar Detalhes da Enquete)
    J -->|Excluir Enquete| L(Excluir Enquete)
    
    U -->|Editar Perfil| M(Atualizar Informações de Usuário)
    U -->|Excluir Conta| N(Excluir Conta)
````
<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Diagrama de Fluxo" alt="Typing SVG" /></a>
````mermaid
flowchart TD
    Start([Início]) --> |Acessa Plataforma| A[Fazer Login]
    A -->|Login Sucesso| B[Dashboard de Enquetes]
    A -->|Login Falhou| C[Exibir Erro de Login]
    C -->|Tentar Novamente| A
    
    B -->|Criar Nova Enquete| D[Criar Enquete]
    D -->|Inserir Título, Opções e Descrição| E[Confirmar Criação]
    E -->|Sucesso| F[Exibir Enquete no Dashboard]
    
    B -->|Votar em Enquete| G[Selecionar Enquete]
    G -->|Escolher Opção| H[Confirmar Voto]
    H -->|Voto Registrado| I[Atualizar Resultados]
    
    B -->|Acompanhar Resultados| J[Visualizar Resultados em Tempo Real]
    
    B -->|Gerenciar Enquetes| K[Editar ou Excluir Enquete]
    K -->|Confirmar Alterações| F
    
    End([Fim])
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
