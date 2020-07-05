public class TimeCard {
    Dog dog;
    TimeCard timeCard = new TimeCard();
    public TimeCard(TimeCard timeCard) {
        this.timeCard = timeCard;
    }

    public TimeCard() {

    }

    void test(TimeCard timeCard) {
        System.out.println(timeCard.timeCard);
    }
}
