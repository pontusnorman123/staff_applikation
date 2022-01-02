package DatabaseCode.Structure;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="resturangorders")
public class Resturangorders {
    @ElementList(name="resturangorder", inline = true)
    public List<Resturangorder> resturangorderTable;
}