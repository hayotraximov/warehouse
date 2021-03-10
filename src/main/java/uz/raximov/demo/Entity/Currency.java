package uz.raximov.demo.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.raximov.demo.Entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Currency extends AbsEntity {
}
