package br.com.letscode;

    public class Stack implements Interface {

        //definimos uma array inicial para a pilha, chamada stack
        private Pessoa[] stack = new Pessoa[10];
        //contador que será atualizado a cada elemento adicionado/removido,
        // guardando o total de elementos na array
        private int cont = 0;

        //Métodos da interface

        @Override
        public void adicionar(Pessoa pessoa) {

            //condição que verifica se a array stack já foi completamente
            // preenchida e se sim chama o método dobrarArray()
            if (this.stack.length == cont) {
                this.dobrarArray();
            }

            //usamos aqui o ++ pós-fixado para que o objeto seja colocado como o elemento do índice e,
            // só depois, o contador seja atualizado.
            this.stack[cont++] = pessoa;
        }

        //método privado e portanto que não participa da interface para aumentar a array quando necessário

        private void dobrarArray(){
            //array temporaria para salvar o conteúdo
            final var arrayTemporaria = this.stack;
            //criando nova array com maior capacidade
            this.stack = new Pessoa[stack.length * 2];
            //copiando os elementos da variável temporária para nossa nova array
            System.arraycopy(arrayTemporaria, 0, this.stack, 0, this.cont);

        }

        @Override
        public void buscar(String name) {
            //variável de controle se a pessoa foi encontrada ou não
            boolean pessoaEncontrada = false;
            for (int i = 0; i < cont; i++){
                //percorre os elementos da array verificando se a condição
                // se confirma para procurar a pessoa pelo nome para mostrar mensagem ao usuário
                if (this.stack[i].getName().equals(name)){
                    //quando a pessoa é encontrada, printamos sua localização e marcamos a variável pessoaEncontrada como true
                    System.out.println("A pessoa de nome " + name + " está no cadastro no índice " + i);
                    pessoaEncontrada = true;
                }
            }
            //se a pessoa não foi encontrada, printamos uma mensagem
            if (!pessoaEncontrada){
                System.out.println("A pessoa de nome " + name + " não foi encontrada em nosso registro.");
            }
        }

        @Override
        public void remover(Pessoa pessoa) {

            for (int i = cont; i >= 0; i--){
                //percorre os elementos da array verificando se a condição
                // se confirma para procurar e remover a pessoa pelo nome
                if (this.stack[i].getName().equals(pessoa.getName())){
                    //criamos um for para percorrer os elementos da array (não os espaços vazios)
                    //  a partir da posição encontrada e substituir o item pelo anterior e assim sucessivamente,
                    //  removendo o último item a ser adicionado como é característica de uma pilha (stack LIFO)
                    for (int j = i; j >= 0; j--){
                        this.stack[j] = this.stack[j - 1];
                    }
                }

            }
            //diminuímos o contador uma vez para ficar de acordo com a quantidade de elementos
            cont--;
        }

        @Override
        public void remover(int index) {
            //criamos um for para substituir o item do índice pelo anterior e assim sucessivamente,
            //  removendo o último item a ser adicionado como é característica de uma pilha (stack LIFO)
            for (int i = index; i >= 0; i--){
                this.stack[i] = this.stack[i - 1];
            }
            //diminuímos o contador uma vez para ficar de acordo com a quantidade de elementos
            cont--;
        }

        @Override
        public void listarTodos() {
            //percorre a array e imprime os nomes e emails das pessoas
            // (atributos dos objetos) do último a ser adicionado até o primeiro
            for (int i = cont; i >= 0; i--){
                System.out.println("Nome: " + this.stack[i].getName());
                System.out.println("Email: " + this.stack[i].getEmail());
            }

        }

        @Override
        public Pessoa getPessoa(int index) {
            //retorna o objeto a partir de seu index na array
            return stack[index];
        }

    }