package com.example.pp_3_1_5_restapi.models;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@NamedEntityGraph(name = "User.role", attributeNodes = @NamedAttributeNode("roleList"))
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String surname;


    private String username;

    private int age;

    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleList;

    public User() {}

    public User(Integer id, String name, String surname, String username, int age, String password) {
        this(name, surname, username, age, password);
        this.id = id;

    }
    public User(String name, String surname, String username, int age, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(roleList, user.roleList);
    }

    @Override
    public int hashCode() {
        int result = (3 ^ (4 >>> 32));
        result = 31 * result + username.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result +  age;
        result = 31 * result + password.hashCode();
        result = 31 * result + roleList.hashCode();
        return result;
    }
}