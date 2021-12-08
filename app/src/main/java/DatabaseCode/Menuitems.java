package DatabaseCode;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="menuitems")
public class Menuitems {
    @ElementList(name="menuitem", inline = true)
    public List<Menuitem> menuitemTable;
}
