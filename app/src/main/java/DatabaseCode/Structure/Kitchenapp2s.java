package DatabaseCode.Structure;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="kitchenapp2s")
public class Kitchenapp2s {
    @ElementList(name="kitchenapp2", inline = true)
    public List<Kitchenapp2> viewTable;
}
