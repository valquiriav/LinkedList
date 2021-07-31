package br.com.letscode;

    public interface Interface {
        void adicionar(Pessoa pessoa);
        void buscar(String name);
        void remover(Pessoa pessoa);
        void remover(int index);
        void listarTodos();
        Pessoa getPessoa(int index);
    }