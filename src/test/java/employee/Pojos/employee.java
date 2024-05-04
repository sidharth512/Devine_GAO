package employee.Pojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class employee {
    private String name;
    private String job;
}
