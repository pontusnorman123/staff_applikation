package DatabaseCode.Structure;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="bookings")
public class Bookings {
    @ElementList(name="booking", inline = true)
    public List<Booking> BookingTable;
}
