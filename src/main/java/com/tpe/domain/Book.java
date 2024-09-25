package com.tpe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)//database'de null olamaz
    @NotBlank(message = "Kitap ismi boşluk olamaz")//"    "
    @NotNull(message = "Kitap ismi girilmelidir")
    private String title;

    @NotBlank(message = "Yazar ismi bosluk olamaz")//"     "
    @Size(min = 2,max = 30,message = "Yazar ismi(${validatedValue}) {min} ve {max} karakter arasında olmalıdır")
    @Column(length = 30,nullable = false)
    private String author;

    @Column(nullable = false)
    private String publicationDate;// yapılar arası geçişler değşşik olduğu için string yazdık

    @ManyToOne
    @JsonIgnore
    private Owner owner;

    //getter-setter-->  yazmaya gerek yok lombok kullandığımız için anatosyaonda yazdık

    //constructor -->   yazmaya gerek yok lombok kullandığımız için anatosyaonda yazdık

    //toString

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Başlık='" + title + '\'' +
                ", Yazar='" + author + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                '}';
    }//bu şekilde iken değişiklik yapması kolay olduğu için anatasyonda yazmadık

}
