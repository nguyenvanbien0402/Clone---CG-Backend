package com.backend.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_master_mst")
public class UserMaster extends BaseEntity implements Cloneable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public Integer userId;

    @Column(name = "user_name", unique = true, nullable = false)
    @Length(min = 0, max = 255, message = "{valid.length}")
    private String userName;

    @Column(name = "full_name")
    @Length(min = 0, max = 255, message = "{valid.length}")
    private String fullName;

    @Column(name = "password")
    @Length(min = 0, max = 255, message = "{valid.length}")
    private String password;

    @Column(name = "role")
    @DecimalMax("9")
    private Integer role;

    @Column(name = "is_active")
    @Length(min = 0, max = 1, message = "{valid.length}")
    private Integer isActive = 1;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
