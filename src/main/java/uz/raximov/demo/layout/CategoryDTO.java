package uz.raximov.demo.layout;

import lombok.Data;
import uz.raximov.demo.Entity.template.AbsEntity;

@Data
public class CategoryDTO extends AbsEntity {
    private Integer parentId;
}
