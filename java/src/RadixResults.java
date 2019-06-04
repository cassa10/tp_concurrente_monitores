import java.util.List;

public class RadixResults {

    private List<Integer> ones;
    private List<Integer> zeros;

    public RadixResults(List<Integer> ones, List<Integer> zeros){
        this.ones = ones;
        this.zeros = zeros;
    }

    public List<Integer> getOnes(){
        return this.ones;
    }
    public List<Integer> getZeros(){
        return this.zeros;
    }
}
