# Web07

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 22.1.3.

## O que foi feito nesta versão (Web07)

Implementação do botão **comprar** da vitrine, que adiciona o produto à cesta de compras usando a `localStorage`.

### Vitrine (`src/app/vitrine/`)

- **`vitrine.html`**: o botão "comprar" passou a chamar o método `adicionarCesta(obj)` no `(click)`.
- **`vitrine.ts`**: criado o método `adicionarCesta(obj: Produto)`, que:
  1. define o preço do item (usa `promo` se for maior que 0, senão usa `valor`);
  2. monta um `ItemCesta` com o produto, `quantidade = 1` e `valorTotal = preço`;
  3. verifica se a chave `"cesta"` já existe na `localStorage`;
  4. **se não existe**, cria uma lista nova com o item;
  5. **se existe**, recupera a lista com `JSON.parse` e faz um loop comparando o `produto.codigo`:
     - se o produto **já está** na cesta, soma +1 na `quantidade` e atualiza o `valorTotal`;
     - se o produto **não está** na cesta, faz o `push` do item na lista;
  6. grava a lista na `localStorage` com `JSON.stringify`;
  7. redireciona para a página da cesta (`location.href = "cesta"`).

### Cesta (`src/app/cesta/`)

- **`cesta.ts`**: a lista mockada de itens foi removida (`itens: ItemCesta[] = []`).
- No `ngOnInit`, a lista de itens agora é recuperada da `localStorage` (chave `"cesta"`):
  - se não existir, mostra a mensagem **"Sua cesta está vazia!"**;
  - se existir, carrega os itens com `JSON.parse`.
- Em seguida chama `calculaTotal()` para somar o valor total da cesta.

### Como testar

1. Rode `ng serve` e abra `http://localhost:4200/`.
2. Clique em **comprar** em um produto: ele aparece na cesta com quantidade 1.
3. Volte à vitrine e compre o **mesmo** produto: a quantidade vai para 2 e o valor é atualizado.
4. Compre um produto **diferente**: aparece uma linha nova na cesta.
5. Para limpar a cesta: DevTools (F12) → Application → Local Storage → apagar a chave `cesta`.

## Development server

To start a local development server, run:

```bash
ng serve
```

Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
ng generate --help
```

## Building

To build the project run:

```bash
ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Vitest](https://vitest.dev/) test runner, use the following command:

```bash
ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.
