package DatabaseCode;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="kitchenorders")
public class Kitchenorders {
    @ElementList(name="kitchenorder", inline = true)
    public List<Kitchenorder> kitchenorderTable;
}
