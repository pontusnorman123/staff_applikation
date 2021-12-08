package DatabaseCode;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="cookingtimes")
public class Cookingtimes {
    @ElementList(name="cookingtime", inline = true)
    public List<Cookingtime> cookingtimeTable;
}
