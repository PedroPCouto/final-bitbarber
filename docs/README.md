# Bit & Beard


**Bruna Lopes de Souza, blsouza@sga.pucminas.br**

**Gustavo Pessoa Firmino Duarte, gpfduarte@sga.pucminas.br**

**Livia Bontempo Leite, livia.bontempo@sga.pucminas.br**

**Marco Antônio Ferreira, mamferreira@sga.pucminas.br**

**Pedro Henrique de Paiva, pedro.couto@sga.pucminas.br**

**Talisson Augusto Prudêncio Santos, talisson.augusto@sga.pucminas.br**

---

Professores:

**Cristiano de Maceddo Neto**

**Danilo Boechat Seufitelli**

---

_Curso de Engenharia de Software

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade Católica de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

**Resumo**

Nosso projeto de desenvolvimento de um software destinado a barbearias. Este software visa aprimorar a maneira como os agendamentos e o gerenciamento operacional são realizados nesses estabelecimentos. Enfrentando desafios comuns no setor, como dificuldades de agendamento e fidelização de clientes, nosso objetivo é oferecer uma solução que não apenas melhore a eficiência operacional, mas também enriqueça a experiência do cliente.

---

## 1. Introdução

_Nossa proposta visa desenvolver um software dedicado a barbearias, oferecendo funcionalidades de agendamento de cortes e ferramentas de gerenciamento para otimizar as operações do negócio._

### 1.1 Contextualização

_De modo geral, empresas que prestam serviços de modo exclusivamente presencial, em estabelecimentos próprios, tendem a lidar com processos muito semelhantes e, repletos de dificuldades. Com barbearias não é diferente, seguindo um modelo de negócio que requer agendamento e cuja qualidade do serviço depende da capacidade individual do prestador, esse tipo de estabelecimento pode enfrentar desafios grandes na gestão e manutenção da clientela._

### 1.2 Problema

_Dificuldade no agendamento:_

Tanto para o cliente quanto para o provedor do serviço existem problemas ligados às questões de agendamento e a visualização de disponibilidade. O barbeiro deseja ser mais facilmente percebido por um potencial cliente, e, da mesma forma, o consumidor não deseja lidar com complicações desnecessárias que podem tomar seu tempo.

_Feedback:_

Considerando que um serviço para o cabelo é um trabalho de caráter bem paticular para o cliente, torna-se uma tarefa difícil escolher o serviço que será prestado sem algum respaldo. Em contrapartida, o barbeiro procura aprimorar suas habilidades cada vez mais, porém, receber a resposta de seu trabalho, logo após realizado, nem sempre é possível, pois pode ser desagradável para ambos.

_Fidelização do Cliente:_

Para o barbeiro e a gestão, fidelizar o cliente é essencial na manutenção da empresa, e, levando isso em consideração, cupons de descontos ou brindes concedidos pela frequência, poderiam manter o cliente frequentando a barbearia. Assim, por questões de logística, isso é dificilmente implementável.

_Cancelamentos Repentinos:_

O cancelamento é uma questão frequente em serviços prestados presencialmente e, além de acarretar ociosidade para um barbeiro, é um horário perdido para um cliente que de fato cumpriria o compromisso.

_Visualização da eficiência dos funcionários:_

Considerando as dificuldades de feedback já mencionadas, para um gestor ou administrador da barbearia, é de suma importância ter a visualização da qualidade do trabalho de seus funcionários, mas, mesmo com eventuais reclamações, é um dado de difícil compilação.

### 1.3 Objetivo geral

O objetivo geral deste trabalho é criar uma aplicação web cujo intuito é melhorar a experiência de atendimento, gerenciamento de horários marcados, descontos e administração da qualidade dos serviços.

#### 1.3.1 Objetivos específicos

Sistema de agendamento, podendo escolher o funcionário e o serviço desejado pelo cliente sem maiores dificuldades, facilitando também desmarcações e remarcações.

Sistema de descontos, provendo de maneira automática cupons de desconto e brindes para clientes com base em critérios específicos, como, por exemplo, realizar 12 cortes de cabelo na barbearia poderia conceder 1 corte gratuito.

Sistema de feedback, concedendo ao cliente a possibilidade de relatar a sua experiência, dando estrelas e fazendo comentários para o serviço.

Sistema de melhoria dos serviços, angariando os dados dos feedbacks e criando uma tabela que condensa a qualidade dos serviços dos barbeiros.

### 1.4 Justificativas

Levando em consideração os problemas citados anteriormente neste documento, vide seção 1.1, o sistema que se busca criar por meio desse projeto, sanaria as maiores dificuldades enfrentadas no modelo de negócios de barbearia, ajudando uma empresa hipotética desse segmento a crescer sem precisar de lidar com os problemas citados.

## 2. Participantes do processo

Proprietários/Gerentes: Responsáveis pela administração do estabelecimento, incluindo gestão de pessoal, finanças e estratégias de marketing. 

Barbeiros/Cabeleireiros: Profissionais responsáveis pela execução dos serviços de corte e cuidados com a barba.

Clientes: Pessoas que frequentam a barbearia em busca de serviços de cuidados pessoais, incluindo cortes de cabelo e barba.

## 3. Modelagem do processo de negócio

### 3.1. Análise da situação atual

Nos últimos anos, o público masculino tem sido alvo da indústria de serviços e bem-estar e, segundo uma pesquisa estadunidense, publicada pela Grand View Research,  o setor de cuidados pessoais masculinos foi avaliado em US$ 30,8 bi em 2021 e apresenta estimativa de crescimento de 9,1% ao ano entre 2022-2030. As barbearias por sua vez, acompanham a alta demanda por produtos e serviços voltados para os homens, com um crescimento de 70% no Brasil, nos últimos anos, de acordo com dados do Sebrae. No entanto, considerando os tempos atuais, a digitalização das barbearias torna-se, cada vez mais, um fator de visibilidade dentre os estabelecimentos, já que o cliente procura, além de qualidade do atendimento, praticidade, conforto e agilidade. Portanto, vê-se uma necessidade de implementar um software capaz de apresentar ferramentas úteis de agendamento e feedback do serviço prestado.

### 3.2. Descrição geral da proposta

Nossa proposta é desenvolver um software que gerencie o agendamento de serviços de uma barbearia. O software, em primeira instância, pretende disponibilizar para o cliente uma ferramenta de agendamento do atendimento, cujo agendamento haverá a possibilidade de marcação, remarcação e cancelamento da prestação de serviço, agregando ao negócio, assim, melhoria na organização do tempo e do serviço. Além disso, pretende-se criar uma ferramenta para que o serviço de barbearia seja avaliado pelo cliente, o que ajuda a manter a qualidade do serviço e transparência para com os envolvidos do estabelecimento.

### 3.3. Modelagem dos processos

[PROCESSO 1 - FeedBack](images/modelagem-feedback.jpg)

[PROCESSO 2 - Retenção](images/processo_comunicacao_cliente.png)

[PROCESSO 3 - Contratação de Serviço](images/modelagem-contratacao-servico.jpeg)

[PROCESSO 4 - Cadastrar Cliente](images/processo_registrar_cliente.png)

## 4. Projeto da solução

O documento a seguir apresenta o detalhamento do projeto da solução. São apresentadas duas seções que descrevem, respectivamente: modelo relacional e tecnologias.

[Projeto da solução](solution-design.md "Detalhamento do projeto da solução: modelo relacional e tecnologias.")


## 5. Indicadores de desempenho

O documento a seguir apresenta os indicadores de desempenho dos processos.

[Indicadores de desempenho dos processos](performance-indicators.md)


## 6. Interface do sistema

A sessão a seguir apresenta a descrição do produto de software desenvolvido. 

[Documentação da interface do sistema](interface.md)

## 7. Conclusão

_Apresente aqui a conclusão do seu trabalho. Discussão dos resultados obtidos no trabalho, onde se verifica as observações pessoais de cada aluno. Poderá também apresentar sugestões de novas linhas de estudo._

# REFERÊNCIAS

_Como um projeto de software não requer revisão bibliográfica, a inclusão das referências não é obrigatória. No entanto, caso você deseje incluir referências relacionadas às tecnologias, padrões, ou metodologias que serão usadas no seu trabalho, relacione-as de acordo com a ABNT._

_Verifique no link abaixo como devem ser as referências no padrão ABNT:_

http://portal.pucminas.br/imagedb/documento/DOC_DSC_NOME_ARQUI20160217102425.pdf

**[1.1]** - _ELMASRI, Ramez; NAVATHE, Sham. **Sistemas de banco de dados**. 7. ed. São Paulo: Pearson, c2019. E-book. ISBN 9788543025001._

**[1.2]** - _COPPIN, Ben. **Inteligência artificial**. Rio de Janeiro, RJ: LTC, c2010. E-book. ISBN 978-85-216-2936-8._

**[1.3]** - _CORMEN, Thomas H. et al. **Algoritmos: teoria e prática**. Rio de Janeiro, RJ: Elsevier, Campus, c2012. xvi, 926 p. ISBN 9788535236996._

**[1.4]** - _SUTHERLAND, Jeffrey Victor. **Scrum: a arte de fazer o dobro do trabalho na metade do tempo**. 2. ed. rev. São Paulo, SP: Leya, 2016. 236, [4] p. ISBN 9788544104514._

**[1.5]** - _RUSSELL, Stuart J.; NORVIG, Peter. **Inteligência artificial**. Rio de Janeiro: Elsevier, c2013. xxi, 988 p. ISBN 9788535237016._



# APÊNDICES


_Atualizar os links e adicionar novos links para que a estrutura do código esteja corretamente documentada._


## Apêndice A - Código fonte

[Código do front-end](../src/front) -- repositório do código do front-end

[Código do back-end](../src/back)  -- repositório do código do back-end


## Apêndice B - Apresentação final


[Slides da apresentação final](presentations/)


[Vídeo da apresentação final](video/)






