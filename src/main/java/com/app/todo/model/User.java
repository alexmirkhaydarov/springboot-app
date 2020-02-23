package com.app.todo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorColumn(name = "type")
@Entity
public class User {
    @Column(insertable = false, updatable = false)
    private String type;
//    public String getType() {
//        return type;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String username;

    @OneToMany(/*cascade = CascadeType.ALL, */fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Todo> Todos;

    private String externalId;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




    public Set<Todo> getTodos() { return Todos; }

    public void setTodos(Set<Todo> Todos) {
        this.Todos = Todos;
    }

}
