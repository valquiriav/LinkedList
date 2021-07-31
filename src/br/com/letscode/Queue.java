package br.com.letscode;

    public class Queue implements Interface {

        //definimos uma array inicial para a fila, chamada queue
        private Pessoa[] queue = new Pessoa[10];
        //contador que será atualizado a cada elemento adicionado/removido,
        // guardando o total de elementos na array
        private int cont = 0;

        //Métodos da interface

        @Override
        public void adicionar(Pessoa pessoa) {

            //condição que verifica se a array queue já foi completamente
            // preenchida e se sim chama o método dobrarArray()
            if (this.queue.length == cont) {
                this.dobrarArray();
            }

            //usamos aqui o ++ pós-fixado para que o objeto seja colocado como o elemento do índice e,
            // só depois, o contador seja atualizado.
            this.queue[cont++] = pessoa;
        }

        //método privado e portanto que não participa da interface para aumentar a array quando necessário

        private void dobrarArray(){
            //array temporaria para salvar o conteúdo
            final var arrayTemporaria = this.queue;
            //criando nova array com maior capacidade
            this.queue = new Pessoa[queue.length * 2];
            //copiando os elementos da variável temporária para nossa nova array
            System.arraycopy(arrayTemporaria, 0, this.queue, 0, this.cont);

        }

        @Override
        public void buscar(String name) {
            //variável de controle se a pessoa foi encontrada ou não
            boolean pessoaEncontrada = false;
            for (int i = 0; i < cont; i++){
                //percorre os elementos da array verificando se a condição
                // se confirma para procurar a pessoa pelo nome para mostrar mensagem ao usuário
                if (this.queue[i].getName().equals(name)){
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

            for (int i = 0; i < cont; i++){
                //percorre os elementos da array verificando se a condição
                // se confirma para procurar e remover a pessoa pelo nome
                if (this.queue[i].getName().equals(pessoa.getName())){
                    //criamos um for para percorrer os elementos da array (não os espaços vazios)
                    //  a partir da posição encontrada e substituir o item pelo próximo e assim sucessivamente,
                    //  removendo o primeiro item a ser adicionado como é característica de uma fila (queue FIFO)
                    for (int j = i; j < cont - i; j++){
                        this.queue[j] = this.queue[j + 1];
                    }
                }

            }
            //diminuímos o contador uma vez para ficar de acordo com a quantidade de elementos
            cont--;
        }

        @Override
        public void remover(int index) {
            //criamos um for para substituir o item do índice pelo próximo e assim sucessivamente,
            //  removendo o primeiro item a ser adicionado como é característica de uma fila (queue FIFO)
            for (int i = index; i < cont - index; i++){
                this.queue[i] = this.queue[i + 1];
            }
            //diminuímos o contador uma vez para ficar de acordo com a quantidade de elementos
            cont--;
        }

        @Override
        public void listarTodos() {

            //percorre a array e imprime os nomes e emails das pessoas (atributos dos objetos) na lista
            for (int i = 0; i < cont; i++){
                System.out.println("Nome: " + this.queue[i].getName());
                System.out.println("Email: " + this.queue[i].getEmail());
            }

        }

        @Override
        public Pessoa getPessoa(int index) {
            //retorna o objeto a partir de seu index na array
            return queue[index];
        }

    }