package br.com.letscode;

import java.util.Objects;

public class Pessoa {

        private String name;
        private String email;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pessoa pessoa = (Pessoa) o;
            return Objects.equals(name, pessoa.name) && Objects.equals(email, pessoa.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, email);
        }
    }