import com.company.Length;

import java.util.HashMap;
import java.util.Map;

public class Units {

    enum LengthUnits{inch,feet,cm,m}
    enum VolumeUnits{gallon,litre, cubicMeter, ml}

    private Map<LengthUnits, Double> toInch;
    private Map<VolumeUnits, Double> toLitre;

    private LengthUnits u;
    private VolumeUnits v;
    private double value;

    private Units(LengthUnits u,double value) {
        this.u = u;
        this.value = value;
        this.toInch = mapUnitToInch();
    }
    private Units(VolumeUnits v,double value) {
        this.v = v;
        this.value = value;
        this.toLitre = mapUnitToLitter();
    }

    private Map<LengthUnits, Double> mapUnitToInch() {
        toInch = new HashMap<LengthUnits, Double>();
        toInch.put(LengthUnits.feet,12.0);
        toInch.put(LengthUnits.inch,1.0);
        toInch.put(LengthUnits.m,40.0);
        toInch.put(LengthUnits.cm,0.4);
        return toInch;
    }
    private Map<VolumeUnits, Double> mapUnitToLitter() {
        toLitre = new HashMap<VolumeUnits, Double>();
        toLitre.put(VolumeUnits.gallon,3.78);
        toLitre.put(VolumeUnits.litre,1.0);
        toLitre.put(VolumeUnits.ml,0.001);
        toLitre.put(VolumeUnits.cubicMeter,0.001);
        return toLitre;
    }

    public static Units create(LengthUnits u, double value){
        return new Units(u,value);
    }
    public static Units create(VolumeUnits v, double value){
        return new Units(v,value);
    }

    public int compare(Units unit) {
//        System.out.println();
        double value1 = toInch.get(this.u)*this.value;
        double value2 = toInch.get(unit.u)*unit.value;
        return (value1 >value2||value2 >value1)? (int) (value1 - value2) :0;
    }

    public int compareVolume(Units unit) {
        double value1 = toLitre.get(this.v)*this.value;
        double value2 = toLitre.get(unit.v)*unit.value;
        return (value1 >value2||value2 >value1)? (int) (value1 - value2) :0;
    }
}