package employee.Pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.*;

import java.util.Objects;

//@Getter
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class employee {
    private String name;
    private String job;
   // private Object gender;

}
