import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishnum on 3/14/2015.
 */
public class Units {

    enum ListOfUnits{inch,feet,cm,m} ListOfUnits unitList;
    private Map<ListOfUnits, Double> toInch;
    private ListOfUnits u;
    private double value;

    private Units(ListOfUnits u,double value) {
        this.u = u;
        this.value = value;
        this.toInch = mapUnitToInch();
    }

    private Map<ListOfUnits, Double> mapUnitToInch() {
        toInch = new HashMap<ListOfUnits, Double>();
        toInch.put(ListOfUnits.feet,12.0);
        toInch.put(ListOfUnits.inch,1.0);
        toInch.put(ListOfUnits.m,40.0);
        toInch.put(ListOfUnits.cm,0.4);
        return toInch;
    }

    public static Units create(ListOfUnits u, double value){
        return new Units(u,value);
    }

    public int compare(Units unit) {
        double value1 = toInch.get(this.u)*this.value;
        double value2 = toInch.get(unit.u)*unit.value;
        System.out.println(value1+" "+value2+" "+(value1 >value2)+" "+(value2 >value1));
        return (value1 >value2||value2 >value1)? (int) (value1 - value2) :0;
    }
}
