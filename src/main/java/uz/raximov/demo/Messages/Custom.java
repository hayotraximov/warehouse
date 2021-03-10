package uz.raximov.demo.Messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Custom {
    private String text;
    private boolean status;
    private Integer id;
}
