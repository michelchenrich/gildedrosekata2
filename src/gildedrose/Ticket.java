package gildedrose;

public class Ticket extends TypedItem {
    public Ticket(String name, int sellIn, int quality) {
        super(name, sellIn, quality, Type.TICKET);
    }
}
