package Variable;

public class JobShopSchedulingVariable {
    /**
     * Initialize the Variable
     * Name and Duration for each Task
     **/
    public String name;
    public int duration;

    public JobShopSchedulingVariable(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
}
