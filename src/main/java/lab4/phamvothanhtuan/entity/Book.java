package lab4.phamvothanhtuan.entity;

import jakarta.validation.constraints.Positive;
import lab4.phamvothanhtuan.Validator.annotation.ValidUserId;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",length = 50)
    @Size(max = 50, message = "Title must be less than 50 characters")
    @NotNull(message = "Title must not be  null")
    private String title;

    @Column(name = "author", length = 50)
    @Size(max = 50,message = "Author must be lee than 50 characters")
    private  String author;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id ", referencedColumnName="id")
    @ValidCategory
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId

}