package com.example.th02.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data // Tự động sinh ra các hàm Getter, Setter nhờ thư viện Lombok
@NoArgsConstructor // Tự động tạo constructor rỗng
@AllArgsConstructor // Tự động tạo constructor có đầy đủ tham số
@Entity // Báo cho Spring Boot biết đây là một thực thể cần map với database
@Table(name = "categories") // Tên bảng sẽ được tạo trong MySQL
public class Category {
    
    @Id // Đánh dấu đây là Khóa chính (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Khóa chính tự động tăng (Auto Increment)
    private Long id;

    @Column(nullable = false, length = 100) // Cột "name" không được để trống, độ dài tối đa 100 ký tự
    private String name;

    // Thiết lập mối quan hệ 1-Nhiều: 1 Danh mục chứa nhiều Sản phẩm
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}