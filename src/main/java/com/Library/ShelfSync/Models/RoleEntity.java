package com.Library.ShelfSync.Models;

import com.Library.ShelfSync.enums.RoleName;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public RoleEntity(Long id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public RoleEntity() {
    }

    public RoleName getroleName() {
        return roleName;
    }

    public void setroleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
