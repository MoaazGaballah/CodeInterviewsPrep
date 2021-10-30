package AlgoExpret.Recursion.LowestCommonManager;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {

    /*
     * You are given three inputs, all of which are instances of an OrgChart class that
     * have a directReports property pointing to their direct reports. The first input
     * is the top manager in an organizational chart(i.e., the only instance that isn't
     * anybody else's direct report), and the other two inputs are reports in the
     * organizational chart. The two reports are guaranteed to be distinct.
     *
     * Write a function that returns the lowest common manager to the two reports.
     *
     * Sample Input
     * topManager = Node A
     * reportOne = Node E
     * reportTwo = Node I
     *
     * Sample Output
     * Node B
     */

    public static char getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        // Write your code here.
        return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager.name;
    }

    public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo){
        int numImportantReports = 0;

        for (OrgChart directReport : manager.directReports) {

            OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
            if (orgInfo.lowestCommonManager != null ) return orgInfo;

            numImportantReports += orgInfo.numImportantReports;
        }

        if (manager == reportOne || manager == reportTwo) numImportantReports++;

        OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;

        OrgInfo newOrgInfo = new OrgInfo(lowestCommonManager, numImportantReports);

        return newOrgInfo;
    }

    public static class OrgInfo{

        public OrgChart lowestCommonManager;
        int numImportantReports;

        OrgInfo(OrgChart lowestCommonManager, int numImportantReports){
            this.lowestCommonManager = lowestCommonManager;
            this.numImportantReports = numImportantReports;
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    public static OrgChart createOrgChart(char name, OrgChart [] directReports){

        OrgChart createdOrgChart = new OrgChart(name);
        createdOrgChart.addDirectReports(directReports);

        return createdOrgChart;
    }
    public static void main(String[] args) {

        OrgChart F = createOrgChart('F', new OrgChart[]{});
        OrgChart G = createOrgChart('G', new OrgChart[]{});
        OrgChart H = createOrgChart('H', new OrgChart[]{});
        OrgChart reportOne = createOrgChart('E', new OrgChart[]{});
        OrgChart reportTwo = createOrgChart('I', new OrgChart[]{});

        OrgChart D = createOrgChart('D', new OrgChart[]{H, reportTwo});
        OrgChart C = createOrgChart('C', new OrgChart[]{F, G});
        OrgChart B = createOrgChart('B', new OrgChart[]{D, reportOne});

        OrgChart topManager = createOrgChart('A', new OrgChart[]{B, C});


        System.out.println(getLowestCommonManager(topManager, reportOne, reportTwo));
    }
}
