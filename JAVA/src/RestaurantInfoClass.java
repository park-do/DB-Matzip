public class RestaurantInfoClass {
    public int res_id;
    public String name;

    public RestaurantInfoClass(int res_id, String name)
    {
        this.res_id = res_id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
