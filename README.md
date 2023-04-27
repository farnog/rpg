# rpg
Avanade Desafio Java - RPG

Endpoints PERSONAGEM: 
GET
/rpg/rpg 
Exibir todos personagem

/rpg/rpg/{id}
Buscar personagem pelo ID

/rpg/rpg/ataque/{id}
Cálculo da força do ataque, informando o ID do personagem

/rpg/rpg/ataque/{id}
Cálculo da força de defesa, informando o ID do personagem

/rpg/rpg/dano/{idAtq},{idDef}
Calculo do dano, informando o id dos pernsagens envolvidos na batalha (ataque e defesa)

POST
Criar Personagem

PUT
/rpg/rpg 
Atualizar personagem pelo ID

DELETE
/rpg/rpg/
Deletar personagem pelo ID
========================================

Endpoints BATALHA: 
Get
/rpg/rpg/inicio
Executa iniciativa, retorna número inteiro.

Post
/rpg/rpg/turno/{idAtq}{idDef}
Inicia o turno, basta informar o id dos personagens envolvidos na batalha, id do personagem de ataque e id do personagem de defesa
=========================================

Endpoints LOG: 
Get
/rpg/rpg/log
Retorna o log da batalha

Post
/rpg/rpg/log
Grava log da batalha 
