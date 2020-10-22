package Classes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Depot_Article {
    private Depot d;
    private Article a ;
    private Double prix ;
    private int qte ;


}
