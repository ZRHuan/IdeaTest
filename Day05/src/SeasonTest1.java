
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer.toString());
        System.out.println("**********************");
        Season1[] values = Season1.values();
        for (int i = 0;i < values.length;i++){
            System.out.println(values[i]);
        }

        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }
}
interface Info{
    void show();
}
enum Season1 implements Info{
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("动天", "冰天雪地");
    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}
