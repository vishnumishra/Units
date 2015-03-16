import com.company.Length;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitsTest {
    @Test
    public void UnitShouldCompareBetweenTwoUnits_01(){
        Units u1 = Units.create(Units.LengthUnits.feet,1);
        Units u2 = Units.create(Units.LengthUnits.inch,12);
        assertEquals(u2.compare(u1),0);
    }
    @Test
    public void UnitShouldCompareBetweenTwoUnits_02(){
        Units u1 = Units.create(Units.LengthUnits.feet,1);
        Units u2 = Units.create(Units.LengthUnits.inch,12);
        assertEquals(u1.compare(u2),0);
    }

    @Test
    public void UnitShouldCompareBetweenFeetToCm_01(){
        Units u1 = Units.create(Units.LengthUnits.feet,1);
        Units u2 = Units.create(Units.LengthUnits.cm,12);
        assertEquals(u2.compare(u1),-7);
    }
    @Test
    public void UnitShouldCompareBetweenFeetToCm_02(){
        Units u1 = Units.create(Units.LengthUnits.feet,1);
        Units u2 = Units.create(Units.LengthUnits.cm,12);
        assertEquals(u1.compare(u2),7);
    }
    @Test
    public void UnitShouldCompareBetweenInchToCm_01(){
        Units u1 = Units.create(Units.LengthUnits.inch,2);
        int expected = -(int) (2 - (0.8*0.4));
        Units u2 = Units.create(Units.LengthUnits.cm,0.8);
        assertEquals(expected,u2.compare(u1));
    }
    @Test
    public void UnitShouldCompareBetweenInchToCm_02(){
        Units u1 = Units.create(Units.LengthUnits.inch,2);
        int expected = (int) (2 - (0.8*0.4));
        Units u2 = Units.create(Units.LengthUnits.cm,0.8);
        assertEquals(expected,u1.compare(u2));
    }
    @Test
    public void UnitShouldCompareBetweenInchToM_01(){
        Units u1 = Units.create(Units.LengthUnits.inch,1);
        Units u2 = Units.create(Units.LengthUnits.cm,0.4);
        assertEquals(0,u2.compare(u1));
    }
    @Test
    public void UnitShouldCompareBetweenInchToM_02(){
        Units u1 = Units.create(Units.LengthUnits.inch,1);
        Units u2 = Units.create(Units.LengthUnits.cm,0.4);
        assertEquals(0,u1.compare(u2));
    }
    @Test
    public void UnitShouldCompareBetweenInchToM_03(){
        Units u1 = Units.create(Units.LengthUnits.inch,1);
        assertEquals(0,u1.compare(u1));
    }
    @Test
    public void UnitShouldCompareBetweenFeetToM_01(){
        Units u1 = Units.create(Units.LengthUnits.feet,1);
        Units u2 = Units.create(Units.LengthUnits.m,0.3);
        assertEquals(0,u1.compare(u2));
    }
    @Test
    public void UnitShouldCompareBetweenFeetToM_02(){
        Units u1 = Units.create(Units.LengthUnits.feet,1);
        Units u2 = Units.create(Units.LengthUnits.m,0.3);
        assertEquals(0,u2.compare(u1));
    }
    @Test
    public void UnitShouldCompareBetweenGallonToLiter(){
        Units u1 = Units.create(Units.VolumeUnits.gallon,1);
        Units u2 = Units.create(Units.VolumeUnits.litre,3.78);
        assertEquals(0,u2.compareVolume(u1));
    }
    @Test
    public void UnitShouldCompareBetweenLiterToGallon(){
        Units u1 = Units.create(Units.VolumeUnits.gallon,1);
        Units u2 = Units.create(Units.VolumeUnits.litre,3.78);
        assertEquals(0,u1.compareVolume(u2));
    }
    @Test
    public void UnitShouldCompareBetweenLiterToMl(){
        Units u1 = Units.create(Units.VolumeUnits.ml,1000);
        Units u2 = Units.create(Units.VolumeUnits.litre,1);
        assertEquals(0,u1.compareVolume(u2));
    }

}
