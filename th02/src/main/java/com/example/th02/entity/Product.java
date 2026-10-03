package com.example.th02.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    private double price;

    @Column(columnDefinition = "TEXT") // Sử dụng kiểu TEXT trong MySQL cho các nội dung dài
    private String description;

    // Thiết lập mối quan hệ Nhiều-1: Nhiều Sản phẩm thuộc về 1 Danh mục
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Đây chính là Khóa ngoại (Foreign Key) liên kết sang bảng categories
    private Category category;
}