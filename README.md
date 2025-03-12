# Naruto

![NPM](https://img.shields.io/npm/l/react) (https://github.com/SauloHrodrigues/Desafio_Naruto/blob/main/LICENSE)

# Sobre o projeto

O presente projeto foi desencolvido em forma de desafio, com o objetico de avaliar nossas habilidades em programação
orientada a objetos, utilizando classes, interfaces, heranças, polimorfismo e etc. Para isso, foi desenvolvido uma
aplicação, apenas backend, em Java. A aplicação esta em forma de CRUD e conta com a seguinte estrutura:

## Estrutura do desenvolvimento

### Atributos do Personagem:

    • Nome (String)
    • Idade (int)
    • Aldeia (String)
    • Jutsus (Map de jutsu)  
    • Chakra (int)
    • vida (int)
    • ninja (CategoriaNijaEnu)

#### Métodos:

    • Um construtor que inicialize os atributos do personagem.
    • Um construtor que inicialize os atributos de nijas.
    • Um método que permita exibir todas as informações do personagem (nome, idade, aldeia).

### Interface Ninja:

#### Métodos:

    • usarJutsu(): exibe uma mensagem na tela indicando que o personagem está usando um jutsu.
    • desviar(): exibe uma mensagem na tela indicando que o personagem está desviando de um ataque.

### Classes:

#### PersonagemNinja: classe que representa um personagem Ninja. Estende a classe perssonagem e implementa a interface Ninja. 

<span style="color: red;">Estende a classe Personagem</span><br>
<span style="color: red;">Implementar interface Ninja</span>

##### Métodos:

        • usarJutsu(): retorna String
        • desviar(): retorna String

#### NinjaDeTaijutsu: classe que representa um personagem especializado em Taijutsu.

<span style="color: red;">Estende a classe PersonagemNinja</span>

##### Métodos:

        • usarJutsu(): exibe uma mensagem na tela indicando que o personagem está usando um golpe de Taijutsu.
        • desviar(): exibe uma mensagem na tela indicando que o personagem está desviando de um ataque usando sua habilidade em Taijutsu.

#### NinjaDeNinjutsu: classe que representa um personagem especializado em Ninjutsu.

<span style="color: red;">Estende a classe PersonagemNinja</span>

##### Métodos:

        • usarJutsu(): exibe uma mensagem na tela indicando que o personagem está usando um jutsu de Ninjutsu.
        • desviar(): exibe uma mensagem na tela indicando que o personagem está desviando de um ataque usando sua habilidade em Ninjutsu.

#### NinjaDeGenjutsu: classe que representa um personagem especializado em Ninjutsu.

<span style="color: red;">Estende a classe PersonagemNinja</span>

##### Métodos:

    • usarJutsu(): exibe uma mensagem na tela indicando que o personagem está usando um jutsu de Genjutsu.
    • desviar(): exibe uma mensagem na tela indicando que o personagem está desviando de um ataque usando sua habilidade em Genjutsu

## Tecnologias Utilizadas

    • Java 17
    • SpringBoot
    • Maven
    • Mockito
    • Junit5
    • Swagger
## Funcionamento da appi
### Cadastrar personagens Ninjas 
#### POST/personagem
##### Para cadastrar um Ninja é necssário que o atributo (categoriaNinja), que é uma String, seja preenchido com:
• NinjaNinjutsu
• NinjaTaijutsu
• NinjaGenjutsu.
### Cadatrar um novo Jutsu
#### PATCH/personagem{nome do Ninja}/novojutsu
##### Para cadastrar um novo jutsu, é necessário um personagem previamente cadastrado, pois ao criar o jutsu você o vincula ao personagem, que pode ter vários  jutsus.
### Usar Jutsu 
#### GET/personagem/{nome do Ninja}/novojutsu
#### O usar jutsu da controller personagem contempla a primeira fase do projeto, na qual, tal metodo retorna apenas um texto mostrando qual tipo de ninja está usando o jutsu.
#### GET/personagem/{nome do Ninja}/desviar
#### O desviar da controller personagem, assim como o usar jutsu, também contempla a primeira fase do projeto, apenas retornando um texto mostrando qual tipo de ninja está usando o desviar.


### Fluxo da API.
#### Após criar dois personagens ninjas e atribuir, ao menos um jutso para cada um, na controller jogar, pode-se criar um jogo (batalha) entre os dois ninjas criados.
#### Ambos os ninjas podem atacar utilizando-se dos Jutsus criados. Ao atacar com o jutsu, o ninja perde chakras.
#### O ninja atacado pode/deve fazer sua defesa que, aleatoriamente, pode ou não ter efeito. se a defesa não for efetiva, o ninja atacado perdera um ponto, que poderá ou não perder vida.
#### O ninja que não tiver mais chakras ou vida, perde o jogo.


## Autor

### Nome: Saulo Henrique Rodrigues

### LinkedIn:  https://www.linkedin.com/in/saulohenriquerodrigues/
    
    
