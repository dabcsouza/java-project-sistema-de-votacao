# Requisitos do desafio: Sistema de Votação


Por conta de seus conhecimentos em Java, você recebeu uma demanda para desenvolver um sistema de votação eletrônico. A ideia é que esse sistema permita o cadastro das pessoas candidatas, o cadastro das pessoas eleitoras, a realização do processo de votação e a consulta do resultado tanto parcial quanto final da votação.

O fluxo do sistema é definido seguindo três etapas principais que devem ser executadas na seguinte ordem:

1. **Cadastrar pessoas candidatas:** nessa etapa, é preciso ter um menu para o cadastro de pessoas candidatas e, ao fim do cadastro de cada nova pessoa, deve-se oferecer a opção de cadastrar outra. Quando não houver mais pessoas candidatas para serem cadastradas, então se passa para a etapa de cadastro de pessoas eleitoras;

2. **Cadastrar pessoas eleitoras:** aqui é preciso ter um menu que possibilite o cadastro de pessoas eleitoras, similar ao menu do cadastro de pessoas candidatas. Finalizado o cadastro, deve-se voltar ao estado inicial do menu de cadastro de pessoas eleitoras para oferecer a oportunidade de cadastrar uma nova pessoa. Quando não houver mais pessoas eleitoras para serem cadastradas, o sistema deve seguir para a etapa de votação;

3. **Iniciar processo votação:** nessa etapa é iniciado o processo de votação, em que foi solicitado, na demanda, um menu que ofereça as opções de `votar`, `ver resultado parcial` e `finalizar a votação`. A seguir o detalhamento de cada caminho:
- Quando escolhida a opção `votar`, solicita-se o identificador da pessoa eleitora (por exemplo, o CPF) e o número da pessoa candidata em quem se deseja votar. Depois do voto, o menu deve voltar ao estado inicial, oferecendo as opções `votar`, `ver resultado parcial` e `finalizar a votação`.
- A opção `ver resultado parcial` deve listar todos os nomes das pessoas candidatas, mostrando a quantidade de votos absolutos recebida por cada pessoa candidata e o percentual de votos entre elas. Depois de ver o resultado parcial, o menu deve voltar ao estado inicial, oferecendo as opções `votar`, `ver resultado parcial` e `finalizar a votação`.
- A opção `finalizar a votação` deve mostrar o resultado da votação listando as pessoas candidatas, o número absoluto de votos por pessoa candidata e também o percentual dos votos totais que cada pessoa candidata recebeu. Com o fechamento do processo de votação, o programa deve ser finalizado.


Esse sistema deve ter cinco classes: `Principal`, `GerenciamentoVotacao`, `Pessoa`, `PessoaCandidata` e `PessoaEleitora`. Cada uma delas é descrita a seguir:

- `Principal`: essa classe deve conter o método `main`, que por sua vez deve conter (I) uma instância da classe `GerenciamentoVotacao`, (II) uma instância da classe `Scanner` para poder ler as entradas da pessoa usuária pelo console e (III) três laços de repetição que representam menus da aplicação. O primeiro laço deve conter o menu para o cadastro de pessoas candidatas, o segundo deve conter o menu para o cadastro de pessoas eleitoras, e o terceiro, o menu para votar, ver o resultado parcial e finalizar a votação.
   - O menu do primeiro laço deve ter o formato:
   
```
        Cadastrar pessoa candidata?
        1 - Sim
        2 - Não
        Entre com o número correspondente à opção desejada:
```

   Se a pessoa usuária entrar com o valor 1 (que indica que ela quer cadastrar uma pessoa candidata), a mensagem `Entre com o nome da pessoa candidata:` deverá ser impressa no console. Em seguida, depois de inserir o nome da pessoa candidata e pressionar enter, aparecerá a mensagem `Entre com o número da pessoa candidata:` no console. Depois que a pessoa usuária inserir o número da pessoa candidata, o sistema deverá retornar ao estado inicial do menu. Supondo que o nome da primeira pessoa candidata seja "Maria" e o seu número para votar seja "1", então um exemplo do conteúdo do console depois de cadastrar a primeira pessoa candidata será:
   
```
        Cadastrar pessoa candidata?
        1 - Sim
        2 - Não
        Entre com o número correspondente à opção desejada:
        1
        Entre com o nome da pessoa candidata:
        Maria
        Entre com o número da pessoa candidata:
        1
        Cadastrar pessoa candidata?
        1 - Sim
        2 - Não
        Entre com o número correspondente à opção desejada:
```
        
   Esse ciclo se repete até não haver mais pessoas candidatas para serem cadastradas. Quando isso acontencer, a pessoa usuária entrará com a opção 2 do menu, o que vai parar o primeiro laço. O segundo laço, que representa a etapa de cadastro de pessoas eleitoras, deve ser iniciado logo na sequência.

   - O menu do segundo laço deve ter o formato:
   ```
        Cadastrar pessoa eleitora?
        1 - Sim
        2 - Não
        Entre com o número correspondente à opção desejada:
   ```
        
   Se a pessoa usuária entrar com o valor 1 (que indica que ela quer cadastrar uma pessoa eleitora), então a mensagem `Entre com o nome da pessoa eleitora:` será impressa no console. Em seguida, depois de inserir o nome da pessoa eleitora e pressionar enter, aparecerá no console a mensagem `Entre com o cpf da pessoa eleitora:`. Depois que a pessoa usuária inserir o CPF da pessoa eleitora, o sistema deve retornar ao estado inicial do menu. Supondo que o nome da primeira pessoa eleitora seja Joao, portador do CPF 978.413.510-89, um exemplo do conteúdo do console depois de cadastrá-la será:
   
```
        Cadastrar pessoa eleitora?
        1 - Sim
        2 - Não
        Entre com o número correspondente à opção desejada:
        1
        Entre com o nome da pessoa eleitora:
        João
        Entre com o cpf da pessoa eleitora:
        978.413.510-89
        Cadastrar pessoa eleitora?
        1 - Sim
        2 - Não
        Entre com o número correspondente à opção desejada:
 ```
        
   Esse ciclo se repete até o esgotamento das pessoas eleitoras a serem cadastradas. Ao final desse cadastro, a pessoa usuária entrará com a opção 2 do menu, o que vai parar o segundo laço e iniciar o terceiro, marcando o início da votação.

   - O menu do terceiro laço deve ter o seguinte formato:
   
```
     Entre com o número correspondente à opção desejada:
     1 - Votar
     2 - Resultado Parcial
     3 - Finalizar Votação
```
        
   Se a pessoa usuária entrar com o valor 1 (que indica que ela quer computar um voto), a mensagem `Entre com o cpf da pessoa eleitora:` deverá ser impressa no console. Em seguida, depois de inserir o CPF da pessoa eleitora e pressionar enter, aparecerá a mensagem `Entre com o número da pessoa candidata:` no console. Feito isso, o voto deve ser computado, e o sistema retorna ao estado inicial do menu. Supondo que o CPF da primeira pessoa eleitora seja 978.413.510-89, e o número da pessoa candidata seja 1, então um exemplo do conteúdo do console depois de realizar um voto será:
   
```
     Entre com o número correspondente à opção desejada:
     1 - Votar
     2 - Resultado Parcial
     3 - Finalizar Votação
     1
     Entre com o cpf da pessoa eleitora:
     978.413.510-89
     Entre com o número da pessoa candidata:
     1
     Entre com o número correspondente à opção desejada:
     1 - Votar
     2 - Resultado Parcial
     3 - Finalizar Votação
```

  Por outro lado, se a pessoa usuária entrar com o valor 2 (que indica que ela quer visualizar o resultado parcial), deve ser impresso no console o resultado parcial. Supondo que temos apenas a pessoa candidata Maria e a pessoa eleitora João, e que João votou em Maria, um exemplo do conteúdo do console depois de escolher a opção 2 (Resultado Parcial) será:
        
```
     Entre com o número correspondente à opção desejada:
     1 - Votar
     2 - Resultado Parcial
     3 - Finalizar Votação
     2
     Nome: Maria - 1 votos ( 100.0% )
     Total de votos: 1
     Entre com o número correspondente à opção desejada:
     1 - Votar
     2 - Resultado Parcial
     3 - Finalizar Votação
```       
        
  Esse ciclo se repete até que a pessoa usuária escolha a opção 3 (Finalizar Votação). Quando a opção 3 for escolhida, o terceiro laço deve ser terminado, imprimindo o resultado da votação, de forma similar ao resultado parcial, seguida da finalização do programa.
        
  Supondo que temos apenas a pessoa candidata Maria e a pessoa eleitora João, e que João votou em Maria, um exemplo do conteúdo do console depois de selecionada a opção 3 (Finalizar Votação) será:
        
```
        Entre com o número correspondente à opção desejada:
        1 - Votar
        2 - Resultado Parcial
        3 - Finalizar Votação
        3
        Nome: Maria - 1 votos ( 100.0% )
        Total de votos: 1
``

  Suponha que temos duas pessoas candidatas: Maria e José. Maria recebeu 2 votos e José recebeu 1 voto. Veja como deve ser essa saída:
        
```
     Nome: Maria - 2 votos ( 67.0% )
     Nome: José - 1 votos ( 33.0% )
     Total de votos: 3
```
   
- `calcularPorcentagemVotos`: esse método privado serve para uso exclusivo dessa classe. Ele é utilizado para auxiliar no cálculo da porcentagem dos votos. Ele tem o retorno do tipo `double` e recebe um **parâmetro**. Esse parâmetro é um inteiro que representa o índice **do** objeto da classe `PessoaCandidata` no array `pessoasCandidatas`, de forma que se possa recuperar o número de votos recebidos por essa pessoa e **dividir** esse valor pelo total de votos computados que está armazenado no atributo `totalVotos`. Como o atributo `totalVotos` e o número de votos da pessoa candidata são do tipo inteiro, deve-se converter esses valores no tipo `float` ou `double`. Para **arredondar** o valor para uma casa decimal, utilize o método estático `round` da classe `Math` do Java.

- `Pessoa`: essa classe abstrata possui apenas o atributo protegido `nome` do tipo String. Ela tem também as assinaturas do método `Getter` e `Setter` para obrigar que a pessoa desenvolvedora faça a sua implementação nas classes herdeiras.

- `PessoaCandidata`: essa classe herda da classe `Pessoa`, ficando responsável por representar a pessoa candidata. Ela também é composta por dois atributos privados e do tipo inteiro, `numero` e `votos`, sendo o atributo `nome` herdado da classe `Pessoa`. Seu construtor recebe dois parâmetros, o `nome` e o `numero`, e os armazena nos respectivos atributos. O método construtor também inicializa o atributo `votos` com o valor zero. Essa classe é formada pelos métodos `Getter`s e `Setter`s dos atributos `nome`, `numero` e `votos`, contendo também um método `receberVoto` que adiciona 1 ao atributo voto toda vez que é chamado. 

Resumindo, a classe `PessoaCandidata` é formada por:

   - `nome`: atributo herdado da classe `Pessoa`;

   - `numero`: atributo do tipo inteiro que armazena o número identificador para voto;

   - `votos`: atributo do tipo inteiro que armazena o número de votos recebidos pela pessoa candidata.

   Os métodos dessa classe são:

   - `getNome`: método `Getter` para o atributo `nome`;

   - `setNome`: método `Setter` para o atributo `nome`;

   - `getNumero`: método `Getter` para o atributo `numero`;

   - `setNumero`: método `Setter` para o atributo `numero`;

   - `getVotos`: método `Getter` para o atributo `votos`;

   - `setVotos`: método `Setter` para o atributo `votos`;

   - `receberVoto`: método responsável por adicionar 1 ao atributo `votos` para representar a quantidade de votos recebidos pela pessoa candidata, esse método tem retorno do tipo `void`.

   Note que todos os métodos da classe em questão são públicos.

- `PessoaEleitora`: essa classe herda da classe `Pessoa`, ficando responsável por representar a pessoa eleitora. Ela também é composta por um atributo privado do tipo String, `cpf` e o atributo `nome` é herdado da classe `Pessoa`. Seu construtor recebe dois parâmetros, o `nome` e  o `cpf`, armazenando-os nos respectivos atributos. Essa classe também é formada pelos métodos `Getter`s e `Setter`s dos atributos `nome` e `cpf`.

Resumindo, a classe `PessoaEleitora` é formada por:

   - `nome`: atributo herdado da classe `Pessoa`;

   - `cpf`: atributo do tipo String que armazena o CPF da pessoa eleitora;

   Os métodos dessa classe são:

   - `getNome`: método `Getter` para o atributo `nome`;

   - `setNome`: método `Setter` para o atributo `nome`;

   - `getCpf`: método `Getter` para o atributo `cpf`;

   - `setCpf`: método `Setter` para o atributo `cpf`;

   Note que todos os métodos dessa classe são públicos.

## Restrições

- Pessoa candidata só pode ser cadastrada uma vez.
- Pessoa eleitora só pode ser cadastrada uma vez.
- Nome da pessoa candidata e eleitora só pode ser o primeiro nome para facilitar o uso da classe `Scanner` do Java.
- Pessoa eleitora só pode votar uma vez.

## Exemplo

Aqui tempos um exemplo do funcionamento desse sistema, considerando a saída completa do console. Nesse exemplo, temos duas pessoas candidatas, Maria e José, e três pessoas eleitoras, João, Rute e Raquel. Supondo que João e Rute votaram em Maria e que Raquel votou em José, teremos a seguinte saída:

```
----------- Bem-vindo ao Sistema de Votação -----------

Cadastrar pessoa candidata?
1 - Sim
2 - Não
Entre com o número correspondente à opção desejada:
1
Entre com o nome da pessoa candidata:
Maria
Entre com o número da pessoa candidata:
1
Cadastrar pessoa candidata?
1 - Sim
2 - Não
Entre com o número correspondente à opção desejada:
1
Entre com o nome da pessoa candidata:
José
Entre com o número da pessoa candidata:
2
Cadastrar pessoa candidata?
1 - Sim
2 - Não
Entre com o número correspondente à opção desejada:
2


----------- Cadastre as pessoas eleitoras -----------

Cadastrar pessoa eleitora?
1 - Sim
2 - Não
Entre com o número correspondente à opção desejada:
1
Entre com o nome da pessoa eleitora:
João
Entre com o cpf da pessoa eleitora:
154.118.560-94
Cadastrar pessoa eleitora?
1 - Sim
2 - Não
Entre com o número correspondente à opção desejada:
1
Entre com o nome da pessoa eleitora:
Rute
Entre com o cpf da pessoa eleitora:
589.292.640-00
Cadastrar pessoa eleitora?
1 - Sim
2 - Não
Entre com o número correspondente à opção desejada:
1
Entre com o nome da pessoa eleitora:
Raquel
Entre com o cpf da pessoa eleitora:
023.476.580-18
Cadastrar pessoa eleitora?
1 - Sim
2 - Não
Entre com o número correspondente à opção desejada:
2


----------- Votação iniciada! -----------

Entre com o número correspondente à opção desejada:
1 - Votar
2 - Resultado Parcial
3 - Finalizar Votação
1
Entre com o cpf da pessoa eleitora:
154.118.560-94
Entre com o número da pessoa candidata:
1
Entre com o número correspondente à opção desejada:
1 - Votar
2 - Resultado Parcial
3 - Finalizar Votação
1
Entre com o cpf da pessoa eleitora:
589.292.640-00
Entre com o número da pessoa candidata:
1
Entre com o número correspondente à opção desejada:
1 - Votar
2 - Resultado Parcial
3 - Finalizar Votação
1
Entre com o cpf da pessoa eleitora:
023.476.580-18
Entre com o número da pessoa candidata:
2
Entre com o número correspondente à opção desejada:
1 - Votar
2 - Resultado Parcial
3 - Finalizar Votação
3
Nome: Maria - 2 votos ( 67.0% )
Nome: José - 1 votos ( 33.0% )
Total de votos: 3
```
