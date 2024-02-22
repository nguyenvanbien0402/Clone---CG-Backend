package com.backend.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
// mapp với database khi được kế thừa
@Data
@EntityListeners(AuditingEntityListener.class)
// ghi lại sự kiện tự động
public abstract class BaseEntity {

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy.MM.dd", timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    // Lưu cả ngày giờ
    @JsonFormat(pattern = "yyyy.MM.dd", timezone = JsonFormat.DEFAULT_TIMEZONE)
    // Format ngày giờ
    @Column(name = "updated_date")
    private Date updatedDate;
}
