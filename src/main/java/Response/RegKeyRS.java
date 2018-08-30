package Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Andrey Melnichenko at 16:28 30-08-2018
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegKeyRS {
    private String regkey;
    private String server;
}
