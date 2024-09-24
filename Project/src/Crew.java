public class Crew extends Staff implements Tipped{
    public static int staffNumber = 0;
    public static float tips = 0;
    @Override
    public void Tipped() {
        super.wage += tips/(float) staffNumber;
    }
}
