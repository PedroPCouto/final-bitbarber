![Exemplo de um Modelo BPMN do PROCESSO 1](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1381100-bit-beard/blob/main/docs/images/processo-agendamento-servicoV2.png)

Este é o processo onde o cliente deve selecionar o serviço que deseja, o profissional e efetivamente agenda-lo.


#### Detalhamento das atividades

_Atividade 1 - Cliente entra na página de de contração, clicando no botão localizado no centro, no topo da página web, em sua barra de navegação._

_Atividade 2 - Cliente seleciona o serviço que deseja para si, tendo como opções o corte de cabelo, a pintura e fazer a barba_

_Atividade 3 - Cliente deve escolher um, dentro vários possíveis profissionais disponiveis_

_Atividade 4 - Cliente deve escolher um dia para a realização do serviço selecionado_

_Atividade 5 - Cliente deve escolher um horário daquele diz que escolheu_

_Atividade 6 - Cliente deve confirmar seu agendamento_




**Gerenciar horários disponíveis - barbeiro**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
|dias diponíveis        | seleção múltipla   | deve selecionar pelo menos um dia da semana|           -     |
| horarios disponíveis           | seleção múltipla   | deve selecionar pelo menos um horario em cada dia disponivel |      -   |
| intervalo entre atendimentos           | número   | deve ser um número positivo |      30 minutos  |
| periodos bloqueados          | tabela   | lista de datas/horas bloqueadas. o formato de cada entrada deve ser: data, hora de início e hora de término |      -  |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| inserir agenda               | próxima atividade           | default           |
| cancelar            | fim do processo |          cancel         |


**Validar agenda - bit&beard**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
|   agenda configurada   |    área de texto   |  somente leitura exibe um resumo da agenda configurada anteriormente | exibe as configuracoes feitas na atividade1 |
|   comentario sobre a agenda  |    área de texto   |  nenhuma | vazio |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
|  publicar agenda |  publicar a agenda configurada para clientes acessarem |default|
|  editar agenda |  voltar a atividade 1 para editar a agenda configurada |cancel|


**Publicar agenda - bit&beard**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
|   agenda configurada   |    área de texto   |  somente leitura exibe um resumo da agenda configurada anteriormente | exibe as configuracoes feitas na atividade "Validar agenda" |
|   link de acesso  |    área de texto   |  somente leitura exibe o link de acesso para os clientes | link gerado automaticamente após a publicação da agenda |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
|  acessar agenda | clientes acessam a agenda publicada |default|
|  gerenciar agenda |  voltar a atividade 1 para gerenciar a agenda configurada |cancel|
