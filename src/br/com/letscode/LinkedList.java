package br.com.letscode;

public class LinkedList implements Interface{

    private Node head;

    private class Node {
        //atributos que representam as partes de um node: o valor e a referência para o próximo node
        private Pessoa data;
        private Node next;

        //construtor que cria o node com o valor
        public Node(Pessoa pessoa){
            this.data = pessoa;
        }

        //getters e setters do node

        public Pessoa getData() {
            return data;
        }

        public void setData(Pessoa data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    @Override
    public void adicionar(Pessoa pessoa) {

        Node node = new Node(pessoa);
//para o caso de o primeiro node (head) estar vazio, o node a ser adicionado é o primeiro
        if (this.head == null){
            this.head = node;
            //para o caso de o primeiro node (head) estar apontando para um espaço vazio, o node a ser adicionado será o próximo
        } else if(this.head.getNext() == null){
            this.head.setNext(node);
            //para o caso de o head estar apontando para outro node, o node a ser adicionado é colocado no meio, apontando para o segundo e sendo apontado pelo primeiro
        } else {
            node.setNext(this.head.getNext());
            this.head.setNext(node);
        }

    }

    @Override
    public void buscar(String name) {
        Node node = this.head;
        while (node != null) {
            //cria variável interna de referência
            Pessoa pessoaRef = node.getData();
            //busca situação em que sejam iguais pelo nome
            if (pessoaRef.getName().equalsIgnoreCase(name)){
                System.out.println(pessoaRef);
            }
            //ressignifica o node para ir para o próximo elemento
            node = node.getNext();
        }
    }

    @Override
    public void remover(Pessoa pessoa) {
        Node node = this.head;
        while (node != null) {
            if (node.getData().equals(pessoa)){
                //remove
                node = null;
                //sai do laço pois já cumpriu o propósito
                break;
            }
            //ressignifica o node para ir para o próximo elemento
            node = node.getNext();
        }
    }

    @Override
    public void remover(int index) {
        //puxa a pessoa pelo index e chama o método anterior
        Pessoa pessoaRef = this.getPessoa(index);
        this.remover(pessoaRef);
    }

    @Override
    public void listarTodos() {

        //imprime os valores de todos os nodes
        Node node = this.head;
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }

    }

    @Override
    public Pessoa getPessoa(int index) {
        int cont = 0;
        Node node = this.head;
        //percorre os nodes em busca do que tem o mesmo valor do index de acordo com o contador
        while (node != null){
            if (cont++ == index){
                return node.getData();
            }
            node = node.getNext();
        }
        return null;
    }
}
