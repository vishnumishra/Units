import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishnum on 3/14/2015.
 */
public class Units {

    enum LengthUnits{inch,feet,cm,m}

    private Map<LengthUnits, Double> toInch;
    private LengthUnits u;
    private double value;

    private Units(LengthUnits u,double value) {
        this.u = u;
        this.value = value;
        this.toInch = mapUnitToInch();
    }

    private Map<LengthUnits, Double> mapUnitToInch() {
        toInch = new HashMap<LengthUnits, Double>();
        toInch.put(LengthUnits.feet,12.0);
        toInch.put(LengthUnits.inch,1.0);
        toInch.put(LengthUnits.m,40.0);
        toInch.put(LengthUnits.cm,0.4);
        return toInch;
    }

    public static Units create(LengthUnits u, double value){
        return new Units(u,value);
    }

    public int compare(Units unit) {
        double value1 = toInch.get(this.u)*this.value;
        double value2 = toInch.get(unit.u)*unit.value;
        return (value1 >value2||value2 >value1)? (int) (value1 - value2) :0;
    }
}
