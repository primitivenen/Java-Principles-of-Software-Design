
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\WillAdeAge\\Downloads\\SearchingEarthquakeDataStarterProgram\\data\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        /*for(QuakeEntry qe : list){
           System.out.println(qe);
        }*/
        System.out.println("read in "+list.size()+" quakes");
        int max=indexOfLargest(list);
        System.out.println("The largest earthquake is at location " + max +" and has magnitude "+list.get(max).getMagnitude());
        ArrayList<QuakeEntry> answer = getLargest(list, 5);
        for(QuakeEntry qe:answer){
            System.out.println(qe);
        }
    }
    public int indexOfLargest(ArrayList<QuakeEntry> data){
        int idxMax = 0;
        double magMax = 0.0;
        for(int j=0; j<data.size(); j++){
            if(data.get(j).getMagnitude()>magMax){
                idxMax=j;
                magMax=data.get(j).getMagnitude();
            }
        }
        return idxMax;
    }
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        for(int j=0;j<howMany;j++){
            int LargestIndex=0;
            for(int k=1;k<copy.size();k++){
                    LargestIndex=indexOfLargest(copy);
            }
            ret.add(copy.get(LargestIndex));
            copy.remove(LargestIndex);
        }
        return ret;
    }
}
