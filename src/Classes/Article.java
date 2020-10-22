package Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Article {
    private Categorie c;
    private int id ;
    private String  designation ;
    private String    description ;



}
