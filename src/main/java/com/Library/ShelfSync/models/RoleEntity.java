package com.Library.ShelfSync.models;

import com.Library.ShelfSync.enums.RoleName;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public RoleEntity(Long id, RoleName RoleName) {
        this.id = id;
        this.roleName = RoleName;
    }

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public RoleEntity() {
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
